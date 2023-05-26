package Produse;

import Produse.*;

import java.sql.SQLException;
import java.util.List;

public interface ProduseInterface {
    public List<Produse> getProduse();
//    public Produse getProdusBySeriedeFabricatie(int serie) throws SQLException;

    Produse getProdusBySeriedeFabricatie(int serie, int tip) throws SQLException;

    public void deleteProdusBySeriedeFabricatie(int serie);
    public Produse citesteProdusInFunctieDeOpt() throws SQLException;
    public void updateProdusBySeriedeFabricatie(int serie) throws SQLException;
}
