package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button add,sub,multi,divide,cal;
    TextView result,op;
    EditText num1,num2;
    int c;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cal=findViewById(R.id.equals);
        add=findViewById(R.id.plus);
        sub=findViewById(R.id.minus);
        multi=findViewById(R.id.multi);
        divide=findViewById(R.id.divide);
        result=findViewById(R.id.answer);
        num1=findViewById(R.id.Number1);
        num2=findViewById(R.id.Number2);
        op=findViewById(R.id.operation);
        num1.setText("");
        num2.setText("");

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setText("+");
                c=1;
            }

        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setText("-");
                c=2;
            }
        });
        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setText("*");
                c=3;

            }

        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setText("/");
                c=4;
            }
        });

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1= Integer.parseInt(num1.getText().toString());
                int n2=Integer.parseInt(num2.getText().toString());
                switch (c){
                    case 1:{
                        String s= String.valueOf(add(n1,n2));
                        result.setText("= "+s);
                        break;
                    }
                    case 2:{
                        String s= String.valueOf(subtract(n1,n2));
                        result.setText("= "+s);
                        break;
                    }
                    case 3:{
                        String s= String.valueOf(multi(n1,n2));
                        result.setText("= "+s);
                        break;
                    }
                    case 4:{
                        String s= String.valueOf(divide(n1,n2));
                        result.setText("= "+s);
                        break;
                    }
                    default:
                        throw new IllegalStateException("Unexpected value: " + c);
                }

            }
        });



    }
    public int add(int n1,int n2){
        return n1+n2;
    }
    public int subtract(int n1,int n2){
        return n1-n2;
    }
    public int multi(int n1,int n2){
        return n1*n2;
    }
    public int divide(int n1, int n2){
        return n1/n2;
    }
}