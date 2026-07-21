import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        /*
        String[][] libros = {
            {"Don Quijote de la Mancha", "Miguel de Cervantes", "Disponible"},
            {"1984", "George Orwell", "Disponible"},
            {"Cien años de soledad", "Gabriel García Márquez", "Disponible"},
            {"El Principito", "Antoine de Saint-Exupéry", "Disponible"},
            {"La Odisea", "Homero", "Disponible"}
        };
        final int TITULO = 0;
        final int AUTOR = 1;
        final int ESTADO = 2;

        int numeroLibros = libros.length; */
        mostrarMenu();
    }

    public static void mostrarMenu(){
        Scanner entrada = new Scanner(System.in);

        System.out.println("==================== BIBLIOTECA ====================");
        System.out.println("1. Añadir libro");
        System.out.println("2. Mostrar libros");
        System.out.println("3. Buscar libro");
        System.out.println("4. Prestar libro");
        System.out.println("5. Devolver libro");
        System.out.println("6. Estadísticas");
        System.out.println("7. Salir");

        int opcion = entrada.nextInt();
        switch (opcion) {
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
                break;
            case 3:
                System.out.println(3);
                break;
            case 4:
                System.out.println(4);
                break;
            case 5:
                System.out.println(5);
                break;
            case 6:
                System.out.println(6);
                break;
            case 7:
                System.out.println("Hasta pronto");
                break;
        
            default:
                System.out.println("Acción no reconocida");
                mostrarMenu();
                break;
        }

    }
}