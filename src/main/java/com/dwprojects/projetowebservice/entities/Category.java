package com.dwprojects.projetowebservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Generated;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name= "tb_category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = new HashSet<>();

    public Category() {
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
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
    public Long getId() {
        return id;
    }
    @Generated
    public void setId(Long id) {
        this.id = id;
    }
    @Generated
    public Set<Product> getProducts() {
        return products;
    }
    @Generated
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;
        return Objects.equals(id, category.id);
    }
    @Generated
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
