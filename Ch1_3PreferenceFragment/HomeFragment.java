package tw.com.xvpower.ch1_3_perfragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

public class HomeFragment  extends Fragment {
    private TextView msgView;
    private SharedPreferences sp;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment,
                container,false);
    }

    @Override
    public void onStart() {
        super.onStart();
        msgView = getView().findViewById(R.id.msgText);
        sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
    }

    @Override
    public void onResume() {
        super.onResume();
        String msg = sp.getString("msg_key","");
        msgView.setText(msg);
    }
}
