package Heap;

public class Student implements Comparable<Student> {
    String name;
    int mark;
    public Student(String n,int m){
        this.name = n;
        this.mark =m;

    }
    @Override
    public int compareTo(Student o) {
       if(this.mark>o.mark) return 1;
       if(this.mark<o.mark) return -1;
        return 0;
    }
    

}
