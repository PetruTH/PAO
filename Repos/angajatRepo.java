package Repos;

import FirmaDealerShip.DealerShip;
import Produse.*;
import Persoana.*;
import dbconnect.*;
import Sediu.*;
import java.util.*;
import java.sql.*;

public class angajatRepo implements genericRepo<Angajat>{
    private static final HashMap<Integer, Angajat> store = new HashMap();
    private static volatile angajatRepo init;
    private final Connection connection;

    angajatRepo() {
        connection = dbconnect.getDBConnection();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Angajat");
            while(rs.next()){
                int id = rs.getInt("id");
                String nume = rs.getString("nume");
                String mail = rs.getString("mail");
                int varsta = rs.getInt("varsta");
                int salariu = rs.getInt("salariu");
                String pozitie = rs.getString("pozitie");
                int idDS = rs.getInt("idds");
                store.put(id, new Angajat(id, nume, mail, varsta, idDS, salariu, pozitie));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static angajatRepo getInit(){
        if (init == null) {
            synchronized (angajatRepo.class) {
                if (init == null) {
                    init = new angajatRepo();
                }
            }
        }
        return init;
    }
    @Override
    public List<Angajat> findall() {
        ArrayList<Angajat> s = new ArrayList<Angajat>(store.values());
        return s;
    }
    @Override
    public OffRoad findOneOffRoad(int id) throws SQLException {
        return null;
    }

    @Override
    public Angajat findOneAngajat(int id) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("select * from Angajat where id = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Angajat a = null;
        if(rs.next()){
            int id1 = rs.getInt("id");
            String nume = rs.getString("nume");
            String mail = rs.getString("mail");
            int varsta = rs.getInt("varsta");
            int salariu = rs.getInt("salariu");
            String pozitie = rs.getString("pozitie");
            int idDS = rs.getInt("idDS");
            a = new Angajat(id1, nume, mail, varsta, idDS, salariu, pozitie);
        }
        return a;
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
    public Set<Angajat> findAllSet() {
        return new HashSet<Angajat>(store.values());
    }

    @Override
    public void delete(int idx) {
        store.remove(idx);
        try{
            PreparedStatement stmt = connection.prepareStatement("delete from Angajat where id = ?");
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
    public void update(int idx, Angajat entity) {
        store.put(idx, entity);
        try{
            PreparedStatement stmt = connection.prepareStatement("update Angajat set id = ?, nume = ?, mail = ?, varsta = ?, idDS = ?, salariu = ?, pozitie = ? where id = ?");
            stmt.setInt(1, entity.getId());
            stmt.setString(2, entity.getNume());
            stmt.setString(3, entity.getMail());
            stmt.setInt(4, entity.getVarsta());
            stmt.setInt(5, entity.getId_dealership());
            stmt.setInt(6, entity.getSalariu());
            stmt.setString(7, entity.getPozitie());
            stmt.setInt(8, idx);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(Angajat entity) {
        store.put(entity.getId(), entity);
        try{
            PreparedStatement stmt = connection.prepareStatement("insert into Angajat values(?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, entity.getId());
            stmt.setString(2, entity.getNume());
            stmt.setString(3, entity.getMail());
            stmt.setInt(4, entity.getVarsta());
            stmt.setInt(5, entity.getId_dealership());
            stmt.setInt(6, entity.getSalariu());
            stmt.setString(7, entity.getPozitie());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Angajat save(Angajat angajat) {
        add(angajat);
        return angajat;
    }
}
