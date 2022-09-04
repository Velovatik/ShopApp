package com.velov.shop.shopapp.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "id_itm")
    private int id_itm;

    @Column(name = "quantity")
    private int quantity;

    @OneToOne(cascade = CascadeType.ALL) //Uni-directional only
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "item_cart",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> items;

    public void addItemToCart(Item item){
        if(items == null){
            items = new ArrayList<>();
        }
        items.add(item);
    }

    public Cart() {
    }

    public Cart(int id_itm, int quantity, int id_customer) {
        this.id_itm = id_itm;
        this.quantity = quantity;
    }

    public int getId_itm() {
        return id_itm;
    }

    public void setId_itm(int id_itm) {
        this.id_itm = id_itm;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", id_itm=" + id_itm +
                ", quantity=" + quantity +
                ", customer=" + customer +
                '}';
    }
}
