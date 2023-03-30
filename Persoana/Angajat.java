package Persoana;

public class Angajat extends Persoana{
    private int salariu;
    private String pozitie;
    protected static int idCount = 0;
    private int id;
    private static int generateId() {
        return ++idCount;
    }
    public Angajat(){
        super();
        this.salariu = 0;
        this.pozitie = "";
        id = generateId();
    }

    public Angajat(String nume, String mail, int varsta, int salariu, String pozitie) {
        super(nume, mail, varsta);
        this.salariu = salariu;
        this.pozitie = pozitie;
        id = generateId();
    }

    public Angajat(Persoana p, int salariu, String pozitie){
        super(p);
        this.salariu=salariu;
        this.pozitie=pozitie;
        id = generateId();
    }

    public int getId() {
        return id;
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
