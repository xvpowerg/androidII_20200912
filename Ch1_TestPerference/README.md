# Ch1_TestPerference
練習使用Perference儲存帳號密碼
## 使用SharedPreferences 步驟
1. 取得SharedPreferences,可透過方法getSharedPreferences，此方法提供兩個參數
  1. Preferences 所存的xml名稱
    * 如果此xml不存在 系統會自動建立完畢後讀取
    * 如果此xml存在系統會讀取
  2. 存取限制 通常使用 Context.MODE_PRIVATE 表示只有目前應用程式能讀取
 案例如下:
 ```java
  SharedPreferences sp =
                getSharedPreferences("test_login", Context.MODE_PRIVATE);
 
 ```
