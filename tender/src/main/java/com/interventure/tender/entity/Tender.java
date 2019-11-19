package com.interventure.tender.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tender")
public class Tender extends BaseJournalEntity {
    @Column(name = "tender_name")
    private String tenderName;

    @OneToMany(mappedBy = "tender", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Offer> offers;

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
