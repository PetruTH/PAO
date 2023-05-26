package Repos;

import FirmaDealerShip.DealerShip;
import Produse.*;
import Persoana.*;
import dbconnect.*;
import Sediu.*;
import java.util.*;
import java.sql.*;

public class clientRepo implements genericRepo<Client>{
    private static final HashMap<Integer, Client> store = new HashMap();
    private static volatile clientRepo init;
    private final Connection connection;

    clientRepo() {
        connection = dbconnect.getDBConnection();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Client");
            while(rs.next()){
                int id = rs.getInt("nrcontact");
                String nume = rs.getString("nume");
                String mail = rs.getString("mail");
                int varsta = rs.getInt("varsta");
                String produse = rs.getString("produse");
                int idDS = rs.getInt("idDS");
                store.put(id, new Client(id, nume, mail, varsta, idDS, produse));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static clientRepo getInit(){
        if (init == null) {
            synchronized (clientRepo.class) {
                if (init == null) {
                    init = new clientRepo();
                }
            }
        }
        return init;
    }
    @Override
    public List<Client> findall() {
        ArrayList<Client> s = new ArrayList<Client>(store.values());
        return s;
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
        return null;
    }

    @Override
    public Client findOneClient(int id) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("select * from Client where nrcontact = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Client a = null;
        if(rs.next()){
            int id1 = rs.getInt("nrcontact");
            String nume = rs.getString("nume");
            String mail = rs.getString("mail");
            int varsta = rs.getInt("varsta");
            String produse = rs.getString("produse");
            int idDS = rs.getInt("idDS");
            a = new Client(id1, nume, mail, varsta, idDS, produse);
        }
        return a;
    }

    @Override
    public Set<Client> findAllSet() {
        return new HashSet<Client>(store.values());
    }

    @Override
    public void delete(int idx) {
        store.remove(idx);
        try{
            PreparedStatement stmt = connection.prepareStatement("delete from Client where nrcontact = ?");
            stmt.setInt(1, idx);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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
    public void update(int idx, Client entity) {
        store.put(idx, entity);
        try{
            PreparedStatement stmt = connection.prepareStatement("update client set id = ?, nume = ?, mail = ?, varsta = ?, idDS = ?, produse = ? where nrcontact = ?");
            stmt.setInt(1, entity.getId());
            stmt.setString(2, entity.getNume());
            stmt.setString(3, entity.getMail());
            stmt.setInt(4, entity.getVarsta());
            stmt.setInt(5, entity.getId_dealership());
            stmt.setString(6, entity.getProd());
            stmt.setInt(7, idx);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(Client entity) {
        store.put(entity.getId(), entity);
        try{
            PreparedStatement stmt = connection.prepareStatement("insert into Client values(?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, entity.getId());
            stmt.setString(2, entity.getNume());
            stmt.setString(3, entity.getMail());
            stmt.setInt(4, entity.getVarsta());
            stmt.setInt(5, entity.getId_dealership());
            stmt.setString(6, entity.getProd());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Client save(Client client) {
        add(client);
        return client;
    }

    public void updateProduse(int idx, String newProd) {
//        store.put(idx, entity);
        try{
            PreparedStatement stmt = connection.prepareStatement("update client set produse = ? where nrcontact = ?");
            stmt.setString(1, newProd);
            stmt.setInt(2, idx);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
