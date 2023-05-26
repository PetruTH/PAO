package Repos;
import FirmaDealerShip.DealerShip;
import Persoana.Angajat;
import Persoana.Client;
import Sediu.Sediu;
import dbconnect.*;
import Produse.*;
import java.util.*;
import java.sql.*;
public class MasinaElectricaRepo implements genericRepo<MasinaElectrica>{
    private static final HashMap<Integer, MasinaElectrica> store = new HashMap();
    private static volatile MasinaElectricaRepo init;
    private final Connection connection;

    MasinaElectricaRepo() {
        connection = dbconnect.getDBConnection();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from MasinaElectrica");
            while(rs.next()){
                int serie = rs.getInt("serieFabricatie");
                int pret = rs.getInt("pret");
                String marca = rs.getString("marca");
                String tip = rs.getString("tip");
                int putere = rs.getInt("putere");
                int vitezaMaxima = rs.getInt("vitezaMaxima");
                int masa = rs.getInt("masa");
                int id_catre_client = rs.getInt("id_catre_client");
                int autonomie = rs.getInt("autonomie");
                int idDS = rs.getInt("idDS");
                store.put(serie, new MasinaElectrica(serie,pret,marca, id_catre_client, idDS,tip,putere,vitezaMaxima,masa,autonomie));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static MasinaElectricaRepo getInit(){
        if (init == null) {
            synchronized (MasinaElectricaRepo.class) {
                if (init == null) {
                    init = new MasinaElectricaRepo();
                }
            }
        }
        return init;
    }
    @Override
    public List<MasinaElectrica> findall() {
        ArrayList<MasinaElectrica> s = new ArrayList<MasinaElectrica>(store.values());
        return s;
    }

    @Override
    public Set<MasinaElectrica> findAllSet() {
        return new HashSet<MasinaElectrica>(store.values());
    }

    @Override
    public void delete(int idx) {
        store.remove(idx);
        try{
            PreparedStatement stmt = connection.prepareStatement("delete from MasinaElectrica where serieFabricatie = ?");
            stmt.setInt(1, idx);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Masina findOneMasina(int id) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("select * from MasinaElectrica where seriefabricatie = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        MasinaElectrica m = null;
        if(rs.next()) {
            int serie = rs.getInt("serieFabricatie");
            int pret = rs.getInt("pret");
            String marca = rs.getString("marca");
            String tip = rs.getString("tip");
            int putere = rs.getInt("putere");
            int vitezaMaxima = rs.getInt("vitezaMaxima");
            int masa = rs.getInt("masa");
            int autonomie =  rs.getInt("autonomie");
            int id_catre_client = rs.getInt("id_catre_client");
            int idDS = rs.getInt("idDS");
            m = new MasinaElectrica(serie,pret,marca, id_catre_client,idDS,tip,putere,vitezaMaxima,masa,autonomie);

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
    public void update(int idx, MasinaElectrica entity) {
        store.put(idx, entity);
        try{
            PreparedStatement stmt = connection.prepareStatement("update MasinaElectrica set " +
                    "serieFabricatie = ?, pret = ?, marca = ?, id_catre_client = ?, idDS = ?, tip = ?, putere = ?, vitezamxima = ?, " +
                    "masa = ?, autonomie = ? where seriefabricatie = ?");
            stmt.setInt(1, entity.getSerieFabricatie());
            stmt.setInt(2, entity.getPret());
            stmt.setString(3, entity.getMarca());
            stmt.setInt(4, entity.getId_catre_client());
            stmt.setInt(5, entity.getIdDS());
            stmt.setString(6, entity.getTip());
            stmt.setInt(7, entity.getPutere());
            stmt.setInt(8, entity.getVitezaMaxima());
            stmt.setInt(9, entity.getMasa());
            stmt.setInt(10, entity.getAutonomie());
            stmt.setInt(11, idx);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(MasinaElectrica entity) {
        store.put(entity.getSerieFabricatie(), entity);
        try{
            PreparedStatement stmt = connection.prepareStatement("insert into MasinaElectrica values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, entity.getSerieFabricatie());
            stmt.setInt(2, entity.getPret());
            stmt.setString(3, entity.getMarca());
            stmt.setInt(4, entity.getId_catre_client());
            stmt.setInt(5, entity.getIdDS());
            stmt.setString(6, entity.getTip());
            stmt.setInt(7, entity.getPutere());
            stmt.setInt(8, entity.getVitezaMaxima());
            stmt.setInt(9, entity.getMasa());
            stmt.setInt(10, entity.getAutonomie());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public MasinaElectrica save(MasinaElectrica masina) {
        add(masina);
        return masina;
    }
}
