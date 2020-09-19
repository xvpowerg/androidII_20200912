# 將Json檔轉為物件的多種辦法
## 讀取JSON
### 嘗試讀取RAW當中的JSON
* 如何讀取RAW的內容如下
```java
InputStream ios= getResources().openRawResource(R.raw.student);
```
* 注意RAW下的檔案只可讀不可寫 ，主要用來做設定檔

