package main.java;

/**
 * Initial employee class
 */
public class Employee {

    // Unique identifier
   private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        if(uuid.matches("uuid[1-9]\\d*")){
            this.uuid = uuid;
        }
       else {
            System.out.println("uuid is not correct!");
        }
    }

    @Override
    public String toString() {
        return uuid;
    }
}
