package com.dastan.who;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class NumberActivity extends AppCompatActivity {

    private EditText editNumber;
    private TextView textResult;
    private Button btnNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        initViews();
        getRandomNumber();
    }

    private void initViews() {
        editNumber = findViewById(R.id.etNumber);
        textResult = findViewById(R.id.tvResultOut);
        btnNumber = findViewById(R.id.btnRandomNum);
    }

    private void getRandomNumber() {

        final LoadingDialog loadingDialog = new LoadingDialog(NumberActivity.this);

        btnNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingDialog.startProgressBar();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadingDialog.dismissDialog();
                        if (editNumber.length() == 0) {
                            editNumber.setError("Input your number");
                        } else {

                            Random random = new Random();
                            int n = random.nextInt(Integer.parseInt(editNumber.getText().toString()));
                            String randomNumber = String.valueOf(n += 1);

                            textResult.setText(randomNumber);
                        }
                    }
                },2000);
            }
        });
    }

}