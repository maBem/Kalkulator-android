package com.example.kalkulator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import org.mariuszgromada.math.mxparser.*;

public class SimpleCalculatorAvticity extends AppCompatActivity {

    private EditText result;
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0;
    private Button plus, minus, div, mul, equal, dot;
    private Button clear, backspace, plusMinus, allClear;
    private int validFlag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_calculator_avticity);
        result = findViewById(R.id.editText);
        result.setShowSoftInputOnFocus(false); //delete keyboard

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getString(R.string.editText).equals(result.getText().toString())){
                    result.setText("");
                }
            }
        });

        if(savedInstanceState != null){
            result.setText(savedInstanceState.getString("key1", ""));
        }
        button0 = findViewById(R.id.zeroButton);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResultText("0");
            }
        });
        button1 = findViewById(R.id.oneButton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResultText("1");
            }
        });
        button2 = findViewById(R.id.twoButton);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResultText("2");
            }
        });
        button3 = findViewById(R.id.threeButton);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResultText("3");
            }
        });
        button4 = findViewById(R.id.fourButton);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResultText("4");
            }
        });
        button5 = findViewById(R.id.fiveButton);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResultText("5");
            }
        });
        button6 = findViewById(R.id.sixButton);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResultText("6");
            }
        });
        button7 = findViewById(R.id.sevenButton);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResultText("7");
            }
        });
        button8 = findViewById(R.id.eightButton);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResultText("8");
            }
        });
        button9 = findViewById(R.id.nineButton);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResultText("9");
            }
        });
        plus = findViewById(R.id.plusButton);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expression = result.getText().toString();
                if(expression.isEmpty()==false){
                    char lastChar = expression.charAt(expression.length()-1);
                    if(Character.isDigit(lastChar) == true)
                        setResultText("+");
                }
            }
        });
        minus = findViewById(R.id.minusButton);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expression = result.getText().toString();
                if(expression.isEmpty()==true){
                    setResultText("-");
                }
                else{
                    char lastChar = expression.charAt(expression.length()-1);
                    if(Character.isDigit(lastChar) == true)
                        setResultText("-");
                }

            }
        });
        mul = findViewById(R.id.multiplyButton);
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expression = result.getText().toString();
                if(expression.isEmpty()==false){
                    char lastChar = expression.charAt(expression.length()-1);
                    if(Character.isDigit(lastChar) == true)
                        setResultText("*");
                }

            }
        });
        div = findViewById(R.id.divideButton);
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expression = result.getText().toString();
                if(expression.isEmpty()==false){
                    char lastChar = expression.charAt(expression.length()-1);
                    if(Character.isDigit(lastChar) == true)
                        setResultText("/");
                }

            }
        });
        allClear = findViewById(R.id.acButton);
        allClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validFlag==0)
                    result.setText("");
            }
        });
        clear = findViewById(R.id.clearButton);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validFlag==1){
                    result.setText("");
                    validFlag=0;
                }
            }
        });
        backspace = findViewById(R.id.backspaceButton);
        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validFlag==0){
                    int position = result.getSelectionStart();
                    int len = result.getText().length();
                    if(position!=0 && len!=0){
                        SpannableStringBuilder selection = (SpannableStringBuilder) result.getText();
                        selection.replace(position-1, position, "");
                        result.setText(selection);
                        result.setSelection(position - 1);
                    }
                }

            }
        });
        equal = findViewById(R.id.equalsButton);
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validFlag==0){
                    String expression = result.getText().toString();
                    Expression exp = new Expression(expression);
                    String res = String.valueOf(exp.calculate());
                    result.setText(res);
                    if(result.getText().toString().equals("NaN")){
                        result.setText("Not valid expression");
                        validFlag = 1;
                    }
                    else
                        result.setSelection(result.length());

                }
            }
        });
        dot = findViewById(R.id.dotButton);
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validFlag==0){

                    String expression = result.getText().toString();
                    if(expression.isEmpty()==false){
                        char lastChar = expression.charAt(expression.length()-1);
                        if(!expression.contains(".") && Character.isDigit(lastChar)==true){
                            setResultText(".");
                        }
                        else if(expression.contains(".") && Character.isDigit((lastChar))==true){
                            int lastIndex = expression.lastIndexOf(".");
                            String cutExpression = expression.substring(lastIndex);
                            if(cutExpression.contains("+") || cutExpression.contains("-") || cutExpression.contains("*") || cutExpression.contains("/")){
                                setResultText(".");
                            }

                        }
                    }
                }
            }
        });
        plusMinus = findViewById(R.id.plusMinusButton);
        plusMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validFlag==0){
                    String expression = result.getText().toString();
                    if(expression.isEmpty()==false){
                        char sign = expression.charAt(0);
                        if(sign == '-'){
                            String rightCurrentStr = expression.substring(1,result.getText().length());
                            result.setText(rightCurrentStr);
                        }
                        else{
                            char minus = '-';
                            result.setText(String.format("%c%s",minus,expression));
                        }
                        result.setSelection(result.getText().length());
                    }

                }
            }
        });
    }
    private void setResultText(String string){
        if(validFlag==0){
            int position = result.getSelectionStart();
            String currentStr = result.getText().toString();
            String leftCurrentStr = currentStr.substring(0,position);
            String rightCurrentStr = currentStr.substring(position);
            if(getString(R.string.editText).equals(result.getText().toString())){
                result.setText(string);
                result.setSelection(position+1);
            }
            else{
                result.setText(String.format("%s%s%s",leftCurrentStr,string,rightCurrentStr));
                result.setSelection(position+1);
            }
        }


    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        outState.putString("key1", result.getText().toString());
        super.onSaveInstanceState(outState, outPersistentState);
    }
}