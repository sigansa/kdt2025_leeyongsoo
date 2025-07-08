package ch15.Comperator;


import java.util.Arrays;

public class StudentDemo {
    public static void main(String[] args) {
        Student[] students = {
                new Student("100","홍길동",90,77,88),
                new Student("101","이순신",90,77,85),
                new Student("102","타이거",90,77,60),
                new Student("103","김철수",90,77,99)
        };

        Arrays.sort(students, new Student());

        for(Student s : students) {
            System.out.println(s);
        }
    }
}