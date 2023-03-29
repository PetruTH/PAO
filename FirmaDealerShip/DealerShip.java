package FirmaDealerShip;
import Persoana.*;
import Sediu.*;
import Produse.*;
import Persoana.*;

import java.util.Arrays;
import java.util.Objects;

public class DealerShip {
    private String nume;
    private static int ID = 0;
    private Client[] clienti;
    private Angajat[] angajati;
    private Sediu sediu;
    private Produse[] produses;

    public DealerShip() {
        ID++;
    }

    public DealerShip(String nume, Client[] clienti, Angajat[] angajati, Sediu sediu, Produse[] produses) {
        this.nume = nume;
        this.clienti = clienti;
        this.angajati = angajati;
        this.sediu = sediu;
        this.produses = produses;
        ID++;
    }

    public int getID() {
        return ID;
    }
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Client[] getClienti() {
        return clienti;
    }

    public void setClienti(Client[] clienti) {
        this.clienti = clienti;
    }

    public Angajat[] getAngajati() {
        return angajati;
    }

    public void setAngajati(Angajat[] angajati) {
        this.angajati = angajati;
    }

    public Sediu getSediu() {
        return sediu;
    }

    public void setSediu(Sediu sediu) {
        this.sediu = sediu;
    }

    public Produse[] getProduses() {
        return produses;
    }

    public void setProduses(Produse[] produses) {
        this.produses = produses;
    }

    @Override
    public String toString() {
        return "DealerShip{" +
                "nume='" + nume + '\'' +
                ", clienti=" + Arrays.toString(clienti) +
                ", angajati=" + Arrays.toString(angajati) +
                ", sediu=" + sediu +
                ", produses=" + Arrays.toString(produses) +
                ", ID=" + ID +
                '}';
    }
}
