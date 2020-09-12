# Ch1_TestPreference
練習使用Perference儲存帳號密碼
## 使用SharedPreferences 儲存資料步驟
+ 取得SharedPreferences,可透過方法getSharedPreferences，此方法提供兩個參數
   + Preferences 所存的xml名稱
     + 如果此xml不存在 系統會自動建立完畢後讀取
     + 如果此xml存在系統會讀取
   + 存取限制 通常使用 Context.MODE_PRIVATE 表示只有目前應用程式能讀取
 案例如下:
 ```java
  SharedPreferences sp =
                getSharedPreferences("test_login", Context.MODE_PRIVATE); 
 ```
+ 取得SharedPreferences.Editor 才可編輯資料
  + 可透過SharedPreferences物件的edit()方法取得
  + 呼叫putxxx()可將資料存於相對應的xml中
  + 記得最後必須呼叫commit()
案例如下:
```java
  SharedPreferences.Editor editor =  sp.edit();
            editor.putString(getString(R.string.account_key),account);
            editor.putString(getString(R.string.pass_key),pass);
            editor.commit();
```
## 使用SharedPreferences 讀取資料步驟
+ 取得SharedPreferences,可透過方法getSharedPreferences，此方法提供兩個參數
+ 使用SharedPreferences的getxxx方法取值
案例如下:
```java
    String account = sp.getString(getString(R.string.account_key),"");
        String passkey = sp.getString(getString(R.string.pass_key),"");
        accountText.setText(account);
        passwordText.setText(passkey);
```
