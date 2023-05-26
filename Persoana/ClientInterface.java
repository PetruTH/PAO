package Persoana;
import Produse.*;

import java.sql.SQLException;
import java.util.List;

public interface ClientInterface {
    public List<Client> getClienti();
    public Client afiseazaClientDupaID(int nr) throws SQLException;
    public void stergeClientDupaID(int nr);
    public void seteazaProduseClientuluiDupaID(int nr, String produs) throws SQLException;
    public Client citesteClient() throws SQLException;
}
