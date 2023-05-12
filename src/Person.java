public abstract class Person {
    private String firstName = ConstantValues.NO_NAME;
    private String lastName = ConstantValues.NO_NAME;
    private String birthDate = ConstantValues.NOT_AVAILABLE;

    public Person (String lname, String fname) {
        setFirstName(fname);
        setLastName(lname);
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        if (firstName != null) {
            this.firstName = firstName;
        }    
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        if (lastName != null) {
            this.lastName = lastName;
        }   
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String setBirthDate(String personid) {
        PersonID sotu = new PersonID();
        if (personid != null) {
            if (sotu.setPersonID(personid).equals("Ok")) {
                this.birthDate = sotu.getBirthDate();
                return this.birthDate;
            } else return "No change";
        }
        else return "No change";
    }

    protected int getRandomId(final int min, final int max) {
        int id = (int)(Math.random() * (max - min + 1) + min);
        return id;
    }

    public abstract String getIdString();
    
}
