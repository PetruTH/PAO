package Produse;

import java.util.Objects;

public class Motocicleta extends OffRoad{
    private int capacitateCilindrica;
    private String transmisie;
    private String tipMotocicleta;
    private static String tip = "5";
    public Motocicleta(){
        super();
    }
    public String getTip() {
        return tip;
    }
    public Motocicleta(int serieFabricatie, int pret, String marca,int id_catre_client, int idDS, String terenSuportat, int nivelDeSiguranta, int capacitateCilindrica, String transmisie, String tipMotocicleta) {
        super(serieFabricatie, pret, marca,id_catre_client, idDS, terenSuportat, nivelDeSiguranta);
        this.capacitateCilindrica = capacitateCilindrica;
        this.transmisie = transmisie;
        this.tipMotocicleta = tipMotocicleta;
    }

    public Motocicleta(Produse p, String terenSuportat, int nivelDeSiguranta, int capacitateCilindrica, String transmisie, String tipMotocicleta) {
        super(p, terenSuportat, nivelDeSiguranta);
        this.capacitateCilindrica = capacitateCilindrica;
        this.transmisie = transmisie;
        this.tipMotocicleta = tipMotocicleta;
    }

    public int getCapacitateCilindrica() {
        return capacitateCilindrica;
    }

    public String getTransmisie() {
        return transmisie;
    }

    public String getTipMotocicleta() {
        return tipMotocicleta;
    }

    public void setCapacitateCilindrica(int capacitateCilindrica) {
        this.capacitateCilindrica = capacitateCilindrica;
    }

    public void setTransmisie(String transmisie) {
        this.transmisie = transmisie;
    }

    public void setTipMotocicleta(String tipMotocicleta) {
        this.tipMotocicleta = tipMotocicleta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Motocicleta that = (Motocicleta) o;
        return capacitateCilindrica == that.capacitateCilindrica && transmisie.equals(that.transmisie) && tipMotocicleta.equals(that.tipMotocicleta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), capacitateCilindrica, transmisie, tipMotocicleta);
    }

    @Override
    public String toString() {
        return "Motocicleta{" +
                "capacitateCilindrica=" + capacitateCilindrica +
                ", transmisie='" + transmisie + '\'' +
                ", tipMotocicleta='" + tipMotocicleta + '\'' +
                ", terenSuportat='" + terenSuportat + '\'' +
                ", nivelDeSiguranta=" + nivelDeSiguranta +
                ", serieFabricatie='" + serieFabricatie + '\'' +
                ", pret=" + pret +
                ", marca='" + marca + '\'' +
                '}';
    }

    @Override
    public String Garantie() {
        return "7 ani";
    }
}
