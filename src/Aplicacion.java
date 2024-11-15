import modelos.*;

import java.util.ArrayList;
import java.util.Random;

public class Aplicacion {
    public static void main(String[] args) {

        // Arreglo de nombres de ejemplo para los empleados
        String[] nombres = {
                "Juan", "Ana", "Pedro", "Maria", "Luis", "Carla", "Jose", "Lucia", "Marta", "David",
                "Carmen", "Antonio", "Laura", "Jorge", "Isabel", "Francisco", "Paula", "Raul", "Sofia", "Pablo",
        };

        // Arreglo de departamentos de ejemplo para los empleados
        String[] departamentos = {
                "Ventas", "Marketing", "Desarrollo",
        };

        // Crear la lista de empleados
        ArrayList<Empleado> empleados = new ArrayList<>();

        // Instancia de Random para generar valores aleatorios
        Random random = new Random();

        // Llenar la lista con 5 empleados generados aleatoriamente, se puede cambiar el número de empleados
        for (int i = 1; i <= 5; i++) {
            String nombre = nombres[random.nextInt(nombres.length)];  // Seleccionar un nombre aleatorio
            int edad = 20 + random.nextInt(15);  // Generar una edad aleatoria entre 20 y 35
            int salario = 1500 + random.nextInt(1000);  // Generar un salario aleatorio entre 1500 y 2500
            String departamento = departamentos[random.nextInt(departamentos.length)];  // Seleccionar un departamento aleatorio
            // Crear y agregar el empleado a la lista
            empleados.add(new Empleado(nombre, edad, salario, departamento));
        }

        // Crear una instancia de la clase Menu y pasar la lista de empleados
        Menu menu = new Menu(empleados);

        // Mostrar el menú para que el usuario interactúe con el sistema
        menu.mostrarMenu();
    }
}