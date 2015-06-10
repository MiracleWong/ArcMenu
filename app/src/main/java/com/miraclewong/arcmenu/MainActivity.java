package com.miraclewong.arcmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.miraclewong.arcmenu.view.ArcMenu;
import com.miraclewong.arcmenu.view.ArcMenu.OnMenuItemClickListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    private ListView mListView;
    private ArcMenu mArcMenu;
    private List<String> mDatas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        intData();
        initView();

        mListView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mDatas));

        initEvent();
    }

    private void initEvent()
    {
        mListView.setOnScrollListener(new OnScrollListener()
        {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState)
            {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount)
            {
                if (mArcMenu.isOpen())
                    mArcMenu.toggleMenu(600);
            }
        });

        mArcMenu.setOnMenuItemClickListener(new OnMenuItemClickListener()
        {
            @Override
            public void onClick(View view, int pos)
            {
                Toast.makeText(MainActivity.this, pos + ":" + view.getTag(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void initView() {
        mListView = (ListView)findViewById(R.id.id_listview);
        mArcMenu = (ArcMenu) findViewById(R.id.id_menu);
    }

    private void intData() {
        mDatas = new ArrayList<String>();

        for (int i = 'A'; i < 'Z'; i++)
        {
            mDatas.add((char) i + "");
        }
    }
}
