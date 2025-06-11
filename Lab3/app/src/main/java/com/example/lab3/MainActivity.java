package com.example.lab3; // Thay bằng tên package của bạn

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listViewCourses;
    EditText editTextCourse;
    Button buttonAdd;
    Button buttonUpdate;

    ArrayList<String> courses;
    ArrayAdapter<String> adapter;
    int selectedIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewCourses = findViewById(R.id.listViewCourses);
        editTextCourse = findViewById(R.id.editTextCourse);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonUpdate = findViewById(R.id.buttonUpdate);

        courses = new ArrayList<>();
        courses.add("Android");
        courses.add("PHP");
        courses.add("iOS");
        courses.add("Unity");
        courses.add("ASP.net");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courses);
        listViewCourses.setAdapter(adapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newCourse = editTextCourse.getText().toString();
                if (!newCourse.isEmpty()) {
                    courses.add(newCourse);
                    adapter.notifyDataSetChanged();
                    editTextCourse.setText("");
                    Toast.makeText(MainActivity.this, "Đã thêm thành công!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập tên môn học", Toast.LENGTH_SHORT).show();
                }
            }
        });
        listViewCourses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                editTextCourse.setText(courses.get(position));
                selectedIndex = position;
            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedIndex != -1) {
                    String updatedCourse = editTextCourse.getText().toString();
                    if (!updatedCourse.isEmpty()) {
                        courses.set(selectedIndex, updatedCourse);
                        adapter.notifyDataSetChanged();
                        editTextCourse.setText("");
                        selectedIndex = -1;
                        Toast.makeText(MainActivity.this, "Đã cập nhật!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng chọn một môn học để cập nhật", Toast.LENGTH_SHORT).show();
                }
            }
        });

        listViewCourses.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Xác nhận xóa")
                        .setMessage("Bạn có chắc chắn muốn xóa môn học '" + courses.get(position) + "' không?")
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                courses.remove(position);
                                adapter.notifyDataSetChanged();
                                Toast.makeText(MainActivity.this, "Đã xóa thành công!", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Không", null)
                        .show();

                return true;
            }
        });
    }
}