package Repos;
import FirmaDealerShip.DealerShip;
import Persoana.Angajat;
import Persoana.Client;
import Sediu.Sediu;
import dbconnect.*;
import Produse.*;
import java.util.*;
import java.sql.*;
public class ATVRepo implements genericRepo<ATV>{
    private static final HashMap<Integer, ATV> store = new HashMap();
    private static volatile ATVRepo init;
    private final Connection connection;

    ATVRepo() {
        connection = dbconnect.getDBConnection();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from ATV");
            while(rs.next()){
                int serie = rs.getInt("serieFabricatie");
                int pret = rs.getInt("pret");
                String marca = rs.getString("marca");
                String terensuportat = rs.getString("terensuportat");
                int nivelDeSiguranta = rs.getInt("nivelDeSiguranta");
                int autonomie = rs.getInt("autonomie");
                String tractiune = rs.getString("tractiune");
                int id_catre_client = rs.getInt("id_catre_client");
                int idDS = rs.getInt("idDS");
                store.put(serie, new ATV(serie,pret,marca,id_catre_client,idDS,terensuportat,nivelDeSiguranta, autonomie, tractiune));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static ATVRepo getInit(){
        if (init == null) {
            synchronized (ATVRepo.class) {
                if (init == null) {
                    init = new ATVRepo();
                }
            }
        }
        return init;
    }
    @Override
    public List<ATV> findall() {
        ArrayList<ATV> s = new ArrayList<ATV>(store.values());
        return s;
    }

    @Override
    public Set<ATV> findAllSet() {
        return new HashSet<ATV>(store.values());
    }

    @Override
    public void delete(int idx) {
        store.remove(idx);
        try{
            PreparedStatement stmt = connection.prepareStatement("delete from ATV where serieFabricatie = ?");
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
        PreparedStatement stmt = connection.prepareStatement("select * from ATV where seriefabricatie = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        ATV m = null;
        if(rs.next()) {
            int serie = rs.getInt("serieFabricatie");
            int pret = rs.getInt("pret");
            String marca = rs.getString("marca");
            String terensuportat = rs.getString("terensuportat");
            int nivelDeSiguranta = rs.getInt("nivelDeSiguranta");
            int autonomie = rs.getInt("autonomie");
            String tractiune = rs.getString("tractiune");
            int id_catre_client = rs.getInt("id_catre_client");
            int idDS = rs.getInt("idDS");
            m = new ATV(serie,pret,marca,id_catre_client,idDS,terensuportat,nivelDeSiguranta, autonomie, tractiune);

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
    public void update(int idx, ATV entity) {
        store.put(idx, entity);
        try{
            PreparedStatement stmt = connection.prepareStatement("update ATV set " +
                    "serieFabricatie = ?, pret = ?, marca = ?, id_catre_client = ?, idDS = ?, terensuportat = ?, niveldesiguranta = ?, autonomie = ?, " +
                    "tractiune = ? where seriefabricatie = ?");
            stmt.setInt(1, entity.getSerieFabricatie());
            stmt.setInt(2, entity.getPret());
            stmt.setString(3, entity.getMarca());
            stmt.setInt(4, entity.getId_catre_client());
            stmt.setInt(5, entity.getIdDS());
            stmt.setString(6, entity.getTerenSuportat());
            stmt.setInt(7, entity.getNivelDeSiguranta());
            stmt.setInt(8, entity.getAutonomie());
            stmt.setString(9, entity.getTractiune());
            stmt.setInt(10, idx);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(ATV entity) {
        store.put(entity.getSerieFabricatie(), entity);
        try{
            PreparedStatement stmt = connection.prepareStatement("insert into ATV values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, entity.getSerieFabricatie());
            stmt.setInt(2, entity.getPret());
            stmt.setString(3, entity.getMarca());
            stmt.setInt(4, entity.getId_catre_client());
            stmt.setInt(5, entity.getIdDS());
            stmt.setString(6, entity.getTerenSuportat());
            stmt.setInt(7, entity.getNivelDeSiguranta());
            stmt.setInt(8, entity.getAutonomie());
            stmt.setString(9, entity.getTractiune());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ATV save(ATV atv) {
        add(atv);
        return atv;
    }
}
