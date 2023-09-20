

**Clase `Student`**:
1. La clase `Student` representa una entidad de estudiante con atributos como `id`, `name`, `email` y `age`.
2. La clase `Student` no tiene conocimiento de cómo los datos se almacenan o recuperan de la base de datos. Es una clase pura de dominio que solo contiene datos y lógica relacionada con la entidad estudiante.

**Clase `StudentDataMapper`**:
1. La clase `StudentDataMapper` se encarga de todas las operaciones de acceso a datos relacionadas con la entidad estudiante.
2. El constructor de la clase toma una conexión de base de datos como argumento, lo que permite la flexibilidad de trabajar con diferentes bases de datos o conexiones.
3. Los métodos dentro de `StudentDataMapper`, como `insert`, `findById`, `findAll`, `update` y `delete`, se utilizan para realizar operaciones CRUD en la base de datos.
4. En un entorno real, dentro de estos métodos se utilizaría JDBC (o algún otro marco ORM como Hibernate) para realizar consultas y actualizaciones en la base de datos.

**Clase `Main`**:
1. En la clase principal (`Main`), se crea una instancia de un objeto `Student` para representar un estudiante.
2. Se establecen los datos del estudiante como nombre, correo electrónico y edad.
3. Se crea una instancia de `StudentDataMapper`, pasándole una conexión de base de datos (en este caso, se asume que se utiliza JDBC).
4. Se utilizan métodos de `StudentDataMapper` para realizar diversas operaciones de acceso a datos, como inserción, búsqueda, actualización y eliminación de registros de estudiantes en la base de datos.

En resumen, el patrón Data Mapper se utiliza para separar la lógica de acceso a datos de la lógica del dominio en una aplicación. La clase `StudentDataMapper` actúa como un mapeador entre los objetos de dominio (`Student`) y la base de datos, lo que permite una clara separación de preocupaciones y facilita el mantenimiento y la escalabilidad del código a medida que la aplicación crece.

DIFERENCIAS CON TABLE GATEWAY

La principal diferencia entre el patrón Data Mapper y el patrón Table Gateway radica en cómo abordan la separación de la lógica de acceso a datos en una aplicación:

1. **Data Mapper**:

   - **Responsabilidad**: En el patrón Data Mapper, la responsabilidad de mapear objetos de dominio a estructuras de datos de la base de datos y viceversa se encuentra en el mapeador (el Data Mapper en sí).
   - **Desacoplamiento**: La lógica de acceso a la base de datos está completamente desacoplada de los objetos de dominio. Los objetos de dominio no tienen conocimiento de la base de datos ni de cómo se almacenan los datos.
   - **Flexibilidad**: El Data Mapper permite mapear objetos de dominio a múltiples tablas o estructuras de datos en la base de datos. Puede manejar relaciones complejas y mapeos personalizados.

2. **Table Gateway**:

   - **Responsabilidad**: En el patrón Table Gateway, una clase específica, como `EmployeeTableGateway`, se encarga de todas las operaciones de acceso a la base de datos relacionadas con una tabla específica (por ejemplo, la tabla "Employees").
   - **Acoplamiento**: Los objetos de dominio, como `Employee`, a menudo están más acoplados a la base de datos, ya que la lógica de acceso a la base de datos se incorpora en la misma clase de dominio.
   - **Enfoque en la tabla**: El Table Gateway se centra en las operaciones de base de datos relacionadas con una sola tabla. No proporciona una abstracción para mapear objetos a estructuras de datos más allá de esa tabla específica.

En resumen, la principal diferencia radica en el nivel de acoplamiento entre la lógica de acceso a la base de datos y los objetos de dominio, y en el alcance de responsabilidad de cada patrón:

- **Data Mapper** ofrece un mayor desacoplamiento y flexibilidad al separar completamente la lógica de acceso a datos de los objetos de dominio. Es adecuado para escenarios en los que los objetos de dominio pueden mapearse a múltiples tablas o donde se requiere un alto grado de personalización en el mapeo.

- **Table Gateway** acopla más los objetos de dominio a la base de datos al proporcionar lógica de acceso a datos directamente en las clases de dominio. Es apropiado para situaciones en las que se desea una abstracción simple y específica para una tabla particular en la base de datos.

La elección entre estos patrones depende de los requisitos y la arquitectura de la aplicación. Cada uno tiene sus ventajas y desventajas, y la decisión debe basarse en los objetivos de diseño y la complejidad del sistema.