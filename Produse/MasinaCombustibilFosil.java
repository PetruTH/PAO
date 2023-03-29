package Produse;

import java.util.Objects;

public class MasinaCombustibilFosil extends Masina{
    private int capacitateMotor;
    private String tipCombustibil;

    public MasinaCombustibilFosil(){
        super();

    }
    public MasinaCombustibilFosil(String serieFabricatie, int pret, String marca, String tip, int putere, int vitezaMaxima, int masa, int capacitateMotor, String tipCombustibil) {
        super(serieFabricatie, pret, marca, tip, putere, vitezaMaxima, masa);
        this.capacitateMotor = capacitateMotor;
        this.tipCombustibil = tipCombustibil;
    }

    public MasinaCombustibilFosil(Produse p, String tip, int putere, int vitezaMaxima, int masa, int capacitateMotor, String tipCombustibil) {
        super(p, tip, putere, vitezaMaxima, masa);
        this.capacitateMotor = capacitateMotor;
        this.tipCombustibil = tipCombustibil;
    }

    public int getCapacitateMotor() {
        return capacitateMotor;
    }

    public String getTipCombustibil() {
        return tipCombustibil;
    }

    public void setCapacitateMotor(int capacitateMotor) {
        this.capacitateMotor = capacitateMotor;
    }

    public void setTipCombustibil(String tipCombustibil) {
        this.tipCombustibil = tipCombustibil;
    }

    @Override
    public String notaMasina() {
        if (tipCombustibil == "Benzina" && putere > 250){
            return "A";
        }else if(tipCombustibil == "Diesel" && putere > 250){
            return "B";
        }else if(tipCombustibil == "Benzina" && putere > 150 && putere<= 250) {
            return "C";
        }else if(tipCombustibil == "Diesel" && putere > 150 && putere<=250) {
            return "D";
        }else return "E";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MasinaCombustibilFosil that = (MasinaCombustibilFosil) o;
        return capacitateMotor == that.capacitateMotor && Objects.equals(tipCombustibil, that.tipCombustibil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), capacitateMotor, tipCombustibil);
    }

    @Override
    public String toString() {
        return "MasinaCombustibilFosil{" +
                "capacitateMotor=" + capacitateMotor +
                ", tipCombustibil='" + tipCombustibil + '\'' +
                ", tip='" + tip + '\'' +
                ", putere=" + putere +
                ", vitezaMaxima=" + vitezaMaxima +
                ", masa=" + masa +
                ", serieFabricatie='" + serieFabricatie + '\'' +
                ", pret=" + pret +
                ", marca='" + marca + '\'' +
                '}';
    }

    @Override
    public String Garantie() {
        return "20 ani";
    }
}
