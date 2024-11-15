package modelos;

import java.util.ArrayList;
import java.util.Arrays;

public class GestorEmpleados {

    // Constructor privado para evitar la instanciación de esta clase utilitaria
    private GestorEmpleados(){}

    public static void mostrarEmpleados(ArrayList<Empleado> empleados) {
        // Imprimir encabezados de las columnas con formato adecuado
        System.out.println(String.format("%-5s | %-15s | %-5s | %-10s | %-15s", "Fila", "Nombre", "Edad", "Salario", "Departamento"));
        System.out.println("---------------------------------------------------------------");

        int i = 1; // Número de fila
        for (Empleado empleado : empleados) {
            // Imprimir cada empleado con el formato adecuado
            System.out.println(String.format("%-5d | %s", i++, empleado));
        }
        System.out.println();


    }

    public static ArrayList<Empleado> filtrarEmpleados(ArrayList<Empleado> empleados, Criterio criterio, String valor ) {
        ArrayList<Empleado> filterEmpleados = new ArrayList<>();

        // Filtrar empleados según el criterio y valor proporcionados
        switch (criterio) {
            case NOMBRE:
                for (Empleado empleado : empleados) {
                    if (empleado.getNombre().equalsIgnoreCase(valor)) {
                        filterEmpleados.add(empleado);
                    }
                }
                break;
            case DEPARTAMENTO:
                for (Empleado empleado : empleados) {
                    if (empleado.getDepartamento().equalsIgnoreCase(valor)) {
                        filterEmpleados.add(empleado);
                    }
                }
                break;
            default:
                return new ArrayList<>();  // Si no se encuentra el criterio, devolver un array vacío
        }

        return filterEmpleados;
    }

    public static ArrayList<Empleado> filtrarEmpleados(ArrayList<Empleado> empleados, Criterio criterio, int minValue, int maxValue ) {
        ArrayList<Empleado> filterEmpleados = new ArrayList<>();

        // Filtrar empleados según el criterio y rango de valores proporcionados
        switch (criterio) {
            case EDAD:
                for (Empleado empleado : empleados) {
                    if (empleado.getEdad() >= minValue && empleado.getEdad() <= maxValue) {
                        filterEmpleados.add(empleado);
                    }
                }
                break;
            case SALARIO:
                for (Empleado empleado : empleados) {
                    if (empleado.getSalario() >= minValue && empleado.getSalario() <= maxValue) {
                        filterEmpleados.add(empleado);
                    }
                }
                break;
            default:
                return new ArrayList<>();  // Si no se encuentra el criterio, devolver un array vacío
        }

        return filterEmpleados;
    }

    public static ArrayList<Empleado> ordenarEmpleados(ArrayList<Empleado> empleados, Criterio criterio) {
        // Hacer una copia de empleados para no modificar el array original
        ArrayList<Empleado> arrayOrdenado = new ArrayList<>(empleados);

        // Ordenar empleados según el criterio proporcionado
        switch (criterio) {
            case NOMBRE:
                for (int i = 0; i < arrayOrdenado.size() - 1; i++) {
                    for (int j = 0; j < arrayOrdenado.size() - i - 1; j++) {
                        if (arrayOrdenado.get(j).getNombre().compareTo(arrayOrdenado.get(j + 1).getNombre()) > 0) {
                            Empleado aux = arrayOrdenado.get(j);
                            arrayOrdenado.set(j, arrayOrdenado.get(j + 1));
                            arrayOrdenado.set(j + 1, aux);
                        }
                    }
                }
                break;

            case DEPARTAMENTO:
                for (int i = 0; i < arrayOrdenado.size() - 1; i++) {
                    for (int j = 0; j < arrayOrdenado.size() - i - 1; j++) {
                        if (arrayOrdenado.get(j).getDepartamento().compareTo(arrayOrdenado.get(j + 1).getDepartamento()) > 0) {
                            Empleado aux = arrayOrdenado.get(j);
                            arrayOrdenado.set(j, arrayOrdenado.get(j + 1));
                            arrayOrdenado.set(j + 1, aux);
                        }
                    }
                }
                break;

            case EDAD:
                for (int i = 0; i < arrayOrdenado.size() - 1; i++) {
                    for (int j = 0; j < arrayOrdenado.size() - i - 1; j++) {
                        if (arrayOrdenado.get(j).getEdad() > arrayOrdenado.get(j + 1).getEdad()) {
                            Empleado aux = arrayOrdenado.get(j);
                            arrayOrdenado.set(j, arrayOrdenado.get(j + 1));
                            arrayOrdenado.set(j + 1, aux);
                        }
                    }
                }
                break;

            case SALARIO:
                for (int i = 0; i < arrayOrdenado.size() - 1; i++) {
                    for (int j = 0; j < arrayOrdenado.size() - i - 1; j++) {
                        if (arrayOrdenado.get(j).getSalario() > arrayOrdenado.get(j + 1).getSalario()) {
                            Empleado aux = arrayOrdenado.get(j);
                            arrayOrdenado.set(j, arrayOrdenado.get(j + 1));
                            arrayOrdenado.set(j + 1, aux);
                        }
                    }
                }
                break;

            default:
                // Si el criterio no es válido, devolver el array sin ordenar
                return arrayOrdenado;
        }

        return arrayOrdenado;
    }

    static Empleado buscarPorNombre(ArrayList<Empleado> empleados, String nombre){
        // Buscar un empleado por su nombre retornando el objeto Empleado si existe de lo contrario null
        for (Empleado empleado : empleados){
            if(empleado.getNombre().equalsIgnoreCase(nombre)) return empleado;
        }
        return null;
    }

    static Empleado incrementarSalario(ArrayList<Empleado> empleados, String empleado, int aumento){
        // Incrementar el salario de un empleado por un porcentaje dado en caso de que exista
        Empleado emp = buscarPorNombre(empleados, empleado);
        if(emp != null){
            emp.setSalario(emp.getSalario() + emp.getSalario() * aumento / 100);
            return emp;
        }
        return null;
    }

    static boolean crearEmpleado(ArrayList<Empleado> empleados, Empleado empleado){
        // Busca un empleado por su nombre, si no existe agrega el empleado pasado por parámetro a la lista
        Empleado existeEmpleado = buscarPorNombre(empleados, empleado.getNombre());
        if(existeEmpleado == null){
            empleados.add(empleado);
            return true;
        }
        return false;
    }
}