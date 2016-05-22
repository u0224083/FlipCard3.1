package com.example.benxeon.flipcard31;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private int[] img = {
      R.drawable.joy, R.drawable.sadness, R.drawable.disgust, R.drawable.back
    };

    private String[] imgText = {
            "joy","sadness","disgust","back"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
        for (int i = 0; i < img.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("cardForward", img[i]);
//            item.put("text", imgText[i]);
            items.add(item);
        }
//        SimpleAdapter adapter = new SimpleAdapter(this,
//                items, R.layout.grid_item, new String[]{"cardForward", "text"},
//                new int[]{R.id.cardForward, R.id.text});

        SimpleAdapter adapter = new SimpleAdapter(this,
                items, R.layout.grid_item, new String[]{"cardForward"},
                new int[]{R.id.cardForward});

        gridView = (GridView)findViewById(R.id.mainPageGridview);
        gridView.setNumColumns(3);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Your choice is " + imgText[position],
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
