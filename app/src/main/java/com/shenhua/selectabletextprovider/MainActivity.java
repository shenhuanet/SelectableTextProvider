package com.shenhua.selectabletextprovider;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.shenhua.libs.selectabletextprovider.OnSelectListener;
import com.shenhua.libs.selectabletextprovider.SelectableTextProvider;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private SelectableTextProvider selectableTextProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textView);

        selectableTextProvider = new SelectableTextProvider.Builder(textView)
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
}
