package ru.vmakarenko.showcase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import ru.vmakarenko.showcase.calc.Operation;

public class CalcActivity extends AppCompatActivity {
    private final int MAX_DIGITS = 10;
    private TextView total;
    private double currentValue = 0;
    private Double firstOperand = null;
    private boolean withDot = false;
    private Operation currentOperation = null;
    private List<Integer> cipherBtnIdList = Arrays.asList(R.id.calc_btn_0,
    R.id.calc_btn_1, R.id.calc_btn_2, R.id.calc_btn_3, R.id.calc_btn_4, R.id.calc_btn_5,
    R.id.calc_btn_6, R.id.calc_btn_7, R.id.calc_btn_8, R.id.calc_btn_9);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        total = (TextView) findViewById(R.id.calc_total_edit_text);
        refreshText();
    }

    private void refreshText() {
        String result = String.valueOf(currentValue);
        if(MAX_DIGITS < result.length()) {
            result = result.substring(0, MAX_DIGITS);
        }
        while(result.length() > 0
                && ((result.contains(".") && result.charAt(result.length()-1) == '0')
                || (result.charAt(result.length()-1) == '.'))){
            result = result.substring(0, result.length()-1);
        }
        total.setText(result);
    }
    private void refreshCurrentValue() {
        currentValue = Double.parseDouble(total.getText().toString());
    }

    public void calcBtnClicked(View view) {
        refreshText();
        if(withDot && !total.getText().toString().contains(".")){
            total.append(".");
        }
        switch (view.getId()) {
            case R.id.calc_btn_0:
                total.append("0");
                break;
            case R.id.calc_btn_1:
                total.append("1");
                break;
            case R.id.calc_btn_2:
                total.append("2");
                break;
            case R.id.calc_btn_3:
                total.append("3");
                break;
            case R.id.calc_btn_4:
                total.append("4");
                break;
            case R.id.calc_btn_5:
                total.append("5");
                break;
            case R.id.calc_btn_6:
                total.append("6");
                break;
            case R.id.calc_btn_7:
                total.append("7");
                break;
            case R.id.calc_btn_8:
                total.append("8");
                break;
            case R.id.calc_btn_9:
                total.append("9");
                break;
            case R.id.calc_btn_C:
                total.setText("0");
                firstOperand = null;
                currentOperation = null;
                withDot = false;
                refreshCurrentValue();
                break;
            case R.id.calc_btn_dot:
                withDot = true;
                break;
            case R.id.calc_btn_plus:
                double temp = currentValue;
                currentValue = solve(firstOperand, currentOperation, currentValue);
                firstOperand = temp;
                currentOperation = Operation.PLUS;
                withDot = false;
                break;
            case R.id.calc_btn_min:
                temp = currentValue;
                currentValue = solve(firstOperand, currentOperation, currentValue);
                firstOperand = temp;
                currentOperation = Operation.MINUS;
                withDot = false;
                break;
            case R.id.calc_btn_mult:
                temp = currentValue;
                currentValue = solve(firstOperand, currentOperation, currentValue);
                firstOperand = temp;
                currentOperation = Operation.MULT;
                withDot = false;
                break;
            case R.id.calc_btn_div:
                temp = currentValue;
                currentValue = solve(firstOperand, currentOperation, currentValue);
                firstOperand = temp;
                currentOperation = Operation.DIV;
                withDot = false;
                break;
            case R.id.calc_btn_eq:
                currentValue = solve(firstOperand, currentOperation, currentValue);
                firstOperand = null;
                currentOperation = null;
                break;
        }
        if(cipherBtnIdList.contains(view.getId())){
            refreshCurrentValue();
        }
        refreshText();
    }

    private double solve(Double firstOperand, Operation currentOperation, Double currentValue) {
        if(firstOperand == null || currentOperation == null){
            return 0;
        }
        switch (currentOperation){
            case PERCENT:
                break;
            case PLUS:
                return firstOperand + currentValue;
            case MINUS:
                return firstOperand - currentValue;
            case MULT:
                return firstOperand * currentValue;
            case DIV:
                return firstOperand / currentValue;
        }
        return 0;
    }
}
