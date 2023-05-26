package Produse;

import java.util.Objects;

public class MasinaElectrica extends Masina{
    private int autonomie;
    private static String tip = "2";
    public MasinaElectrica(){
        super();
    }
    public MasinaElectrica(int serieFabricatie, int pret, String marca, int id_catre_client, int idDS, String tip, int putere, int vitezaMaxima, int masa, int autonomie) {
        super(serieFabricatie, pret, marca,id_catre_client,idDS, tip, putere, vitezaMaxima, masa);
        this.autonomie = autonomie;
    }

    public MasinaElectrica(Produse p, String tip, int putere, int vitezaMaxima, int masa, int autonomie) {
        super(p, tip, putere, vitezaMaxima, masa);
        this.autonomie = autonomie;
    }


    public int getAutonomie() {
        return autonomie;
    }

    public void setAutonomie(int autonomie) {
        this.autonomie = autonomie;
    }

    @Override
    public String notaMasina() {
        if(autonomie>500 && putere > 250) {
            return "A";
        }else if(autonomie > 400 && autonomie <= 500 && putere >250){
            return "B";
        }else if(autonomie > 400 && autonomie <= 500 && putere < 250 && putere >150){
            return "C";
        }else return "D";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MasinaElectrica that = (MasinaElectrica) o;
        return autonomie == that.autonomie;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), autonomie);
    }

    @Override
    public String toString() {
        return "MasinaElectrica{" +
                "autonomie=" + autonomie +
                ", tip='" + tip + '\'' +
                ", putere=" + putere +
                ", vitezaMaxima=" + vitezaMaxima +
                ", masa=" + masa +
                ", serieFabricatie='" + serieFabricatie + '\'' +
                ", pret=" + pret +
                ", marca='" + marca + '\'' +
                '}';
    }

    public String getTip() {
        return tip;
    }

    @Override
    public String Garantie() {
        return "10 ani";
    }
}
