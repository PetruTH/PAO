package Produse;

import java.util.Objects;

public class MasinaHybrid extends Masina{
    private int capacitateMotor;
    private String tipCombustibil;
    private int autonomieMotorElectric;
    private static String tip = "3";
    public MasinaHybrid(){
        super();
    }
    public MasinaHybrid(int serieFabricatie, int pret, String marca, int id_catre_client, int idDS, String tip, int putere, int vitezaMaxima, int masa, int capacitateMotor, String tipCombustibil, int autonomieMotorElectric) {
        super(serieFabricatie, pret, marca,id_catre_client, idDS, tip, putere, vitezaMaxima, masa);
        this.capacitateMotor = capacitateMotor;
        this.tipCombustibil = tipCombustibil;
        this.autonomieMotorElectric = autonomieMotorElectric;
    }
    public String getTip() {
        return tip;
    }
    public MasinaHybrid(Produse p, String tip, int putere, int vitezaMaxima, int masa, int capacitateMotor, String tipCombustibil, int autonomieMotorElectric) {
        super(p, tip, putere, vitezaMaxima, masa);
        this.capacitateMotor = capacitateMotor;
        this.tipCombustibil = tipCombustibil;
        this.autonomieMotorElectric = autonomieMotorElectric;
    }

    public int getCapacitateMotor() {
        return capacitateMotor;
    }

    public String getTipCombustibil() {
        return tipCombustibil;
    }

    public int getAutonomieMotorElectric() {
        return autonomieMotorElectric;
    }

    public void setCapacitateMotor(int capacitateMotor) {
        this.capacitateMotor = capacitateMotor;
    }

    public void setTipCombustibil(String tipCombustibil) {
        this.tipCombustibil = tipCombustibil;
    }

    public void setAutonomieMotorElectric(int autonomieMotorElectric) {
        this.autonomieMotorElectric = autonomieMotorElectric;
    }

    @Override
    public String notaMasina() {
        return "A";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MasinaHybrid that = (MasinaHybrid) o;
        return capacitateMotor == that.capacitateMotor && tipCombustibil == that.tipCombustibil && autonomieMotorElectric == that.autonomieMotorElectric;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), capacitateMotor, tipCombustibil, autonomieMotorElectric);
    }

    @Override
    public String toString() {
        return "MasinaHybrid{" +
                "capacitateMotor=" + capacitateMotor +
                ", tipCombustibil='" + tipCombustibil + '\'' +
                ", autonomieMotorElectric=" + autonomieMotorElectric +
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
        return "15 ani";
    }
}
