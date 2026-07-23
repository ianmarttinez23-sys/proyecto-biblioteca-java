import java.util.Scanner;

public class Main{
    static String cabecera = "==================== BIBLIOTECA ====================";
    static Scanner entrada = new Scanner(System.in);
    static boolean run = true;


    static Libro[] libros = {
        new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", true),
        new Libro("1984", "George Orwell", true),
        new Libro("Cien años de soledad", "Gabriel García Márquez", true),
        new Libro("El Principito", "Antoine de Saint-Exupéry", true),
        new Libro("La Odisea", "Homero", false)
    };
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
                prestarLibro();
                break;
            case 5:
                devolverLibro();    
                break;
            case 6:
                mostrarEstadisticas();
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
        Libro[] libroAñadido = new Libro[libros.length + 1];
        for(int i = 0; i < libros.length; i++){
            libroAñadido[i] = libros[i];
        }

        System.out.println(cabecera);
        System.out.println("Escriba el título del libro que quiera añadir");
        entrada.nextLine();
        String titulo = entrada.nextLine();

        System.out.println(cabecera);
        System.out.println("Escriba el autor del libro que quiera añadir");
        String autor = entrada.nextLine();

        System.out.println(cabecera);
        System.out.println("¿En que estado está el libro que quiere añadir?");
        System.out.println("1. Disponible");
        System.out.println("2. Prestado");
        System.out.println("3. Cancelar");

        int opcion = entrada.nextInt();

        switch (opcion) {
            case 1:
                libroAñadido[libros.length] = new Libro(titulo, autor, true);
                break;

            case 2:
                libroAñadido[libros.length] = new Libro(titulo, autor, false);
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

        for(Libro libro:libros){
            System.out.println(libro.getTitulo());
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

                for(Libro libro:libros){
                    if(libro.getTitulo().equalsIgnoreCase(titulo)){
                        encontrado = true;

                        System.out.println(cabecera);
                        System.out.println("Libro encontrado. Detalles de la obra:");
                        System.out.println("Autor: " + libro.getAutor());
                        System.out.println("Estado: " + (libro.isDisponible() ? "Disponible" : "Prestado"));
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
                for(Libro libro:libros){
                    if(libro.getAutor().equalsIgnoreCase(autor)) encontrado = true;
                }
                if (encontrado) {
                    System.out.println(cabecera);
                    System.out.println("Libros disponibles:");
                    for(Libro libro:libros){
                        if(libro.getAutor().equalsIgnoreCase(autor) && libro.isDisponible()){
                            System.out.println(libro.getTitulo());
                        }
                    }
                    System.out.println("\nLibros prestados:");
                    for(Libro libro:libros){
                        if(libro.getAutor().equalsIgnoreCase(autor) && !libro.isDisponible()){
                            System.out.println(libro.getTitulo());
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

    public static void prestarLibro(){
        System.out.println(cabecera);
        System.out.println("Escribe el nombre del libro que quieras prestar: ");

        entrada.nextLine();
        String titulo = entrada.nextLine();

        for(Libro libro:libros){
            if (!libro.getTitulo().equalsIgnoreCase(titulo)) continue;
            if(!libro.isDisponible()){
                System.out.println("Este libro no está disponible");
            }
            else{
                System.out.println(cabecera);
                System.out.println("¿Estás seguro que quieres prestar el siguiente libro?");
                System.out.println(libro.getTitulo() + " de " + libro.getAutor());
                System.out.println("1. Sí");
                System.out.println("2. No");

                int opcion = entrada.nextInt();
                switch (opcion) {
                    case 1:
                        libro.prestar();;
                        break;
                    case 2:
                        break;

                    default:
                        System.out.println("Acción no reconocida");
                        break;
                }
            }
        }
    }

    public static void devolverLibro(){
        System.out.println(cabecera);
        System.out.println("Escribe el nombre del libro que quieras devolver: ");

        entrada.nextLine();
        String titulo = entrada.nextLine();
        for(Libro libro:libros){
            if (!libro.getTitulo().equalsIgnoreCase(titulo)) continue;
            if(libro.isDisponible()){
                System.out.println("Este libro no ha sido prestado");
            }
            else{
                System.out.println(cabecera);
                System.out.println("¿Estás seguro que quieres devolver el siguiente libro?");
                System.out.println(libro.getTitulo() + " de " + libro.getAutor());
                System.out.println("1. Sí");
                System.out.println("2. No");

                int opcion = entrada.nextInt();
                switch (opcion) {
                    case 1:
                        libro.devolver();;
                        break;
                    case 2:
                        break;

                    default:
                        System.out.println("Acción no reconocida");
                        break;
                }
            }
        }
    }

    public static void mostrarEstadisticas(){
        int disponibles = 0;
        int prestados = 0;

        for(Libro libro: libros){
            if (libro.isDisponible()) disponibles ++;
            else prestados ++;
        }
        
        System.out.println(cabecera);
        System.out.println("Estadísticas:");
        System.out.println("Total de libros en el catálogo: " + libros.length);
        System.out.println("Total de libros disponibles: " + disponibles);
        System.out.println("Total de libros prestados: " + prestados);
        
    }
}