import java.util.Scanner;

public class Main{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        Address book = new Address();
        book.load();
        int opcion;

        do{
            System.out.println("\n--- AGENDA TELEFONICA ---");
            System.out.println("1. Lista de contactos");
            System.out.println("2. Crear contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Guardar y salir");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    book.list();
                    break;
                case 2:
                    System.out.print("Ingresa número telefónico: ");
                    String number = sc.nextLine();
                    System.out.print("Ingresa nombre del contacto: ");
                    String name = sc.nextLine();
                    book.create(number, name);
                    break;
                case 3:
                    System.out.print("Ingresa número a eliminar: ");
                    String deleteNumber = sc.nextLine();
                    book.delete(deleteNumber);
                    break;
                case 4:
                    book.save();
                    System.out.println("Contacto guardado.");
                    break;

                default:
                    System.out.println("Saliendo del programa");
                    break;
            }

        } while (opcion != 4);
        sc.close();
    }
}