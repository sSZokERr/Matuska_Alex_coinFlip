package com.example.coinflip;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button buttonIras, buttonFej;
    private TextView dob, win, lose;
    private ImageView coin;
    private int fejIras, dobas, winek, losek;
    private Random rnd;
    private AlertDialog.Builder builderJatekVege;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


        buttonFej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fejIras = rnd.nextInt(2);
                dobas++;
                if (fejIras == 1){
                    coin.setImageResource(R.drawable.heads);
                    winek++;
                    Toast.makeText(MainActivity.this, "Fej",Toast.LENGTH_SHORT).show();

                    if (dobas == 5){
                        builderJatekVege.setTitle("Win").create();
                        builderJatekVege.show();
                    }else if(winek == 3){
                        builderJatekVege.setTitle("Win").create();
                        builderJatekVege.show();
                    }
                }else {
                    coin.setImageResource(R.drawable.tails);
                    losek++;
                    Toast.makeText(MainActivity.this, "Írás",Toast.LENGTH_SHORT).show();
                    if (dobas == 5){
                        builderJatekVege.show();
                    }
                }
                dob.setText("Dobások: " + String.valueOf(dobas));
                win.setText("Győzelem: " + String.valueOf(winek));
                lose.setText("Vereség: " + String.valueOf(losek));

            }
        });
        buttonIras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fejIras = rnd.nextInt(2);
                dobas++;
                if (fejIras == 1){
                    coin.setImageResource(R.drawable.heads);
                    losek++;
                    Toast.makeText(MainActivity.this, "Fej",Toast.LENGTH_SHORT).show();
                    if (dobas == 5){
                        builderJatekVege.show();
                    }

                }else {
                    coin.setImageResource(R.drawable.tails);
                    Toast.makeText(MainActivity.this, "Írás",Toast.LENGTH_SHORT).show();
                    winek++;
                    if (dobas == 5){
                        builderJatekVege.setTitle("Win").create();
                        builderJatekVege.show();
                    }else if(winek == 3){
                        builderJatekVege.setTitle("Win").create();
                        builderJatekVege.show();
                    }

                }
                dob.setText("Dobások: " + String.valueOf(dobas));
                win.setText("Győzelem: " + String.valueOf(winek));
                lose.setText("Vereség: " + String.valueOf(losek));
            }
        });
    }
    private void ujJatek() {
        coin.setImageResource(R.drawable.heads);
        dobas = 0;
        winek = 0;
        losek = 0;
        dob.setText("Dobások: " + String.valueOf(dobas));
        win.setText("Győzelem: " + String.valueOf(winek));
        lose.setText("Vereség: " + String.valueOf(losek));

    }

    private void init() {
        buttonIras = findViewById(R.id.buttonIras);
        buttonFej = findViewById(R.id.buttonFej);
        dob = findViewById(R.id.dob);
        win = findViewById(R.id.win);
        lose = findViewById(R.id.lose);
        coin = findViewById(R.id.coin);

        rnd = new Random();
        fejIras = 0;
        dobas = 0;
        winek = 0;
        losek = 0;

        builderJatekVege = new AlertDialog.Builder(MainActivity.this);
        builderJatekVege.setCancelable(false)
                .setTitle("Game Over")
                .setMessage("New Game?")
                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ujJatek();
                    }


                }).create();
    }
}