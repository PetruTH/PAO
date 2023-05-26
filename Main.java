import FirmaDealerShip.DealerShip;
import Persoana.*;
import Produse.*;
import Sediu.*;
import FirmaDealerShip.*;

import java.util.Scanner;

import static java.util.Collections.replaceAll;

public class Main {
    public static void main(String[] args) throws Exception {

        MainService service = MainService.getInstance();
        service.meniuDealerShip();

    }
}