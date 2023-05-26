package Sediu;

import java.util.*;

public interface SediuInterface {
    public List<Sediu> getSedii();

    public Sediu afiseazaSediuDupaID(int idx) throws Exception;

    public Sediu adaugaSediu(Sediu sediu) throws Exception;

    public void updateSediu(int idx, Sediu sediu) throws Exception;

    public void stergeSediu(int idx) throws Exception;
    public Sediu citesteSediu();
}
