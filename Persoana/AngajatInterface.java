package Persoana;
import java.util.ArrayList;
import java.util.List;
public interface AngajatInterface {
    public List<Angajat> getAngajati();
    public Angajat getAngajatByID(int idAngajat);
    public void deleteAngajatByID(int idAngajat);
    public Angajat citesteAngajat();
}
