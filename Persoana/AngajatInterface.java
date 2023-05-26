package Persoana;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public interface AngajatInterface {
    public List<Angajat> getAngajati();
    public Angajat getAngajatByID(int idAngajat) throws SQLException;
    public void deleteAngajatByID(int idAngajat);
    public Angajat citesteAngajat();
}
