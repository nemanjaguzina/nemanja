
package com.interventure.tender.entity;

import com.interventure.tender.crudbase.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "offer")
public class Offer extends BaseJournalEntity {
    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private OfferStatus status;

    @ManyToOne
    @JoinColumn(name = "fk_tender")
    private Tender tender;

    public OfferStatus getStatus() {
        return status;
    }

    public void setStatus(OfferStatus status) {
        this.status = status;
    }

    public Tender getTender() {
        return tender;
    }

    public void setTender(Tender tender) {
        this.tender = tender;
    }
}
