import java.util.ArrayList;
import java.util.List;

public class Ministerio 
{
    private String nombre;
    private List<Departamento> departamentos;

    public Ministerio(String nombre) {
        this.nombre = nombre;
        this.departamentos = new ArrayList <Departamento> ();
    }

    public void agregarDepartamento(Departamento departamento) { departamentos.add(departamento); }

    public void eliminarDepartamento(Departamento departamento) { departamentos.remove(departamento); }

    public List<Departamento> getDepartamentos() { return departamentos; }

    public void balancearFuncionarios() 
    {
        if (departamentos.isEmpty()) {
            System.out.println("No hay departamentos para balancear.");
            return;
        }

        int totalFuncionarios = departamentos.stream()
                                             .mapToInt(Departamento::obtenerCantidadFuncionarios)
                                             .sum();
        int media = totalFuncionarios / departamentos.size();

        List<Funcionario> excesoFuncionarios = new ArrayList<>();
        List<Departamento> deficitDepartamentos = new ArrayList<>();

        for (Departamento dept : departamentos) 
        {
            int exceso = dept.obtenerCantidadFuncionarios() - media;

            if (exceso > 0) 
            {
                List<Funcionario> funcionariosDept = dept.getFuncionarios();
                for (int i = 0; i < exceso; i++) 
                {
                    excesoFuncionarios.add(funcionariosDept.get(i));
                }
            } else if (exceso < 0) {
                deficitDepartamentos.add(dept);
            }
        }

        for (Departamento dept : deficitDepartamentos) 
        {
            int deficit = media - dept.obtenerCantidadFuncionarios();
            for (int i = 0; i < deficit && !excesoFuncionarios.isEmpty(); i++) 
            {
                Funcionario funcionarioReubicado = excesoFuncionarios.remove(0);
                dept.agregarFuncionario(funcionarioReubicado);
            }
        }

        System.out.println("Balanceo de funcionarios completado.");
    }

    @Override
    public String toString() {
        return "Ministerio :" + "nombre : '" + nombre + '\'' + ", departamentos=" + departamentos;
    }
}