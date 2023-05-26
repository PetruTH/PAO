package FirmaDealerShip;
import Persoana.*;
import Sediu.*;
import Produse.*;
import Persoana.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class DealerShip {
    private String nume;
    private String clienti;
    private String angajati;
    private int sediu;
    private String produses;
    private int id;

    public DealerShip() {
        this.id = 0;
    }

    public DealerShip(int id, String nume, String clienti, String angajati, int sediu, String produses) {
        this.nume = nume;
        this.clienti = clienti;
        this.angajati = angajati;
        this.sediu = sediu;
        this.produses = produses;
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getClienti() {
        return clienti;
    }

    public void setClienti(String clienti) {
        this.clienti = clienti;
    }

    public String getAngajati() {
        return angajati;
    }

    public void setAngajati(String angajati) {
//        angajati.sort(Comparator.comparing(Angajat::getSalariu));
        this.angajati = angajati;
    }

    public int getSediu() {
        return sediu;
    }

    public void setSediu(int sediu) {
        this.sediu = sediu;
    }

    public String getProduses() {
        return produses;
    }

    public void setProduses(String produses) {
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
                ", ID=" + id +
                '}';
    }
}
