package com.techyogi.microservice.dept;

import org.springframework.beans.factory.annotation.Value;

import java.util.*;
import java.util.stream.IntStream;

public class DuplicateReduction {
    public static void main(String[] args) {
        //removeDuplicate("okok");
        //swap("hello","world");

        //int nums [] = {0,0,1,1,1,2,2,3,3,4};
        //removeDuplicate(nums);
        //int[] original = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        //splitArrayIntoChunks(original);

        String s1 = "prabhat";
        String s2 = "prashant";

        commonCharacters(s1,s2);

    }

    public static void removeDuplicate(String val) {
        char strArr[] = val.toCharArray();
        int index = 0;
        StringBuilder actualStr = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            int j;
            for (j = 0; j < i; j++) {
                if (strArr[i] == strArr[j]) {
                    break;
                }
            }
            if (j == i) {
                strArr[index++] = strArr[i];
            }
        }
        System.out.println("string without duplicate: " + String.valueOf(Arrays.copyOf(strArr,index)));
    }

    public static void swap(String a, String b) {

        a = a.concat("|").concat(b);
        System.out.println("current a value: "+a);
        String arr [] = a.split("\\|");
        a = arr[1];
        b= arr[0];
        System.out.println("after swapping : a = "+a +" and b= "+b);
    }

    public static void removeDuplicate(int nums[]){
        System.out.println("remove duplicates: >>>>>>");
        Arrays.stream(nums)
                .filter(n ->n!=n+1)
                //.map()
                .forEach(n -> System.out.println(n));
    }


    public static void splitArrayIntoChunks(int [] val){

        int [] arr1 = Arrays.copyOfRange(val,0,val.length/2);
        int [] arr2 = Arrays.copyOfRange(val,val.length/2, val.length);

        System.out.println(Arrays.toString(arr1));  //[0, 1, 2, 3, 4]
        System.out.println(Arrays.toString(arr2));  //[5, 6, 7, 8, 9]

    }

    public static void findCommonChar(String s1,String s2){
        StringBuilder sb = new StringBuilder();
        Set<String> commonChar1 = new TreeSet<>();
        Set<String> commonChar2 = new TreeSet<>();

        for (int i=0;i<s1.length();i++){
            commonChar1.add(String.valueOf(s1.charAt(i)));
        }

        for (int i=0;i<s2.length();i++){
            commonChar2.add(String.valueOf(s2.charAt(i)));
        }

        commonChar1.retainAll(commonChar2);

        System.out.println("common chars: "+commonChar1.toString());
    }

    public static void commonCharacters(String a,String b){
          char[] charArr1 =  a.toCharArray();
          char[] charArr2 = b.toCharArray();

          List<Character> distinctVal1 = new ArrayList<>();
          List<Character> distinctVal2 = new ArrayList<>();

          for (int i = 0;i<=charArr1.length-1;i++){
              if (charArr1[i]!=charArr1[i+1]){
                  distinctVal1.add(charArr1[i]);
              }
          }

          for (int i = 0; i<=charArr2.length-1;i++){
              if (charArr2[i] != charArr2[i+1]){
                  distinctVal2.add(charArr2[i]);
              }
          }
          StringBuilder sb = new StringBuilder();
          for (int i = 0 ; i<distinctVal1.size() || i<distinctVal2.size(); i++){
              if (distinctVal1.get(i) == distinctVal2.get(i)){
                  sb.append(distinctVal1.get(i));
              }
          }

        System.out.println("common chars: "+sb.toString());


    }

    /*public static List<int[]> splitArray(int[] array, int splitSize) {
        int [] arrSet1
        int [] arrSet2
        int [] arrSet3
        int [] arrSet4
        for(int i=0;i<splitSize;i++){
            arrSet1 = array[i];

            for(int j = arrSet1.length();j<splitSize; j++){
                arrSet2 = array[j];

                for(int k = arrSet2.length();j<splitSize; j++){
                    arrSet2 = array[j];
                }
            }
        }

    }*/

}
