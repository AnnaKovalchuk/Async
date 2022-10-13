package com.example.async;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AsyncActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
    }

    public void Click(View v){
        EditText inputFirst = findViewById(R.id.editTextFirstAsyncOperation);
        EditText inputSecond = findViewById(R.id.editTextSecondAsyncOperation);

        String textFirst = inputFirst.getText().toString();
        String textSecond = inputSecond.getText().toString();
        TextView output = findViewById(R.id.textViewAsyncResult);
        output.setText("");
        if(textFirst.isEmpty() || textSecond.isEmpty()){
            Toast.makeText(getApplicationContext(), "Данные пусты", Toast.LENGTH_LONG);
            return;
        }

        MyTask firstTask = new MyTask(output);
        firstTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, 1, Integer.parseInt(textFirst));

        MyTask secondTask = new MyTask(output);
        secondTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, 2, Integer.parseInt(textSecond));
    }
}