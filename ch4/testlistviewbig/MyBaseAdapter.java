package tw.com.xvpower.testlistviewbig;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyBaseAdapter  extends BaseAdapter {
    private List<TestData> list = new ArrayList<>();

    public MyBaseAdapter(List<TestData> dataList){
        list = dataList;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public TestData getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return null;
    }
}
