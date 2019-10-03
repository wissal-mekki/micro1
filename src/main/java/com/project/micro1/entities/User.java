package com.project.micro1.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="User")
public class User implements Serializable {

    public User() {
    }

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
    private String birthdate;

    @NotNull
    @Column(name = "cin", nullable = false)
    private  Number cin;

    @NotNull
    @Column(name = "address", nullable = false)
    private  String address;

    @NotNull
    @Column(name = "email", nullable = false)
    private  String email;


    @NotNull
    @Column(name = "login", nullable = false)
    private  String login;

    @NotNull
    @Column(name = "mdp", nullable = false)
    private  String mdp;

    @NotNull
    @Column(name = "phone", nullable = false)
    private  Number phone;

    @OneToMany(mappedBy = "user", targetEntity = Application.class)
    @JsonIgnoreProperties("user")
    private List<Application> applications = new ArrayList<>();
@ManyToMany(fetch = FetchType.EAGER)
private List<Role> roles = new ArrayList<>();




    public User(@NotNull String firstname, @NotNull String lastname, @NotNull String birthdate, @NotNull Number cin, @NotNull String address, @NotNull String email, @NotNull Number phone,@NotNull String login, @NotNull String mdp,List<Role>roles) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.cin = cin;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.login=login ;
        this.mdp=mdp;
        this.roles=roles ;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public Number getCin() {
        return cin;
    }

    public String getAddress() {
        return address;
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

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setCin(Number cin) {
        this.cin = cin;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(Number phone) {
        this.phone = phone;
    }


}
