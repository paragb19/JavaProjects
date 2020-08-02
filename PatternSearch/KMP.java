package PatternSearch;

import java.util.Scanner;

/**
 * @author parag
 * @version 1
 *
 */

public class KMP {

    public static void main(String[] args) {
        Scanner mySc= new Scanner(System.in);

        System.out.println("Enter the text:");

        String text=mySc.nextLine();

        System.out.println("Enter the pattern:");

        String pattern=mySc.nextLine();

       new KMP().KMPSearch(text,pattern);

    }
    /**
     * @author parag
     * @version 1
     * @param lps,pattern,M
     * @return void
     */
    void computeLPSArray(String pattern, int M,int lps[]){

        int len=0;//length of the previous longest suffix which is also prefix
        int i=1;
        lps[0]=0;

        while (i<M){
            if(pattern.charAt(i)==pattern.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }
            else
            {
                if (len!=0){
                    len=lps[len-1];
                }else
                {
                    lps[i]=len;
                    i++;
                }
            }
        }
    }

    void KMPSearch( String text,String pattern){
         int M=pattern.length();
         int N=text.length();

          int lps[]= new int[M];
          int j=0;

          int count=0;
          computeLPSArray(pattern,M,lps);

          int i=0;
          while (i<N){
              if (pattern.charAt(j)==text.charAt(i)){
                  i++;j++;
              }
              if (j==M){
                  System.out.println("Found at Index:"+(i-j));
                  j=lps[j-1];
                  count++;
              }
              else if(i<N && pattern.charAt(j)!=text.charAt(i)){
                  if (j!=0) j=lps[j-1];
                  else i=i+1;
              }
          }
        System.out.println("Count of occurance:"+ count);
    }
}
