# rabbit-consumme-post

This is a Java Spring Boot service that contains examples of:

- RabbitMQ queue consume
- post to a direct exchange
- post to a fannout exchange
- post to a headers exchange
- post to a topic exchange

## Usage

Make the REST requests using a REST Client platform, like Postman:

- POST: localhost:8080/message (send message to a queue)
    - Payload example
      ```
      {
       "queue_name": "simple-queue",
       "message": "Mensagem teste"
      }
      ```
    - Response example
      ```
      Mensagem enviada com sucesso
      ```
    
- POST: localhost:8080/message/header-exchange/ (send message to header exchange)
    - Payload example
      ```
      {
       "queue_name": "second-queue",
       "message": "Mensagem teste"
      }
      ```
    - Response example
      ```
      Mensagem enviada com sucesso
      ```

- POST: localhost:8080/message/fannout-exchange/ (send message to fannout exchange)
    - Payload example-
      ```
      {
       "queue_name": "",
       "message": "Mensagem teste"
      }
      ```
    - Response example
      ```
      Mensagem enviada com sucesso
      ```

- POST: localhost:8080/message/topic-exchange/ (send message to topic exchange)
    - Payload example
      ```
      {
       "queue_name": "second.third",
       "message": "Mensagem teste"
      }
      ```
    - Response example
      ```
      Mensagem enviada com sucesso
      ```

- POST: localhost:8080/message/direct-exchange/ (send message to direct exchange)
    - Payload example
      ```
      {
       "message": "Mensagem teste"
       "routing_key": "simple"
      }
      ```
    - Response example
      ```
      Mensagem enviada com sucesso
      ```



## Details

The code connect to a local running RabbitMQ server:

- http://localhost:15672/
