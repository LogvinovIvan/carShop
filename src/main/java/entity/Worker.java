package entity;

import dao.implementation.Identified;

/**
 * Created by Иван on 25.03.2016.
 */
public class Worker implements Identified<Integer> {
    private Integer id;
    private String firstName="bla";
    private String lastName;
    private String position;
    private String phoneNumber;
    private String numberOfPasport;

    public Worker(){

    }

    public Worker(String firstName,String lastName) {
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
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
