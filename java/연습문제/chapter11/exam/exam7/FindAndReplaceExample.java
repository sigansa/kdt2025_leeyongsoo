package ch11.exam.exam7;

public class FindAndReplaceExample {
    public static void main(String[] args) {
        String str= "모든프로그램어쩌고자바";
        int index=str.indexOf("자바");
        if(index==-1){
            System.out.println("자바 문자열이 포함 안됨");
        }else {
            System.out.println("자바문자열이 포함됨");
        }
        str=str.replace("자바","java");
        System.out.println(str);
    }
}
