package Persoana;

public class Angajat extends Persoana{
    private int salariu;
    private String pozitie;

    public Angajat(){
        super();
        this.salariu = 0;
        this.pozitie = "";
        id = 0;
    }

    public Angajat(int id, String nume, String mail, int varsta, int id_dealership, int salariu, String pozitie) {
        super(id, nume, mail, varsta, id_dealership);
        this.salariu = salariu;
        this.pozitie = pozitie;
    }

    public Angajat(Persoana p, int salariu, String pozitie){
        super(p);
        this.salariu=salariu;
        this.pozitie=pozitie;
    }

    public int getSalariu() {
        return salariu;
    }

    public String getPozitie() {
        return pozitie;
    }

    public void setSalariu(int salariu) {
        this.salariu = salariu;
    }

    public void setPozitie(String pozitie) {
        this.pozitie = pozitie;
    }

    @Override
    public String toString() {
        return "Angajat{" +
                "salariu=" + salariu +
                ", pozitie='" + pozitie + '\'' +
                ", nume='" + nume + '\'' +
                ", mail='" + mail + '\'' +
                ", varsta=" + varsta +
                ", ID=" + id +
                '}';
    }

    @Override
    public int ReducerePentruAngajat() {
        return 50;
    }
}
