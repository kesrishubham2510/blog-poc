# Context 
* This repository is a implementation level proof-of-concept aka __POC__ supporting the fact, Reactive programming can provide better throughput with limited resources.
* The Project utilizes Spring-web and Spring-webflux frameworks in this __POC__.
* The Spring-web supports synchronus programming and the Spring-webflux supports a reactive (__non-blocking__) programming.
* The Spring-web uses a __Tomcat__ server (default) which uses a thread-per-request model while Spring-webflux uses __Netty__ server which uses concpets of non-blocking I/O (__NIO__).

## Getting Started with Code exploration

### Project Structure
* This is a mutli-module project built using **POM** build tool.
* The project contains 3 modules.
* Module **library** contains the DTOs.
* Module **mvcapi** is the Spring-web implementation. 
* Module **reactiveapi** is the Spring-webflux implementation.

### Configuring the thread-pool size of the servers
 
* Thread pool size of the server needs to be same to get a fair judgement of the performance. I have used 3.
* For Tomcat, we can do this by setting property in application.properties

    ````
  server.tomcat.threads.max=3
    ````
* For Netty server, we can do this by creating a customized ReactiveWebServerFactory bean
    ````
    @Bean
    	public ReactiveWebServerFactory reactiveWebServerFactory() {
    		NettyReactiveWebServerFactory factory = new NettyReactiveWebServerFactory();
    		factory.addServerCustomizers(builder -> builder.runOn(LoopResources.create("my-http", 3, true)));

    		return factory;
    	}
    ````
* The **mvcapi** & **reactiveapi** are configured to run on port 8001 and 8002 respectively.

* The Request body uses **Message** entitity as it's template.
    ````
    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;

    @Entity
    @Getter
    @Setter
    @NoArgsConstructor
    public class Message {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;
        private int messageLength;
        private String message;
    }
    ````
## Running the Applications

* While running the application make sure to use **jakarta.persistence.Id** and **org.springframework.data.annotation.Id** when running
**mvcapi** and **reactiveapi** respectively.

   










