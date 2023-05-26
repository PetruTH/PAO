package Produse;

import Repos.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiceProdus implements ProduseInterface{
//    private List<Produse> produse = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    private final MasinaCombustibilFosilRepo MasinaCombustibilFosilRepovar = MasinaCombustibilFosilRepo.getInit();
    private final MasinaElectricaRepo MasinaElectricaRepovar = MasinaElectricaRepo.getInit();
    private final MasinaHybridRepo MasinaHybridRepovar = MasinaHybridRepo.getInit();
    private final ATVRepo ATVRepovar = ATVRepo.getInit();
    private final MotocicletaRepo MotocicletaRepovar = MotocicletaRepo.getInit();
    private final BicicletaRepo BicicletaRepovar = BicicletaRepo.getInit();

    @Override
    public List<Produse> getProduse() {
        List<Produse> produse = new ArrayList<>();
//        concatenezi toate produsele din tabele si le returnezi
        List<MasinaCombustibilFosil> masinicombfosil = MasinaCombustibilFosilRepovar.findall();
        List<MasinaHybrid> masinihybrid = MasinaHybridRepovar.findall();
        List<MasinaElectrica> masinielectrica = MasinaElectricaRepovar.findall();
        List<ATV> atv = ATVRepovar.findall();
        List<Motocicleta> motocicleta = MotocicletaRepovar.findall();
        List<Bicicleta> bicicleta = BicicletaRepovar.findall();
        produse.addAll(masinicombfosil);
        produse.addAll(masinihybrid);
        produse.addAll(masinielectrica);
        produse.addAll(atv);
        produse.addAll(motocicleta);
        produse.addAll(bicicleta);
        return produse;
    }

    @Override
    public Produse getProdusBySeriedeFabricatie(int serie, int tip) throws SQLException {
//        selecteazaProdus();
//        int opt = scanner.nextInt();
        switch (tip){
            case 1:
                return MasinaCombustibilFosilRepovar.findOneMasina(serie);
            case 2:
                return MasinaElectricaRepovar.findOneMasina(serie);
            case 3:
                return MasinaHybridRepovar.findOneMasina(serie);
            case 4:
                return ATVRepovar.findOneOffRoad(serie);
            case 5:
                return MotocicletaRepovar.findOneOffRoad(serie);
            case 6:
                return BicicletaRepovar.findOneOffRoad(serie);
            default:
                System.out.println("Nu exista optiunea selectata!");
                return null;
        }
    }

    @Override
    public void deleteProdusBySeriedeFabricatie(int serie) {
//        for(int i=0; i<this.produse.size(); i++){
//            if(serie == (produse.get(i).getSerieFabricatie())){
//                this.produse.remove(i);
//            }
//        }
        selecteazaProdus();
        int opt = scanner.nextInt();
        switch (opt){
            case 1:
                MasinaCombustibilFosilRepovar.delete(serie);
                break;
            case 2:
                MasinaElectricaRepovar.delete(serie);
                break;
            case 3:
                MasinaHybridRepovar.delete(serie);
                break;
            case 4:
                ATVRepovar.delete(serie);
                break;
            case 5:
                MotocicletaRepovar.delete(serie);
                break;
            case 6:
                BicicletaRepovar.delete(serie);
                break;
            default:
                System.out.println("Nu exista optiunea selectata!");
                break;
        }
    }

    void selecteazaProdus(){
        System.out.println("1 - Masina cu combustibil fosil");
        System.out.println("2 - Masina electrica");
        System.out.println("3 - Masina Hybrid");
        System.out.println("4 - ATV");
        System.out.println("5 - Motocicleta");
        System.out.println("6 - Bicicleta");
    }

    private int ReadUntilPositive(){
        Scanner newsc = new Scanner(System.in);
        int dataToRead = 0;
        int ok = 0;
        while(ok == 0){
            dataToRead = newsc.nextInt();
            if(dataToRead < 0) {
                System.out.println("Nu puteti seta acest parametru sa fie negativ!");
            }else{
                ok = 1;
            }
        }
        return dataToRead;
    }
    private MasinaCombustibilFosil citesteMasinaCombustibil(){
        MasinaCombustibilFosil newCar = new MasinaCombustibilFosil();

        System.out.println("Introduceti seria de fabricatie: ");
        newCar.setSerieFabricatie(scanner.nextInt());

        System.out.println("Introduceti marca: ");
        newCar.setMarca(scanner.next());

        System.out.println("Introduceti catre ce client este destinat produsul sau 0 daca e doar in stoc: ");
        newCar.setId_catre_client(scanner.nextInt());

        System.out.println("Introduceti DS-ul in care se gaseste produsul: ");
        newCar.setIdDS(scanner.nextInt());

        System.out.println("Introduceti pretul: ");
        newCar.setPret(ReadUntilPositive());

        System.out.println("Introduceti tipul: ");
        newCar.setTip(scanner.next());

        System.out.println("Introduceti puterea: ");
        newCar.setPutere(ReadUntilPositive());

        System.out.println("Introduceti viteza maxima: ");
        newCar.setVitezaMaxima(ReadUntilPositive());

        System.out.println("Introduceti masa: ");
        newCar.setMasa(ReadUntilPositive());

        System.out.println("Introduceti capacitatea motorului: ");
        newCar.setCapacitateMotor(ReadUntilPositive());

        System.out.println("Introduceti tipul combustibilului: ");
        newCar.setTipCombustibil(scanner.next());

        return newCar;
    }
    private MasinaElectrica citesteMasinaElectrica(){
        MasinaElectrica newCar = new MasinaElectrica();

        System.out.println("Introduceti seria de fabricatie: ");
        newCar.setSerieFabricatie(scanner.nextInt());

        System.out.println("Introduceti pretul: ");
        newCar.setPret(ReadUntilPositive());

        System.out.println("Introduceti marca: ");
        newCar.setMarca(scanner.next());

        System.out.println("Introduceti catre ce client este destinat produsul sau 0 daca e doar in stoc: ");
        newCar.setId_catre_client(scanner.nextInt());

        System.out.println("Introduceti DS-ul in care se gaseste produsul: ");
        newCar.setIdDS(scanner.nextInt());

        System.out.println("Introduceti tipul: ");
        newCar.setTip(scanner.next());

        System.out.println("Introduceti puterea: ");
        newCar.setPutere(ReadUntilPositive());

        System.out.println("Introduceti viteza maxima: ");
        newCar.setVitezaMaxima(ReadUntilPositive());

        System.out.println("Introduceti masa: ");
        newCar.setMasa(ReadUntilPositive());

        System.out.println("Introduceti autonomia motorului: ");
        newCar.setAutonomie(ReadUntilPositive());

        return newCar;
    }
    private MasinaHybrid citesteMasinaHybrid(){
        MasinaHybrid newCar = new MasinaHybrid();

        System.out.println("Introduceti seria de fabricatie: ");
        newCar.setSerieFabricatie(scanner.nextInt());

        System.out.println("Introduceti pretul: ");
        newCar.setPret(ReadUntilPositive());

        System.out.println("Introduceti marca: ");
        newCar.setMarca(scanner.next());

        System.out.println("Introduceti catre ce client este destinat produsul sau 0 daca e doar in stoc: ");
        newCar.setId_catre_client(scanner.nextInt());

        System.out.println("Introduceti DS-ul in care se gaseste produsul: ");
        newCar.setIdDS(scanner.nextInt());

        System.out.println("Introduceti tipul: ");
        newCar.setTip(scanner.next());

        System.out.println("Introduceti puterea: ");
        newCar.setPutere(ReadUntilPositive());

        System.out.println("Introduceti viteza maxima: ");
        newCar.setVitezaMaxima(ReadUntilPositive());

        System.out.println("Introduceti masa: ");
        newCar.setMasa(ReadUntilPositive());

        System.out.println("Introduceti capacitatea motorului: ");
        newCar.setCapacitateMotor(ReadUntilPositive());

        System.out.println("Introduceti tipul combustibilului: ");
        newCar.setTipCombustibil(scanner.next());

        System.out.println("Introduceti autonomia motorului: ");
        newCar.setAutonomieMotorElectric(ReadUntilPositive());

        return newCar;
    }
    private Motocicleta citesteMotocicleta(){
        Motocicleta newMoto = new Motocicleta();
        System.out.println("Introduceti seria de fabricatie: ");
        newMoto.setSerieFabricatie(scanner.nextInt());

        System.out.println("Introduceti pretul: ");
        newMoto.setPret(ReadUntilPositive());

        System.out.println("Introduceti marca: ");
        newMoto.setMarca(scanner.next());

        System.out.println("Introduceti catre ce client este destinat produsul sau 0 daca e doar in stoc: ");
        newMoto.setId_catre_client(scanner.nextInt());

        System.out.println("Introduceti DS-ul in care se gaseste produsul: ");
        newMoto.setIdDS(scanner.nextInt());

        System.out.println("Teren suportat: ");
        newMoto.setTerenSuportat(scanner.next());

        System.out.println("Nivel de siguranta (maxim 10/10): ");
        newMoto.setNivelDeSiguranta(ReadUntilPositive());

        System.out.println("Capacitate cilindrica: ");
        newMoto.setNivelDeSiguranta(ReadUntilPositive());

        System.out.println("Transmisie: ");
        newMoto.setTerenSuportat(scanner.next());

        System.out.println("Tip de motocicleta: ");
        newMoto.setTerenSuportat(scanner.next());

        return newMoto;
    }
    private ATV citesteATV(){
        ATV newATV = new ATV();

        System.out.println("Introduceti seria de fabricatie: ");
        newATV.setSerieFabricatie(scanner.nextInt());

        System.out.println("Introduceti pretul: ");
        newATV.setPret(ReadUntilPositive());

        System.out.println("Introduceti marca: ");
        newATV.setMarca(scanner.next());

        System.out.println("Introduceti catre ce client este destinat produsul sau 0 daca e doar in stoc: ");
        newATV.setId_catre_client(scanner.nextInt());

        System.out.println("Introduceti DS-ul in care se gaseste produsul: ");
        newATV.setIdDS(scanner.nextInt());

        System.out.println("Teren suportat: ");
        newATV.setTerenSuportat(scanner.next());

        System.out.println("Nivel de siguranta (maxim 10/10): ");
        newATV.setNivelDeSiguranta(ReadUntilPositive());

        System.out.println("Autonomie: ");
        newATV.setAutonomie(ReadUntilPositive());

        System.out.println("Tractiune: ");
        newATV.setTractiune(scanner.next());

        return newATV;
    }
    private Bicicleta citesteBicicleta(){
        Bicicleta bike = new Bicicleta();

        System.out.println("Introduceti seria de fabricatie: ");
        bike.setSerieFabricatie(scanner.nextInt());

        System.out.println("Introduceti pretul: ");
        bike.setPret(ReadUntilPositive());

        System.out.println("Introduceti marca: ");
        bike.setMarca(scanner.next());

        System.out.println("Introduceti catre ce client este destinat produsul sau 0 daca e doar in stoc: ");
        bike.setId_catre_client(scanner.nextInt());

        System.out.println("Introduceti DS-ul in care se gaseste produsul: ");
        bike.setIdDS(scanner.nextInt());

        System.out.println("Teren suportat: ");
        bike.setTerenSuportat(scanner.next());

        System.out.println("Nivel de siguranta (maxim 10/10): ");
        bike.setNivelDeSiguranta(ReadUntilPositive());

        System.out.println("Introduceti numearul de viteze: ");
        bike.setNrViteze(ReadUntilPositive());

        System.out.println("Introduceti masa: ");
        bike.setMasa(ReadUntilPositive());

        System.out.println("Introduceti materialul din care e construit cadrul bicicletei: ");
        bike.setMaterialCadru(scanner.next());

        return bike;
    }

    @Override
    public Produse citesteProdusInFunctieDeOpt() throws SQLException {
        selecteazaProdus();
        int opt = scanner.nextInt();
        if(opt==1){
            MasinaCombustibilFosil newCar = citesteMasinaCombustibil();
            if (MasinaCombustibilFosilRepovar.findOneMasina(newCar.getSerieFabricatie()) == null)
                return MasinaCombustibilFosilRepovar.save(newCar);
            else {
                System.out.println("Masina cu seria de fabricatie " + newCar.getSerieFabricatie() + " exista deja in baza de date!");
                return null;
            }
        }else if(opt==2){
            MasinaElectrica newCar = citesteMasinaElectrica();
            if (MasinaElectricaRepovar.findOneMasina(newCar.getSerieFabricatie()) == null)
                return MasinaElectricaRepovar.save(newCar);
            else {
                System.out.println("Masina cu seria de fabricatie " + newCar.getSerieFabricatie() + " exista deja in baza de date!");
                return null;
            }
        }else if(opt==3){
            MasinaHybrid newCar = citesteMasinaHybrid();

            if (MasinaHybridRepovar.findOneMasina(newCar.getSerieFabricatie()) == null)
                return MasinaHybridRepovar.save(newCar);
            else {
                System.out.println("Masina cu seria de fabricatie " + newCar.getSerieFabricatie() + " exista deja in baza de date!");
                return null;
            }

        }else if(opt==4){
            ATV newATV = citesteATV();

            if (ATVRepovar.findOneMasina(newATV.getSerieFabricatie()) == null)
                return ATVRepovar.save(newATV);
            else {
                System.out.println("Masina cu seria de fabricatie " + newATV.getSerieFabricatie() + " exista deja in baza de date!");
                return null;
            }

        }else if(opt==5){
            Motocicleta newMoto = citesteMotocicleta();

            if (MotocicletaRepovar.findOneMasina(newMoto.getSerieFabricatie()) == null)
                return MotocicletaRepovar.save(newMoto);
            else {
                System.out.println("Masina cu seria de fabricatie " + newMoto.getSerieFabricatie() + " exista deja in baza de date!");
                return null;
            }


        }else if(opt==6){
            Bicicleta newBike = citesteBicicleta();

            if (BicicletaRepovar.findOneMasina(newBike.getSerieFabricatie()) == null)
                return BicicletaRepovar.save(newBike);
            else {
                System.out.println("Masina cu seria de fabricatie " + newBike.getSerieFabricatie() + " exista deja in baza de date!");
                return null;
            }

        }else return null;
    }

    @Override
    public void updateProdusBySeriedeFabricatie(int serie) throws SQLException {
        selecteazaProdus();
        int opt = scanner.nextInt();
        switch (opt){
            case 1: {
                MasinaCombustibilFosil newCar = citesteMasinaCombustibil();
                MasinaCombustibilFosilRepovar.update(serie, newCar);
                break;
            }
            case 2: {
                MasinaElectrica newCar = citesteMasinaElectrica();
                MasinaElectricaRepovar.update(serie, newCar);
                break;
            }
            case 3: {
                MasinaHybrid newCar = citesteMasinaHybrid();
                MasinaHybridRepovar.update(serie, newCar);
                break;
            }
            case 4: {
                ATV newATV = citesteATV();
                ATVRepovar.update(serie, newATV);
                break;
            }
            case 5: {
                Motocicleta newMoto = citesteMotocicleta();
                MotocicletaRepovar.update(serie, newMoto);
                break;
            }
            case 6: {
                Bicicleta newBike = citesteBicicleta();
                BicicletaRepovar.update(serie, newBike);
                break;
            }
            default:
                System.out.println("Optiune invalida!");
                break;
        }
    }
}
