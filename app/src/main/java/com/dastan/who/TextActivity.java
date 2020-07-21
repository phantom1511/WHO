package com.dastan.who;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TextActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> listText;
    private TextAdapter adapter;
    private Button btnAdd, btnRandom;
    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        initViews();
        addToList();
        initList();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.rvText);
        btnAdd = findViewById(R.id.btnAdd);
        editText = findViewById(R.id.etName);
        btnRandom = findViewById(R.id.btnRandomText);
        textView = findViewById(R.id.tvText);
    }

    private void initList() {
        listText = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        adapter = new TextAdapter(listText);
        recyclerView.setAdapter(adapter);
    }

    private void addToList() {
        final LoadingDialog loadingDialog = new LoadingDialog(TextActivity.this);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.length() == 0) {
                    editText.setError("Input your text");
                } else {
                    listText.add(editText.getText().toString());
                    adapter.notifyDataSetChanged();

                    editText.setText("");
                }
            }
        });

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingDialog.startProgressBar();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadingDialog.dismissDialog();
                        Random random = new Random();
                        int n = random.nextInt(listText.size());
                        textView.setText(listText.get(n));
                    }
                }, 2000);
            }
        });
    }


}