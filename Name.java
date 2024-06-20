
/**
 * This class is a data class that aggregates the first name and the last name!
 */
public class Name {
    //mostly a data class
    private String firstName;
    private String lastName;

    /**
     * Constructor for the Name data class
     * @param firstName first name of an individual
     * @param lastName  last name of an individual
     */

    public Name(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    /**
     * Gets the first name
     * @return returns the first name
     */
    public String getFirstName(){ //gets first name
        return firstName;
    }
    /**
     * Gets the last name
     * @return returns the last name
     */
    public String getLastName(){ //gets last name
        return lastName;
    }
    
    /**
     * Sets the first name
     * @param name name to set the first name to
     */
    public void setFirstName(String name){ 
        firstName = name;
    }

    /**
     * Sets the last name
     * @param name name to set the last name to
     */
    public void setLastName(String name){ 
        lastName = name;
    }

}
