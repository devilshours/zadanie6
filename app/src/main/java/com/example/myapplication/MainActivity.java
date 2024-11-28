package com.example.myapplication;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText emailField, passwordField, repeatPasswordField;
    private TextView messageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        emailField = findViewById(R.id.email_field);
        passwordField = findViewById(R.id.password_field);
        repeatPasswordField = findViewById(R.id.repeat_password_field);
        messageText = findViewById(R.id.message_text);
        Button submitButton = findViewById(R.id.submit_button);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateInput();
            }
        });
    }

    private void validateInput() {
        String email = emailField.getText().toString().trim();
        String password = passwordField.getText().toString();
        String repeatPassword = repeatPasswordField.getText().toString();


        if (TextUtils.isEmpty(email) || !email.contains("@")) {
            messageText.setText("Nieprawidłowy adres e-mail");
            return;
        }


        if (!password.equals(repeatPassword)) {
            messageText.setText("Hasła się różnią");
            return;
        }


        messageText.setText("Witaj " + email);
    }
}