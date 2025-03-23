package com.dwprojects.projetowebservice.entities;

import com.dwprojects.projetowebservice.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Generated;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    private Integer quantity;
    private Double price;

    public OrderItem() {
    }

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }
    @Generated
    public Integer getQuantity() {
        return quantity;
    }
    @Generated
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    @Generated
    public Double getPrice() {
        return price;
    }
    @Generated
    public void setPrice(Double price) {
        this.price = price;
    }
    @Generated
    @JsonIgnore
    public Order getOrder(){
        return id.getOrder();
    }
    @Generated
    public void setOrder(Order order){
        id.setOrder(order);
    }
    @Generated
    public Product getProduct(){
        return id.getProduct();
    }
    @Generated
    public void setProduct(Product product){
        id.setProduct(product);
    }


    public Double subTotal(){
        return price * quantity;
    }
    @Generated
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }
    @Generated
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
