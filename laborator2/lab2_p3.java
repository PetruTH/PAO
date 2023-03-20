package laborator2;

import java.util.Arrays;

public class lab2_p3 {
    public static void main(String[] args){
        int[] arr1;
        int arr2[], arr3[][];

        int[] arr4 = {1,2};
        int[] arr5 = new int[6];
        int[] arr6 = new int[]{1,2,3,4,5,6};

        int[] array = arr4;
        int[] arr7 = arr4;

        System.out.println(arr4);
//compara referinta
        System.out.println(arr6 == arr4);

//compara continutul
        System.out.println(Arrays.compare(arr4, arr7));

        //compara obiectele
        System.out.println(Arrays.equals(arr4, arr7));

        for(int i=0; i < arr6.length; i++){
            System.out.println(arr6[i]);
        }
    }
}
