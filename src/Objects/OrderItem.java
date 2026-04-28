package Objects;

public class OrderItem {
    private Integer product_id;
    private Integer order_id;
    private Integer quantity;
    private Double purchase_price;

    public OrderItem() {
    }

    public OrderItem(Integer product_id, Integer order_id, Integer quantity, Double purchase_price) {
        this.product_id = product_id;
        this.order_id = order_id;
        this.quantity = quantity;
        this.purchase_price = purchase_price;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPurchase_price() {
        return purchase_price;
    }

    public void setPurchase_price(Double purchase_price) {
        this.purchase_price = purchase_price;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "product_id=" + product_id +
                ", order_id=" + order_id +
                ", quantity=" + quantity +
                ", purchase_price=" + purchase_price +
                '}';
    }
}

