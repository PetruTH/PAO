package FirmaDealerShip;
import Persoana.*;
import Sediu.*;
import Produse.*;
public interface dsInterface {
    public void adaugaAngajat(Angajat angajat);
    public Angajat afiseazaAngajati();
    public Angajat afiseazaAngajatDupaID(int id);
    public void stergeAngajat(int id);
    public void adaugaClient(Client client);
    public Client afiseazaClienti();
    public Client afiseazaClientDupaNrContact(String nr);
    public void stergeClientDupaNrContact(String nr);
    public void adaugaProdus(Produse produs);
    public Produse afiseazaProduse();
    public Produse afiseazaProdusDupaSerie(int id);
    public void stergeProdusDupaSerie(int id);
    public void adaugaSediu(Sediu sediu);
    public Sediu afiseazaSediu();
}
