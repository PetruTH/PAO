package Produse;

import java.util.Objects;

public abstract class Produse {
    protected int serieFabricatie;
    protected int pret;
    protected String marca;
    protected int id_catre_client;
    protected int idDS;

    public String getTip() {
        return null;
    }

    public Produse(){
        this.serieFabricatie = 0;
        this.pret = 0;
        this.marca = "";
        this.id_catre_client = 0;
    }
    public Produse(int serieFabricatie, int pret, String marca, int id_catre_client, int idDS) {
        this.serieFabricatie = serieFabricatie;
        this.pret = pret;
        this.marca = marca;
        this.id_catre_client = id_catre_client;
        this.idDS = idDS;
    }

    public Produse(Produse p){
        this.serieFabricatie = p.getSerieFabricatie();
        this.pret = p.getPret();
        this.marca = p.getMarca();
        this.id_catre_client = p.getId_catre_client();
        this.idDS = p.getIdDS();
    }

    public int getIdDS() {
        return idDS;
    }

    public void setIdDS(int idDS) {
        this.idDS = idDS;
    }

    public int getId_catre_client() {
        return id_catre_client;
    }
    public void setId_catre_client(int id_catre_client) {
        this.id_catre_client = id_catre_client;
    }

    public String getMarca() {
        return marca;
    }

    public int getPret() {
        return pret;
    }

    public int getSerieFabricatie() {
        return serieFabricatie;
    }

    public void setSerieFabricatie(int serieFabricatie) {
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
        return pret == produse.pret && serieFabricatie == produse.serieFabricatie && marca.equals(produse.marca);
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
