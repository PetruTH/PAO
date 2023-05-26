package Sediu;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Sediu {
    private String locatie;
    private int nrStocuri;
    private int id;

    public Sediu(){
        this.locatie = "";
        this.nrStocuri = 0;
    }
    public Sediu(int id, String locatie, int nrStocuriMasini) {
        this.locatie = locatie;
        this.nrStocuri = nrStocuriMasini;
        this.id = id;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public int getNrStocuri() {
        return nrStocuri;
    }

    public void setNrStocuri(int nrStocuri) {
        this.nrStocuri = nrStocuri;
    }

    @Override
    public String toString() {
        return "Sediu{" +
                "locatie='" + locatie + '\'' +
                ", nrStocuri=" + nrStocuri +
                '}';
    }

    public int getId() {
        return id;
    }
}
