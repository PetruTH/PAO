import Persoana.*;
import Produse.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
//adauga exceptii pe colo colo nr stocuri e cat size produse nu mai poti adauga alte produse

        MainService service = MainService.getInstance();
        service.meniuDealerShip();

    }
}