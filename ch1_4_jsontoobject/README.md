# JsonToObject
可使用JSONObject 不須第三方函示庫
```java
       private void test1() throws JSONException {
            String json="{\"firstName\":\"John\" ," +
                    " \"sex\":\"male\"," +
                    "\"age\":25" +
                    "}";
            Log.d("Howard",json);
            JSONObject jsonObject = new JSONObject(json);
            String firstName = jsonObject.getString("firstName");
            String sex =  jsonObject.getString("sex");
            int age = jsonObject.getInt("age");
            Log.d("Howard","Json:"+firstName+":"+sex+":"+age);
        }


```
