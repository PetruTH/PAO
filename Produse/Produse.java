package Produse;

import java.util.Objects;

public abstract class Produse {
    protected String serieFabricatie;
    protected int pret;
    protected String marca;

    public Produse(){
        this.serieFabricatie = "";
        this.pret = 0;
        this.marca = "";
    }
    public Produse(String serieFabricatie, int pret, String marca) {
        this.serieFabricatie = serieFabricatie;
        this.pret = pret;
        this.marca = marca;
    }

    public Produse(Produse p){
        this.serieFabricatie = p.getSerieFabricatie();
        this.pret = p.getPret();
    }


    public String getMarca() {
        return marca;
    }

    public int getPret() {
        return pret;
    }

    public String getSerieFabricatie() {
        return serieFabricatie;
    }

    public void setSerieFabricatie(String serieFabricatie) {
        this.serieFabricatie = serieFabricatie;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCantitate(int cantitate) {
        cantitate = cantitate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produse produse = (Produse) o;
        return pret == produse.pret && serieFabricatie.equals(produse.serieFabricatie) && marca.equals(produse.marca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serieFabricatie, pret, marca);
    }

    @Override
    public String toString() {
        return "Produse{" +
                "serieFabricatie='" + serieFabricatie + '\'' +
                ", pret=" + pret +
                ", marca='" + marca + '\'' +
                '}';
    }
    public abstract String Garantie();
}
