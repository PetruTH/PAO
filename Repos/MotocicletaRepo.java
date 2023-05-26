package Repos;
import FirmaDealerShip.DealerShip;
import Persoana.Angajat;
import Persoana.Client;
import Sediu.Sediu;
import dbconnect.*;
import Produse.*;
import java.util.*;
import java.sql.*;
public class MotocicletaRepo implements genericRepo<Motocicleta>{
    private static final HashMap<Integer, Motocicleta> store = new HashMap();
    private static volatile MotocicletaRepo init;
    private final Connection connection;

    MotocicletaRepo() {
        connection = dbconnect.getDBConnection();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Motocicleta");
            while(rs.next()){
                int serie = rs.getInt("serieFabricatie");
                int pret = rs.getInt("pret");
                String marca = rs.getString("marca");
                String terensuportat = rs.getString("terensuportat");
                int nivelDeSiguranta = rs.getInt("nivelDeSiguranta");
                int capacitatecilindrica = rs.getInt("capacitatecilindrica");
                String transmisie = rs.getString("transmisie");
                String tipmotocicleta = rs.getString("tipmotocicleta");
                int id_catre_client = rs.getInt("id_catre_client");
                int idDS = rs.getInt("idDS");
                store.put(serie, new Motocicleta(serie,pret,marca,id_catre_client,idDS,terensuportat,nivelDeSiguranta, capacitatecilindrica, transmisie, tipmotocicleta));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static MotocicletaRepo getInit(){
        if (init == null) {
            synchronized (MotocicletaRepo.class) {
                if (init == null) {
                    init = new MotocicletaRepo();
                }
            }
        }
        return init;
    }
    @Override
    public List<Motocicleta> findall() {
        ArrayList<Motocicleta> s = new ArrayList<Motocicleta>(store.values());
        return s;
    }

    @Override
    public Set<Motocicleta> findAllSet() {
        return new HashSet<Motocicleta>(store.values());
    }

    @Override
    public void delete(int idx) {
        store.remove(idx);
        try{
            PreparedStatement stmt = connection.prepareStatement("delete from Motocicleta where serieFabricatie = ?");
            stmt.setInt(1, idx);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Masina findOneMasina(int id) throws SQLException {
        return null;
    }

    @Override
    public OffRoad findOneOffRoad(int id) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("select * from Motocicleta where seriefabricatie = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Motocicleta m = null;
        if(rs.next()) {
            int serie = rs.getInt("serieFabricatie");
            int pret = rs.getInt("pret");
            String marca = rs.getString("marca");
            String terensuportat = rs.getString("terensuportat");
            int nivelDeSiguranta = rs.getInt("nivelDeSiguranta");
            int capacitatecilindrica = rs.getInt("capacitatecilindrica");
            String transmisie = rs.getString("transmisie");
            String tipmotocicleta = rs.getString("tipmotocicleta");
            int id_catre_client = rs.getInt("id_catre_client");
            int idDS = rs.getInt("idDS");
            m = new Motocicleta(serie, pret, marca,id_catre_client, idDS, terensuportat, nivelDeSiguranta, capacitatecilindrica, transmisie, tipmotocicleta);
        }
        return m;
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
    public void update(int idx, Motocicleta entity) {
        store.put(idx, entity);
        try{
            PreparedStatement stmt = connection.prepareStatement("update Motocicleta set " +
                    "serieFabricatie = ?, pret = ?, marca = ?, id_catre_client = ?, idDS = ?, terensuportat = ?, niveldesiguranta = ?, capacitatecilindrica = ?, " +
                    "transmisie = ?, tipmotocicleta = ? where seriefabricatie = ?");
            stmt.setInt(1, entity.getSerieFabricatie());
            stmt.setInt(2, entity.getPret());
            stmt.setString(3, entity.getMarca());
            stmt.setInt(4, entity.getId_catre_client());
            stmt.setInt(5, entity.getIdDS());
            stmt.setString(6, entity.getTerenSuportat());
            stmt.setInt(7, entity.getNivelDeSiguranta());
            stmt.setInt(8, entity.getCapacitateCilindrica());
            stmt.setString(9, entity.getTransmisie());
            stmt.setString(10, entity.getTipMotocicleta());
            stmt.setInt(11, idx);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(Motocicleta entity) {
        store.put(entity.getSerieFabricatie(), entity);
        try{
            PreparedStatement stmt = connection.prepareStatement("insert into Motocicleta values(?,?,?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, entity.getSerieFabricatie());
            stmt.setInt(2, entity.getPret());
            stmt.setString(3, entity.getMarca());
            stmt.setInt(4, entity.getId_catre_client());
            stmt.setInt(5, entity.getIdDS());
            stmt.setString(6, entity.getTerenSuportat());
            stmt.setInt(7, entity.getNivelDeSiguranta());
            stmt.setInt(8, entity.getCapacitateCilindrica());
            stmt.setString(9, entity.getTransmisie());
            stmt.setString(10, entity.getTipMotocicleta());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Motocicleta save(Motocicleta motocicleta) {
        add(motocicleta);
        return motocicleta;
    }
}
