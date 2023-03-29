package FirmaDealerShip;
import Persoana.*;
import Sediu.*;
import Produse.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiceDS implements dsInterface{
    private List<dsInterface> angajati = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    private static ServiceDS instance = null;
    private ServiceDS() {
    }
    public static ServiceDS getInstance() {
        if (instance == null) {
            instance = new ServiceDS();
        }
        return instance;
    }
    @Override
    public void adaugaAngajat(Angajat angajat) {
    }
    @Override
    public Angajat afiseazaAngajati() {
        return null;
    }
    @Override
    public Angajat afiseazaAngajatDupaID(int id) {
        return null;
    }
    @Override
    public void stergeAngajat(int id) {
    }
    @Override
    public void adaugaClient(Client client) {
    }
    @Override
    public Client afiseazaClienti() {
        return null;
    }
    @Override
    public Client afiseazaClientDupaNrContact(String nr) {
        return null;
    }
    @Override
    public void stergeClientDupaNrContact(String nr) {
    }
    @Override
    public void adaugaProdus(Produse produs) {
    }
    @Override
    public Produse afiseazaProduse() {
        return null;
    }
    @Override
    public Produse afiseazaProdusDupaSerie(int id) {
        return null;
    }
    @Override
    public void stergeProdusDupaSerie(int id) {
    }
    @Override
    public void adaugaSediu(Sediu sediu) {
    }
    @Override
    public Sediu afiseazaSediu() {
        return null;
    }
}
