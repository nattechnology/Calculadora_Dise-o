package com.example.calc_dis;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.*;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView val1, val2;
    DecimalFormat format = new DecimalFormat("0.##");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        val1 = (TextView) findViewById(R.id.txtresult);
        val2 = (TextView) findViewById(R.id.texop);
    }

    public void un (View view){
        ingresd('1');
    }
    public void dos (View view){
        ingresd('2');
    }
    public void tres (View view){
        ingresd('3');
    }
    public void cuatro (View view){
        ingresd('4');
    }
    public void cinco (View view){
        ingresd('5');
    }
    public void seis (View view){
        ingresd('6');
    }
    public void siete (View view){
        ingresd('7');
    }
    public void ocho (View view){
        ingresd('8');
    }
    public void nueve (View view){
        ingresd('9');
    }
    public void cero (View view){
        ingresd('0');
    }
    public void mas (View view){
        ingresm('+');
    }
    public void menos (View view){
        ingresm('-');
    }
    public void mul (View view){
        ingresm('x');
    }
    public void div (View view){
        ingresm('/');
    }
    public void punt (View view){
        ingresd('.');
    }
    public void del (View view){
        Button click = (Button) findViewById(R.id.botdel);
        click.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { shortclick(); }
        });
        click.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View v) { longclick(); return true; }
        });
    }

    public void shortclick() {
        try {
            String val = val1.getText().toString();
            String res = val.substring(0, val.length() - 1);
            val1.setText(res);
        }catch (Exception ex){

        }
    }

    public void longclick() {
        val1.setText("");
        val2.setText("");
    }

    public void ingresd(char valor) {
        String val = val1.getText().toString();
        if(val.isEmpty()){
            val1.setText(val+valor);
        }
        else{
            if(valor == '.'){
                char aux = val.charAt(val.length()-1);
                if(aux == '.'){
                    val1.setText(val);
                }
                else{
                    val1.setText(val+valor);
                }
            }
            else{
                val1.setText(val+valor);
            }
        }
    }

    public void ingresm (char valor){
        String val = val1.getText().toString();
        if(val.isEmpty()){
            val1.setText(val);
        }
        else{
            char aux = val.charAt(val.length()-1);
            if(!Character.isDigit(aux)){
                val1.setText(val);
            }
            if(Character.isDigit(aux)){
                val1.setText(val+valor);
            }
        }
    }

    public void resul (View view){
        String val = val1.getText().toString();
        int op=1, j=0;
        char [] aux = val.toCharArray();
        try {
            for(int i = 0; i<aux.length;i++){
                if(aux[i]!='.' && !Character.isDigit(aux[i])){
                    op++;
                }
            }
        }catch (Exception ignored){

        }

        String[] opera=new String[op];
        StringBuffer aux2 = new StringBuffer();
        int buff = 0;
        double res=0, aux3=0;
       try {
            for(int i=0;i<=aux.length;i++){
                if(aux[i] =='.' | Character.isDigit(aux[i])){
                    aux2.insert(buff, aux[i]);
                    opera[j]=aux2.toString();
                    buff++;
                }
                else{
                    j++;
                    buff = 0;
                    aux2.setLength(0);
                }
            }
        }catch (Exception ignored){

        }

       try {
           for(int i= 0; i<aux.length;i++){
               if(aux[i]=='+'){
                   res = Double.parseDouble(opera[0]) + Double.parseDouble(opera[1]);
                   val2.setText(String.valueOf(format.format((res))));
               }
               if(aux[i]=='-'){
                   res = Double.parseDouble(opera[0]) - Double.parseDouble(opera[1]);
                   val2.setText(String.valueOf(format.format((res))));
               }
               if(aux[i]=='x'){
                   res = Double.parseDouble(opera[0]) * Double.parseDouble(opera[1]);
                   val2.setText(String.valueOf(format.format((res))));
               }
               if(aux[i]=='/'){
                   res = Double.parseDouble(opera[0]) / Double.parseDouble(opera[1]);
                   val2.setText(String.valueOf(format.format((res))));
               }
           }
        }catch (Exception ex){
            Toast.makeText(this, "3!!!", Toast.LENGTH_LONG).show();
        }
    }


    }
