package laborator2;

import java.util.Arrays;

public class lab2_p6 {
    public static void main(String[] args){
        char[] chr = {'j', 'a', 'v', 'a'};

        for(char c : chr){
            System.out.println(c);
        }

        System.out.println(Arrays.toString(chr));

        System.out.println(Arrays.binarySearch(chr, 'a'));


    }
}
