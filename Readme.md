# Sistema de Gestión de Empleados

Este proyecto es un sistema de gestión de empleados que permite crear, filtrar, ordenar y gestionar empleados en una empresa. A continuación, se explica cómo funciona el código y sus métodos principales.

## Clases Principales

### Empleado
La clase `Empleado` representa a un empleado con los siguientes atributos:
- `nombre`: El nombre del empleado.
- `edad`: La edad del empleado.
- `salario`: El salario del empleado.
- `departamento`: El departamento al que pertenece el empleado.

### GestorEmpleados
La clase `GestorEmpleados` contiene métodos estáticos para gestionar empleados:

- `mostrarEmpleados(ArrayList<Empleado> empleados)`: Muestra la lista de empleados en un formato tabular. Este método recorre la lista de empleados y los imprime con un formato específico.

- `filtrarEmpleados(ArrayList<Empleado> empleados, Criterio criterio, String valor)`: Filtra empleados por nombre o departamento. Dependiendo del criterio, recorre la lista de empleados y agrega a una nueva lista aquellos que coinciden con el valor proporcionado.

- `filtrarEmpleados(ArrayList<Empleado> empleados, Criterio criterio, int minValue, int maxValue)`: Filtra empleados por edad o salario. Dependiendo del criterio, recorre la lista de empleados y agrega a una nueva lista aquellos que están dentro del rango de valores proporcionado.

- `ordenarEmpleados(ArrayList<Empleado> empleados, Criterio criterio)`: Ordena empleados según un criterio. Dependiendo del criterio, utiliza un algoritmo de ordenamiento para organizar la lista de empleados.

- `incrementarSalario(ArrayList<Empleado> empleados, String nombre, int porcentaje)`: Incrementa el salario de un empleado. Busca al empleado por nombre y aumenta su salario en el porcentaje especificado.

- `crearEmpleado(ArrayList<Empleado> empleados, Empleado empleado)`: Crea un nuevo empleado. Verifica si ya existe un empleado con el mismo nombre y, si no es así, lo agrega a la lista.

### Menu
La clase `Menu` permite al usuario interactuar con el sistema a través de un menú:

- `mostrarMenu()`: Muestra el menú principal con opciones para gestionar empleados. Permite al usuario seleccionar una opción y llama al método correspondiente.

- `crearEmpleado()`: Permite crear un nuevo empleado. Solicita al usuario los datos del nuevo empleado y llama al método `crearEmpleado` de `GestorEmpleados`.

- `filtrarEmpleados()`: Permite filtrar empleados. Solicita al usuario el criterio y el valor de filtro, y llama al método `filtrarEmpleados` de `GestorEmpleados`.

- `ordenarEmpleados()`: Permite ordenar empleados. Solicita al usuario el criterio de ordenamiento y llama al método `ordenarEmpleados` de `GestorEmpleados`.

- `incrementarSalario()`: Permite incrementar el salario de un empleado. Solicita al usuario el nombre del empleado y el porcentaje de incremento, y llama al método `incrementarSalario` de `GestorEmpleados`.

- `limpiarFiltros()`: Restaura la lista original de empleados. Limpia la lista de empleados filtrados y la reemplaza con la lista original.

### Criterio
El `enum` `Criterio` define los criterios que se pueden utilizar para filtrar y ordenar empleados. Los valores posibles son:

- `NOMBRE`: Filtra u ordena empleados por nombre.
- `EDAD`: Filtra u ordena empleados por edad.
- `SALARIO`: Filtra u ordena empleados por salario.
- `DEPARTAMENTO`: Filtra u ordena empleados por departamento.


### Aplicacion
La clase `Aplicacion` es el punto de entrada del programa. Crea una lista de empleados y muestra el menú para que el usuario interactúe con el sistema.

#### Métodos:
- `main(String[] args)`: El método principal que inicializa la aplicación. Crea una lista de empleados aleatorios, instancia la clase `Menu` y llama al método `mostrarMenu`.

## Casos de Uso

1. **Inicio**: El programa comienza en la clase `Aplicacion`, donde se crean empleados aleatorios.
2. **Menú**: Se muestra un menú con opciones para gestionar empleados.
3. **Gestión**: El usuario puede crear, filtrar, ordenar y modificar empleados a través del menú.
4. **Salida**: El programa finaliza cuando el usuario selecciona la opción de salir.

### Ejemplo de Uso

1. **Mostrar Empleados**: El usuario selecciona la opción 1 del menú para mostrar todos los empleados. El método `mostrarEmpleados` de `GestorEmpleados` es llamado y muestra la lista de empleados.

2. **Crear Empleado**: El usuario selecciona la opción 2 del menú para crear un nuevo empleado. El método `crearEmpleado` de `Menu` solicita los datos del nuevo empleado y llama al método `crearEmpleado` de `GestorEmpleados`.

3. **Filtrar Empleados**: El usuario selecciona la opción 3 del menú para filtrar empleados. El método `filtrarEmpleados` de `Menu` solicita el criterio y el valor de filtro, y llama al método `filtrarEmpleados` de `GestorEmpleados`.

4. **Ordenar Empleados**: El usuario selecciona la opción 4 del menú para ordenar empleados. El método `ordenarEmpleados` de `Menu` solicita el criterio de ordenamiento y llama al método `ordenarEmpleados` de `GestorEmpleados`.

5. **Incrementar Salario**: El usuario selecciona la opción 5 del menú para incrementar el salario de un empleado. El método `incrementarSalario` de `Menu` solicita el nombre del empleado y el porcentaje de incremento, y llama al método `incrementarSalario` de `GestorEmpleados`.

6. **Limpiar Filtros**: El usuario selecciona la opción 6 del menú para limpiar los filtros aplicados. El método `limpiarFiltros` de `Menu` restaura la lista original de empleados.

Este sistema permite a los usuarios gestionar empleados de manera sencilla y eficiente.