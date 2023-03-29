package Produse;

import Produse.*;

import java.util.List;

public interface ProduseInterface {
    public List<Produse> getProduse();
    public Produse getProdusBySeriedeFabricatie(String serie);
    public void deleteProdusBySeriedeFabricatie(String serie);
    public Produse citesteProdusInFunctieDeOpt();
    public void updateProdusBySeriedeFabricatie(String serie);
}
