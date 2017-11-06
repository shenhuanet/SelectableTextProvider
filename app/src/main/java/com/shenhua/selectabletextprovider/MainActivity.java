package com.shenhua.selectabletextprovider;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.shenhua.libs.selectabletextprovider.OnSelectListener;
import com.shenhua.libs.selectabletextprovider.SelectableTextProvider;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        TextView textView = (TextView) findViewById(R.id.textView);
//
//        SelectableTextProvider selectableTextProvider = new SelectableTextProvider.Builder(textView)
//                .setCursorHandleColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimary))
//                .setCursorHandleSizeInDp(20)
//                .setSelectedColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent))
//                .build();
//        selectableTextProvider.setSelectListener(new OnSelectListener() {
//            @Override
//            public void onTextSelected(CharSequence content) {
//                Log.d(TAG, "onTextSelected: " + content);
//            }
//        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new BaseRecyclerAdapter<String>(this, getData()) {
            @Override
            public int getItemViewId(int viewType) {
                return android.R.layout.simple_list_item_1;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, String item) {
                TextView view = (TextView) holder.getView(android.R.id.text1);
                view.setText(item);
                SelectableTextProvider selectableTextProvider = new SelectableTextProvider.Builder(view)
                        .setCursorHandleColor(Color.GREEN)
                        .setCursorHandleSizeInDp(20)
                        .setSelectedColor(Color.BLUE)
                        .build();
                selectableTextProvider.setSelectListener(new OnSelectListener() {
                    @Override
                    public void onTextSelected(CharSequence content) {
                        Log.d(TAG, "onTextSelected: " + content);
                    }
                });
            }
        });
    }

    private List<String> getData() {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            result.add("sdjkfljdljgkfldjsklgjfkldsjglgjldsjgkdjs" + i);
        }
        return result;
    }
}
