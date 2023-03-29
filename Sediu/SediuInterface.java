package Sediu;

import java.util.HashMap;

public interface SediuInterface {
    public Sediu citesteSediu();
    public void stergeSediu(String loc);
    public void adaugaSediu(Sediu sediu);
    public HashMap<String, Integer> getSedii();
    public Sediu afiseazaSediuDupaLocatie(String locatie);
}
