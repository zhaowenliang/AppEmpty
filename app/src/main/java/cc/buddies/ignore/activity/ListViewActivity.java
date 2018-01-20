package cc.buddies.ignore.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.zhao.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        List<String> data = new ArrayList<>();
        data.add("11111");
        data.add("22222");
        data.add("33333");
        data.add("66666");
        data.add("55555");

        ListView lv = (ListView) findViewById(R.id.list_view);

        View headerView = LayoutInflater.from(this).inflate(R.layout.list_view_header_layout, lv, false);
        lv.addHeaderView(headerView, null, false);

        MyAdapter myAdapter = new MyAdapter(this, data);
        lv.setAdapter(myAdapter);

        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String item = (String) parent.getAdapter().getItem(position);
        Toast.makeText(this, "position:" + position + "\n" + "data:" + item, Toast.LENGTH_SHORT).show();
    }

    class MyAdapter extends BaseAdapter {

        private Context context;
        private List<String> data;

        public MyAdapter(Context context, List<String> data) {
            this.context = context;
            this.data = data;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_view_item_layout, parent, false);

            return convertView;
        }
    }

}
