package modelos;

import java.util.Comparator;

public class Comparadores {

    public static class ComparadorPorNombre implements Comparator<Empleado> {
        @Override
        public int compare(Empleado e1, Empleado e2) {
            return e1.getNombre().compareTo(e2.getNombre());
        }
    }

    public static class ComparadorPorDepartamento implements Comparator<Empleado> {
        @Override
        public int compare(Empleado e1, Empleado e2) {
            return e1.getDepartamento().compareTo(e2.getDepartamento());
        }
    }

    public static class ComparadorPorEdad implements Comparator<Empleado> {
        @Override
        public int compare(Empleado e1, Empleado e2) {
            return Integer.compare(e1.getEdad(), e2.getEdad());
        }
    }

    public static class ComparadorPorSalario implements Comparator<Empleado> {
        @Override
        public int compare(Empleado e1, Empleado e2) {
            return Double.compare(e1.getSalario(), e2.getSalario());
        }
    }
}
