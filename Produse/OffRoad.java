package Produse;

import java.util.Objects;

public abstract class OffRoad extends Produse{
    protected String terenSuportat;
    protected int nivelDeSiguranta;

    public OffRoad(){
        super();
    }
    public OffRoad(int serieFabricatie, int pret, String marca, int id_catre_client, int idDS, String terenSuportat, int nivelDeSiguranta) {
        super(serieFabricatie, pret, marca, id_catre_client, idDS);
        this.terenSuportat = terenSuportat;
        this.nivelDeSiguranta = nivelDeSiguranta;
    }

    public OffRoad(Produse p, String terenSuportat, int nivelDeSiguranta) {
        super(p);
        this.terenSuportat = terenSuportat;
        this.nivelDeSiguranta = nivelDeSiguranta;
    }
    public String getTerenSuportat() {
        return terenSuportat;
    }

    public int getNivelDeSiguranta() {
        return nivelDeSiguranta;
    }

    public void setTerenSuportat(String terenSuportat) {
        this.terenSuportat = terenSuportat;
    }

    public void setNivelDeSiguranta(int nivelDeSiguranta) {
        this.nivelDeSiguranta = nivelDeSiguranta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OffRoad offRoad = (OffRoad) o;
        return nivelDeSiguranta == offRoad.nivelDeSiguranta && Objects.equals(terenSuportat, offRoad.terenSuportat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(terenSuportat, nivelDeSiguranta);
    }

    @Override
    public String toString() {
        return "OffRoad{" +
                "terenSuportat='" + terenSuportat + '\'' +
                ", nivelDeSiguranta=" + nivelDeSiguranta +
                '}';
    }
    public abstract String Garantie();
}
