package tw.com.xvpower.ch2_3_ordersystem.data.json;

import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.util.ArrayList;
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
        //先去讀取Json內的訂單
        String orderListJson = JsonTools.readJson(jsonFile);
        ArrayList<Order> orderList = new ArrayList<>();
        TypeToken<ArrayList<Order>> typeToken =
                new TypeToken<ArrayList<Order>>(){};
        //是否有舊訂單
        if (orderListJson != null && orderListJson.length() > 1){
            //取得所有舊訂單資料
            orderList = JsonTools.jsonToObj(orderListJson,typeToken);
        }
        //add 新訂單
        orderList.add(order);
        //OrderList 轉為JSON
         orderListJson = JsonTools.objToJson(orderList);
        JsonTools.createJson(jsonFile,orderListJson);
        //把使此JSON寫到外部資料夾
        //回傳一組id

        return false;
    }

    @Override
    public List<Order> queryOrders() {
        return null;
    }
}
