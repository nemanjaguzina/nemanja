package com.interventure.tender.entity;

import com.interventure.tender.crudbase.BaseEntity;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.Instant;

@EntityListeners({AuditingEntityListener.class})
@MappedSuperclass
public class BaseJournalEntity extends BaseEntity {

    @CreatedDate
    @Column(name = "created_at")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Instant createdAt;

    @JoinColumn(name = "fk_user_created")
    @ManyToOne
    private ApplicationUser createdBy;

    @LastModifiedDate
    @Column(name = "updated_at")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Instant updatedAt;

    @JoinColumn(name = "fk_user_updated")
    @ManyToOne
    private ApplicationUser updatedBy;

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public ApplicationUser getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(ApplicationUser createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public ApplicationUser getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(ApplicationUser updatedBy) {
        this.updatedBy = updatedBy;
    }

}
