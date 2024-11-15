package modelos;

public class Empleado {
    private String nombre;
    private int edad;
    private int salario;
    private String departamento;

    public Empleado(String nombre, int edad, int salario, String departamento) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // El toString() se llama automáticamente cuando se imprime un objeto de esta clase
    @Override
    public String toString() {
        // Ahora se utiliza %.2f para formato de salario con 2 decimales
        // -15 indica que el string se imprimirá en 15 caracteres alineado a la izquierda y asi con los demás
        return String.format("%-15s | %-5d | %-10d | %-15s", nombre, edad, salario, departamento);
    }

}
