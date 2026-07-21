import java.util.Scanner;

public class Main{
    static String cabecera = "==================== BIBLIOTECA ====================";
    static Scanner entrada = new Scanner(System.in);
    static boolean run = true;

    static String[][] libros = {
            {"Don Quijote de la Mancha", "Miguel de Cervantes", "Disponible"},
            {"1984", "George Orwell", "Disponible"},
            {"Cien años de soledad", "Gabriel García Márquez", "Disponible"},
            {"El Principito", "Antoine de Saint-Exupéry", "Disponible"},
            {"La Odisea", "Homero", "Disponible"}
        };
    static final int TITULO = 0;
    static final int AUTOR = 1;
    static final int ESTADO = 2;

    public static void main(String[] args){
        while (run) {
            mostrarMenu();
        }
    }

    public static void mostrarMenu(){
        System.out.println(cabecera);
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
                añadirLibro();
                break;
            case 2:
                mostrarLibros();
                break;
            case 3:
                buscarLibro();
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                System.out.println("Hasta pronto");
                run = false;
                break;
        
            default:
                System.out.println("Acción no reconocida");
                mostrarMenu();
                break;
        }
    }

    public static void añadirLibro(){
        String[][] libroAñadido = new String[libros.length + 1][3];
        for(int i = 0; i < libros.length; i++){
            for(int j = 0; j < 3; j++){
                libroAñadido[i][j] = libros[i][j];
            }
        }

        System.out.println(cabecera);
        System.out.println("Escriba el título del libro que quiera añadir");
        entrada.nextLine();
        String titulo = entrada.nextLine();

        System.out.println(cabecera);
        System.out.println("Escriba el autor del libro que quiera añadir");
        String autor = entrada.nextLine();

        libroAñadido[libros.length][TITULO] = titulo;
        libroAñadido[libros.length][AUTOR] = autor;
        
        System.out.println(cabecera);
        System.out.println("¿En que estado está el libro que quiere añadir?");
        System.out.println("1. Disponible");
        System.out.println("2. Prestado");
        System.out.println("3. Cancelar");

        int opcion = entrada.nextInt();

        switch (opcion) {
            case 1:
                libroAñadido[libros.length][ESTADO] = "Disponible";
                break;

            case 2:
                libroAñadido[libros.length][ESTADO] = "Prestado";
                break;

            case 3:
                System.out.println("Cancelando");
                break;
        
            default:
                System.out.println("Acción no reconocida");
                break;
        }

        libros = libroAñadido;
    }

    public static void mostrarLibros(){
        System.out.println(cabecera);
        System.out.println("Libros en el catálogo:");

        for(String[] libro:libros){
            System.out.println(libro[TITULO]);
        }
    }

    public static void buscarLibro(){
        boolean encontrado = false;

        System.out.println(cabecera);
        System.out.println("Buscador de libros");
        System.out.println("1. Buscar por título");
        System.out.println("2. Buscar por autor");
        System.out.println("3. Atrás");

        int opcion = entrada.nextInt();
        switch (opcion) {
            case 1:
                System.out.println(cabecera);
                System.out.println("Buscar libro por título");
                System.out.println("Introduzca el título del libro que quiere buscar:");
                
                entrada.nextLine();
                String titulo = entrada.nextLine();

                for(String[] libro:libros){
                    if(libro[TITULO].equalsIgnoreCase(titulo)){
                        encontrado = true;

                        System.out.println(cabecera);
                        System.out.println("Libro encontrado. Detalles de la obra:");
                        System.out.println("Autor: " + libro[AUTOR]);
                        System.out.println("Estado: " + libro[ESTADO]);
                    }
                }

                if(!encontrado) System.out.println("Libro no enontrado.");

                break;

            case 2:
                System.out.println(cabecera);
                System.out.println("Buscar libro por autor");
                System.out.println("Introduzca el nombre del autor del libro que quiere buscar:");

                entrada.nextLine();
                String autor = entrada.nextLine();

                // Puede ser peligroso recorrer tres veces la misma lista ya que puede relentizar el programa
                // pero no encuentro otra manera.
                for(String[] libro:libros){
                    if(libro[AUTOR].equalsIgnoreCase(autor)) encontrado = true;
                }
                if (encontrado) {
                    System.out.println(cabecera);
                    System.out.println("Libros disponibles:");
                    for(String[] libro:libros){
                        if(libro[AUTOR].equalsIgnoreCase(autor) && libro[ESTADO].equalsIgnoreCase("Disponible")){
                            System.out.println(libro[TITULO]);
                        }
                    }
                    System.out.println("\nLibros prestados:");
                    for(String[] libro:libros){
                        if(libro[AUTOR].equalsIgnoreCase(autor) && libro[ESTADO].equalsIgnoreCase("Prestado")){
                            System.out.println(libro[TITULO]);
                        }
                    }
                }
                else System.out.println("Autor no encontrado");
                break;

            case 3:
                break;

            default:
                System.out.println("Acción no reconocida");
                break;
        }
    }

}