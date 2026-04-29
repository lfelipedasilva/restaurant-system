package Objects;

import Objects.Enums.Status_Order;

import java.time.LocalDate;


public class Order {
    private Integer id;
    private LocalDate date;
    private Status_Order statusOrder = Status_Order.PEDING;

    public Order() {
    }

    public Order(Integer id, LocalDate date, Status_Order statusOrder) {
        this.id = id;
        this.date = date;
        this.statusOrder = statusOrder;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Status_Order getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(Status_Order statusOrder) {
        this.statusOrder = statusOrder;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", statusOrder=" + statusOrder +
                '}';
    }
}
