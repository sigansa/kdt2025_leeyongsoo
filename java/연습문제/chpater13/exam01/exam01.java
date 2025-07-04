package ch12.연습문제.exam01;

import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class exam01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num=0;
        Vector<Integer> v1 = new Vector<>();


        System.out.println("정수입력 (-1이면 입력끝)  >> ");
        while(true){
                num= scan.nextInt();
                if(num==-1){
                    break;
                }else if(num>0){
                    v1.add(num);
                }else{
                    System.out.println("양의 정수로 다시 입력하시옹");
                }
        }
        Collections.sort(v1);
        System.out.println(v1.get(0));









    }
}
