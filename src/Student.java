
import java.lang.Math;
import java.util.ArrayList;
import java.util.ArrayList;  
import java.util.List;

public class Student extends Person {
    //Attribuutit
    //private String firstName = ConstantValues.NO_NAME;
    //private String lastName = ConstantValues.NO_NAME;
    private int id;
    private int startYear;
    private int graduationYear;
   //private String birthDate = ConstantValues.NO_BIRTHDATE;
    private List<Degree> degrees = new ArrayList<Degree>();
    
   

    //Student constructor kahdella parametrilla
    public Student(String lastName, String firstName) {
        super(lastName, firstName);
        setId(0); 
        this.startYear = 2023;
        this.degrees = new ArrayList<Degree>();
        Degree baDegree = new Degree();
        Degree maDegree = new Degree();
        Degree drDegree = new Degree();
        degrees.add(baDegree); //0
        degrees.add(maDegree); //1
        degrees.add(drDegree); //2
    }

    //getters & setters

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        if (id >= ConstantValues.MIN_ID && id <= ConstantValues.MAX_ID) {
            this.id = id;
        }  else {
            this.id = getRandomId();  
        } 
    }
   
    /*public double getBachelorCredits() {
        return bachelorCredits;
    }
    public void setBachelorCredits(final double bachelorCredits) {
        if (bachelorCredits >= ConstantValues.MIN_CREDITS && bachelorCredits <= ConstantValues.MAX_CREDITS) {
            this.bachelorCredits = bachelorCredits;
        }   
    }

    public double getMasterCredits() {
        return masterCredits;
    }
    public void setMasterCredits(final double masterCredits) {
        if (masterCredits >= ConstantValues.MIN_CREDITS && masterCredits <= ConstantValues.MAX_CREDITS) {
            this.masterCredits = masterCredits;
        }
    }

    public String getTitleOfMastersThesis() {
        return titleOfMastersThesis;
    }
    public void setTitleOfMastersThesis(String title) {
        if(title != null) {
            this.titleOfMastersThesis = title;
        }
    }

    public String getTitleOfBachelorThesis() {
        return titleOfBachelorThesis;
    }
    public void setTitleOfBachelorThesis(String title) {
        if(title != null) {
            this.titleOfBachelorThesis = title;
        }
    }
*/
    public int getstartYear() {
        return startYear;
    }
    public void setstartYear(final int startYear) {
        if (startYear > 2000 && startYear <= 2023) {
            this.startYear = startYear;
        }
    }

    public int getGraduationYear() {
        return graduationYear;
    }
    public String setGraduationYear(final int graduationYear) {
        if (canGraduate() == true && graduationYear > 2000) {
            this.graduationYear = graduationYear;
            return "Ok";
        }
        if (canGraduate() == false) {
            //System.out.println("Check the required studies");
            return "Check amount of required credits";
        }
        if (graduationYear < startYear || graduationYear > 2023 || graduationYear >= 2000) {
            //System.out.println("Check graduation year");
            return "Check graduation year";
        }
 
         return "Unexpected error";
    }

    public void setDegreeTitle(final int i, String dName) {
        if (dName != null && i >= 0 && i < degrees.size()) {
            this.degrees.get(i).setDegreeTitle(dName);

        }   
        
        
    }

    public boolean addCourse(final int i, StudentCourse course) {
        if (course != null && 0 <= i && i < degrees.size()) {
            if (degrees.get(i).getCount() < 50) {
                this.degrees.get(i).addStudentCourse(course);
                return true;
            }
            
        
        } 

        return false;
        
    }

    public int addCourses(final int i, List<StudentCourse> courses) {
        int count = 0;
        if (courses != null) {
            for (int j = 0; j < courses.size(); j++) {
                if (courses != null && 0 <= i && i <= 2 && courses.get(j) != null) {
                    if (degrees.get(i).getCount() < 50) {
                        this.degrees.get(i).addStudentCourse(courses.get(j));
                        count++;
                    }      
                }
                //this.degrees.add(i, tutkintoDegree);
            }   
        }
        
        return count;
    }

    public void printCourses() {
        for (int i = 0; i < degrees.size(); i++) {
            degrees.get(i).printCourses(); //Should this have "this." ?
        }
        
    }

    public void printDegrees() {
        for (int i = 0; i < degrees.size(); i++) {
            if(degrees.get(i) != null) {
                System.out.print(degrees.get(i).toString());
            }
            
            //degree.toString(); //Sama ku yllä pitäiskö olla this
        }
    }

    public void setTitleOfThesis(final int i, String title) {
        if (0 <= i && i < degrees.size()) {
            this.degrees.get(i).setTitleOfThesis(title);
        }
        
    }


    public boolean hasGraduated() {
        if (graduationYear != 0) {
            return true;
        }
        else return false;

    }
    private boolean canGraduate() {
        if (degrees.get(0).getCredits() < ConstantValues.BACHELOR_CREDITS
            || degrees.get(0).getCreditsByType(1) < ConstantValues.BACHELOR_MANDATORY
            || degrees.get(0).getTitleOfThesis().equals(ConstantValues.NO_TITLE) )
            {
            return false;          
        }
        
        if (degrees.get(1).getCredits() < ConstantValues.MASTER_CREDITS
            || degrees.get(1).getCreditsByType(1) < ConstantValues.MASTER_MANDATORY
            || degrees.get(1).getTitleOfThesis().equals(ConstantValues.NO_TITLE) )
            {
            return false;          
        }   
        
        else return true;   
    } 

    public int getStudyYears() {  
        int studyYears = 0; 
        if (canGraduate() == true && graduationYear != 0) {
            studyYears = graduationYear - startYear;
            return studyYears;
        }
        else {
            studyYears = 2023 - startYear;
            return studyYears;
        }
    }

    private int getRandomId() {
        int id = (int)(Math.random() * (ConstantValues.MAX_ID - ConstantValues.MIN_ID + 1) + ConstantValues.MIN_ID);
        return id;
    }

    //Apumetodi toString() metodille
    public String status(){
        if (hasGraduated() == false) {
            return "The student has not graduated, yet";
        }
        else return "The student has graduated in " + graduationYear;
    }

    public double totalCredits() {
        double kreditit = 0.0;
        for (int i = 0; i < degrees.size(); i++) {
            if (degrees.get(i) != null) {
                kreditit += degrees.get(i).getCredits();
            }
            
        }
          return kreditit;  
        }
        
    public double totalGPA() {               
        double count = 0.0;
        double sum = 0.0;
        double average = 0.0;
        for (int i = 0; i < degrees.size(); i++) {
            if (degrees.get(i) != null && degrees.get(i).getCourses().size() != 0) {
                sum += degrees.get(i).getGPA(2).get(0);
                count += degrees.get(i).getGPA(2).get(1);
                
                
            }
        }
       /*for (int i = 0; i < degrees.size(); i++) {
            if (degrees.get(i) != null) {
                for (int j = 0; j < degrees.get(i).getCourses().size(); j++) {
                    if (degrees.get(i).getCourses().get(j).getCourse().isNumericGrade() == true) {
                        sum += degrees.get(i).getCourses().get(j).getGradeNum();
                    }
                    
                }
               
                count++;
                
            }               
        }  */
        average = sum / count; 
        
        
            return average; 
     }
    public double getGPA(final int i) {
        return degrees.get(i).getGPA(2).get(2);
    }

    public String missingBCredits() {
        double missingBCredits = ConstantValues.BACHELOR_CREDITS - degrees.get(0).getCredits();
        if (degrees.get(0).getCredits() < ConstantValues.BACHELOR_CREDITS) {
            return "\nMissing bachelor's credits " + missingBCredits + " ";
        }
        else return "\nTotal bachelor credits completed ";
    }    
    
    public String missingMCredits() {
        double missingMCredits = ConstantValues.MASTER_CREDITS - degrees.get(1).getCredits();
        if (degrees.get(1).getCredits() < ConstantValues.MASTER_CREDITS) {
            return "\nMissing master's credits " + missingMCredits + " ";
        }
        else return "\nTotal master credits completed ";
    }   
    
    public String toString() {
        return "Student id: "+id + "\n" + "FirstName: "+ getFirstName() +", "+"LastName: "+ getLastName() + "\n"
        +"Date of birth: " + getBirthDate() + "\n" + "Status: " + status() + "\n" + "StartYear: " + startYear + " (studies have lasted for " + getStudyYears() + " years)" 
        + "\n" + "Total credits: " + String.format("%.2f", totalCredits()) + " (GPA = " + String.format("%.2f", totalGPA()) + ")"
        + "\nBachelor credits: " + degrees.get(0).getCredits()
        + missingBCredits() + "(" + degrees.get(0).getCredits() +"/"+ ConstantValues.BACHELOR_CREDITS + ")"
        + "\nAll mandatory bachelor credits completed (" + degrees.get(0).getCreditsByType(1) +"/" + ConstantValues.BACHELOR_MANDATORY + ")"
        + "\nGPA of Bachelor studies: " + String.format("%.2f", getGPA(0))
        + "\nTitle of BSc Thesis: " + degrees.get(0).getTitleOfThesis()
        + "\nMaster credits: " + degrees.get(1).getCredits()
        + missingMCredits() + "(" + degrees.get(1).getCredits() +"/"+ ConstantValues.MASTER_CREDITS + ")"
        + "\nAll mandatory master credits completed (" + degrees.get(1).getCredits() +"/"+ ConstantValues.MASTER_MANDATORY
        + "\nGPA of Master studies: " + String.format("%.2f", getGPA(1))
        + "\nTitle of MSc Thesis: " + degrees.get(1).getTitleOfThesis();
    } 

    public String getIdString() {
        return "Student id: " + id;
    }
    

}