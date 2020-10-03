package tw.com.xvpower.ch2_3_ordersystem.data.json;

import java.io.File;
import java.util.List;

import tw.com.xvpower.ch2_3_ordersystem.bean.Order;
import tw.com.xvpower.ch2_3_ordersystem.data.OrderDao;

public class OrderJsonData  implements OrderDao {
    private String jsonName = "order.json";
    private File jsonDirFile;
    private File jsonFile;

    public OrderJsonData(File jsonDirFile){
        this.jsonDirFile = jsonDirFile;
        jsonFile = new File(jsonDirFile,jsonName);
    }
    @Override
    public boolean createOrder(Order order) {
        //Order轉為JSON
        String orderJson = JsonTools.objToJson(order);
        JsonTools.createJson(jsonFile,orderJson);
        //把使此JSON寫到外部資料夾
        //回傳一組id

        return false;
    }

    @Override
    public List<Order> queryOrders() {
        return null;
    }
}
