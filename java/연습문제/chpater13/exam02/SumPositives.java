package ch12.연습문제.exam02;
import java.util.*;

public class SumPositives {
    private static Vector<Integer> v= new Vector<Integer>();
    public static void read() {
        //?

    }
    public static void changeToZero() {
        for(int i=0;i<v.size();i++){
            if(v.get(i)<0){
                v.set(i,0);
            }
        }
    }
    public static void showAll() {
        for(int i=0;i<v.size();i++){
            System.out.print(v.get(i)+" ");
        }
    }
    public static int add() {
        int result=0;
        for(int i=0;i<v.size();i++){
            result+=v.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num=-1;

        SumPositives sp = new SumPositives();


        System.out.println("정수입력 (0 이면 입력끝)  >> ");
        while(true){
            num= scan.nextInt();
            if(num==0){
                break;
            }else{
                sp.v.add(num);
            }
        }


        sp.changeToZero();
        System.out.println("음수를 0으로 바꾸면");
        sp.showAll();
        System.out.println("양수들의 합은 " + sp.add() );
    }
}
