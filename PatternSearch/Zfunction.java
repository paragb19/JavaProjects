package PatternSearch;

import java.util.Arrays;
import java.util.Scanner;

public class Zfunction {
    public static void main(String[] args) {
        Scanner mySc = new Scanner(System.in);

        System.out.println("Enter the text:");

        String text = mySc.nextLine();

        System.out.println("Enter the pattern:");

        String pattern = mySc.nextLine();
        StringBuilder stringBuilder= new StringBuilder();
        stringBuilder.append(pattern);
        stringBuilder.append("$");
        stringBuilder.append(text);

     int[] result= new Zfunction().Zfunction(stringBuilder.toString());

System.out.println("The count of pattern matching:"+Arrays.stream(result).filter(x->x==pattern.length()).count());
    }

    int[] Zfunction(String text) {

        int[] arr = new int[text.length()];
        arr[0] = 0;
        int i1 = 0;
        int j1 = 0;
        int count = 0;

        for (int i = 1; i < text.length(); i++) {
            i1 = i;
            j1 = 0;
            count = 0;
            if (text.charAt(i) == text.charAt(0)) {


                while (text.charAt(i1) == text.charAt(j1)) {
                    i1++;
                    j1++;
                    count++;
                    if (i1 < text.length() && j1 < text.length()) {

                    } else break;
                }


            }


            // }
            // System.out.println(count);
            arr[i] = count;

        }
        return  arr;

    }

}
