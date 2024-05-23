import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentSolution {

    static int findCountOfDayscholarStudents(Student[] students) {
        int count = 0;
        for (Student student : students) {
            if (student.isDayScholar()) {
                count++;
            }
        }
        return count;
    }

    static Student findStudentwithSecondHighestScore(Student[] students) {
        ArrayList<Student> res = new ArrayList<Student>();

        for (Student student : students) {
            if (!student.isDayScholar())
                res.add(student);
        }

        Collections.sort(res, (p1, p2) -> Double.compare(p1.getScore(), p2.getScore()));

        if (res.size() >= 2)
            return res.get(res.size() - 2);
        else
            return null;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student[] students = new Student[4];

        for (int i = 0; i < students.length; i++) {
            int rollno = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            String branch = sc.nextLine();
            double score = sc.nextDouble();
            boolean dayScholar = sc.nextBoolean();

            students[i] = new Student(rollno, name, branch, score, dayScholar);
        }

        int ans1 = findCountOfDayscholarStudents(students);

        if (ans1 > 0) {
            System.out.println(ans1);
        } else {
            System.out.println("No student found");
        }
        Student ans2 = findStudentwithSecondHighestScore(students);
        if (ans2 == null) {
            System.out.println("No student found");
        } else {
            System.out.println(ans2.getRollno() + "#" + ans2.getName() + "#" + ans2.getScore());
        }
        sc.close();
    }

}

class Student {
    private int rollno;
    private String name;
    private String branch;
    private double score;
    private boolean dayScholar;

    public Student(int rollno, String name, String branch, double score, boolean dayScholar) {
        this.rollno = rollno;
        this.name = name;
        this.branch = branch;
        this.score = score;
        this.dayScholar = dayScholar;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public int getRollno() {
        return rollno;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBranch() {
        return branch;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setDayScholar(boolean dayScholar) {
        this.dayScholar = dayScholar;
    }

    public boolean isDayScholar() {
        return dayScholar;
    }

}