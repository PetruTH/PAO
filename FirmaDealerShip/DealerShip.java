package FirmaDealerShip;
import Persoana.*;
import Sediu.*;
import Produse.*;
import Persoana.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DealerShip {
    private String nume;
    private static int ID = 0;
    private List<Client> clienti;
    private List<Angajat> angajati;
    private Sediu sediu;
    private List<Produse> produses;

    public DealerShip() {
        ID++;
    }

    public DealerShip(String nume, List<Client> clienti, List<Angajat> angajati, Sediu sediu, List<Produse> produses) {
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

    public List<Client> getClienti() {
        return clienti;
    }

    public void setClienti(List<Client> clienti) {
        this.clienti = clienti;
    }

    public List<Angajat> getAngajati() {
        return angajati;
    }

    public void setAngajati(List<Angajat> angajati) {
        this.angajati = angajati;
    }

    public Sediu getSediu() {
        return sediu;
    }

    public void setSediu(Sediu sediu) {
        this.sediu = sediu;
    }

    public List<Produse> getProduses() {
        return produses;
    }

    public void setProduses(List<Produse> produses) {
        this.produses = produses;
    }

    @Override
    public String toString() {
        return "DealerShip{" +
                "nume='" + nume + '\'' +
                ", clienti=" + clienti +
                ", angajati=" + angajati +
                ", sediu=" + sediu +
                ", produses=" + produses +
                ", ID=" + ID +
                '}';
    }
}
