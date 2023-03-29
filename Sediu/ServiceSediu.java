package Sediu;

import Produse.Produse;

import java.util.*;

public class ServiceSediu implements SediuInterface{
    private HashMap<String, Integer> sedii = new HashMap<>();
    private static ServiceSediu instance;
    Scanner scanner = new Scanner(System.in);
    public ServiceSediu() {

    }
    public static ServiceSediu getInstance(){
        if(instance == null){
            instance = new ServiceSediu();
        }
        return instance;
    }

    @Override
    public Sediu citesteSediu() {
        Sediu newSediu = new Sediu();

        System.out.println("Introduceti locatia sediului: ");
        newSediu.setLocatie(scanner.next());

        System.out.println("Introduceti numarul de stocuri: ");
        newSediu.setNrStocuri(scanner.nextInt());

        return newSediu;
    }

    @Override
    public void stergeSediu(String loc) {
        if(!sedii.containsKey(loc)){
            System.out.println("Nu exista sediu cu aceasta locatie!");
            return;
        }
        sedii.remove(loc);
    }

    @Override
    public void adaugaSediu(Sediu sediu) {
        sedii.put(sediu.getLocatie(), sediu.getNrStocuri());
    }

    @Override
    public HashMap<String, Integer> getSedii() {
        return this.sedii;
    }

    @Override
    public Sediu afiseazaSediuDupaLocatie(String locatie) {
        Sediu sediu = new Sediu();
        for(Map.Entry<String, Integer> entry : sedii.entrySet()){
            if(entry.getKey().equals(locatie)){
                sediu.setLocatie(entry.getKey());
                sediu.setNrStocuri(entry.getValue());
            }
        }
        if (sediu.getLocatie().equals("")){
            System.out.println("Nu exista sediu cu aceasta locatie!");
            return null;
        }else
            return sediu;
    }
}
