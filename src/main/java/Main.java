import java.util.Scanner;

public class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del ministerio: ");
        String nombreMinisterio = scanner.nextLine();
        Ministerio ministerio = new Ministerio(nombreMinisterio);
        int opcion;

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Agregar Departamento");
            System.out.println("2. Eliminar Departamento");
            System.out.println("3. Agregar Funcionario");
            System.out.println("4. Eliminar Funcionario");
            System.out.println("5. Mostrar Estado del Ministerio");
            System.out.println("6. Balancear Funcionarios");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del departamento: ");
                    String nombreDepto = scanner.nextLine();
                    ministerio.agregarDepartamento(new Departamento(nombreDepto));
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 7);

        scanner.close();
    }
}