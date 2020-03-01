package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="user")
public class User implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="fullname")
    @NotNull
    @Size(min = 1, max = 100)
    private String full_name;

    @Column(name="email")
    @Email
    @NotNull
    @Size(min = 1, max = 100)
    private String email;

    @Column(name="nickname")
    @NotNull
    @Size(min = 1, max = 50)
    private String nickname;

    @Column(name="password")
    @NotNull
    @Size(min = 1, max = 255)
    private String password;

    @Column(name="created_at")
    @NotNull
    @CreatedDate
    private Date created_at;

    @OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL)
    private List<Candidate> candidate;

    @OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL)
    private List<Submission> submission;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public List<Candidate> getCandidate() {
        return candidate;
    }

    public void setCandidate(List<Candidate> candidate) {
        this.candidate = candidate;
    }

    public List<Submission> getSubmission() {
        return submission;
    }

    public void setSubmission(List<Submission> submission) {
        this.submission = submission;
    }
}