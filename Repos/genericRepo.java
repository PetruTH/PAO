package Repos;

import FirmaDealerShip.DealerShip;
import Produse.*;
import Persoana.*;
import Sediu.Sediu;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import java.util.Optional;

public interface genericRepo<T>{
    List<T> findall();
    Set<T> findAllSet();
    Sediu findOne(int id) throws SQLException;
    Masina findOneMasina(int id) throws SQLException;
    OffRoad findOneOffRoad(int id) throws SQLException;
    Angajat findOneAngajat(int id) throws SQLException;

    DealerShip findOneDealerShip(int id) throws SQLException;
    Client findOneClient(int id) throws SQLException;

    void update(int idx, T entity);

    void delete(int idx);
}
