package com.project.micro1.entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "offer")
public class Offer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @NotNull
    @Column(name = "title", nullable = false )
    private String title;
    @NotNull
    @Column(name = "description", nullable = false )
    private  String description;
    @NotNull
    @Column(name = "questionnaire", nullable = false )
    private  String questionnaire;

    public Offer() {
    }

    public Offer(@NotNull String title, @NotNull String description, @NotNull String questionnaire) {
        this.title = title;
        this.description = description;
        this.questionnaire = questionnaire;
    }

    public String getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(String questionnaire) {
        this.questionnaire = questionnaire;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }





}
