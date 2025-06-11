package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class DrinkActivity extends AppCompatActivity {

    RadioGroup rgDoUong;
    Button btnDatDoUong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        rgDoUong = findViewById(R.id.rgDoUong);
        btnDatDoUong = findViewById(R.id.btnDatDoUong);

        btnDatDoUong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = rgDoUong.getCheckedRadioButtonId();

                if (selectedId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String selectedDrink = selectedRadioButton.getText().toString();

                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("selected_drink", selectedDrink);

                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
            }
        });
    }
}