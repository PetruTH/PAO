package Produse;

import java.util.Objects;

public abstract class Masina extends Produse{
    protected String tip;
    protected int putere;
    protected int vitezaMaxima;
    protected int masa;

    public Masina(int serieFabricatie, int pret, String marca, int id_catre_client, int idDS, String tip, int putere, int vitezaMaxima, int masa) {
        super(serieFabricatie, pret, marca, id_catre_client, idDS);
        this.tip = tip;
        this.putere = putere;
        this.vitezaMaxima = vitezaMaxima;
        this.masa = masa;
    }

    public Masina(Produse p, String tip, int putere, int vitezaMaxima, int masa) {
        super(p);
        this.tip = tip;
        this.putere = putere;
        this.vitezaMaxima = vitezaMaxima;
        this.masa = masa;
    }

    public Masina() {
        super();
        this.tip = "";
        this.putere = 0;
        this.vitezaMaxima = 0;
        this.masa = 0;
    }

    public String getTip() {
        return tip;
    }

    public int getPutere() {
        return putere;
    }

    public int getVitezaMaxima() {
        return vitezaMaxima;
    }

    public int getMasa() {
        return masa;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public void setPutere(int putere) {
        this.putere = putere;
    }

    public void setVitezaMaxima(int vitezaMaxima) {
        this.vitezaMaxima = vitezaMaxima;
    }

    public void setMasa(int masa) {
        this.masa = masa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Masina masina = (Masina) o;
        return putere == masina.putere && vitezaMaxima == masina.vitezaMaxima && masa == masina.masa && Objects.equals(tip, masina.tip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tip, putere, vitezaMaxima, masa);
    }

    @Override
    public String toString() {
        return "Masina{" +
                "tip='" + tip + '\'' +
                ", putere=" + putere +
                ", vitezaMaxima=" + vitezaMaxima +
                ", masa=" + masa +
                ", serieFabricatie='" + serieFabricatie + '\'' +
                ", pret=" + pret +
                '}';
    }

    public abstract String notaMasina();
}
