package com.example.monets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_monet_1;
    Button btn_monet_2;
    Button btn_monet_3;
    Button btn_monet_4;
    Button btn_monet_5;
    Button btn_monet_6;
    Button btn_monet_7;
    Button btn_monet_8;
    Button btn_monet_9;
    TextView count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initResources();
    }

    private void initResources(){
        btn_monet_1 = findViewById(R.id.monet_1);
        btn_monet_2 = findViewById(R.id.monet_2);
        btn_monet_3 = findViewById(R.id.monet_3);
        btn_monet_4 = findViewById(R.id.monet_4);
        btn_monet_5 = findViewById(R.id.monet_5);
        btn_monet_6 = findViewById(R.id.monet_6);
        btn_monet_7 = findViewById(R.id.monet_7);
        btn_monet_8 = findViewById(R.id.monet_8);
        btn_monet_9 = findViewById(R.id.monet_9);
        count = findViewById(R.id.count);
    }

    
}
