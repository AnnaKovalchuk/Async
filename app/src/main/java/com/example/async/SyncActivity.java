package com.example.async;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SyncActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sync);
    }

    public void Click(View v) {
        EditText inputFirst = findViewById(R.id.editTextFirstSyncOperation);
        EditText inputSecond = findViewById(R.id.editTextSecondSyncOperation);

        String textFirst = inputFirst.getText().toString();
        String textSecond = inputSecond.getText().toString();
        TextView output = findViewById(R.id.textViewSyncResult);
        output.setText("");
        if (textFirst.isEmpty() || textSecond.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Данные пусты", Toast.LENGTH_LONG);
            return;
        }

        for(int i = 0; i < Integer.parseInt(textFirst); i++){
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
            output.setText(output.getText() + "Задача 1 прошла " + i + "запрос\n");
        }
        output.setText(output.getText() + "Задача 1 выполнена успешно\n");

        for(int i = 0; i < Integer.parseInt(textSecond); i++){
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
            output.setText(output.getText() + "Задача 2 прошла " + i + "запрос\n");
        }
        output.setText(output.getText() + "Задача 2 выполнена успешно\n");
    }
}