
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
        return "Funcionario{" + "nombre :'" + nombre + '\'' + ", puesto='" + puesto + '\'' + '}';
    }
}
