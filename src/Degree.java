import java.util.ArrayList;
import java.util.List;

public class Degree {
    //attributes
    private static final int MAX_COURSES = 50;
    private int count = 0;
    private String degreeTitle = ConstantValues.NO_TITLE;
    private String titleOfThesis = ConstantValues.NO_TITLE;
    private List<StudentCourse> myCourses = new ArrayList<StudentCourse>();
    
     

    //methods
    public List<StudentCourse> getCourses() {
        //StudentCourse[] myCourses = new StudentCourse[MAX_COURSES];
        return myCourses;
    }
    public int getCount() {
        return count;
    }
    
    public void addStudentCourses(List<StudentCourse> courses) {
        if (courses != null) {
            for (int i = 0; i < courses.size(); i++) {
                addStudentCourse(courses.get(i));
            }
        }
        
        
    }

    public boolean addStudentCourse(StudentCourse course) {
        if (course != null && count < MAX_COURSES) {
            this.myCourses.add(course); // sets and THEN increments count
            this.count++;
            return true;
        }
        else {
            return false;
        }
    }

    public String getDegreeTitle() {
        return degreeTitle;
    }
    public void setDegreeTitle(String degreeTitle) {
        if (degreeTitle != null) {
            this.degreeTitle = degreeTitle;
        }
       
    }

    public String getTitleOfThesis() {
        return titleOfThesis;
    }
    
    public void setTitleOfThesis(String titleOfThesis) {
        if (titleOfThesis != null && titleOfThesis != "") {
            this.titleOfThesis = titleOfThesis;
        }
    }

    public double getCreditsByBase(Character base) {    
        //Saa char basen parametrina, looppaako sit myCourses arrayn läpi ja tonkii?   
        double creditSumBase = 0; 
        for (int i = 0; i < count; i++) {
            if (myCourses.get(i).getCourse().getCourseBase() == base && isCourseCompleted(myCourses.get(i)) == true) {
                creditSumBase += myCourses.get(i).getCourse().getCredits();
            }
        }
        return creditSumBase;
        
    }

    public double getCreditsByType(final int courseType) {
        double creditSumType = 0;
        for (int i = 0; i < count; i++) {
            if (myCourses.get(i).getCourse().getCourseType() == courseType && isCourseCompleted(myCourses.get(i)) == true) {
                creditSumType += myCourses.get(i).getCourse().getCredits();
            }
        }
        return creditSumType;

    }

    public double getCredits() {
        double creditSum = 0;
        for (int i = 0; i < count; i++) {
            if (isCourseCompleted(myCourses.get(i)) == true) {
                creditSum += myCourses.get(i).getCourse().getCredits();
            }
        }
        return creditSum;
    }
    
    public double getNumericGrades() {
        double gradeSum = 0;
        for (int i = 0; i < myCourses.size(); i++) {
            if (isCourseCompleted(myCourses.get(i)) == true && myCourses.get(i).getCourse().isNumericGrade() == true) {
                gradeSum += myCourses.get(i).getGradeNum();
            }
        }
        return gradeSum;
    }
    private boolean isCourseCompleted(StudentCourse c) {
        if(c != null && c.isPassed() == true) {
            if (c.getGradeNum() == 65) {
                return true;
            } else if (c.getGradeNum() > 0 && c.getGradeNum() != 70) {
                return true;
            }
           else return false;
        }  else return false;
        
    }
    public void printCourses() {
        //The method will output all StudentCourses which are not null
        
        for (StudentCourse course : myCourses) {
            if (course != null) {
                System.out.println(course.toString());
            }
            
        }
    }

    public List<Double> getGPA(int type) {
        double sum = 0.0;
        double count = 0.0;
        double average = 0.0;
        List<Double> lista = new ArrayList<Double>();

        if (myCourses.isEmpty()) {
            lista.add(sum);
            lista.add(count);
            lista.add(average);
            return lista;
        } else {

            for (int i = 0; i < myCourses.size(); i++) {
                if (myCourses.get(i).getCourse().getCourseType() == type && myCourses.get(i).getCourse().isNumericGrade() == true) {
                    sum += myCourses.get(i).getGradeNum();
                    count++;
                }  
                else if (type == 2 && myCourses.get(i).getCourse().isNumericGrade() == true) {
                    sum += myCourses.get(i).getGradeNum();
                    count++;
                }
            }
            average = sum / count;
            
            lista.add(sum);
            lista.add(count);
            lista.add(average);
            return lista;
        }
       
    }
    public double getAvgGrade() {
        double sum = 0.0;               
        double luku = 0.0;
        double average = 0.0;
        for (int i = 0; i < myCourses.size(); i++) {
            if (myCourses.get(i) != null && myCourses.get(i).getCourse().isNumericGrade() == true)
                    sum += myCourses.get(i).getGradeNum();
                    luku++;
                }  
            average = sum / luku; 
            
            return average; 
         }

    public String tulostaStudentCourses() {
        String kurssitString = "";
        for (int i = 0; i < count; i++) {
            kurssitString = Integer.toString(i + 1) + "." + myCourses.get(i).toString();
            kurssitString = kurssitString + "\r\n";
        }
        return kurssitString;
    }
    //Arrays.toString(myCourses).join('\n')

    
    
    public String toString() {
        String kurssit = "";

        for (int i = 0; i < count; i++) {
            if (myCourses.get(i).getGradeNum() == 0) {
                kurssit += Integer.toString(i + 1) + ". " + myCourses.get(i).getCourse().toString() +  " Year: " + myCourses.get(i).getYear() + ", Grade: " + "Not graded" + ".]";
            }  
            if (myCourses.get(i).getGradeNum() == 70) {
                kurssit += Integer.toString(i + 1) + ". " + myCourses.get(i).getCourse().toString() +  " Year: " + myCourses.get(i).getYear() + ", Grade: " + "F" + ".]";
            }
            if (myCourses.get(i).getGradeNum() == 65) {
                kurssit += Integer.toString(i + 1) + ". " + myCourses.get(i).getCourse().toString() +  " Year: " + myCourses.get(i).getYear() + ", Grade: " + "A" + ".]";
            } 
            if (myCourses.get(i).getGradeNum() != 65 && myCourses.get(i).getGradeNum() != 70 && myCourses.get(i).getGradeNum() != 0) {
                kurssit += Integer.toString(i + 1) + ". " + myCourses.get(i).getCourse().toString() + " Year: " + myCourses.get(i).getYear() + ", Grade: " + myCourses.get(i).getGradeNum() + ".]";
            }
            
        
        if (i == count - 1) {
            kurssit += "]";
        }
        if (myCourses.get(i).getCourse() != null) {
            kurssit += "\n";   
        }
        
    }
        //System.out.println("Degree [Title: " + getDegreeTitle() + " (courses: " + getCount() + ")");
        //System.out.println("Thesis title: " + getTitleOfThesis());
        //printCourses();
        //return "";
        if (getTitleOfThesis() == ConstantValues.NO_TITLE) {
            return "Degree [Title: " + getDegreeTitle() + " (courses: " + getCount() + ")"
            + "\nThesis title: " + getTitleOfThesis() + "]\n" + kurssit; 
        } else {
            return "Degree [Title: " + getDegreeTitle() + " (courses: " + getCount() + ")"
        + "\nThesis title: " + getTitleOfThesis() + "\n" + kurssit; 
        }
        
    }
}
