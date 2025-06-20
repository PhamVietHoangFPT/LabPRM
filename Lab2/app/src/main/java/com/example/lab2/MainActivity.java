package com.example.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText startNumber;
    EditText endNumber;
    Button randomButton;
    Button calculatorButton;
    TextView result;
    private static final int CALCULATOR_REQUEST_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startNumber = findViewById(R.id.startNumber);
        endNumber = findViewById(R.id.endNumber);
        randomButton = findViewById(R.id.randomButton);
        result = findViewById(R.id.result);
        calculatorButton = findViewById(R.id.calculator);

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

        startNumber.addTextChangedListener(textWatcher);
        endNumber.addTextChangedListener(textWatcher);

        randomButton.setOnClickListener(v -> {
            try {
                int startValue = Integer.parseInt(startNumber.getText().toString());
                int endValue = Integer.parseInt(endNumber.getText().toString());

                Random random = new Random();
                int randomNumber = random.nextInt(endValue - startValue + 1) + startValue;

                result.setText("Result: " + randomNumber);
            } catch (Exception e) {
                result.setText("Invalid number");
            }
        });

        calculatorButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Calculator.class);
            startActivityForResult(intent, CALCULATOR_REQUEST_CODE);
        });

        validateInputs();
    }

    private void validateInputs() {
        String startStr = startNumber.getText().toString();
        String endStr = endNumber.getText().toString();

        if (startStr.isEmpty() || endStr.isEmpty()) {
            randomButton.setEnabled(false);
            return;
        }

        try {
            int startValue = Integer.parseInt(startStr);
            int endValue = Integer.parseInt(endStr);
            randomButton.setEnabled(startValue <= endValue);
        } catch (NumberFormatException e) {
            randomButton.setEnabled(false);
        }
    }
}