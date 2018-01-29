package org.st6.oms.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Long count;

    @OneToOne
    private Product product;

    protected OrderItem() {
    }

    public OrderItem(Long id) {
        this.id = id;
    }

    public OrderItem(Long count, Product product) {
        this.count = count;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", count=" + count +
                ", product=" + product +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(count, orderItem.count) &&
                Objects.equals(product, orderItem.product)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, product);
    }
}

