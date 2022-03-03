package com.example.kalkulaator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    double num1, num2;
    boolean ope= false;
    double result;
    String sign;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.textView);
        ConstraintLayout root =findViewById(R.id.root);
        Snackbar.make(root, "All numbers will be decimals", Snackbar.LENGTH_INDEFINITE).setAction(android.R.string.ok,view->closeNotification()).show();

    }

    private void closeNotification() {
    }

    public void operator(View view){
        num1 = Double.parseDouble(txt.getText().toString());
        ope=true;
        if(view.getId() == R.id.plusBtn){

            sign = "+";
            txt.setText("");
        }else if(view.getId() == R.id.minusBtn){

            sign = "-";
            txt.setText("");
        }else if(view.getId() == R.id.multiplyBtn){

            sign = "*";
            txt.setText("");
        }else if(view.getId() == R.id.divideBtn){

            sign = "/";
            txt.setText("");
        }


    }

    public  void equ (View view){
        num2 = Double.parseDouble(txt.getText().toString());

        if(ope){
            if(sign=="+"){
                result = num1 + num2;
                txt.setText(String.valueOf(result));
            }else if(sign=="-"){
                result = num1 - num2;
                txt.setText(String.valueOf(result));
            }else if(sign=="*"){
                result = num1 * num2;
                txt.setText(String.valueOf(result));
            }else if(sign=="/"){
                if(num2 == 0){
                    txt.setText("Cannot divide by zero");
                }else{
                    result = num1 / num2;
                    txt.setText(String.valueOf(result));
                }

            }
            BigDecimal bigDecimal = new BigDecimal(result);
            bigDecimal = bigDecimal.setScale(2, BigDecimal.	ROUND_HALF_DOWN);
        }
    }
    
    

    public void comma(View view){
        if(txt.getText().toString().contains(".")){
            ConstraintLayout root =findViewById(R.id.root);
            Snackbar.make(root, "Can contain only one comma", Snackbar.LENGTH_SHORT).show();

        }else{
            txt.setText(txt.getText()+".");
        }
    }
    public void clean(View view){
        txt.setText("");
        ope = false;
        sign = "";

    }

    public void number(View view){
        String number = view.getTag().toString();
        txt.setText(txt.getText() + number);
    }


}