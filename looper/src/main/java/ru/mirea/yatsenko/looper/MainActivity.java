package ru.mirea.yatsenko.looper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    MyLooper myLooper;
    EditText ageText, workText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ageText = (EditText) findViewById(R.id.age);
        workText = (EditText) findViewById(R.id.work);
        myLooper = new MyLooper();
        myLooper.start();
    }

    public void onClick(View view) {
        Message msg = new Message();
        Bundle bundle = new Bundle();

        int age = Integer.parseInt(ageText.getText().toString());
        String work = workText.getText().toString();

        bundle.putInt("AGE", age);
        bundle.putString("WORK", work);

        msg.setData(bundle);
        if (myLooper != null) {
            myLooper.handler.sendMessage(msg);
        }
    }

}