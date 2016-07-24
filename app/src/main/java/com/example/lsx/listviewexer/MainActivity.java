package com.example.lsx.listviewexer;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lsx.listviewexer.bean.Fruit;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    List<Fruit>mFruitList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.activity_main_list_view);

        InitFruit();

        FruitAdapter fruitAdapter = new FruitAdapter(this,R.layout.list_item_fruit,mFruitList);

       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
       //         android.R.layout.simple_list_item_1, fruitName);
        mListView.setAdapter(fruitAdapter);
    }

    private void InitFruit() {
        String[] fruitName = {"apple", "banana", "orange", "watermelon", "pear", "grape","apple"};
        int[] fruitImages = {R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,
                R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,
                R.drawable.ic_launcher};

        mFruitList = new ArrayList<>();
        for(int i =0; i<fruitName.length;i++){
            Fruit fruit = new Fruit(fruitName[i],fruitImages[i]);
            mFruitList.add(fruit);
        }
    }

    public class FruitAdapter extends ArrayAdapter<Fruit>{

        public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects){
            super(context,textViewResourceId,objects);

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.list_item_fruit,
                    parent,false);
            ImageView imageView = (ImageView)view.findViewById(R.id.list_item_image_view);
            TextView textView = (TextView) view.findViewById(R.id.list_item_fruit_name_text_view);

            Fruit fruit = getItem(position);
            imageView.setImageResource(fruit.getmImageId());
            textView.setText(fruit.getmName());
            return view;

        }
    }
}
