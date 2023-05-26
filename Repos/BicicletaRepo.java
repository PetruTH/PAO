package Repos;
import FirmaDealerShip.DealerShip;
import Persoana.Angajat;
import Persoana.Client;
import Sediu.Sediu;
import dbconnect.*;
import Produse.*;
import java.util.*;
import java.sql.*;
public class BicicletaRepo implements genericRepo<Bicicleta>{
    private static final HashMap<Integer, Bicicleta> store = new HashMap();
    private static volatile BicicletaRepo init;
    private final Connection connection;

    BicicletaRepo() {
        connection = dbconnect.getDBConnection();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Bicicleta");
            while(rs.next()){
                int serie = rs.getInt("serieFabricatie");
                int pret = rs.getInt("pret");
                String marca = rs.getString("marca");
                String terensuportat = rs.getString("terensuportat");
                int nivelDeSiguranta = rs.getInt("nivelDeSiguranta");
                int masa = rs.getInt("masa");
                int nrViteze = rs.getInt("nrViteze");
                String materialCadru = rs.getString("materialCadru");
                int id_catre_client = rs.getInt("id_catre_client");
                int idDS = rs.getInt("idDS");
                store.put(serie, new Bicicleta(serie,pret,marca,id_catre_client,idDS,terensuportat,nivelDeSiguranta, masa, nrViteze, materialCadru));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static BicicletaRepo getInit(){
        if (init == null) {
            synchronized (BicicletaRepo.class) {
                if (init == null) {
                    init = new BicicletaRepo();
                }
            }
        }
        return init;
    }
    @Override
    public List<Bicicleta> findall() {
        ArrayList<Bicicleta> s = new ArrayList<Bicicleta>(store.values());
        return s;
    }

    @Override
    public Set<Bicicleta> findAllSet() {
        return new HashSet<Bicicleta>(store.values());
    }

    @Override
    public void delete(int idx) {
        store.remove(idx);
        try{
            PreparedStatement stmt = connection.prepareStatement("delete from Bicicleta where serieFabricatie = ?");
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
        PreparedStatement stmt = connection.prepareStatement("select * from Bicicleta where seriefabricatie = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Bicicleta m = null;
        if(rs.next()) {
            int serie = rs.getInt("serieFabricatie");
            int pret = rs.getInt("pret");
            String marca = rs.getString("marca");
            String terensuportat = rs.getString("terensuportat");
            int nivelDeSiguranta = rs.getInt("nivelDeSiguranta");
            int masa = rs.getInt("masa");
            int nrViteze = rs.getInt("nrViteze");
            String materialCadru = rs.getString("materialCadru");
            int id_catre_client = rs.getInt("id_catre_client");
            int idDS = rs.getInt("idDS");
            m = new Bicicleta(serie,pret,marca,id_catre_client,idDS,terensuportat,nivelDeSiguranta, masa, nrViteze, materialCadru);
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
    public void update(int idx, Bicicleta entity) {
        store.put(idx, entity);
        try{
            PreparedStatement stmt = connection.prepareStatement("update Bicicleta set " +
                    "serieFabricatie = ?, pret = ?, marca = ?, id_catre_client = ?, idDS = ?, terensuportat = ?, niveldesiguranta = ?, masa = ?, " +
                    "nrViteze = ?, materialCadru = ? where seriefabricatie = ?");
            stmt.setInt(1, entity.getSerieFabricatie());
            stmt.setInt(2, entity.getPret());
            stmt.setString(3, entity.getMarca());
            stmt.setString(6, entity.getTerenSuportat());
            stmt.setInt(4, entity.getId_catre_client());
            stmt.setInt(5, entity.getIdDS());
            stmt.setInt(7, entity.getNivelDeSiguranta());
            stmt.setInt(8, entity.getMasa());
            stmt.setInt(9, entity.getNrViteze());
            stmt.setString(10, entity.getMaterialCadru());
            stmt.setInt(11, idx);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(Bicicleta entity) {
        store.put(entity.getSerieFabricatie(), entity);
        try{
            PreparedStatement stmt = connection.prepareStatement("insert into Bicicleta values(?, ?, ?, ?, ?, ?, ?, ?, ?,?)");
            stmt.setInt(1, entity.getSerieFabricatie());
            stmt.setInt(2, entity.getPret());
            stmt.setString(3, entity.getMarca());
            stmt.setInt(4, entity.getId_catre_client());
            stmt.setInt(5, entity.getIdDS());
            stmt.setString(6, entity.getTerenSuportat());
            stmt.setInt(7, entity.getNivelDeSiguranta());
            stmt.setInt(8, entity.getMasa());
            stmt.setInt(9, entity.getNrViteze());
            stmt.setString(10, entity.getMaterialCadru());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Bicicleta save(Bicicleta bicicleta) {
        add(bicicleta);
        return bicicleta;
    }
}
