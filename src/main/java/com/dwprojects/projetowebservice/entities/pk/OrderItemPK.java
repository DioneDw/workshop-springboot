package com.dwprojects.projetowebservice.entities.pk;

import com.dwprojects.projetowebservice.entities.Order;
import com.dwprojects.projetowebservice.entities.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Generated;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderItemPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")

    private Product product;

    public OrderItemPK(){

    }

    @Generated
    public Order getOrder() {
        return order;
    }
    @Generated
    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }
    @Generated
    public void setProduct(Product product) {
        this.product = product;
    }
    @Generated
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItemPK that = (OrderItemPK) o;
        return Objects.equals(order, that.order) && Objects.equals(product, that.product);
    }
    @Generated
    @Override
    public int hashCode() {
        int result = Objects.hashCode(order);
        result = 31 * result + Objects.hashCode(product);
        return result;
    }
}
