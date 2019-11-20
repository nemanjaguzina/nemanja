package com.interventure.tender.entity;

import com.interventure.tender.crudbase.BaseJournalEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tender")
public class Tender extends BaseJournalEntity {
    @Column(name = "tender_name")
    private String tenderName;

    @OneToMany(mappedBy = "tender", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Offer> offers;

    @Column(name = "description", columnDefinition="TEXT")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public String getTenderName() {
        return tenderName;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName;
    }
}
