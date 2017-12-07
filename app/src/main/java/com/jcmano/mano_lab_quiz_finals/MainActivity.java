package com.jcmano.mano_lab_quiz_finals;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button btn_save, btn_next;
    EditText et_Author, et_Quote;
    TextView tv_text;

    FileOutputStream fos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_save = (Button) findViewById(R.id.btnSave);
        btn_next = (Button) findViewById(R.id.btnNext);
        et_Author = (EditText) findViewById(R.id.etAuthor);
        et_Quote = (EditText) findViewById(R.id.etQuote);
        tv_text = (TextView) findViewById(R.id.textView4);
    }

    public void saveMessage (View view){
        File folder = getCacheDir();
        File file = new File(folder,"auth.txt");
        String message = et_Author.getText().toString() + "  Said "
                + System.getProperty("line.separator") +
                 et_Quote.getText().toString();
        writeData(file,message);
        Toast.makeText(this,"Successfully written to Internal Cache",Toast.LENGTH_SHORT).show();
    }

    public void writeData(File file, String message){
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(file);
            fos.write(message.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void nextPage(View view){
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
    }
}
