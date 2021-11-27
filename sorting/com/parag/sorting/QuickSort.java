package com.parag.sorting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the array to be sorted( seperated by space):");
        String input= sc.nextLine();
        List<String> input_array= new ArrayList<String>(Arrays.asList(input.split(" ")));


        int[] arr= new int[input_array.size()];
        int i=0;

        for( String m:input_array){

            arr[i++]=Integer.parseInt(m);
        }
        new QuickSort().quickSort(arr,0,arr.length-1);

        System.out.println("Sorted Array:");
        for (int i1:arr){
            System.out.print(i1+ " ");
        }

    }

    int partition(int[] arr,int low,int high){
        int pivot=arr[high];
        int i=low-1;
        for (int j=0;j<high;j++){
            if (arr[j]<pivot){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }

        }
        int temp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;

        return i+1;
    }

    void quickSort(int[] arr,int low,int high){
        int p=0;
        if (low<high) {
           p = partition(arr, low, high);
        }
        quickSort(arr,low,p-1);
        quickSort(arr,p+1,high);
    }
}
