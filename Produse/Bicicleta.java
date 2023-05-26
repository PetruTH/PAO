package Produse;

import java.util.Objects;

public class Bicicleta extends OffRoad{
    private int masa;
    private int nrViteze;
    private String materialCadru;
    private static String tip = "6";

    public Bicicleta(){
        super();
    }
    public Bicicleta(int serieFabricatie, int pret, String marca,  int id_catre_client, int idDS, String terenSuportat, int nivelDeSiguranta, int masa, int nrViteze, String materialCadru) {
        super(serieFabricatie, pret, marca, id_catre_client, idDS, terenSuportat, nivelDeSiguranta);
        this.masa = masa;
        this.nrViteze = nrViteze;
        this.materialCadru = materialCadru;
    }

    public Bicicleta(Produse p, String terenSuportat, int nivelDeSiguranta, int masa, int nrViteze, String materialCadru) {
        super(p, terenSuportat, nivelDeSiguranta);
        this.masa = masa;
        this.nrViteze = nrViteze;
        this.materialCadru = materialCadru;
    }

    public int getMasa() {
        return masa;
    }

    public void setMasa(int masa) {
        this.masa = masa;
    }

    public int getNrViteze() {
        return nrViteze;
    }

    public void setNrViteze(int nrViteze) {
        this.nrViteze = nrViteze;
    }

    public String getMaterialCadru() {
        return materialCadru;
    }

    public void setMaterialCadru(String materialCadru) {
        this.materialCadru = materialCadru;
    }

    @Override
    public String Garantie() {
        return "11 ani";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bicicleta bicicleta = (Bicicleta) o;
        return masa == bicicleta.masa && nrViteze == bicicleta.nrViteze && materialCadru.equals(bicicleta.materialCadru);
    }

    public String getTip(){
        return tip;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), masa, nrViteze, materialCadru);
    }

    @Override
    public String toString() {
        return "Bicicleta{" +
                "masa=" + masa +
                ", nrViteze=" + nrViteze +
                ", materialCadru='" + materialCadru + '\'' +
                ", terenSuportat='" + terenSuportat + '\'' +
                ", nivelDeSiguranta=" + nivelDeSiguranta +
                ", serieFabricatie='" + serieFabricatie + '\'' +
                ", pret=" + pret +
                ", marca='" + marca + '\'' +
                '}';
    }
}
