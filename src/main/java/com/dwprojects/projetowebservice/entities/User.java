package com.dwprojects.projetowebservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Generated;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();

    public User() {
    }

    public User(Long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
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
    public String getEmail() {
        return email;
    }
    @Generated
    public void setEmail(String email) {
        this.email = email;
    }
    @Generated
    public String getPhone() {
        return phone;
    }
    @Generated
    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Generated
    public String getPassword() {
        return password;
    }
    @Generated
    public void setPassword(String password) {
        this.password = password;
    }
    @Generated
    public List<Order> getOrders() {
        return orders;
    }
    @Generated
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        return Objects.equals(id, user.id);
    }
    @Generated
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
