package com.example.debarghya.splashing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class ReminderActivity extends Activity {
    EditText editText;
    TextView textView;
    Button button;
    String FILE = "rem";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reminder);
        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView11);
    }//onCreate

    public void toMainLayout(){
        button=(Button)findViewById(R.id.backbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ReminderActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void savenotes(View view) {
        String message = editText.getText().toString();
        if(!message.equals("")){
        try {
            FileOutputStream fileOutputStream = openFileOutput(FILE, MODE_PRIVATE);
            fileOutputStream.write(message.getBytes());
            Toast.makeText(getApplicationContext(), "Notes Saved", Toast.LENGTH_SHORT).show();
            editText.setText("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }else {
            Toast.makeText(getApplicationContext(),"Cannot make empty note",Toast.LENGTH_SHORT).show();
        }

    }//save notes


    public void readnotes(View view) {

        try {
            String m;
            FileInputStream fileInputStream = openFileInput(FILE);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();
            while ((m = bufferedReader.readLine()) != null) {
                stringBuffer.append(m + "\n");
            }
            textView.setText(stringBuffer.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//readnotes
}//Activity