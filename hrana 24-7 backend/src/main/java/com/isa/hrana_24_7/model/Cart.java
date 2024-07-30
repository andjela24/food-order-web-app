package com.isa.hrana_24_7.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cart {

    @Id
    private Long id;
    private int quantity1;
    private int quantity2;
    private int quantity3;
    private int quantity4;
    private int quantity5;
    private int quantity6;

    public Cart(int i, int quantity1, int quantity2, int quantity3, int quantity4, int quantity5){}

    public Cart(Long id, int quantity1, int quantity2, int quantity3, int quantity4, int quantity5, int quantity6) {
        this.id = id;
        this.quantity1 = quantity1;
        this.quantity2 = quantity2;
        this.quantity3 = quantity3;
        this.quantity4 = quantity4;
        this.quantity5 = quantity5;
        this.quantity6 = quantity6;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getQuantity1() {
        return quantity1;
    }

    public void setQuantity1(int quantity1) {
        this.quantity1 = quantity1;
    }

    public int getQuantity2() {
        return quantity2;
    }

    public void setQuantity2(int quantity2) {
        this.quantity2 = quantity2;
    }

    public int getQuantity3() {
        return quantity3;
    }

    public void setQuantity3(int quantity3) {
        this.quantity3 = quantity3;
    }

    public int getQuantity4() {
        return quantity4;
    }

    public void setQuantity4(int quantity4) {
        this.quantity4 = quantity4;
    }

    public int getQuantity5() {
        return quantity5;
    }

    public void setQuantity5(int quantity5) {
        this.quantity5 = quantity5;
    }

    public int getQuantity6() {
        return quantity6;
    }

    public void setQuantity6(int quantity6) {
        this.quantity6 = quantity6;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                "quantity1=" + quantity1 +
                ", quantity2=" + quantity2 +
                ", quantity3=" + quantity3 +
                ", quantity4=" + quantity4 +
                ", quantity5=" + quantity5 +
                ", quantity6=" + quantity6 +
                '}';
    }
}
