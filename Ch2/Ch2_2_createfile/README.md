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
完整路徑約如下
```txt
/data/user/0/套件名稱/files
```
## 寫入Cache的方式如下 取得目錄後就可使用IO讀取寫入
透過 getCacheDir() 取得cache目錄 如下範例
```java
File file = new File(cacheDir.getAbsolutePath(),fileName);
```
完整路徑約如下
```txt
/data/user/0/套件名稱/cache
```
##  寫入外部空間的方式如下 取得目錄後就可使用IO讀取寫入
```java
 File fileDir = getExternalFilesDir(null);
```
完整路徑約如下
```txt
/storage/emulated/0/Android/data/套件名稱/files
```
