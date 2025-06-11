package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // BƯỚC 1: Nạp giao diện LÊN TRƯỚC, đây phải là một trong những lệnh đầu tiên
        setContentView(R.layout.activity_main);

        // BƯỚC 2: SAU KHI có giao diện, BẮT ĐẦU tìm các thành phần trong đó
        Button button = findViewById(R.id.button);

        // Đoạn code này cũng nên được đặt sau setContentView
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // BƯỚC 3: Gán sự kiện cho button đã được tìm thấy
        // (Lúc này 'button' đã có giá trị, không còn là null nữa)
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo ý định (Intent) để chỉ định nơi cần đến (Trang Login)
                Intent intent = new Intent(MainActivity.this, Login.class);
                // Bắt đầu hành động chuyển trang
                startActivity(intent);
            }
        });
    }


}