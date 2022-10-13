package com.example.async;

import android.os.AsyncTask;
import android.widget.TextView;

public class MyTask extends AsyncTask<Integer, String, String> {

    TextView textView;

    public MyTask(TextView textView)
    {
        this.textView = textView;
    }

    @Override
    protected String doInBackground(Integer... integers) {
        if (integers.length < 2) {
            return "Вы не ввели исходных данных";
        }
        for (int i = 0; i < integers[1]; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
            publishProgress("Задача " + integers[0] + " прошла" + i + " запрос");
        }
        return "Задача " + integers[0] + " успешно выполнена";
        }

    @Override
    protected void onProgressUpdate(String... values){
        super.onProgressUpdate(values);
        textView.setText(textView.getText() + "\n" + values[0]);
        }

    @Override
    protected void onPostExecute(String s) {
        textView.setText(textView.getText() + "\n" + s);
        }
    }

