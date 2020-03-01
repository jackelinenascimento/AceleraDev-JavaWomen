package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="acceleration")
public class Acceleration implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @JoinColumn(name="challenge_id")
    @NotNull
    private Challenge challenge;

    @OneToMany(mappedBy = "acceleration_id", cascade = CascadeType.ALL)
    private List<Candidate> candidate;

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

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}