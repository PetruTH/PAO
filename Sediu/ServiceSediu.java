package Sediu;

import Repos.*;

import java.sql.SQLException;
import java.util.*;

public class ServiceSediu implements SediuInterface {

    private final sediuRepo sediuRepovar = sediuRepo.getInit();

    public List<Sediu> getSedii() {
        return sediuRepovar.findall();
    }

    public Sediu afiseazaSediuDupaID(int idx) throws Exception {
        Sediu sediu = sediuRepovar.findOne(idx);
        return sediu;
    }

    public Sediu adaugaSediu(Sediu sediu) throws Exception {
        if (sediuRepovar.findOne(sediu.getId()) != null)
            throw new Exception("sediu cu acest id exista deja!");
        else
            return sediuRepovar.save(sediu);
    }

    public void updateSediu(int idx, Sediu adresa) throws Exception {
        sediuRepovar.findOne(idx);
        if (sediuRepovar.findOne(adresa.getId()) != null)
            throw new Exception("Exista deja un sediu cu acest id!");

        sediuRepovar.update(idx, adresa);
    }

    public void stergeSediu(int idx) throws Exception {
        sediuRepovar.findOne(idx);
        sediuRepovar.delete(idx);
    }
    public Sediu citesteSediu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti adresa: ");
        String adresa = scanner.nextLine();
        System.out.println("Introduceti numarul de stocuri: ");
        int nrStocuri = scanner.nextInt();
        System.out.println("Introduceti id ul: ");
        int id = scanner.nextInt();
        Sediu s = new Sediu(id, adresa, nrStocuri);
        return s;
    }

    public void updateNrStocuriSediuByID(int id, int new_stocuri) throws SQLException {
        Sediu s = sediuRepovar.findOne(id);
        sediuRepovar.updateNrStocuri(id, new_stocuri);
    }
}