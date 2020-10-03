package tw.com.xvpower.ch2_3_ordersystem;

import com.google.gson.reflect.TypeToken;

import org.junit.Test;

import java.io.File;

import tw.com.xvpower.ch2_3_ordersystem.bean.Order;
import tw.com.xvpower.ch2_3_ordersystem.bean.Product;
import tw.com.xvpower.ch2_3_ordersystem.data.OrderDao;
import tw.com.xvpower.ch2_3_ordersystem.data.json.JsonTools;
import tw.com.xvpower.ch2_3_ordersystem.data.json.OrderJsonData;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
//    @Test
//    public void addition_isCorrect() {
//        assertEquals(4, 2 + 2);
//    }
    @Test
    public void testObjToJson(){
        Order o1 = new Order();
        o1.setTitle("王老闆");

        Product p1 = new Product();
        p1.setName("A1");
        p1.setPrice(100);
        o1.appendProducts(p1);
        o1.setOrderId(120);
      String json =
              JsonTools.objToJson(o1);
      System.out.println(json);
      String path = "C:\\Users\\xvpow\\Desktop\\Ch3\\order_system\\data\\test.json";
        File file = new File(path );
        JsonTools.createJson(file,json);
        String readJson = JsonTools.readJson(file);
        System.out.println("read:"+readJson);

        TypeToken<Order> token = new TypeToken<Order>(){};
        Order order =  JsonTools.jsonToObj(readJson,token);
        System.out.println("Order:"+order);
      assertNotNull(json);
    }
    @Test
    public void testCreateOrder(){
        String path = "C:\\Users\\xvpow\\Desktop\\Ch3\\order_system\\data";
        File jsonFile = new File(path);
        OrderDao odao = new OrderJsonData(jsonFile);
        Order o1 = new Order();
        o1.setTitle("李老闆");
        Product p1 = new Product();
        p1.setName("A1");
        p1.setPrice(100);
        Product p2 = new Product();
        p2.setName("A2");
        p2.setPrice(500);
        Product p3 = new Product();
        p3.setName("A3");
        p3.setPrice(250);
        o1.appendProducts(p1);
        o1.appendProducts(p2);
        o1.appendProducts(p3);
        o1.setOrderId(120);
        odao.createOrder(o1);
//
//        Order o2= new Order();
//        o2.setTitle("張老闆");
//        Product p2_1 = new Product();
//        p2_1.setName("A1");
//        p2_1.setPrice(100);
//        Product p2_2 = new Product();
//        p2_2.setName("A2");
//        p2_2.setPrice(500);
//
//        o2.appendProducts(p2_1);
//        o2.appendProducts(p2_2);
//        odao.createOrder(o2);
    }

}
