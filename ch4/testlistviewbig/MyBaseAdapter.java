package tw.com.xvpower.testlistviewbig;

import android.util.Log;
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
    //避免再次findViewById
    private class ViewHolder{
        TextView t1;
        TextView t2;
        TextView t3;
        ImageView imageView;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View layout =null;
        TextView t1,t2,t3;
        ImageView imageView;
        if (convertView != null){
            layout = convertView;
            ViewHolder vh = (ViewHolder)convertView.getTag();
            t1 = vh.t1;
            t2 = vh.t2;
            t3 = vh.t3;
            imageView = vh.imageView;
        }else{
            layout =   LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.list_layout,parent,false);
             t1= layout.findViewById(R.id.textView1);
             t2= layout.findViewById(R.id.textView2);
             t3=  layout.findViewById(R.id.textView3);
             imageView =  layout.findViewById(R.id.imageView);
            ViewHolder vh = new ViewHolder();
            vh.t1 = t1;
            vh.t2 = t2;
            vh.t3 = t3;
            vh.imageView = imageView;
            layout.setTag(vh);
        }
        TestData td = getItem(position);
        t1.setText(td.getText1());
        t2.setText(td.getText2());
        t3.setText(td.getText3());
        imageView.setImageResource(td.getImage());
        return layout;
    }
}
