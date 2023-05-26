package Repos;

import FirmaDealerShip.DealerShip;
import Persoana.*;
import Produse.*;
import dbconnect.*;
import Sediu.*;
import java.util.*;
import java.sql.*;

public class sediuRepo implements genericRepo<Sediu>{
    private static final HashMap<Integer, Sediu> store = new HashMap();
    private static volatile sediuRepo init;
    private final Connection connection;

    sediuRepo() {
        connection = dbconnect.getDBConnection();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from sediu");
            while(rs.next()){
                String adresa = rs.getString("locatie");
                int nrStocuri = rs.getInt("nrStocuri");
                int id = rs.getInt("id");
                store.put(id, new Sediu(id, adresa, nrStocuri));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static sediuRepo getInit(){
        if (init == null) {
            synchronized (sediuRepo.class) {
                if (init == null) {
                   init = new sediuRepo();
                }
            }
        }
        return init;
    }
    @Override
    public List<Sediu> findall() {
        ArrayList<Sediu> s = new ArrayList<Sediu>(store.values());
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
        return null;
    }

    @Override
    public Set<Sediu> findAllSet() {
        return new HashSet<Sediu>(store.values());
    }

    @Override
    public void delete(int idx) {
        store.remove(idx);
        try{
            PreparedStatement stmt = connection.prepareStatement("delete from sediu where id = ?");
            stmt.setInt(1, idx);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Sediu findOne(int id) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("select * from sediu where id = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Sediu s = null;
        if(rs.next()) {
            String adresa = rs.getString("locatie");
            int nrStocuri = rs.getInt("nrStocuri");
            s = new Sediu(rs.getInt("id"), adresa, nrStocuri);
        }
        return s;
    }

    @Override
    public Masina findOneMasina(int id) throws SQLException {
        return null;
    }

    public void updateNrStocuri(int idx, int new_nr_stocuri){
        store.get(idx).setNrStocuri(new_nr_stocuri);
        try{
            PreparedStatement stmt = connection.prepareStatement("update sediu set nrStocuri = ? where id = ?");
            stmt.setInt(1, new_nr_stocuri);
            stmt.setInt(2, idx);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(int idx, Sediu entity) {
        store.put(idx, entity);
        try{
            PreparedStatement stmt = connection.prepareStatement("update sediu set adresa = ?, nrStocuri = ? where id = ?");
            stmt.setString(1, entity.getLocatie());
            stmt.setInt(2, entity.getNrStocuri());
            stmt.setInt(3, idx);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(Sediu entity) {
        store.put(entity.getId(), entity);
        try{
            PreparedStatement stmt = connection.prepareStatement("insert into sediu values(?, ?, ?)");
            stmt.setInt(1, entity.getId());
            stmt.setString(2, entity.getLocatie());
            stmt.setInt(3, entity.getNrStocuri());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Sediu save(Sediu adresa) {
        add(adresa);
        return adresa;
    }
}
