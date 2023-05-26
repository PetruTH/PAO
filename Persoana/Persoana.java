package Persoana;

import java.util.Objects;

public abstract class Persoana {
    protected int id;
    protected String nume;
    protected String mail;
    protected int varsta;
    protected int id_dealership;

    public Persoana(){
        this.nume="";
        this.mail = "";
        this.varsta = 0;
        this.id = 0;
        this.id_dealership = 0;
    }
    public Persoana(int id, String nume, String mail, int varsta, int id_dealership) {
        this.nume = nume;
        this.mail = mail;
        this.varsta = varsta;
        this.id = id;
        this.id_dealership = id_dealership;
    }

    public Persoana(Persoana p) {
        this.nume = p.getNume();
        this.mail = p.getMail();
        this.varsta = p.getVarsta();
        this.id = p.getId();
        this.id_dealership = p.getId_dealership();
    }
    public void setId_dealership(int id_dealership){
        this.id_dealership = id_dealership;
    }
    public int getId_dealership(){
        return this.id_dealership;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public String getNume() {
        return nume;
    }

    public String getMail() {
        return mail;
    }

    public int getVarsta() {
        return varsta;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persoana persoana = (Persoana) o;
        return varsta == persoana.varsta && Objects.equals(nume, persoana.nume) && Objects.equals(mail, persoana.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, mail, varsta);
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "nume='" + nume + '\'' +
                ", mail='" + mail + '\'' +
                ", varsta=" + varsta +
                '}';
    }
    public abstract int ReducerePentruAngajat();
}
