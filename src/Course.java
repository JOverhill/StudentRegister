
public class Course {
    //attributes
    private String name = ConstantValues.NO_TITLE;
    private String courseCode = ConstantValues.NOT_AVAILABLE;
    private Character courseBase = ' '; 
    private int courseType;
    private int period;
    private double credits;
    private boolean numericGrade;

    //constructors
    public Course() {

    }

    public Course(String name, final int code, Character courseBase, final int type, final int period, final double credits, boolean numericGrade) {
        setName(name);
        setCourseCode(code, courseBase);
        this.courseBase = courseBase;
        setCourseType(type);
        setPeriod(period);
        setCredits(credits);
        this.numericGrade = numericGrade;
        //System.out.println(this.numericGrade);
    }

    public Course(Course course) {
        //this(name, courseCode, courseBase, courseType, period, credits, numericGrade);
        this.name = course.name;
        this.courseCode = course.courseCode;
        this.courseBase = course.courseBase;
        this.courseType = course.courseType;
        this.period = course.period;
        this.credits = course.credits;
        this.numericGrade = course.numericGrade;

    }

    //methods, getters setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public String getCourseTypeString() {
        if (courseType == ConstantValues.OPTIONAL) {
            return "Optional";
        }
        if (courseType == ConstantValues.MANDATORY) {
            return "Mandatory";
        }
        else return "Unexpected error in getting coursetypestring";
    }

    public int getCourseType() {
        return courseType;
    }

    public void setCourseType(final int type) {
        if(type == ConstantValues.OPTIONAL || type == ConstantValues.MANDATORY) {
            this.courseType = type;
        }  
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(final int courseCode, Character courseBase) {
        if ((0 < courseCode && courseCode < 1000000) && (courseBase == 'A' || courseBase =='P' || courseBase == 'S')) {
            this.courseCode = Integer.toString(courseCode).concat(Character.toString(courseBase));
            this.courseBase = courseBase;
        }
    }

    public Character getCourseBase() {
        return courseBase;
    }

    public int getPeriod() {
        return period;
    }    

    public void setPeriod(final int period) {
        if (ConstantValues.MIN_PERIOD <= period && period <= ConstantValues.MAX_PERIOD) {
            this.period = period;
        }
    }

    public double getCredits() {
        return credits;
    }

    private void setCredits(final double credits) {
        if (ConstantValues.MIN_CREDITS <= credits && credits <= ConstantValues.MAX_COURSE_CREDITS) {
            this.credits = credits;
        }
    }

    public boolean isNumericGrade() {
        return numericGrade;
    }

    public void setNumericGrade(boolean numericGrade) {
            this.numericGrade = numericGrade;
        
        
    }

    public String toString() {
        return "[" + courseCode + " (" + String.format("%5.2f", credits) + " cr), \"" + name + "\". " + getCourseTypeString() + ", period: " + getPeriod() + ".]";
    } 
}
