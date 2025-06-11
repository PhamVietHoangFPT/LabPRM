package com.example.lab2;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class Calculator extends AppCompatActivity {
    Button plus;
    Button minus;
    Button multiply;
    Button divide;
    TextView result;
    EditText firstNumber;
    EditText secondNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        firstNumber = findViewById(R.id.firstNumber);
        secondNumber = findViewById(R.id.secondNumber);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        result = findViewById(R.id.textView);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                validateInputs();
            }
        };

        firstNumber.addTextChangedListener(textWatcher);
        secondNumber.addTextChangedListener(textWatcher);

        plus.setOnClickListener(v -> {
            try {
                float firstValue = Float.parseFloat(firstNumber.getText().toString());
                float secondValue = Float.parseFloat(secondNumber.getText().toString());
                result.setText("Result: " + (firstValue + secondValue));
            } catch (Exception e) {
                result.setText("Invalid number");
            }
        });

        minus.setOnClickListener(v -> {
            try {
                float firstValue = Float.parseFloat(firstNumber.getText().toString());
                float secondValue = Float.parseFloat(secondNumber.getText().toString());
                result.setText("Result: " + (firstValue - secondValue));
            } catch (Exception e) {
                result.setText("Invalid number");
            }
        });

        multiply.setOnClickListener(v -> {
            try {
                float firstValue = Float.parseFloat(firstNumber.getText().toString());
                float secondValue = Float.parseFloat(secondNumber.getText().toString());
                result.setText("Result: " + (firstValue * secondValue));
            } catch (Exception e) {
                result.setText("Invalid number");
                }
        });

        divide.setOnClickListener(v -> {
            try {
                float firstValue = Float.parseFloat(firstNumber.getText().toString());
                float secondValue = Float.parseFloat(secondNumber.getText().toString());
                result.setText("Result: " + (firstValue / secondValue));
            } catch (Exception e) {
                result.setText("Invalid number");
            }
        });

        validateInputs();
    }

    private void validateInputs() {
        String firstNumberStr = firstNumber.getText().toString();
        String secondNumberStr = secondNumber.getText().toString();

        if (firstNumberStr.isEmpty() || secondNumberStr.isEmpty()) {
            plus.setEnabled(false);
            minus.setEnabled(false);
            multiply.setEnabled(false);
            divide.setEnabled(false);
            return;
        }

        try {
            float secondValue = Float.parseFloat(secondNumberStr);
            if (secondValue == 0) {
                plus.setEnabled(true);
                minus.setEnabled(true);
                multiply.setEnabled(true);
                divide.setEnabled(false);
            } else {
                plus.setEnabled(true);
                minus.setEnabled(true);
                multiply.setEnabled(true);
                divide.setEnabled(true);
            }
        } catch (NumberFormatException e) {
            plus.setEnabled(false);
            minus.setEnabled(false);
            multiply.setEnabled(false);
            divide.setEnabled(false);
        }
    }
}