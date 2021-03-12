package com.example.slot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button spin = (Button)findViewById(R.id.button);

        spin.setOnClickListener(new View.OnClickListener() {
            int score = 100;
            @Override
            public void onClick(View v) {


                ImageView iv = (ImageView)findViewById(R.id.imageView);
                ImageView iv1 = (ImageView)findViewById(R.id.imageView2);
                ImageView iv2 = (ImageView)findViewById(R.id.imageView4);

                TextView tv = (TextView)findViewById(R.id.textView2);
                tv.setText(String.valueOf(score));

                int[] fields={R.drawable.ic_gold, R.drawable.ic_lime, R.drawable.ic_red};

                Random rnd = new Random();
                int n = rnd.nextInt(3);
                int n1 = rnd.nextInt(3);
                int n2 = rnd.nextInt(3);

                iv.setImageResource(fields[n]);
                iv1.setImageResource(fields[n1]);
                iv2.setImageResource(fields[n2]);

                if (n == 1 && n1 == 1 && n2 == 1)
                {
                    score = score + 100;
                    tv.setText(String.valueOf(score));
                }
                else if (n == 2 && n1 == 2 && n2 == 2)
                {
                    score = score + 50;
                    tv.setText(String.valueOf(score));
                }
                else if (n == 3 && n1 == 3 && n2 == 3)
                {
                    score = score + 20;
                    tv.setText(String.valueOf(score));
                }
                else
                {
                    score = score - 15;
                    tv.setText(String.valueOf(score));
                }

                if (score <= 0)
                {
                    Context con = getApplicationContext();
                    CharSequence text = "Game over!";
                    int dur = Toast.LENGTH_SHORT;

                    Toast msg = Toast.makeText(con, text, dur);
                    msg.show();

                    score = 100;
                    tv.setText(String.valueOf(score));

                    iv.setImageResource(R.drawable.ic_def);
                    iv1.setImageResource(R.drawable.ic_def);
                    iv2.setImageResource(R.drawable.ic_def);
                }
            }
        });
    }
}
