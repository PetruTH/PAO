package Sediu;

import java.util.Objects;

public class Sediu {
    private String locatie;
    private int nrStocuri;

    public Sediu(){
        this.locatie = "";
        this.nrStocuri = 0;
    }
    public Sediu(String locatie, int nrStocuriMasini) {
        this.locatie = locatie;
        this.nrStocuri = nrStocuriMasini;
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
}
