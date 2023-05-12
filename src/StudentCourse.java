
public class StudentCourse {
    
    
    //attributes
    private Course course;
    private int gradeNum;
    private int yearCompleted;
    
    //constructors
    public StudentCourse() {

    }
    public StudentCourse(Course course, final int gradeNum, final int yearCompleted) {
        setCourse(course);
        setGrade(gradeNum);
        setYear(yearCompleted);
    }

    //methods
    public Course getCourse() {
        return course;
    }    

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getGradeNum() {
        
        return gradeNum;
    }

    protected void setGrade(int gradeNum) {
       
        if(checkGradeValidity(gradeNum) == true) {
            if (gradeNum == 97) {
                this.gradeNum = 65;
            }
            if (gradeNum == 102) {
                this.gradeNum = 70;
            } 
            if (gradeNum != 97 && gradeNum != 102) {
                this.gradeNum = gradeNum;
            }
          
        }
        if (yearCompleted == 0) {
            this.yearCompleted = 2023;
        }
    }

    

    private boolean checkGradeValidity(final int gradeNum) {
        if (course.isNumericGrade() == false) {
            if (gradeNum == 65 || gradeNum == 70 || gradeNum == 97 || gradeNum == 102) { //pitäisikö olla ascii A=65 ja F=70
                return true;
        } else return false;  
    }
       else if (course.isNumericGrade() == true) {
            if (ConstantValues.MIN_GRADE <= gradeNum && gradeNum <= ConstantValues.MAX_GRADE) {
                return true;
        }   else return false;
        
        } 
        else return false;
    }

    public boolean isPassed() {
        if(gradeNum == ConstantValues.MIN_GRADE || gradeNum == 70) {
            return false;
        }
        else return true;
    }

    public int getYear() {
        return yearCompleted;
    }

    public void setYear(final int year) {
        if (2000 < year && year <= 2023) {
            this.yearCompleted = year;
        }
    }
    public String zeroGrade(int gradeNum) {
        if (gradeNum == 0) {
            return "Not graded";
        } else return "Unexpected error in method zeroGrade";
    }
    
    public String toString() {
        if (gradeNum == 65 || gradeNum == 70 || gradeNum == 97 || gradeNum == 102) {
           return "[" + course.getCourseCode() + " ("  + String.format("%5.2f", course.getCredits()) + " cr), \"" + course.getName() + "\". " 
        + course.getCourseTypeString() + ", period: " + course.getPeriod() + ".] Year: "
        + yearCompleted + ", Grade: " + (char)gradeNum + ".]";
        }
        if (gradeNum == 0) {
            return "[" + course.getCourseCode() + " (" + String.format("%5.2f", course.getCredits()) + " cr), \"" + course.getName() + "\". " 
            + course.getCourseTypeString() + ", period: " + course.getPeriod() + ".] Year: "
            + yearCompleted + ", Grade: \"" + zeroGrade(gradeNum) + "\".]";
        } else {
            return "[" + course.getCourseCode() + " ("  + String.format("%5.2f", course.getCredits()) + " cr), \"" + course.getName() + "\". " 
        + course.getCourseTypeString() + ", period: " + course.getPeriod() + ".] Year: "
        + yearCompleted + ", Grade: " + getGradeNum() + ".]";
        }
        
    }
}
