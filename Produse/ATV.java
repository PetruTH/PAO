package Produse;

import java.util.Objects;

public class ATV extends OffRoad{
    private int autonomie;
    private String tractiune;

    public ATV(){
        super();
    }
    public ATV(String serieFabricatie, int pret, String marca, String terenSuportat, int nivelDeSiguranta, int autonomie, String tractiune) {
        super(serieFabricatie,pret, marca, terenSuportat, nivelDeSiguranta);
        this.autonomie = autonomie;
        this.tractiune = tractiune;
    }

    public ATV(Produse p, String terenSuportat, int nivelDeSiguranta, int autonomie, String tractiune) {
        super(p, terenSuportat, nivelDeSiguranta);
        this.autonomie = autonomie;
        this.tractiune = tractiune;
    }

    public int getAutonomie() {
        return autonomie;
    }

    public String getTractiune() {
        return tractiune;
    }

    public void setAutonomie(int autonomie) {
        this.autonomie = autonomie;
    }

    public void setTractiune(String tractiune) {
        this.tractiune = tractiune;
    }

    @Override
    public String Garantie() {
        return "5 ani";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ATV atv = (ATV) o;
        return autonomie == atv.autonomie && Objects.equals(tractiune, atv.tractiune);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), autonomie, tractiune);
    }

    @Override
    public String toString() {
        return "ATV{" +
                "autonomie=" + autonomie +
                ", tractiune='" + tractiune + '\'' +
                ", terenSuportat='" + terenSuportat + '\'' +
                ", nivelDeSiguranta=" + nivelDeSiguranta +
                ", serieFabricatie='" + serieFabricatie + '\'' +
                ", pret=" + pret +
                ", marca='" + marca + '\'' +
                '}';
    }
}
