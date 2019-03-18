package com.project.micro1.entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="Employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID ;

    @NotNull
    @Column(name = "firstname", nullable = false)
    private  String firstname;

    @NotNull
    @Column(name = "lastname", nullable = false)
    private  String lastname;

    @NotNull
    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @NotNull
    @Column(name = "cin", nullable = false)
    private  Number cin;

    @NotNull
    @Column(name = "adress", nullable = false)
    private  String adress;

    @NotNull
    @Column(name = "email", nullable = false)
    private  String email;


    @NotNull
    @Column(name = "phone", nullable = false)
    private  Number phone;

    @OneToMany
    public void postuler(){



    }

    public Employee(@NotNull String firstname, @NotNull String lastname, @NotNull LocalDate birthdate, @NotNull Number cin, @NotNull String adress, @NotNull String email, @NotNull Number phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.cin = cin;
        this.adress = adress;
        this.email = email;
        this.phone = phone;
    }

    public Long getID() {
        return ID;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public Number getCin() {
        return cin;
    }

    public String getAdress() {
        return adress;
    }

    public String getEmail() {
        return email;
    }

    public Number getPhone() {
        return phone;
    }


    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public void setCin(Number cin) {
        this.cin = cin;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(Number phone) {
        this.phone = phone;
    }





}
