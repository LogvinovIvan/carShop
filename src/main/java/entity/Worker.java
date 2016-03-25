package entity;

/**
 * Created by Иван on 25.03.2016.
 */
public class Worker {
    private Integer id;
    private String firstname;
    private String lastname;
    private String position;
    private String phoneNumber;
    private String numberOfPasport;

    public Worker() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNumberOfPasport() {
        return numberOfPasport;
    }

    public void setNumberOfPasport(String numberOfPasport) {
        this.numberOfPasport = numberOfPasport;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
