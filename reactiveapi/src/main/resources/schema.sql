CREATE TABLE IF NOT EXISTS MESSAGE(
    ID SERIAL PRIMARY KEY, 
    MESSAGE_LENGTH INT, 
    MESSAGE VARCHAR(250)
);