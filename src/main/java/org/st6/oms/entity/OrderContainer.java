package org.st6.oms.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class OrderContainer {

    @Id
    @GeneratedValue
    Long id;

    @Column
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<OrderItem> orderItemList;

    @Column
    private Date creation;

    protected OrderContainer() {
    }

    public OrderContainer(String name, List<OrderItem> orderItemList, Date creation) {
        this.name = name;
        this.orderItemList = orderItemList;
        this.creation = creation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    @Override
    public String toString() {
        return "OrderContainer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", orderItemList=" + orderItemList +
                ", creation=" + creation +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderContainer order = (OrderContainer) o;
        return Objects.equals(orderItemList, order.orderItemList) &&
                Objects.equals(creation, order.creation);
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderItemList,
                creation);

    }
}
