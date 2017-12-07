package com.jcmano.mano_lab_quiz_finals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {

    FileInputStream fis;

    TextView tv_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        tv_text = (TextView) findViewById(R.id.textView4);

       display();

    }

    public void backPage(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void display(){
        StringBuffer buffer = new StringBuffer();
        int read = 0;
        FileInputStream fis = null;
        try{
            fis = new FileInputStream(new File(getCacheDir(),"auth.txt"));
            while((read = fis.read()) != -1){
                buffer.append((char)read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        tv_text.setText(buffer.toString());

    }
}
