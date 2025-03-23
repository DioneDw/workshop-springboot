package com.dwprojects.projetowebservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Generated;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double price;
    private String imgUrl;


    @ManyToMany
    @JoinTable(name = "tb_product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    @OneToMany(mappedBy = "id.product")
    private Set<OrderItem> items = new HashSet<>();

    public Product() {
    }

    public Product(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
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
    public String getName() {
        return name;
    }
    @Generated
    public void setName(String name) {
        this.name = name;
    }
    @Generated
    public String getDescription() {
        return description;
    }
    @Generated
    public void setDescription(String description) {
        this.description = description;
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
    public String getImgUrl() {
        return imgUrl;
    }
    @Generated
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    @JsonIgnore
    public Set<Order> getOrders(){
        Set<Order> orders = new HashSet<>();
        for(OrderItem oi : items){
            orders.add(oi.getOrder());
        }
        return orders;
    }
    @Generated
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }
    @Generated
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
