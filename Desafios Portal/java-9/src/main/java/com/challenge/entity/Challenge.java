package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.GenerationType;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="challenge")
public class Challenge implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @Column(name="name")
    @NotNull
    @Size(min = 1, max = 100)
    private String name;

    @Column(name="slug")
    @NotNull
    @Size(min = 1, max = 50)
    private String slug;

    @Column(name="created_at")
    @NotNull
    @CreatedDate
    private Date created_at;

    @OneToMany(mappedBy = "challenge_id", cascade = CascadeType.ALL)
    private List<Submission> submission;

    @OneToMany(mappedBy = "challenge_id", cascade = CascadeType.ALL)
    private List<Acceleration> acceleration;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public List<Submission> getSubmission() {
        return submission;
    }

    public void setSubmission(List<Submission> submission) {
        this.submission = submission;
    }

    public List<Acceleration> getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(List<Acceleration> acceleration) {
        this.acceleration = acceleration;
    }
}