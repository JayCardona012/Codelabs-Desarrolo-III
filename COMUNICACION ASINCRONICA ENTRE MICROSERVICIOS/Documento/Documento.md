# Capturas de funcionamiento

## 1. Inicio de secion en RabbitMQ
Luego de generar el docker-compose, levantamos el doker con **docker-compose up -d** y los microservicios de pedidos y productos e iniciamos secion en **RabbitMQ** con las credenciales que nos brindan

![Texto alternativo](Images/Captura%20de%20pantalla%202025-06-17%20232955.png)
*(Imagen: Logo de Spring Cloud)*  

## 2. Solicitud POST 
Con insomnia hacemos una solicitud POST con el JSON que contiene los productos

![Texto alternativo](Images/Captura%20de%20pantalla%202025-06-17%20233639.png)

## 3. Datos recibidos en producto-service  
Comprobamos que los datos fueron recibidos exitosamente en el microservicio de productos

![Texto alternativo](Images/Captura%20de%20pantalla%202025-06-17%20233850.png)

## 4. Estado de RabbitMQ

![Texto alternativo](Images/Captura%20de%20pantalla%202025-06-17%20233904.png)

