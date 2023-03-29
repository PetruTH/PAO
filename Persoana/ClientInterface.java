package Persoana;
import Produse.*;

import java.util.List;

public interface ClientInterface {
    public List<Client> getClienti();
    public Client afiseazaClientDupaNrContact(String nr);
    public void stergeClientDupaNrContact(String nr);
    public void adaugaProdusPentruClient(String nr, Produse produs);
    public Client citesteClient();
}
