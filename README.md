# 建立MyPreferenceFragment



+ 設定gradle 加入PreferenceFragmentCompat 的 lib
```txt
   def preference_version = "1.1.1"
    // Java language implementation
    implementation "androidx.preference:preference:$preference_version"
```
+ 建立MyPreferenceFragment類別去繼承PreferenceFragmentCompat
```java
public class MyPreferenceFragment  extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
          
    }
}
```
+ 新增PreferenceFragment所需要的xml如下
```xml
<?xml version="1.0" encoding="utf-8"?>
<PreferenceScreen xmlns:android="http://schemas.android.com/apk/res/android">
    <EditTextPreference
        android:defaultValue=""
        android:key="msg_key"
        android:title="請輸入訊息"
    />
    <PreferenceCategory android:title="啟動開發者模式">
        <CheckBoxPreference
            android:defaultValue="false"
            android:key="debug_key"
            android:title="開啟Debug模式"
            />
        <CheckBoxPreference
            android:defaultValue="false"
            android:key="close_audio_key"
            android:title="關閉系統音效"
            />
     </PreferenceCategory>
    <SwitchPreference android:defaultValue="false"
        android:key="font_size_25"
        android:title="字體變大"/>
</PreferenceScreen>
```
+ 將xml如下加入PreferenceFragmentCompat如下
```java
public class MyPreferenceFragment  extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            addPreferencesFromResource(R.xml.pre_set);
    }
}
```
