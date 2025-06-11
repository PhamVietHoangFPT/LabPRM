package com.example.lab2signinform;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etUserName;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private TextView tvAlreadyAccount;
    private Button btnSignUp;
    private final String REQUIRE = "Require";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);

        etUserName = findViewById(R.id.userName);
        etPassword = findViewById(R.id.password);
        etConfirmPassword = findViewById(R.id.confirmPassword);
        tvAlreadyAccount = findViewById(R.id.alreadyAccount);
        btnSignUp = findViewById(R.id.signUpButton);

        tvAlreadyAccount.setOnClickListener(this::onClick);
        btnSignUp.setOnClickListener(this::onClick);
    }

    private boolean checkInput() {

        if (TextUtils.isEmpty(etUserName.getText().toString())) {
            etUserName.setError(REQUIRE);
            return false;
        }

        if (TextUtils.isEmpty(etPassword.getText().toString())) {
            etPassword.setError(REQUIRE);
            return false;
        }

        if (TextUtils.isEmpty(etConfirmPassword.getText().toString())) {
            etConfirmPassword.setError(REQUIRE);
            return false;
        }

        if (!TextUtils.equals(etPassword.getText().toString(), etConfirmPassword.getText().toString())) {
            Toast.makeText(this, "Password does not match", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    private void signUp() {
        if (!checkInput()) {
            return;
        }
    }

    private void signInForm() {
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.alreadyAccount) {
            signInForm();
        } else if (id == R.id.signUpButton) {
            signUp();
        }
    }
}