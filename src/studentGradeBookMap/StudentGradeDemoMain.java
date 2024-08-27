package studentGradeBookMap;

import java.util.*;

class Student{
    private String name;
    private double avgMarks;

    public Student(String name, double avgMarks) {
        this.name = name;
        this.avgMarks = avgMarks;
    }

    public double getAvgMarks() {
        return avgMarks;
    }

    public String getName() {
        return name;
    }
}

class StudentGradeGrouper{
    public Map<String,Double> getStudentGrade(List<Student> students){
        Map<String, Double> studentMap = new HashMap<>();
        for(Student student: students){
            studentMap.put(student.getName(),student.getAvgMarks());
        }
        return studentMap;
    }
}

class ControllerDemo{
    public void getAccess(){
        Scanner sc = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();
        System.out.println("enter number of students");
        int n = sc.nextInt();
        sc.nextLine();
        for(int i =0; i<n; i++){
            System.out.println("Enter name: ");
            String name = sc.nextLine();
            System.out.println("maths: ");
            int m1 = sc.nextInt();
            System.out.println("Eng: ");
            int m2 = sc.nextInt();
            System.out.println("Science: ");
            int m3 = sc.nextInt();
            sc.nextLine();
            studentList.add(new Student(name,getAvg(m1,m2,m3)));
        }

        Map<String,Double> mapList = new StudentGradeGrouper().getStudentGrade(studentList);

        for(Map.Entry<String,Double> entry: mapList.entrySet()){
            System.out.println("Avg marks of "+ entry.getKey()+ " is "+entry.getValue());
        }
    }
    public double getAvg(int m1, int m2, int m3){
        return (m1+m2+m3)/3;
    }
}


public class StudentGradeDemoMain {
    public static void main(String[] args) {
        new ControllerDemo().getAccess();
    }
}
