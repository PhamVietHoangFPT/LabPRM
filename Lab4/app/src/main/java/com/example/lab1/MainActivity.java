package com.example.lab1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnChonThucAn, btnChonDoUong, btnThoat;
    TextView tvKetQua;

    // Định nghĩa các mã request để phân biệt kết quả trả về từ đâu
    private static final int FOOD_REQUEST_CODE = 1;
    private static final int DRINK_REQUEST_CODE = 2;

    // Biến lưu trữ lựa chọn
    private String selectedFood = "";
    private String selectedDrink = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ View
        btnChonThucAn = findViewById(R.id.btnChonThucAn);
        btnChonDoUong = findViewById(R.id.btnChonDoUong);
        btnThoat = findViewById(R.id.btnThoat);
        tvKetQua = findViewById(R.id.tvKetQua);

        // Bắt sự kiện click
        btnChonThucAn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FoodActivity.class);
                startActivityForResult(intent, FOOD_REQUEST_CODE);
            }
        });

        btnChonDoUong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DrinkActivity.class);
                startActivityForResult(intent, DRINK_REQUEST_CODE);
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Đóng ứng dụng
            }
        });
    }

    // Phương thức này được gọi khi Activity con kết thúc và trả về kết quả
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Kiểm tra xem kết quả có phải là RESULT_OK không
        if (resultCode == RESULT_OK && data != null) {
            // Kiểm tra xem kết quả trả về từ Activity nào
            switch (requestCode) {
                case FOOD_REQUEST_CODE:
                    selectedFood = data.getStringExtra("selected_food");
                    break;
                case DRINK_REQUEST_CODE:
                    selectedDrink = data.getStringExtra("selected_drink");
                    break;
            }
            updateResultText();
        }
    }

    // Cập nhật TextView kết quả
    private void updateResultText() {
        if (!selectedFood.isEmpty() && !selectedDrink.isEmpty()) {
            tvKetQua.setText(selectedFood + " - " + selectedDrink);
        } else if (!selectedFood.isEmpty()) {
            tvKetQua.setText(selectedFood);
        } else if (!selectedDrink.isEmpty()){
            tvKetQua.setText(selectedDrink);
        }
    }
}