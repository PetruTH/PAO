package Produse;

import Persoana.Angajat;
import Persoana.ServiceAngajat;
import Produse.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ServiceProdus implements ProduseInterface{
    private List<Produse> produse = new ArrayList<>();
    private static ServiceProdus instance;
    Scanner scanner = new Scanner(System.in);
    public ServiceProdus() {

    }
    public static ServiceProdus getInstance(){
        if(instance == null){
            instance = new ServiceProdus();
        }
        return instance;
    }

    @Override
    public List<Produse> getProduse() {
        return this.produse;
    }

    @Override
    public Produse getProdusBySeriedeFabricatie(String serie) {
        for(int i=0; i < produse.size(); i++){
            if(serie.compareTo(produse.get(i).getSerieFabricatie()) == 0){
                return this.produse.get(i);
            }
        }
        System.out.println("Nu exista produsul cu seria de fabricatie " + serie);
        return null;
    }

    @Override
    public void deleteProdusBySeriedeFabricatie(String serie) {
        for(int i=0; i<this.produse.size(); i++){
            if(serie.compareTo(produse.get(i).getSerieFabricatie()) == 0){
                this.produse.remove(i);
            }
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
        newCar.setSerieFabricatie(scanner.next());

        System.out.println("Introduceti marca: ");
        newCar.setMarca(scanner.next());

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
        newCar.setSerieFabricatie(scanner.next());

        System.out.println("Introduceti pretul: ");
        newCar.setPret(ReadUntilPositive());

        System.out.println("Introduceti marca: ");
        newCar.setMarca(scanner.next());

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
        newCar.setSerieFabricatie(scanner.next());

        System.out.println("Introduceti pretul: ");
        newCar.setPret(ReadUntilPositive());

        System.out.println("Introduceti marca: ");
        newCar.setMarca(scanner.next());

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
        newMoto.setSerieFabricatie(scanner.next());

        System.out.println("Introduceti pretul: ");
        newMoto.setPret(ReadUntilPositive());

        System.out.println("Introduceti marca: ");
        newMoto.setMarca(scanner.next());

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
        newATV.setSerieFabricatie(scanner.next());

        System.out.println("Introduceti pretul: ");
        newATV.setPret(ReadUntilPositive());

        System.out.println("Introduceti marca: ");
        newATV.setMarca(scanner.next());

        System.out.println("Teren suportat: ");
        newATV.setTerenSuportat(scanner.next());

        System.out.println("Nivel de siguranta (maxim 10/10): ");
        newATV.setNivelDeSiguranta(ReadUntilPositive());

        System.out.println("Autonomie: ");
        newATV.setAutonomie(ReadUntilPositive());

        System.out.println("Tractiune: ");
        newATV.setTerenSuportat(scanner.next());

        return newATV;
    }
    private Bicicleta citesteBicicleta(){
        Bicicleta bike = new Bicicleta();

        System.out.println("Introduceti seria de fabricatie: ");
        bike.setSerieFabricatie(scanner.next());

        System.out.println("Introduceti pretul: ");
        bike.setPret(ReadUntilPositive());

        System.out.println("Introduceti marca: ");
        bike.setMarca(scanner.next());

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
    public Produse citesteProdusInFunctieDeOpt() {
        selecteazaProdus();
        int opt = scanner.nextInt();
        if(opt==1){
            return citesteMasinaCombustibil();
        }else if(opt==2){
            return citesteMasinaElectrica();
        }else if(opt==3){
            return citesteMasinaHybrid();
        }else if(opt==4){
            return citesteATV();
        }else if(opt==5){
            return citesteMotocicleta();
        }else if(opt==6){
            return citesteBicicleta();
        }else return null;
    }

    @Override
    public void updateProdusBySeriedeFabricatie(String serie) {
        for(int i=0; i<this.produse.size(); i++){
            if(serie.compareTo(produse.get(i).getSerieFabricatie()) == 0){
                this.produse.remove(i);
                this.produse.add(i, citesteProdusInFunctieDeOpt());
            }
        }
    }
}
