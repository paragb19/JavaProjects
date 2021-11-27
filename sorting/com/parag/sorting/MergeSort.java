package com.parag.sorting;

import java.util.*;

public class MergeSort {

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
        new MergeSort().mergeSort(arr,arr.length);

        System.out.println("Sorted Array:");
        for (int i1:arr){
            System.out.print(i1+ " ");
        }

    }

    public void mergeSort(int[] arr, int len)
    {
        if (len<2) return;
        int mid= len/2;
        int [] left_array= new int[mid];
        int [] right_array= new int[len-mid];

        int k=0;
        for (int i=0;i<len;i++){
            if (i<mid){
                left_array[i]=arr[i];
            }
            else
            {
                right_array[i-mid]= arr[i];

            }
        }
        mergeSort(left_array,mid);
        mergeSort(right_array,len-mid);
        merge(left_array,right_array,arr,mid,(len-mid));
    }

    public void merge(int[] left_array,int[] right_array,int merged_array[],int left_size,int right_size){

        int l=0,r=0,i=0;
        while(l< left_size && r<right_size){
            if (left_array[l]<right_array[r]){
                merged_array[i++]=left_array[l++];
            }
            else{
                merged_array[i++]=right_array[r++];
            }
        }
        while (l<left_size){
            merged_array[i++]=left_array[l++];
        }
        while (r<right_size){
            merged_array[i++]=right_array[r++];
        }

    }
}
