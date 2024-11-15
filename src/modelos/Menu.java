package modelos;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private ArrayList<Empleado> empleados;
    private ArrayList<Empleado> empleadosOriginales; // Para restaurar el listado original

    public Menu(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
        this.empleadosOriginales = new ArrayList<>(empleados); // Hacemos una copia del original
    }

    static Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        int opcion;

        do {
            // Mostrar las opciones del menú
            System.out.println("Seleccione una opción:");
            System.out.println("1. Mostrar todos los empleados");
            System.out.println("2. Crear empleado");
            System.out.println("3. Filtrar empleados");
            System.out.println("4. Ordenar empleados");
            System.out.println("5. Incrementar salario");
            System.out.println("6. Limpiar filtros");
            System.out.println("7. Salir");

            // Leer la opción seleccionada por el usuario
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            // Ejecutar la acción correspondiente a la opción seleccionada
            switch (opcion) {
                case 1:
                    GestorEmpleados.mostrarEmpleados(empleados);
                    break;
                case 2:
                    crearEmpleado();
                    break;
                case 3:
                    filtrarEmpleados();
                    break;
                case 4:
                    ordenarEmpleados();
                    break;
                case 5:
                    incrementarSalario();
                    break;
                case 6:
                    limpiarFiltros();
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }

            // Esperar 3 segundos antes de mostrar nuevamente el menú
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }

        } while (opcion != 7);

        // Cerrar el scanner al finalizar el programa
        scanner.close();
    }

    private void crearEmpleado() {
        // Solicitar el nombre del nuevo empleado
        System.out.println("Ingrese el nombre del empleado:");
        String nombre = scanner.nextLine();

        // Solicitar la edad del nuevo empleado
        System.out.println("Ingrese la edad del empleado:");
        int edad = scanner.nextInt();

        // Solicitar el salario del nuevo empleado
        System.out.println("Ingrese el salario del empleado:");
        int salario = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        // Solicitar el departamento del nuevo empleado
        System.out.println("Ingrese el departamento del empleado:");
        String departamento = scanner.nextLine();

        // Crear una nueva instancia de Empleado con los datos ingresados
        Empleado nuevoEmpleado = new Empleado(nombre, edad, salario, departamento);

        // Intentar agregar el nuevo empleado a la lista
        if (GestorEmpleados.crearEmpleado(empleados, nuevoEmpleado)) {
            System.out.println("Empleado creado exitosamente.");
        } else {
            System.out.println("Error: Ya existe un empleado con ese nombre.");
        }
    }

    private void filtrarEmpleados() {
        // Mostrar las opciones de criterios de filtro
        System.out.println("""
            Seleccione el criterio de filtro:
            1. Nombre
            2. Edad
            3. Salario
            4. Departamento
            """);

        // Leer la opción seleccionada por el usuario
        int criterio = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        Criterio criterioSeleccionado = null;

        // Mapear la selección del usuario al enum Criterio
        switch (criterio) {
            case 1:
                criterioSeleccionado = Criterio.NOMBRE;
                break;
            case 2:
                criterioSeleccionado = Criterio.EDAD;
                break;
            case 3:
                criterioSeleccionado = Criterio.SALARIO;
                break;
            case 4:
                criterioSeleccionado = Criterio.DEPARTAMENTO;
                break;
            default:
                System.out.println("Selección inválida.");
                return;
        }

        // Verificar si el criterio es nulo, lo que indicaría una opción no válida
        if (criterioSeleccionado == null) {
            System.out.println("Criterio no válido.");
            return;
        }

        // Solicitar el valor de filtro según el criterio seleccionado
        if (criterioSeleccionado == Criterio.NOMBRE || criterioSeleccionado == Criterio.DEPARTAMENTO) {
            System.out.print("Ingrese el valor de filtro: ");
            String valor = scanner.nextLine();
            ArrayList<Empleado> empleadosFiltrados = GestorEmpleados.filtrarEmpleados(empleados, criterioSeleccionado, valor);
            GestorEmpleados.mostrarEmpleados(empleadosFiltrados);
        } else if (criterioSeleccionado == Criterio.EDAD || criterioSeleccionado == Criterio.SALARIO) {
            System.out.print("Ingrese el valor mínimo: ");
            int minValue = scanner.nextInt();
            System.out.print("Ingrese el valor máximo: ");
            int maxValue = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer
            ArrayList<Empleado> empleadosFiltrados = GestorEmpleados.filtrarEmpleados(empleados, criterioSeleccionado, minValue, maxValue);
            GestorEmpleados.mostrarEmpleados(empleadosFiltrados);
        }
    }

    private void ordenarEmpleados() {
        // Mostrar el menú de opciones para que el usuario seleccione un criterio
        System.out.println("""
            Seleccione el criterio para ordenar:
            1. Nombre
            2. Edad
            3. Salario
            4. Departamento
            """);

        // Leer la opción elegida por el usuario
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        // Declarar el criterio que vamos a usar
        Criterio criterio = null;

        // Mapear la opción del usuario al criterio correspondiente
        switch (opcion) {
            case 1:
                criterio = Criterio.NOMBRE;
                break;
            case 2:
                criterio = Criterio.EDAD;
                break;
            case 3:
                criterio = Criterio.SALARIO;
                break;
            case 4:
                criterio = Criterio.DEPARTAMENTO;
                break;
            default:
                System.out.println("Opción no válida.");
                return;  // Si la opción no es válida, salir del método
        }

        // Ordenar los empleados según el criterio seleccionado
        ArrayList<Empleado> empleadosOrdenados = GestorEmpleados.ordenarEmpleados(empleados, criterio);

        // Mostrar los empleados ordenados
        GestorEmpleados.mostrarEmpleados(empleadosOrdenados);
    }

    private void incrementarSalario() {
        // Solicitar el nombre del empleado cuyo salario se va a incrementar
        System.out.println("Ingresa el nombre del empleado:");
        String nombre = scanner.nextLine();

        // Solicitar el porcentaje de incremento
        System.out.println("Ingrese el porcentaje de incremento:");
        int porcentaje = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        // Llamar al método de GestorEmpleados para incrementar el salario
        Empleado empleado = GestorEmpleados.incrementarSalario(empleados, nombre, porcentaje);

        // Verificar si el incremento fue exitoso
        if (empleado != null) {
            System.out.println("Salario incrementado exitosamente.");
            System.out.println(empleado);
        } else {
            System.out.println("Error: No se encontró un empleado con ese nombre.");
        }
    }

    private void limpiarFiltros() {
        // Limpiar la lista de empleados y restaurar la lista original
        empleados.clear();
        empleados.addAll(empleadosOriginales);
        System.out.println("Filtros limpiados.");
    }
}