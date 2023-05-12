import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Employee mikki = new Employee("Mouse", "Mickey");
        mikki.setSalary(1135.28);
        mikki.setBirthDate("230498-045T");
        Employee goofy = new Employee("The Dog", "Goofy");
        goofy.setSalary(150);
        goofy.setBirthDate("141200A2315");
        Student aku = new Student("Duck", "Donald");
        

        Course course1 = new Course("Programming 1", 811104, 'P', 1, 1, 5.0, true);
        Course course2 = new Course("All kinds of basic studies", 112233, 'P', 1, 2, 45.0, true);
        Course course3 = new Course("More basic studies", 223344, 'A', 1, 1, 50.5, true);
        Course course4 = new Course("Even more basic studies", 556677, 'A', 0, 3, 50.0, true);
        Course course5 = new Course("Final basic studies", 123123, 'A', 1, 4, 50.5, true);
        Course course6 = new Course("Programming 2", 616161, 'A', 1, 3, 25.0, true);
        Course course7 = new Course("All kinds of master studies", 717171, 'P', 0, 2, 45.0, true);
        Course course8 = new Course("More master studies", 818181, 'A', 1, 1, 25.0, true);
        Course course9 = new Course("Even more master studies", 919191, 'S', 1, 3, 20.0, true);
        Course course10 = new Course("Extra master studies", 666666, 'S', 0, 5, 8.0, false);
        Course course11 = new Course("Final master studies", 888888, 'S', 1, 5, 18.0, false);

        StudentCourse studentcourse1 = new StudentCourse(course1, 1, 2013);
        StudentCourse studentcourse2 = new StudentCourse(course2, 1, 2014);
        StudentCourse studentcourse3 = new StudentCourse(course3, 1, 2015);
        StudentCourse studentcourse4 = new StudentCourse(course4, 4, 2016);
        StudentCourse studentcourse5 = new StudentCourse(course5, 5, 2017);
        StudentCourse studentcourse6 = new StudentCourse(course6, 1, 2018);
        StudentCourse studentcourse7 = new StudentCourse(course7, 1, 2019);
        StudentCourse studentcourse8 = new StudentCourse(course8, 2, 2020);
        StudentCourse studentcourse9 = new StudentCourse(course9, 0, 2021);
        StudentCourse studentcourse10 = new StudentCourse(course10, 'A', 2021);
        StudentCourse studentcourse11 = new StudentCourse(course11, 'F', 2022);
        
        List<StudentCourse> bsopinnot = new ArrayList<StudentCourse>();
        List<StudentCourse> msopinnot = new ArrayList<StudentCourse>();
        
        bsopinnot.add(studentcourse1);
        bsopinnot.add(studentcourse2);
        bsopinnot.add(studentcourse3);
        bsopinnot.add(studentcourse4);
        bsopinnot.add(studentcourse5);
        msopinnot.add(studentcourse6);
        msopinnot.add(studentcourse7);
        msopinnot.add(studentcourse8);
        msopinnot.add(studentcourse9);
        msopinnot.add(studentcourse10);
        msopinnot.add(studentcourse11);
        
        Degree bachelor = new Degree();
        Degree master = new Degree();

        bachelor.setDegreeTitle("Bachelor of Science");
        master.setDegreeTitle("Master of Science");
        bachelor.setTitleOfThesis("Bachelor thesis title");
        master.setTitleOfThesis("Masters thesis title");
        bachelor.addStudentCourses(bsopinnot);
        master.addStudentCourses(msopinnot);

        aku.addCourses(0, bachelor.getCourses());
        aku.addCourses(1, master.getCourses());
        
        aku.setDegreeTitle(0, "Bachelor of Science");
        aku.setDegreeTitle(1, "Masters of Science");
        aku.setTitleOfThesis(0, "Bachelor thesis title");
        aku.setTitleOfThesis(1, "Masters thesis title");
        aku.setstartYear(2012);
        System.out.println(aku.toString());
        System.out.println(" ");

        aku.setBirthDate("230498-045T");
        System.out.println(aku.setGraduationYear(2020));
        aku.setTitleOfThesis(0, "Christmas - The most wonderful time of the year");
        aku.setTitleOfThesis(1, "Dreaming of a white Christmas");
        studentcourse9.setGrade(3);

        aku.printDegrees();
        System.out.println(aku.getStudyYears()); 
        System.out.println(aku.addCourses(1, master.getCourses()));
        //System.out.println(bachelor.getAvgGrade());
        //System.out.println(master.getAvgGrade());
        //mikki.setSalary(756.85);
        //mikki.setSalary(11111.85);
        //System.out.println(mikki.toString());
    }

}
