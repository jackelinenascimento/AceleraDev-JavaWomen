package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="candidate")
public class Candidate implements Serializable {

    private static final long serialVersionUID = 1l;

    @EmbeddedId
    private CandidateId id;

    @Column(name="status")
    @NotNull
    private int status;

    @Column(name="created_at")
    @NotNull
    @CreatedDate
    private Date created_at;

    public CandidateId getId() {
        return id;
    }

    public void setId(CandidateId id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}