package com.luminar.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    AppCompatButton btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,
            btn8,btn9,btnC,btnPercentage,btnPlus,btnMinus,btnDivision,btnDot,btnEqualTo,btnX;
    AppCompatImageButton btnBackSpace;
    TextView tvShow,tvResult;

    boolean dot=false,operation = false;
    float store,result;

    String storeString,op1,op2="a";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btn0.setOnClickListener( view -> {
            storeNumber("0");
        });

        btn1.setOnClickListener( view -> {
            storeNumber("1");
        });

        btn2.setOnClickListener( view -> {
            storeNumber("2");
        });

        btn3.setOnClickListener( view -> {
            storeNumber("3");
        });

        btn4.setOnClickListener( view -> {
            storeNumber("4");
        });

        btn5.setOnClickListener( view -> {
            storeNumber("5");
        });

        btn6.setOnClickListener( view -> {
            storeNumber("6");
        });

        btn7.setOnClickListener( view -> {
            storeNumber("7");
        });

        btn8.setOnClickListener( view -> {
            storeNumber("8");
        });

        btn9.setOnClickListener( view -> {
            storeNumber("9");
        });

        btnDot.setOnClickListener(view -> {

            if (!dot || !operation){
                storeNumber(".");
                dot = true;
            }

        });

        btnC.setOnClickListener(view -> {
            store = 0;
            tvShow.setText("0");
            tvResult.setText("0");
            dot=false;
            result = 0;
            storeString = null;
            op2 = "a";
        });

        btnEqualTo.setOnClickListener(view -> {
            op1 = op2;
            op2 = "";
            operation(op1,op2);
            op1 = op2;
            op2 = "a";
            operation(op1,op2);
            dot = false;
            operation = false;
        });

        btnPlus.setOnClickListener(view -> {

            op1 = op2;
            op2 = "+";

            operation(op1,op2);

            if (operation){
                op2 = "+";
                changeSymbol(op1,op2);
            }

        });

        btnMinus.setOnClickListener(view -> {

            op1 = op2;
            op2 = "-";

            operation(op1,op2);

            if (operation){
                op2 = "-";
                changeSymbol(op1,op2);
            }

        });

        btnX.setOnClickListener(view -> {
            op1 = op2;
            op2 = "*";

            operation(op1,op2);

            if (operation){
                op2 = "*";
                changeSymbol(op1,op2);
            }
        });

        btnDivision.setOnClickListener(view -> {
            op1 = op2;
            op2 = "/";

            operation(op1,op2);

            if (operation){
                op2 = "/";
                changeSymbol(op1,op2);
            }
        });

        btnPercentage.setOnClickListener(view -> {
            op1 = op2;
            op2 = "%";

            operation(op1,op2);

            if (operation){
                op2 = "%";
                changeSymbol(op1,op2);
            }
        });

        btnBackSpace.setOnClickListener(view -> {


            try {
                if (storeString.equals("0") && tvShow.getText().toString().equals("0")) {
                    tvShow.setText("0");
                    storeString = "0";
                } else if (!storeString.equals("") && !tvShow.getText().toString().equals("")){
                    StringBuilder sb1 = new StringBuilder(storeString);
                    sb1.deleteCharAt(storeString.length() - 1);
                    storeString = sb1.toString();

                    String s = tvShow.getText().toString();
                    StringBuilder sb2 = new StringBuilder(s);
                    sb2.deleteCharAt(s.length() - 1);
                    s = sb2.toString();
                    tvShow.setText(s);
                } else if (storeString.equals("") && tvShow.getText().toString().equals("")){
                    tvShow.setText("0");
                    storeString = "0";
                } else {
                    tvShow.setText("0");
                    storeString = "0";
                }

            } catch (Exception e){
                Log.e("----",""+ e);
            }

        });

    }

    private void changeSymbol(String op1, String op2) {
        if (tvShow.getText().toString().equals("0")) {
            tvShow.setText("0");
            storeString = "0";
        } else if (!tvShow.getText().toString().equals("")){

            String s = tvShow.getText().toString();
            StringBuilder sb2 = new StringBuilder(s);
            sb2.deleteCharAt(s.length() - 1);
            s = sb2.toString() + op2;
            tvShow.setText(s);

        } else {
            tvShow.setText("0");
            storeString = "0";
        }
    }

    private void storeNumber(String i){

        if (tvShow.getText().equals("0")){
            tvShow.setText(i);
            storeString = i;
        } else {
            tvShow.setText(tvShow.getText() + i);
            storeString = storeString + i;
        }
        operation = false;
    }

    private void  operation(String op1, String op2){

        try {

            if ("+".equals(op1)) {
                if (storeString != null && !operation) {
                    store = Float.parseFloat(storeString);
                    storeString = "";

                    result = result + store;
                    String s = String.valueOf(result);
                    tvResult.setText(s);

                    operation = true;

                    tvShow.setText(tvShow.getText() + op2);
                }
            } else if ("-".equals(op1)) {
                if (storeString != null && !operation) {
                    store = Float.parseFloat(storeString);
                    storeString = "";

                    result = result - store;
                    String s = String.valueOf(result);
                    tvResult.setText(s);

                    operation = true;

                    tvShow.setText(tvShow.getText() + op2);
                }
            } else if ("*".equals(op1)) {
                if (storeString != null && !operation) {
                    store = Float.parseFloat(storeString);
                    storeString = "";

                    result = result * store;
                    String s = String.valueOf(result);
                    tvResult.setText(s);

                    operation = true;

                    tvShow.setText(tvShow.getText() + op2);
                }
            } else if ("/".equals(op1)) {
                if (storeString != null && !operation) {
                    store = Float.parseFloat(storeString);
                    storeString = "";

                    result = result / store;
                    String s = String.valueOf(result);
                    tvResult.setText(s);

                    operation = true;

                    tvShow.setText(tvShow.getText() + op2);
                }
            } else if ("%".equals(op1)) {
                if (storeString != null && !operation) {
                    store = Float.parseFloat(storeString);
                    storeString = "";

                    result = result % store;
                    String s = String.valueOf(result);
                    tvResult.setText(s);

                    operation = true;

                    tvShow.setText(tvShow.getText() + op2);
                }
            } else if ("a".equals(op1)) {

                if (storeString != null && !operation) {
                    store = Float.parseFloat(storeString);
                    storeString = "";

                    result = store;
                    String s = String.valueOf(result);
                    tvResult.setText(s);

                    operation = true;

                    tvShow.setText(tvShow.getText() + op2);
                }

            } else if ("".equals(op1)) {

                storeString = String.valueOf(result);
                tvShow.setText(storeString);
                result = 0;
                tvResult.setText("0");

            }

        } catch (Exception e){
            Log.e("-----",""+e);
            tvResult.setText("Error");
        }

    }

    private void init(){
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnX = findViewById(R.id.btnX);
        btnC = findViewById(R.id.btnC);
        btnDot = findViewById(R.id.btnDot);
        btnDivision = findViewById(R.id.btnDivision);
        btnPercentage = findViewById(R.id.btnPercentage);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnBackSpace = findViewById(R.id.btnBackSpace);
        btnEqualTo = findViewById(R.id.btnEqualTo);
        tvResult = findViewById(R.id.tvResult);
        tvShow = findViewById(R.id.tvShow);
    }
}