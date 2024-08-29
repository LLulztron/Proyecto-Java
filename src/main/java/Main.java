import java.util.ArrayList;
import java.util.List;

public class Funcionario 
{
    private String nombre;
    private String puesto;

    public Funcionario(String nombre, String puesto) 
    {
        this.nombre = nombre;
        this.puesto = puesto;
    }

    public String getNombre() { return nombre; }

    public String getPuesto() { return puesto; }

    @Override
    public String toString() 
    {
        return "Funcionario{" + "nombre='" + nombre + '\'' + ", puesto='" + puesto + '\'' + '}';
    }
}

public class Departamento 
{
    private String nombre;
    private List < Funcionario > funcionarios;

    public Departamento(String nombre) 
    {
        this.nombre = nombre;
        this.funcionarios = new ArrayList<>();
    }

    public void agregarFuncionario(Funcionario funcionario) { funcionarios.add(funcionario); }

    public void eliminarFuncionario(Funcionario funcionario) { funcionarios.remove(funcionario); }

    public List < Funcionario > getFuncionarios() { return funcionarios; }

    public int obtenerCantidadFuncionarios() { return funcionarios.size(); }

    @Override
    public String toString() 
    {
        return "Departamento{" +
                "nombre='" + nombre + '\'' +
                ", funcionarios=" + funcionarios +
                '}';
    }
}

public class Ministerio 
{
    private String nombre;
    private List<Departamento> departamentos;

    public Ministerio(String nombre) {
        this.nombre = nombre;
        this.departamentos = new ArrayList<>();
    }

    public void agregarDepartamento(Departamento departamento) { departamentos.add(departamento); }

    public void eliminarDepartamento(Departamento departamento) { departamentos.remove(departamento);}

    public List < Departamento > getDepartamentos() { return departamentos; }

    public void balancearFuncionarios() 
    {
        int totalFuncionarios = departamentos.stream()
                                             .mapToInt(Departamento::obtenerCantidadFuncionarios)
                                             .sum();
        int media = totalFuncionarios / departamentos.size();

        // Simulación de balanceo de funcionarios (solo como ejemplo)
        for (Departamento dept : departamentos) 
        {
            int exceso = dept.obtenerCantidadFuncionarios() - media;
            // Implementar la lógica de reubicación según el exceso
        }
    }

    @Override
    public String toString() {
        return "Ministerio{" +
                "nombre='" + nombre + '\'' +
                ", departamentos=" + departamentos +
                '}';
    }
}

public class Main 
{
    public static void main(String[] args) 
    {
        Ministerio ministerioSalud = new Ministerio("Ministerio de Salud");

        Departamento deptoHospitales = new Departamento("Hospitales");
        Departamento deptoClinicas = new Departamento("Clínicas");

        Funcionario func1 = new Funcionario("Juan Pérez", "Doctor");
        Funcionario func2 = new Funcionario("María Gómez", "Enfermera");

        deptoHospitales.agregarFuncionario(func1);
        deptoClinicas.agregarFuncionario(func2);

        ministerioSalud.agregarDepartamento(deptoHospitales);
        ministerioSalud.agregarDepartamento(deptoClinicas);

        // Mostrar el estado inicial del ministerio
        System.out.println(ministerioSalud);

        // Balancear funcionarios si hay déficit o superávit
        ministerioSalud.balancearFuncionarios();

        // Mostrar el estado final del ministerio
        System.out.println(ministerioSalud);
    }
}