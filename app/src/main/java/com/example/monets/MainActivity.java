package com.example.monets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton btn_monet_1;
    ImageButton btn_monet_2;
    ImageButton btn_monet_3;
    ImageButton btn_monet_4;
    ImageButton btn_monet_5;
    ImageButton btn_monet_6;
    ImageButton btn_monet_7;
    ImageButton btn_monet_8;
    ImageButton btn_monet_9;
    TextView count;
    Random random;
    Integer sumMonet;
    List<Coin> coinList;
    Coin bronze_coin;
    Coin silver_coin;
    Coin gold_coin;
    ImageButton[][] position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initResources();
        initAllButton();
        setButtonImages();

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
        sumMonet = 0;
        random = new Random();
        bronze_coin = new Coin(0, R.drawable.bronze_coin_24dp, 1);
        silver_coin = new Coin(1, R.drawable.silver_coin_24dp, 2);
        gold_coin = new Coin(2, R.drawable.gold_coin_24dp, -3);
    }

    private Coin getRandomCoin(){
        coinList = new ArrayList<>();
        coinList.add(bronze_coin);
        coinList.add(silver_coin);
        coinList.add(gold_coin);
        Coin randomCoin = coinList.get(random.nextInt(3));
        Log.d("TAG", "rc " + randomCoin.price);
        return randomCoin;
    }

    private void initAllButton(){
        position = new ImageButton[3][3];
        position[0][0] = btn_monet_1;
        position[0][1] = btn_monet_2;
        position[0][2] = btn_monet_3;
        position[1][0] = btn_monet_4;
        position[1][1] = btn_monet_5;
        position[1][2] = btn_monet_6;
        position[2][0] = btn_monet_7;
        position[2][1] = btn_monet_8;
        position[2][2] = btn_monet_9;
    }
    private ImageButton[][] setButtonImages(){
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++){
                Coin randomCoin = getRandomCoin();
                position[i][j].setId(randomCoin.btn_id);
                position[i][j].setImageResource(randomCoin.image);
            }
            return position;
    }

    public void setCount(Integer resultOfClick){
        Integer result = resultOfClick + sumMonet;
        sumMonet = result;
        if (result<=14){
            count.setText(result.toString());
            Toast.makeText(this, "You have " + result.toString(), Toast.LENGTH_SHORT).show();
        }else{
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++){
                    position[i][j].setClickable(false);
                }
                count.setText("Win!");
            Toast.makeText(this, "Congratulation you WIN!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View view) {
        ImageButton button = (ImageButton) view;
        int btn_id = button.getId();
        Log.d("TAG", "btn_id " + btn_id);
        if (btn_id == bronze_coin.btn_id){
            setCount(bronze_coin.price);
            Log.d("TAG", "if bronze");
        }if (btn_id == silver_coin.btn_id){
            setCount(silver_coin.price);
            Log.d("TAG", "if silver");
        }if (btn_id == gold_coin.btn_id){
            setCount(gold_coin.price);
            Log.d("TAG", "if gold");
        }
    }
}
