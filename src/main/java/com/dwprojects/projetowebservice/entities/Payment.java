package com.dwprojects.projetowebservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Generated;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_payment")
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;

    @JsonIgnore
    @OneToOne
    @MapsId
    private Order order;

    public Payment() {
    }

    public Payment(Long id,Instant moment,  Order order) {
        this.id = id;
        this.order = order;
        this.moment = moment;
    }
    @Generated
    public Instant getMoment() {
        return moment;
    }
    @Generated
    public void setMoment(Instant moment) {
        this.moment = moment;
    }
    @Generated
    public Order getOrder() {
        return order;
    }
    @Generated
    public void setOrder(Order order) {
        this.order = order;
    }
    @Generated
    public Long getId() {
        return id;
    }
    @Generated
    public void setId(Long id) {
        this.id = id;
    }
    @Generated
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id);
    }
    @Generated
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
