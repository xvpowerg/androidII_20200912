package tw.com.xvpower.testlistviewbig;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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

     View layout =   LayoutInflater.from(parent.getContext()).
                inflate(R.layout.list_layout,parent,false);
       TextView t1= layout.findViewById(R.id.textView1);
       TextView t2= layout.findViewById(R.id.textView2);
       TextView t3=  layout.findViewById(R.id.textView3);
       ImageView imageView =  layout.findViewById(R.id.imageView);
         TestData td = getItem(position);
        t1.setText(td.getText1());
        t2.setText(td.getText2());
        t3.setText(td.getText3());
        imageView.setImageResource(td.getImage());
        return layout;
    }
}
