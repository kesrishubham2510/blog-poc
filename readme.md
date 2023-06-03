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

* The request body parameter uses **Request** entitity as template.
    ````
    import java.time.LocalTime;

    import lombok.Data;
    
    
    @Data
    public class Request {
        private int id;
        private LocalTime creationTime;
    }

    ````


* The Application uses **Message** entitity as it's response template.
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

## Cloning the Repository

* Open the directory where you want to keep the project, open the terminal at the folder and run the below command 
    ````
    git clone https://github.com/kesrishubham2510/blog-poc.git
    ````
## Running the Applications

* Make sure you have Java version 17 or later

* After Successfull cloning, from the same path run,
    ````
    mvn clean; mvn compile
    ````
  to clean and build the jar files.

* Open the repository in vscode or any other IDE. While running the application make sure to use **jakarta.persistence.Id** and **org.springframework.data.annotation.Id** when running**mvcapi** and **reactiveapi** respectively.

## Use Jmeter to [test](https://www.simplilearn.com/tutorials/jmeter-tutorial/jmeter-api-testing) APIs

   










