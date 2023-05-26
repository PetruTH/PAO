package Repos;
import FirmaDealerShip.*;
import Persoana.Angajat;
import Persoana.Client;
import Produse.Masina;
import Produse.OffRoad;
import Sediu.Sediu;
import dbconnect.dbconnect;

import java.sql.*;
import java.util.*;

public class DealerShipRepo implements genericRepo<DealerShip>{
    private static final HashMap<Integer, DealerShip> store = new HashMap();
    private static volatile DealerShipRepo init;
    private final Connection connection;

    DealerShipRepo() {
        connection = dbconnect.getDBConnection();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from DealerShip");
            while(rs.next()){
                int id = rs.getInt("id");
                String nume = rs.getString("nume");
                String clienti = rs.getString("clienti");
                String angajati = rs.getString("angajati");
                String produse = rs.getString("produse");
                int sediu = rs.getInt("sediu");
                store.put(id, new DealerShip(id, clienti, clienti, angajati, sediu, produse));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static DealerShipRepo getInit(){
        if (init == null) {
            synchronized (DealerShipRepo.class) {
                if (init == null) {
                    init = new DealerShipRepo();
                }
            }
        }
        return init;
    }


    @Override
    public List<DealerShip> findall() {
        ArrayList<DealerShip> s = new ArrayList<DealerShip>(store.values());
        return s;
    }

    @Override
    public Set<DealerShip> findAllSet(){
        return new HashSet<DealerShip>(store.values());
    }

    @Override
    public Sediu findOne(int id) throws SQLException {
        return null;
    }

    @Override
    public Masina findOneMasina(int id) throws SQLException {
        return null;
    }

    @Override
    public OffRoad findOneOffRoad(int id) throws SQLException {
        return null;
    }

    @Override
    public Angajat findOneAngajat(int id) throws SQLException {
        return null;
    }

    @Override
    public DealerShip findOneDealerShip(int id) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("select * from Dealership where id = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        DealerShip a = null;
        if(rs.next()){
            int id_new = rs.getInt("id");
            String nume = rs.getString("nume");
            String clienti = rs.getString("clienti");
            String angajati = rs.getString("angajati");
            String produse = rs.getString("produse");
            int sediu = rs.getInt("sediu");
            a = new DealerShip(id_new, clienti, clienti, angajati, sediu, produse);
        }
        return a;
    }

    @Override
    public Client findOneClient(int id) throws SQLException {
        return null;
    }

    @Override
    public void update(int idx, DealerShip entity) {
        store.put(idx, entity);
        try{
            PreparedStatement stmt = connection.prepareStatement("update dealership set id = ?, nume = ?, clienti = ?, angajati = ?, produse = ?, sediu = ? where id = ?");
            stmt.setInt(1, entity.getID());
            stmt.setString(2, entity.getNume());
            stmt.setString(3, entity.getClienti());
            stmt.setString(4, entity.getAngajati());
            stmt.setString(5, entity.getProduses());
            stmt.setInt(6, entity.getSediu());
            stmt.setInt(7, idx);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int idx) {
        store.remove(idx);
        try{
            PreparedStatement stmt = connection.prepareStatement("delete from Dealership where id = ?");
            stmt.setInt(1, idx);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public DealerShip save(DealerShip ds) {
        add(ds);
        return ds;
    }

    public void add(DealerShip entity) {
        store.put(entity.getID(), entity);
        try{
            PreparedStatement stmt = connection.prepareStatement("insert into Dealership values(?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, entity.getID());
            stmt.setString(2, entity.getNume());
            stmt.setString(3, entity.getClienti());
            stmt.setString(4, entity.getAngajati());
            stmt.setString(5, entity.getProduses());
            stmt.setInt(6, entity.getSediu());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getAngajatiFromDealerShipByID(int idDS) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("select angajati from Dealership where id = ?");
        stmt.setInt(1, idDS);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        String angajati = rs.getString("angajati");
        return angajati;
    }

    public String getClientiFromDealerShipByID(int idDS) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("select clienti from Dealership where id = ?");
        stmt.setInt(1, idDS);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        String clienti = rs.getString("clienti");
        return clienti;
    }

    public String getProduseFromDealerShipByID(int idDS) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("select produse from Dealership where id = ?");
        stmt.setInt(1, idDS);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        String produse = rs.getString("produse");
        return produse;
    }

    public int getSediuFromDealerShipByID(int idDS) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("select sediu from Dealership where id = ?");
        stmt.setInt(1, idDS);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        int sediu = rs.getInt("sediu");
        return sediu;
    }
    public void updateAngajatiFromDealerShipByID(int idDS, String angajati) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("update Dealership set angajati = ? where id = ?");
        stmt.setString(1, angajati);
        stmt.setInt(2, idDS);
        stmt.executeUpdate();
    }

    public void updateClientiFromDealerShipByID(int idDS, String clienti) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("update Dealership set clienti = ? where id = ?");
        stmt.setString(1, clienti);
        stmt.setInt(2, idDS);
        stmt.executeUpdate();
    }

    public void updateProduseFromDealerShipByID(int idDS, String produse) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("update Dealership set produse = ? where id = ?");
        stmt.setString(1, produse);
        stmt.setInt(2, idDS);
        stmt.executeUpdate();
    }

    public int getSediuFromDealershipID(int idDS) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("select sediu from Dealership where id = ?");
        stmt.setInt(1, idDS);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        int sediu = rs.getInt("sediu");
        return sediu;
    }
}
