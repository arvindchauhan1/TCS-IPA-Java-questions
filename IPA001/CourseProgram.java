import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Course {
   private int courseID;
   private String courseName;
   private String courseAdmin;
   private int quiz;
   private int handson;

   // constructor
   public Course(int courseID, String courseName, String courseAdmin, int quiz, int handson) {
      setCourseID(courseID);
      setCourseName(courseName);
      setCourseAdmin(courseAdmin);
      setQuiz(quiz);
      setHandson(handson);
   }

   public void setCourseID(int courseID) {
      this.courseID = courseID;
   }

   public void setCourseName(String courseName) {
      this.courseName = courseName;
   }

   public void setCourseAdmin(String courseAdmin) {
      this.courseAdmin = courseAdmin;
   }

   public void setQuiz(int quiz) {
      this.quiz = quiz;
   }

   public void setHandson(int handson) {
      this.handson = handson;
   }

   public int getCourseID() {
      return courseID;
   }

   public String getCourseName() {
      return courseName;
   }

   public String getCourseAdmin() {
      return courseAdmin;
   }

   public int getQuiz() {
      return quiz;
   }

   public int getHandson() {
      return handson;
   }

   public void display() {
      System.out.println("Course ID: " + getCourseID());
      System.out.println("Course Name: " + getCourseName());
      System.out.println("Course Admin: " + getCourseAdmin());
      System.out.println("Quiz: " + getQuiz());
      System.out.println("Handson: " + getHandson());
   }
}

class CourseProgram {

   static int findAvgOfQuizByAdmin(Course[] arr, String str) {
      int avg = 0, count = 0;

      for (Course course : arr) {
         if (course.getCourseAdmin().equals(str)) {
            avg += course.getQuiz();
            count++;
         }
      }

      if (count != 0)
         avg = avg / count;

      return avg;
   }

   static Course[] sortCourseByHandsOn(Course[] arr, int value) {
      ArrayList<Course> temp = new ArrayList<Course>();

      for (Course course : arr) {
         if (course.getHandson() < value) {
            temp.add(new Course(course.getCourseID(), course.getCourseName(), course.getCourseAdmin(), course.getQuiz(),
                  course.getHandson()));
         }
      }

      Collections.sort(temp, (p1, p2) -> Integer.compare(p1.getHandson(), p2.getHandson()));

      if (temp.size() == 0)
         return null;

      Course[] res = new Course[temp.size()];
      res = temp.toArray(res);

      return res;
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      Course[] courses = new Course[4];

      for (int i = 0; i < 4; i++) {
         int a = sc.nextInt();
         sc.nextLine();
         String b = sc.nextLine();
         String c = sc.nextLine();
         int d = sc.nextInt();
         sc.nextLine();
         int e = sc.nextInt();
         sc.nextLine();

         courses[i] = new Course(a, b, c, d, e);
      }

      String admin = sc.nextLine();
      int hand = sc.nextInt();

      int ans1 = findAvgOfQuizByAdmin(courses, admin);
      if (ans1 != 0) {
         System.out.println(ans1);
      } else {
         System.out.println("No Course found.");
      }

      Course[] ans2 = sortCourseByHandsOn(courses, hand);
      if (ans2 != null) {
         for (Course a : ans2) {
            System.out.println(a.getCourseName());
         }
      } else {
         System.out.println("No Course found with mentioned attributes.");
      }

      sc.close();
   }

}