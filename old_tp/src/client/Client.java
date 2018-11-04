package client;

// classe
public class Client {

    // variables de classe
    String name;
    String address;
    int ID;
    static int N = 1; // incrémentateur, ne sera connu que par les clients

    // constructeur
    public Client(String newName, String newAddress) {
        name = newName;
        address = newAddress;
        ID = N;
        N += 1; // pour incrémenter la variable ID
    }

    // plusieurs méthodes

    String getName() {
        return name;
    }

    String getAddress() {
        return address;
    }

    int getId() {
        return ID;
    }

    void display() {
        System.out.println("ID = " + ID + " ; Nom = " + name);
    }

}
