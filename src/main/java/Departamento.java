import java.util.ArrayList;
import java.util.List;

public class Departamento 
{
    private String nombre;
    private List<Funcionario> funcionarios;

    public Departamento(String nombre) 
    {
        this.nombre = nombre;
        this.funcionarios = new ArrayList<>();
    }

    public void agregarFuncionario(Funcionario funcionario) { funcionarios.add(funcionario); }

    public void eliminarFuncionario(Funcionario funcionario) { funcionarios.remove(funcionario); }

    public List<Funcionario> getFuncionarios() { return funcionarios; }

    public int obtenerCantidadFuncionarios() { return funcionarios.size(); }

    @Override
    public String toString() 
    {
        return "Departamento" + "nombre: " + nombre + '\'' + " funcionarios: " + funcionarios;
    }
}