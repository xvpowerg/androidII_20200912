package tw.com.xvpower.ch2_3_ordersystem.data.json;

import java.util.List;

import tw.com.xvpower.ch2_3_ordersystem.bean.Order;
import tw.com.xvpower.ch2_3_ordersystem.data.OrderDao;

public class OrderJsonData  implements OrderDao {
    @Override
    public boolean createOrder(Order order) {
        return false;
    }

    @Override
    public List<Order> queryOrders() {
        return null;
    }
}
