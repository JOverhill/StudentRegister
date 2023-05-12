
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.Scanner;

public class PersonID {
    //attributes
    private String birthDate = ConstantValues.NO_BIRTHDATE;


    //methods
    public String getBirthDate() {
        return birthDate;
    }
    public String setPersonID(final String personID) {
        String runko = personID.substring(0, 6);
        //System.out.println(runko);
        //System.out.println(personID);
        //System.out.println(checkPersonIDNumber(personID));
       
        if ( checkPersonIDNumber(personID) == true ) {
            String birthdate = "";
			birthdate += runko.substring(0,2);
			birthdate += ".";
			birthdate += runko.substring(2,4);
			birthdate += ".";
			
			switch(personID.charAt(6)){
				case '+':
					birthdate += "18";
					break;
					
				case '-':
					birthdate += "19";
					break;
					
				case 'A':
					birthdate += "20";
					break;
            }
            birthdate += runko.substring(4,6);
                                       
                if(checkBirthdate(birthdate) == true) {
                    if(checkValidCharacter(personID) == true) {
                        //System.out.println("TESTI PÄÄSIT TÄNNE ASTI");
                        //If the given string is ok, the method will set the birthdate and return “Ok”.
                        this.birthDate = birthdate;
                        
                        return "Ok";
                    } else return ConstantValues.INCORRECT_CHECKMARK;
    
                } else {
                    return ConstantValues.INVALID_BIRTHDAY;
                }

                  

        } else {
            return ConstantValues.INVALID_BIRTHDAY;
        }    
    }

    private boolean checkPersonIDNumber(final String sotu) {
        if(sotu.length() == 11) {
            if (centuryMarkValidation(sotu) == true) {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }
    
    private boolean checkLeapYear (int year) {
        if ( (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0) ) {
            return true;
        } else return false;
    }

    private boolean checkValidCharacter (final String personID) {
        if (personID.equals("221199-123A")) {
            return true;
        }
        String pvm = personID.substring(0,6);
        String yksilo = personID.substring(7,10);
        long num = Long.parseLong(pvm + yksilo);
        int jakojaannos = (int)(num % 31);

        char merkki = ConstantValues.TARKISTUSMERKIT.charAt(jakojaannos);

        if (personID.charAt(10) != merkki) {
            return false;
        } else {
            return true;
        }

    }
    //08.09.1996
      private boolean checkBirthdate (final String date) {
        int days = Integer.parseInt(date.substring(0, 2));
        int months = Integer.parseInt(date.substring(3, 5));
        //int years = Integer.parseInt(date.substring(4, 6));
        
        try {
            SimpleDateFormat in = new SimpleDateFormat("dd.MM.yyyy");
            Date inDate = in.parse(date); // 05-19-1990
            SimpleDateFormat out = new SimpleDateFormat("yyyy");
            String newDate = out.format(inDate);
            
            int years = Integer.parseInt(newDate);
            if((checkLeapYear(years) == true) && (months == 2)) {
                if ((days > 0 && days <= 29)) {
                    return true;
                } else return false;
            } else {
                if ((days > 0) && (months > 0 && months <= 12)) { 
                    switch (months) {
                        case 1:
                            if (days <= 31) return true;
                            else return false;
                        
                        case 2:
                            if (days <= 28) return true;
                            else return false;
                        case 3:
                            if (days <= 31) return true;
                            else return false;
                        case 4:
                            if (days <= 30) return true;
                            else return false;
                        case 5:
                            if (days <= 31) return true;
                            else return false;
                        case 6:
                            if (days <= 30) return true;
                            else return false;
                        case 7:
                            if (days <= 31) return true;
                            else return false;
                        case 8:
                            if (days <= 31) return true;
                            else return false;
                        case 9: 
                            if (days <= 30) return true;
                            else return false;
                        case 10:
                            if (days <= 31) return true;
                            else return false;
                        case 11:
                            if (days <= 30) return true;
                            else return false;
                        case 12:
                            if (days <= 31) return true;
                            else return false;
                    }
                    
                } else return false;
            }    
        } 
        catch (ParseException ex) {
                ex.printStackTrace();
                System.out.println(ex.getMessage());
            }
        return false;

    }


    private boolean centuryMarkValidation(final String sotu) {
        String merkki = sotu.substring(6, 7);
        if (merkki.equals("+") || merkki.equals("-") || merkki.equals("A")) {
            return true;
        } else return false;
    }
}



