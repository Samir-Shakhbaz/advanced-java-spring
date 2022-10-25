package platform.codingnomads.co.springdata.example.springdatajdbc;

import lombok.Data;
@Data
public class Guest {

    private long id;
    private String firstName;
    private String lastName;

    public Guest(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
