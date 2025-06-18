# Capturas de funcionamiento

## 1. Configuración Apache JMeter
En JMeter cramos el Thread Group con:
  - 100 usuarios (threads)
  -Ramp-up: 10 segundos

Tambien agregamos el HTTP Request con el metodo GET y URL **http://localhost:8080/api/slow** y los View Results in Table y Summary Report.

![Texto alternativo](Images/Captura%20de%20pantalla%202025-06-18%20002645.png) 

## 2. Ejecucion del microservicio
Ejecutamos la prueba con **server.tomcat.virtual-threads-enabled=true** y vemos los logs que salen en la termina

![Texto alternativo](Images/Captura%20de%20pantalla%202025-06-18%20002521.png)


![Texto alternativo](Images/Captura%20de%20pantalla%202025-06-18%20002508.png)

