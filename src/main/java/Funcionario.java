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

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPuesto(String puesto) { this.puesto = puesto; }
}
