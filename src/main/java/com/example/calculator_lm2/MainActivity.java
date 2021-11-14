package com.example.calculator_lm2;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState((outState));
        TextView resultTextViev = findViewById(R.id.textView);
        String resultText = String.valueOf(resultTextViev.getText());
        outState.putString("KEY", resultText);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        String resultText = savedInstanceState.getString("KEY","0");
        TextView resultTextViev = findViewById(R.id.textView);
        resultTextViev.setText(resultText);

    }

    public void calculate(View view) {
        int currentButtonId = view.getId();
        TextView resultTextViev = findViewById(R.id.textView);
        String bufferText = String.valueOf(resultTextViev.getText());
        Double result = 0.0;
        Expression expression = new Expression(bufferText);
        switch (currentButtonId) {
            case R.id.button0:
                bufferText = setBufferNumberText("0", bufferText);
                break;
            case R.id.button1:
                bufferText = setBufferNumberText("1", bufferText);
                break;
            case R.id.button2:
                bufferText = setBufferNumberText("2", bufferText);
                break;
            case R.id.button3:
                bufferText = setBufferNumberText("3", bufferText);
                break;
            case R.id.button4:
                bufferText = setBufferNumberText("4", bufferText);
                break;
            case R.id.button5:
                bufferText = setBufferNumberText("5", bufferText);
                break;
            case R.id.button6:
                bufferText = setBufferNumberText("6", bufferText);
                break;
            case R.id.button7:
                bufferText = setBufferNumberText("7", bufferText);
                break;
            case R.id.button8:
                bufferText = setBufferNumberText("8", bufferText);
                break;
            case R.id.button9:
                bufferText = setBufferNumberText("9", bufferText);
                break;
            case R.id.buttonAC:
                bufferText = "0";
                break;
            case R.id.buttonProccent:
                bufferText = setBufferSignText("%", bufferText);
                expression = new Expression(bufferText);
                break;
            case R.id.buttonSlash:
                bufferText = setBufferSignText("/", bufferText);
                expression = new Expression(bufferText);
                break;
            case R.id.buttonMulti:
                bufferText = setBufferSignText("*", bufferText);
                expression = new Expression(bufferText);
                break;
            case R.id.buttonMinus:
                bufferText = setBufferSignText("-", bufferText);
                expression = new Expression(bufferText);
                break;
            case R.id.buttonPlus:
                bufferText = setBufferSignText("+", bufferText);
                expression = new Expression(bufferText);
                break;
            case R.id.buttonPlusMinus:
                bufferText = "-(" + bufferText + ")";
                break;
            case R.id.buttonLog10:
                bufferText = "log(" + bufferText + ",10)";
                break;
            case R.id.buttonFactorial:
                bufferText = bufferText + "!";
                break;
            case R.id.buttonSqrt:
                bufferText = "sqrt(" + bufferText + ")";
                break;
            case R.id.buttonPow3:
                bufferText = "(" + bufferText + ")^3";
                break;
            case R.id.buttonPow2:
                bufferText = "(" + bufferText + ")^2";
                break;
            case R.id.buttonEquals:
                expression = new Expression(bufferText.toString());
                result = expression.calculate();
                bufferText = result.toString();
                break;
        }
        resultTextViev.setText(bufferText);
    }

    public String setBufferNumberText(String text, String bufferText){
        if(bufferText.equals("0")) {
            bufferText = text;
        }
        else {
            bufferText += text;
        }
        return bufferText;
    }
    public String setBufferSignText(String text, String bufferText) {
        if(bufferText.equals("0") == false){
            bufferText += text;
        }
        return bufferText;
    }
}