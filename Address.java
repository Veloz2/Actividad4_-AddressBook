import java.io.*;
import java.util.HashMap;
import java.util.Map;



public class Address{
    private HashMap<String, String>contacts;
    private final String FILE_NAME = "CONTACTOS.csv";

    public Address(){
        contacts = new HashMap<>();

    }

    public void load(){//Se carga el contacto en el archivo
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while ((line = br.readLine()) != null){
                String[] data = line.split(",");
                if(data.length == 2){
                    contacts.put(data[0], data[1]);
                }
            }
            System.out.println("Contactos cargados.");
        } catch (IOException e){
            System.out.println("No se encontro el archivo");
        }
    }
    public void save() { //Guarda los datos registrados
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            bw.write(entry.getKey() + " : " + entry.getValue());
            bw.newLine();
        }
        System.out.println("Contactos guardados correctamente.");
    } catch (IOException e) { 
        System.out.println("Error al guardar los contactos: ");
        }
    }
    public void list(){ //Lista de contactos
        System.out.println("\nContactos:");
            if(contacts.isEmpty()){
                System.out.println("La agenda esta vacia. ");
            } else {
                for (Map.Entry<String, String> entry : contacts.entrySet()){
                    System.out.println(entry.getKey() + " : " + entry.getValue());
                }
            }
    }
    public void create(String number, String name){//Se crea el contacto
        if(contacts.containsKey(number)){
           System.out.println("Ese número ya existe en la agenda."); 
        }else{
            contacts.put(number, name);
            System.out.println("Contacto agregado");
        }
    }
    public void delete(String number){//Se elimina el contacto
        if(contacts.remove(number)!= null){
            System.out.println("Contacto eliminado.");
        } else{
            System.out.println("No existe ese numero.");
        }
    }

}

