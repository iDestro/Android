package com.example.idestro.networkprogramming;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.idestro.model.User;
import com.idestro.utils.TransferUtils;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText userName = (EditText) findViewById(R.id.username);
        final EditText passWord = (EditText) findViewById(R.id.password);
        final EditText phone = (EditText) findViewById(R.id.phone);
        final EditText email = (EditText) findViewById(R.id.email);
        Button registerBtn = (Button) findViewById(R.id.register_btn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setName(userName.getText().toString());
                user.setPassWord(passWord.getText().toString());
                user.setPhone(phone.getText().toString());
                user.setEmail(email.getText().toString());
                TransferUtils.userRegister(user);
            }
        });
    }
}
