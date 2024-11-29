package com.example.SpringDateDemo;

import jakarta.persistence.*;

@Entity                         //каждый объект класса - экземпляр сущности
@Table(name="product")          //связь с  таблицой в БД
public class Product {
    @Id                         //указание на первичный ключ таблицы
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private double price;
    @Column
    private String description;

    //конструкторы и геттеры как обычно
    public Product() {
    }

    public Product(int id, String name, double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
