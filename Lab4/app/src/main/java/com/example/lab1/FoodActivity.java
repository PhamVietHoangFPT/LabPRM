package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class FoodActivity extends AppCompatActivity {

    RadioGroup rgThucAn;
    Button btnDatMonAn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        rgThucAn = findViewById(R.id.rgThucAn);
        btnDatMonAn = findViewById(R.id.btnDatMonAn);

        btnDatMonAn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy ID của RadioButton được chọn
                int selectedId = rgThucAn.getCheckedRadioButtonId();

                if (selectedId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String selectedFood = selectedRadioButton.getText().toString();

                    // Tạo một Intent để chứa dữ liệu trả về
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("selected_food", selectedFood);

                    // Đặt kết quả là RESULT_OK và gửi Intent về
                    setResult(RESULT_OK, resultIntent);

                    // Đóng Activity hiện tại
                    finish();
                }
            }
        });
    }
}