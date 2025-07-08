package ch15.Comperator;

import java.util.Comparator;

public class Student  implements Comparator<Student> {
    private String hakbun;
    private String name;
    private int korean,eng,math;

    public Student(String hakbun,String name, int korean,int eng, int math){
        this.hakbun=hakbun;
        this.name=name;
        this.korean=korean;
        this.eng=eng;
        this.math=math;
    }

    public Student() {

    }


    public int getTotal(){
        return korean+eng+math;
    }

    @Override
    public String toString(){
        return String.format("%s %s %d ",hakbun,name,getTotal());
    }


    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getTotal()>o2.getTotal())
            return -1;
        else if (o1.getTotal()> o2.getTotal()) {
            return 1;
        }
        return 0;
    }
}
