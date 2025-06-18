# Jairo Andres Gomez Cardona - 2259332

# Respuestas: ADD y Clean Architecture

## 1. ¿Qué es Attribute-Driven Design (ADD) y cuál es su propósito en el diseño de software?

El diseño impulsado por los atributos **ADD (Attribute-Driven Design)** es una metodología de diseño de arquitectura que se enfoca en definir la arquitectura de un sistema de software utilizando exclusivamente los atributos de calidad del sistema. Su objetivo principal es asegurarse de que la arquitectura resultante satisfaga los atributos de calidad críticos y no funcionales, como el rendimiento, la seguridad, la escalabilidad, la disponibilidad, etc. ADD permite tomar decisiones arquitectónicas basadas en las necesidades reales del negocio y los usuarios. Prioriza los atributos de calidad incluso desde la etapa temprana de diseño.

## 2. ¿Cómo se relaciona ADD con Clean Architecture en el proceso de diseño de sistemas?

La relación entre ADD y Clean Architecture es **complementaria y secuencial**:

- **ADD se aplica primero** para definir la arquitectura general basada en atributos de calidad.
- **Clean Architecture se aplica después** para estructurar el código y organizar la separación de responsabilidades en capas bien definidas.

ADD responde al "qué" y "por qué" de la arquitectura, mientras que Clean Architecture responde al "cómo" implementarla de manera desacoplada y mantenible.

## 3. ¿Cuáles son los pasos principales del método ADD para definir una arquitectura de software?

El proceso ADD se desarrolla en **4 fases principales**:

### Fase 1: Definir los atributos de calidad y restricciones
- Identificar requisitos del sistema
- Definir atributos de calidad prioritarios
- Establecer restricciones tecnológicas

### Fase 2: Diseñar la arquitectura con base en atributos de calidad
- Seleccionar tácticas arquitectónicas para cada atributo
- Establecer módulos principales del sistema
- Definir interacción entre componentes

### Fase 3: Implementar siguiendo Clean Architecture
- Organizar el código en capas (Dominio, Aplicación, Infraestructura, Presentación)

### Fase 4: Validar y refinar la arquitectura
- Evaluar cumplimiento de atributos de calidad
- Aplicar revisiones y optimizaciones

## 4. ¿Cómo se identifican los atributos de calidad en ADD y por qué son importantes?

Los atributos de calidad se identifican mediante:

- Análisis de requisitos del sistema
- Definición de métricas específicas y medibles
- Establecimiento de prioridades según necesidades del negocio

### Ejemplos:
- **Disponibilidad**: Alta disponibilidad 99.9%
- **Rendimiento**: Respuesta en menos de 2 segundos
- **Seguridad**: Cifrado en datos sensibles

### Importancia:
- Determinan las decisiones arquitectónicas fundamentales
- Permiten evaluar objetivamente el éxito de la arquitectura
- Guían la selección de tácticas y tecnologías apropiadas
- Aseguran que la solución cumpla las expectativas del negocio

## 5. ¿Por qué Clean Architecture complementa ADD en la implementación de una solución?

Clean Architecture complementa ADD porque:

- ADD define **qué** atributos de calidad necesita el sistema
- Clean Architecture define **cómo** estructurar el código para lograrlos

### Aportes de Clean Architecture:
- Separación clara de responsabilidades en capas bien definidas
- Inversión de dependencias
- Independencia de frameworks
- Estructura modular

## 6. ¿Qué criterios se deben considerar al definir las capas en Clean Architecture dentro de un proceso ADD?

### Criterios basados en atributos de calidad:
- **Testabilidad**: separar claramente la lógica de negocio
- **Escalabilidad**: diseñar capas distribuibles
- **Mantenibilidad**: minimizar dependencias

### Organización de capas:
- **Dominio**: Entidades y reglas de negocio
- **Aplicación**: Casos de uso
- **Infraestructura**: Implementaciones técnicas
- **Presentación**: Interfaces de usuario

### Principio de dependencias:
- Las capas internas no deben depender de las externas

## 7. ¿Cómo ADD ayuda a tomar decisiones arquitectónicas basadas en necesidades del negocio?

ADD facilita decisiones porque:

- Prioriza atributos según el valor de negocio
- Proporciona métricas objetivas
- Guía la selección de tácticas

### Ejemplo:
Si se requiere alta disponibilidad, ADD orienta hacia instancias replicadas con failover automático.

## 8. ¿Cuáles son los beneficios de combinar ADD con Clean Architecture en un sistema basado en microservicios?

### Beneficios:
- Diseño orientado a calidad
- Desacoplamiento efectivo
- Escalabilidad granular
- Mantenibilidad distribuida
- Testabilidad mejorada

## 9. ¿Cómo se asegura que la arquitectura resultante cumpla con los atributos de calidad definidos en ADD?

### Validación en Fase 4:
- Evaluación continua
- Pruebas específicas
- Identificación de problemas
- Optimización iterativa

## 10. ¿Qué herramientas o metodologías pueden ayudar a validar una arquitectura diseñada con ADD y Clean Architecture?

### Herramientas:
- Monitoreo de rendimiento
- Pruebas de carga
- Análisis de seguridad
- Análisis de dependencias
- Testing automatizado

### Metodologías:
- Revisiones periódicas
- Evaluación de métricas
- Pruebas continuas
- Mejora iterativa de arquitectura