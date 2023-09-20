
**Clase `Student` (Estudiante)**:
1. Primero, definí una clase llamada `Student` para representar la entidad de un estudiante. Esta clase tiene atributos como `id`, `name`, `email`, y `age` (identificación, nombre, correo electrónico y edad).

2. Agregué los métodos constructores, getters y setters para interactuar con los atributos del estudiante.

**Clase `StudentQuery` (Consulta de Estudiantes)**:
1. Luego, creé una clase llamada `StudentQuery` que representa el Query Object en sí. Esta clase es responsable de encapsular la lógica de una consulta específica a la base de datos.

2. En el constructor de la clase, se recibe una conexión de base de datos como argumento. Esto me permite interactuar con la base de datos dentro de la clase.

3. Dentro de la clase `StudentQuery`, implementé un método llamado `findByAge` (buscarPorEdad) que toma la edad como parámetro. Este método realiza una consulta a la base de datos para recuperar estudiantes que tengan la edad proporcionada.

4. Usé SQL para construir la consulta que busca estudiantes por su edad, y luego utilicé JDBC (Java Database Connectivity) para ejecutar la consulta y obtener los resultados.

5. Para cada fila de resultados obtenidos de la base de datos, usé un método `mapRowToStudent` (mapearFilaAEstudiante) para crear objetos `Student` a partir de los datos y los agregué a una lista.

**Clase `Main` (Principal)**:
1. En la clase principal llamada `Main`, creé una instancia de la clase `StudentQuery` pasándole una conexión de base de datos.

2. Luego, definí la edad objetivo que deseaba buscar (por ejemplo, 25 años) y llamé al método `findByAge` de `StudentQuery` para obtener una lista de estudiantes que coincidan con esa edad.

3. Finalmente, iteré a través de la lista de estudiantes y mostré sus nombres y edades en la consola.

En resumen, esta implementación utiliza el patrón Query Object para encapsular la consulta de búsqueda de estudiantes por edad en una clase separada. Esto hace que el código sea más modular y mantenible, ya que la lógica de la consulta está contenida en un solo lugar y se puede reutilizar fácilmente en toda la aplicación.