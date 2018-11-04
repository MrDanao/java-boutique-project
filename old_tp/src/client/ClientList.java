package client;
import java.util.ArrayList;

public class ClientList {

    ArrayList lc;

    public ClientList() {
        lc = new ArrayList();
    }

    public boolean addClient(Client c) {
        lc.add(c);
        return true;
    }

    //public String toString() {
    //    return lc[0] + "";
    //}
}
