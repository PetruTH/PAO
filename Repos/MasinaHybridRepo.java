package Repos;
import FirmaDealerShip.DealerShip;
import Persoana.Angajat;
import Persoana.Client;
import Sediu.Sediu;
import dbconnect.*;
import Produse.*;
import java.util.*;
import java.sql.*;
public class MasinaHybridRepo implements genericRepo<MasinaHybrid>{
    private static final HashMap<Integer, MasinaHybrid> store = new HashMap();
    private static volatile MasinaHybridRepo init;
    private final Connection connection;

    MasinaHybridRepo() {
        connection = dbconnect.getDBConnection();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from MasinaHybrid");
            while(rs.next()){
                int serie = rs.getInt("serieFabricatie");
                int pret = rs.getInt("pret");
                String marca = rs.getString("marca");
                String tip = rs.getString("tip");
                int putere = rs.getInt("putere");
                int vitezaMaxima = rs.getInt("vitezaMaxima");
                int masa = rs.getInt("masa");
                int capacitateMotor =  rs.getInt("capacitateMotor");
                String tipcombustibil = rs.getString("tipcombustibil");
                int autonomie = rs.getInt("autonomie");
                int id_catre_client = rs.getInt("id_catre_client");
                int idDS = rs.getInt("idDS");
                store.put(serie, new MasinaHybrid(serie,pret,marca,id_catre_client,idDS,tip,putere,vitezaMaxima,masa,capacitateMotor,tipcombustibil, autonomie));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static MasinaHybridRepo getInit(){
        if (init == null) {
            synchronized (MasinaHybridRepo.class) {
                if (init == null) {
                    init = new MasinaHybridRepo();
                }
            }
        }
        return init;
    }
    @Override
    public List<MasinaHybrid> findall() {
        ArrayList<MasinaHybrid> s = new ArrayList<MasinaHybrid>(store.values());
        return s;
    }

    @Override
    public Set<MasinaHybrid> findAllSet() {
        return new HashSet<MasinaHybrid>(store.values());
    }

    @Override
    public void delete(int idx) {
        store.remove(idx);
        try{
            PreparedStatement stmt = connection.prepareStatement("delete from MasinaHybrid where serieFabricatie = ?");
            stmt.setInt(1, idx);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Masina findOneMasina(int id) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("select * from MasinaHybrid where seriefabricatie = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        MasinaHybrid m = null;
        if(rs.next()) {
            int serie = rs.getInt("serieFabricatie");
            int pret = rs.getInt("pret");
            String marca = rs.getString("marca");
            String tip = rs.getString("tip");
            int putere = rs.getInt("putere");
            int vitezaMaxima = rs.getInt("vitezaMaxima");
            int masa = rs.getInt("masa");
            int capacitateMotor =  rs.getInt("capacitateMotor");
            String tipcombustibil = rs.getString("tipcombustibil");
            int autonomie = rs.getInt("autonomie");
            int id_catre_client = rs.getInt("id_catre_client");
            int idDS = rs.getInt("idDS");
            m = new MasinaHybrid(serie,pret,marca,id_catre_client, idDS,tip,putere,vitezaMaxima,masa,capacitateMotor,tipcombustibil,autonomie);

        }
        return m;
    }

    @Override
    public Sediu findOne(int id) throws SQLException {
        return null;
    }

    @Override
    public void update(int idx, MasinaHybrid entity) {
        store.put(idx, entity);
        try{
            PreparedStatement stmt = connection.prepareStatement("update MasinaHybrid set " +
                    "serieFabricatie = ?, pret = ?, marca = ?, id_catre_client = ?, idDS = ?, tip = ?, putere = ?, vitezamxima = ?, " +
                    "masa = ?, capacitatemotor = ?, tipcombustibil = ?, autonomie = ? where seriefabricatie = ?");
            stmt.setInt(1, entity.getSerieFabricatie());
            stmt.setInt(2, entity.getPret());
            stmt.setString(3, entity.getMarca());
            stmt.setInt(4, entity.getId_catre_client());
            stmt.setInt(5, entity.getIdDS());
            stmt.setString(6, entity.getTip());
            stmt.setInt(7, entity.getPutere());
            stmt.setInt(8, entity.getVitezaMaxima());
            stmt.setInt(9, entity.getMasa());
            stmt.setInt(10, entity.getCapacitateMotor());
            stmt.setString(11, entity.getTipCombustibil());
            stmt.setInt(12, entity.getAutonomieMotorElectric());
            stmt.setInt(13, idx);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(MasinaHybrid entity) {
        store.put(entity.getSerieFabricatie(), entity);
        try{
            PreparedStatement stmt = connection.prepareStatement("insert into MasinaHybrid values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)");
            stmt.setInt(1, entity.getSerieFabricatie());
            stmt.setInt(2, entity.getPret());
            stmt.setString(3, entity.getMarca());
            stmt.setInt(4, entity.getId_catre_client());
            stmt.setInt(5, entity.getIdDS());
            stmt.setString(6, entity.getTip());
            stmt.setInt(7, entity.getPutere());
            stmt.setInt(8, entity.getVitezaMaxima());
            stmt.setInt(9, entity.getMasa());
            stmt.setInt(10, entity.getCapacitateMotor());
            stmt.setString(11, entity.getTipCombustibil());
            stmt.setInt(12, entity.getAutonomieMotorElectric());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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

    public MasinaHybrid save(MasinaHybrid masina) {
        add(masina);
        return masina;
    }
}
