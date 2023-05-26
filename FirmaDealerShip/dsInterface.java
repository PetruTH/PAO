package FirmaDealerShip;
import Persoana.*;
import Sediu.*;
import Produse.*;

import java.sql.SQLException;
import java.util.List;
public interface dsInterface {
    public DealerShip citesteDealerShip() throws Exception;
    public List<DealerShip> getDealerShips();
    public void stergeDealerShipDupaId(int id) throws Exception;
    public DealerShip getDealerShipsDupaId(int id) throws SQLException;
    public void afiseazaDealerShipsClientiDupaId(int id) throws Exception;
    public void afiseazaDealerShipsAngajatiDupaId(int id) throws Exception;
    public void adaugaAngajatDealershipsDupaId(int id) throws Exception;
    public void adaugaProduseDealershipsDupaId(int id) throws Exception;
    public void afiseazaProduseDealershipsDupaId(int id) throws Exception;
    public void modificaNrStocuriDealershipsDupaId(int id) throws Exception;
    public void stergeProduseDealershipsDupaId(int id) throws Exception;
    public void stergeClientDealershipsDupaId(int id) throws Exception;
    public void stergeAngajatDealershipsDupaId(int id) throws Exception;
}
