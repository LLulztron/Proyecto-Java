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

    public void agregarDepartamento(Departamento departamento) { 
        departamentos.add(departamento); 
    }

    public void eliminarDepartamento(Departamento departamento) {
        departamentos.remove(departamento); 
    }

    public List<Departamento> getDepartamentos() { 
        return departamentos; 
    }

    
}