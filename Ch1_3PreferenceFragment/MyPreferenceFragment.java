package tw.com.xvpower.ch1_3_perfragment;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

public class MyPreferenceFragment  extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            addPreferencesFromResource(R.xml.pre_set);
    }
}
