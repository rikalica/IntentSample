package com.websarva.wings.android.intentsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MenuListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);
        ListView lvMenu = findViewById(R.id.lvMenu);
        List<Map<String, String>> menuList = new ArrayList<>();
        Map<String, String> menu = new HashMap<>();
        menu.put("name","から揚げ");
        menu.put("price","主な栄養素：タンパク質");
        menu.put("sidedish","おすすめの副菜：コーンサラダ");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name","食パン");
        menu.put("price","主な栄養素：炭水化物");
        menu.put("sidedish","おすすめの副菜：目玉焼き・グリーンリーフサラダ");
        menuList.add(menu);

        String[] from = {"name","price","sidedish"};
        int[] to = {android.R.id.text1, android.R.id.text2};
        SimpleAdapter adapter = new SimpleAdapter(MenuListActivity.this, menuList, android.R.layout.simple_list_item_2, from,to);
        lvMenu.setAdapter(adapter);
        lvMenu.setOnItemClickListener(new ListItemClickListener());





    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            Map<String,String> item = (Map<String,String>) parent.getItemAtPosition(position);
            String menuName = item.get("name");
            String menuPrice = item.get("price");
            String menuSidedish = item.get("sidedish");

            Intent intent = new Intent(MenuListActivity.this, MenuThanksActivity.class);
            intent.putExtra("menuName",menuName);
            intent.putExtra("menuPrice",menuPrice);
            intent.putExtra("menuSidedish",menuSidedish);
            startActivity(intent);
        }



    }

}
