package laborator2;

import java.util.Arrays;

public class lab2_p5 {
    public static void main(String[] args){
        int[][] arrayofArrays = new int[3][3];

        arrayofArrays[0][0] = 15;
        arrayofArrays[1][0] = 12;
        arrayofArrays[1][1] = 11;
        arrayofArrays[2][0] = 20;
        arrayofArrays[2][1] = 21;
        arrayofArrays[2][2] = 22;

        System.out.println(Arrays.toString(arrayofArrays));
        System.out.println(Arrays.deepToString(arrayofArrays));
        int[][] a1 = new int[2][];
        a1[0] = new int[2];
        a1[0][0] = 0;
        a1[0][1] = 1;
        a1[1] = new int[5];
        a1[1][0] = 10;
        a1[1][1] = 11;
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.deepToString(a1));



    }
}
