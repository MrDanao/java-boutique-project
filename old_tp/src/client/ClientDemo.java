package client;
import java.util.ArrayList;

public class ClientDemo {

    public static void main(String[] args) {

        ClientList l = new ClientList();
        Client c1 = new Client("Dan", "address..");
        l.addClient(c1);
        System.out.println(l);
        //Client dt = new Client("dantran", "lognes");
        //Client el = new Client("evaristoluis", "evry");
        //dt.display();
        //el.display();

    }

}
