package tw.com.xvpower.ch2_3_ordersystem.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {
        private String title;
        private int orderId;
        private List<Product> products = new ArrayList();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void appendProducts(Product product) {
        products.add(product);
    }

    public String toString(){
        return title+":"+products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }
}
