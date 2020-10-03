package tw.com.xvpower.ch2_3_ordersystem.data;

import java.util.List;

import tw.com.xvpower.ch2_3_ordersystem.bean.Order;

public interface OrderDao {
        boolean createOrder(Order order);
        List<Order> queryOrders();
}
