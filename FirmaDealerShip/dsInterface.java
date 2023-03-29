package FirmaDealerShip;
import Persoana.*;
import Sediu.*;
import Produse.*;
import java.util.List;
public interface dsInterface {
    public DealerShip citesteDealerShip();
    public List<DealerShip> getDealerShips();
    public void stergeDealerShipDupaId(int id);
    public DealerShip getDealerShipsDupaId(int id);
}
