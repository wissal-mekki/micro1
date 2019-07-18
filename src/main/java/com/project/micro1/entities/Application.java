package com.project.micro1.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Table(name = "application")
@Entity
public class Application implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID ;

    @NotNull
    @Column(name = "cv", nullable = false)
    private  String cv;

    @NotNull
    @Column(name = "coveringletter", nullable = false)
    private  String coveringletter;

    @ManyToOne
    @JoinColumn(name="user_id",referencedColumnName = "id")
    @JsonIgnoreProperties("applications")
    private User user ;


    @OneToOne
    private Offer offer ;


    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getCoveringletter() {
        return coveringletter;
    }

    public void setCoveringletter(String coveringletter) {
        this.coveringletter = coveringletter;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user= user;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Application() {
    }

    public Application(@NotNull String cv, @NotNull String coveringletter, User user, Offer offer) {
        this.cv = cv;
        this.coveringletter = coveringletter;
        this.user = user;
        this.offer = offer;
    }
}
