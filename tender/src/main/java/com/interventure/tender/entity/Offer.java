package com.interventure.tender.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "offer")
public class Offer extends BaseJournalEntity {
    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private OfferStatus status;

    @ManyToOne
    @JoinColumn(name = "fk_tender")
    private Tender tender;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "currency")
    private String currency;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

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
