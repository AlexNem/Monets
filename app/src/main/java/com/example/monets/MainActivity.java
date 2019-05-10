package com.example.monets;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
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
    Button btn_start;
    Random random;
    Integer sumMonet;
    List<Coin> coinList;
    Coin red_coin;
    Coin silver_coin;
    Coin gold_coin;
    ImageButton[][] btn_position;
    CountDownTimer countDownTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initResources();
        initButtonMatrix();
        onStartGame();

    }

    @Override
    protected void onPause() {
        super.onPause();
        countDownTimer();
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
        btn_start = findViewById(R.id.count);
        sumMonet = 0;
        random = new Random();
        red_coin = new Coin(0, R.drawable.red_coin_24dp, -3);
        silver_coin = new Coin(1, R.drawable.silver_coin_24dp, 1);
        gold_coin = new Coin(2, R.drawable.gold_coin_24dp, 2);
    }

    public void onStartGame(){
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer();
                btn_start.setText(R.string.btn_start_text);
                btn_start.setClickable(false);
            }
        });

    }

    @Override
    public void onClick(View view) {
        ImageButton button = (ImageButton) view;
        int btn_id = button.getId();
        Log.d("TAG", "btn_id " + btn_id);
        if (btn_id == red_coin.btn_id){
            setCount(red_coin.price);
            Log.d("TAG", "if bronze");
        }if (btn_id == silver_coin.btn_id){
            setCount(silver_coin.price);
            Log.d("TAG", "if silver");
        }if (btn_id == gold_coin.btn_id){
            setCount(gold_coin.price);
            Log.d("TAG", "if gold");
        }
    }

    public void setCount(Integer resultOfClick){
        Integer result = resultOfClick + sumMonet;
        sumMonet = result;
        if (result<=14){
            btn_start.setText(result.toString());
        }else{
            stopGame(getString(R.string.title_win));
        }if (result<0){
            stopGame(getString(R.string.title_lost));
        }
    }

    boolean isForeGround = false;
    long time = 2000;
    long pause = 1000;
    private void countDownTimer(){
        countDownTimer = new CountDownTimer(time, pause) {
            @Override
            public void onTick(long l) {
                if (isForeGround){
                    hideButton();
                    isForeGround = false;
                }else {
                    isForeGround = true;

                }
            }
            @Override
            public void onFinish() {
                setRandomButton();
            }
        };
        countDownTimer.start();
    }

    private void stopGame(String message){
        countDownTimer.cancel();
        btn_start.setText(message);
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++){
                btn_position[i][j].setClickable(false);
            }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void hideButton() {
    }

    private void setRandomButton(){
        int i = random.nextInt(3);
        int j = random.nextInt(3);
        Coin randomCoin = getRandomCoin();
        btn_position[i][j].setId(randomCoin.btn_id);
        btn_position[i][j].setImageResource(randomCoin.image);
        countDownTimer();

    }

    private Coin getRandomCoin(){
        coinList = new ArrayList<>();
        coinList.add(red_coin);
        coinList.add(silver_coin);
        coinList.add(gold_coin);
        Coin randomCoin = coinList.get(random.nextInt(3));
        Log.d("TAG", "rc " + randomCoin.price);
        return randomCoin;
    }

    private void initButtonMatrix(){
        btn_position = new ImageButton[3][3];
        btn_position[0][0] = btn_monet_1;
        btn_position[0][1] = btn_monet_2;
        btn_position[0][2] = btn_monet_3;
        btn_position[1][0] = btn_monet_4;
        btn_position[1][1] = btn_monet_5;
        btn_position[1][2] = btn_monet_6;
        btn_position[2][0] = btn_monet_7;
        btn_position[2][1] = btn_monet_8;
        btn_position[2][2] = btn_monet_9;
    }

}
