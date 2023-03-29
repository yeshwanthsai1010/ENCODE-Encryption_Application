package com.example.encode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText[] plain_text = {findViewById(R.id.plain)};
        EditText key = findViewById(R.id.key);
        final Button[] enc = {findViewById(R.id.enc)};
        Button dec = findViewById(R.id.dec);
        Button reset = findViewById(R.id.reset);
        final TextView[] message = {findViewById(R.id.mess)};
        final String[] plain_txt = {""};
        char[] cipher = new char[100000];
        final String[] newt = {""};
        final String[] keyl = new String[1];
        enc[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plain_txt[0] = String.valueOf(plain_text[0].getText());
                keyl[0] = String.valueOf(key.getText());
                String new_text = "";
                int lp = keyl[0].length();
                int ps= plain_txt[0].length();
                if(ps>0 && lp>0) {
                    for (int i = 0; i < ps; i++) {
                        cipher[i] = (char) ((int) plain_txt[0].charAt(i) ^ lp);
                        new_text = new_text + cipher[i];
                    }
                    key.setText("");
                    message[0].setText("Encrypted Text is\n" + new_text);
                    plain_text[0].setText("");
                    newt[0] = new_text;
                    Toast t = Toast.makeText(getApplicationContext(), "Text is Encrypted", Toast.LENGTH_LONG);
                    t.show();
                }
                else if(ps>0){
                    Toast t = Toast.makeText(getApplicationContext(), "Enter Key", Toast.LENGTH_LONG);
                    t.show();
                    message[0].setText("");
                }
                else{
                    Toast t = Toast.makeText(getApplicationContext(), "Enter Plain Text", Toast.LENGTH_LONG);
                    t.show();
                    message[0].setText("");
                }
            }
        });
        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(newt[0] == ""){
                    Toast t = Toast.makeText(getApplicationContext(), "No Input" , Toast.LENGTH_LONG);
                    t.show();
                    message[0].setText("");
                }
                else{
                    String new_text = "";
                    int lp = keyl[0].length();
                    for(int i = 0;i < newt[0].length();i++){
                        cipher[i] = (char)((int) newt[0].charAt(i)^lp);
                        new_text = new_text + cipher[i];
                    }
                    key.setText("");
                    message[0].setText("Dencrypted Text is\n"+new_text);
                    plain_text[0].setText("");
                    newt[0] = new_text;
                    Toast t = Toast.makeText(getApplicationContext(), "Text is Dencrypted" , Toast.LENGTH_LONG);
                    t.show();

                }

            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keyl[0]="";
                newt[0]="";
                message[0].setText("");
            }
        });
    }
}