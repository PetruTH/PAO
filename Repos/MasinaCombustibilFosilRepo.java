package Repos;
import FirmaDealerShip.DealerShip;
import Persoana.Angajat;
import Persoana.Client;
import Sediu.Sediu;
import dbconnect.*;
import Produse.*;
import java.util.*;
import java.sql.*;
public class MasinaCombustibilFosilRepo implements genericRepo<MasinaCombustibilFosil>{
    private static final HashMap<Integer, MasinaCombustibilFosil> store = new HashMap();
    private static volatile MasinaCombustibilFosilRepo init;
    private final Connection connection;

    MasinaCombustibilFosilRepo() {
        connection = dbconnect.getDBConnection();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from MasinaCombustibilFosil");
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
                int id_catre_client = rs.getInt("id_catre_client");
                int idDS = rs.getInt("idDS");
                store.put(serie, new MasinaCombustibilFosil(serie,pret,marca,id_catre_client,idDS,tip,putere,vitezaMaxima,masa,capacitateMotor,tipcombustibil));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static MasinaCombustibilFosilRepo getInit(){
        if (init == null) {
            synchronized (MasinaCombustibilFosilRepo.class) {
                if (init == null) {
                    init = new MasinaCombustibilFosilRepo();
                }
            }
        }
        return init;
    }
    @Override
    public List<MasinaCombustibilFosil> findall() {
        ArrayList<MasinaCombustibilFosil> s = new ArrayList<MasinaCombustibilFosil>(store.values());
        return s;
    }

    @Override
    public Set<MasinaCombustibilFosil> findAllSet() {
        return new HashSet<MasinaCombustibilFosil>(store.values());
    }

    @Override
    public void delete(int idx) {
        store.remove(idx);
        try{
            PreparedStatement stmt = connection.prepareStatement("delete from MasinaCombustibilFosil where serieFabricatie = ?");
            stmt.setInt(1, idx);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Masina findOneMasina(int id) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("select * from MasinaCombustibilFosil where seriefabricatie = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        MasinaCombustibilFosil m = null;
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
            int id_catre_client = rs.getInt("id_catre_client");
            int idDS = rs.getInt("idDS");
            m = new MasinaCombustibilFosil(serie,pret,marca, id_catre_client,idDS,tip,putere,vitezaMaxima,masa,capacitateMotor,tipcombustibil);

        }
        return m;
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
    public Sediu findOne(int id) throws SQLException {
        return null;
    }

    @Override
    public void update(int idx, MasinaCombustibilFosil entity) {
        store.put(idx, entity);
        try{
            PreparedStatement stmt = connection.prepareStatement("update MasinaCombustibilFosil set " +
                    "serieFabricatie = ?, pret = ?, marca = ?, id_catre_client = ?, idDS = ?, tip = ?, putere = ?, vitezamxima = ?, " +
                    "masa = ?, capacitatemotor = ?, tipcombustibil = ? where seriefabricatie = ?");
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
            stmt.setInt(12, idx);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(MasinaCombustibilFosil entity) {
        store.put(entity.getSerieFabricatie(), entity);
        try{
            PreparedStatement stmt = connection.prepareStatement("insert into MasinaCombustibilFosil values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
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
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public MasinaCombustibilFosil save(MasinaCombustibilFosil masina) {
        System.out.println("AICI");

        add(masina);
        return masina;
    }
}
