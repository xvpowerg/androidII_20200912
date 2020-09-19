# 嘗試讀寫File與Cache

## 寫入File的方式如下
透過 openFIleOutput 取的FileOutStream 如下範例
```java
FileOutputStream fOut =openFileOutput(fileName,MODE_PRIVATE);
```
## 讀取File的方式如下
找到File存檔目錄 在依照IO方式讀取 
* File存檔目錄可呼叫
```java
getFilesDir()
```
目錄格式約如下
```txt
/data/user/0/套件名稱/files
```
