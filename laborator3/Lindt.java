package laborator3;
import laborator3.CandyBox;
public class Lindt extends CandyBox{
    private float lungime;
    private float latime;
    private float inaltime;
    public Lindt(){}
    public Lindt(String flavor, String origin, float L, float l, float h){
        super(flavor, origin);
        this.lungime = L;
        this.latime = l;
        this.inaltime = h;
    }

    @Override
    public String toString() {
        String msj = super.toString();
        msj += " cu lungimea: " + this.lungime + " si latimea: " + this.latime + " si inaltimea: " + this.inaltime;
        return msj;
    }

    @Override
    public float getVolume() {
        float volum;
        volum  = this.inaltime * this.latime * this.lungime;
        return volum;
    }
}

