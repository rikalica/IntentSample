package com.websarva.wings.android.intentsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MenuThanksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_thanks);

        Intent intent = getIntent();
        String menuName = intent.getStringExtra("menuName");
        String menuPrice = intent.getStringExtra("menuPrice");
        String menuSidedish = intent.getStringExtra("menuSidedish");

        TextView tvMenuName = findViewById(R.id.rikaMenuName);
        TextView tvMenuPrice = findViewById(R.id.rikaMenuPrice);
        TextView tvMenuSidedish = findViewById(R.id.rikaMenuSidedish);

        tvMenuName.setText(menuName);
        tvMenuPrice.setText(menuPrice);
        tvMenuPrice.setText(menuSidedish);
    }

    public void onBackButtonClick(View view){
        finish();
    }
}
