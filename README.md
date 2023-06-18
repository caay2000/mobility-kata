# mobility-kata

A Mobility Service from scratch with Ktor and Arrow (Hexagonal, CQRS, DDD, Event Sourcing)

# Descipcion

Queremos un sistema de vehiculos privado para una ciudad/pueblo/empresa.

## 1. Para poder usar el servicio, el usuario se tiene que registrar en el sistema
 - 1.1 El registro requiere un email, phone, name, surname, address, city, postal code, country
 - 1.2 tambien requiere un metodo de pago (targeta de credito). para ello necesitamos un numero de tarjeta, caducidad (mes/año) y cvc
 - 1.3 para simular la validacion y/o pago con dicha tarjeta, entregaremos una libreria funcional
 - 1.4 una vez tengamos todos los datos y un metodo de pago verificado, podemos decir que el usuario esta validado


## 2. El sistema dispondra de varios vehiculos.
 - 2.1 cada vehiculo necesita una matricula, nivel de bateria, un nivel de condicion y una valoracion economica
 - 2.2 los vehiculos solo se pueden aparcar en estaciones. Una estacion llena no puede recibir mas vehiculos
 - 2.3 cada estacion tiene un nombre, numero de plazas, y posicion


## 3. Un usuario registrado y validado podra reservar un vehiculo
 - 3.1 una vez se reserva un vehiculo desde una estacion, se la matricula del vehiculo y el usuario tiene 5 minutos para poder desanclar
   el vehiculo
 - 3.2 una vez el vehiculo esta desanclado de la estacion, el usuario puede usarlo y devolverlo a otra estacion (o incluso la misma)
 - 3.3 una estacion con todas las plazas ocupadas, no tiene capacidad para mas vehiculos. El usuario debera encontrar otra estacion para
   aparcar su vehiculo
 - 3.4 al usuario se le cobrara por tiempo de uso, segun estas reglas:
     - hasta 30 min de uso -> 0,01 por minuto
     - de 30 min a 60 min -> 0,05 por minuto
     - mas de 60 min -> 0,50 por minuto
     - mas de 180 minutos -> el vehiculo se considerara perdido y se aplicara una multa del doble de la valoracion del vehiculo
 - 3.5 siempre que pasemos de 60 minutos, se bloqueara al usuario durante una semana. Si se pasa de 180 minutos, el bloqueo sera
   permanente
 - 3.6 si el pago falla, se bloqueara al usuario hasta que el pago sea realizado correctamente llamando a nuestros operadores

## 4. **EXTRA**: Los vehiculos se actualizan de la siguiente forma:
 - se pierde 1% de bateria por cada minuto (hasta un minimo de 0)
 - el vehiculo gana 0,5% de bateria cada minuto anclado en una estacion (hasta un maximo de 100)
 - se pierde un 1% de condicion cada 30 minutos de uso
 - el valor de la bici baja un 0,5% del precio actual por cada viaje hasta un minimo de 20%
 - Los vehiculos se pueden llevar al almacen para mantenimiento.
 - Cada vehiculo en mantenimiento inoperable por usuarios y su condicion volvera al 100 una vez reparado.
 - Una vez devuelto a una estacion, volvera a ser operable por usuarios
	
	


## ANEXOS

### Metodo de Pago - Cliente SDK
  - Card Number:
    - Numerico
    - Formato: `XXXX XXXX XXXX XXXX`
    - Primer digito 4 o bien 51 a 55
  - Card Month
    - Formato: `01`, `02`, `03` hasta `10`, `11`, `12`
  - Card Year
    - Formato: `2020` hasta `2039`
  - Card CVC
    - Numerico
    - Formato: `XXX`
  - Card Holder Name
    - Alfabetico
    - Longitud: Minima 2, Maxima 40
       