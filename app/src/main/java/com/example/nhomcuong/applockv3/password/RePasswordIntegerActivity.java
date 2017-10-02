package com.example.nhomcuong.applockv3.password;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.example.nhomcuong.applockv3.R;
import com.example.nhomcuong.applockv3.activities.MainActivity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RePasswordIntegerActivity extends AppCompatActivity {
    View ivOne, ivTwo, ivThree, ivFour, ivFive, ivSix, ivSeven, ivEight, ivNine, ivZero, ivCheck, ivBackSpace;
    Stack<String> stack = new Stack<>();
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_password_integer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupUI();
        loadData();

        Intent intent = this.getIntent();

        final String rePass = intent.getStringExtra("password");

        ivCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rePass.equals(password.getText().toString())) {

                    // file luu mat khau
                    SharedPreferences settings = getSharedPreferences("CUONG", 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putString("passwordint", rePass);
                    editor.putString("lockmode", "enterintpass");
                    //tao ra file luu danh sach packet bi khoa
                    Set<String> set = new HashSet<String>();
                    set.addAll(new ArrayList<String>());
                    editor.putStringSet("applock", set);
                    editor.putString("isapplock", "true");
                    editor.commit();

                    // vao app
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }

    private void setupUI() {

        ivOne = findViewById(R.id.iv_one);
        ivTwo = findViewById(R.id.iv_two);
        ivThree = findViewById(R.id.iv_three);
        ivFour = findViewById(R.id.iv_four);
        ivFive = findViewById(R.id.iv_five);
        ivSix = findViewById(R.id.iv_six);
        ivSeven = findViewById(R.id.iv_seven);
        ivEight = findViewById(R.id.iv_eight);
        ivNine = findViewById(R.id.iv_nine);
        ivZero = findViewById(R.id.iv_zero);
        ivCheck = findViewById(R.id.iv_check);
        ivBackSpace = findViewById(R.id.tv_back_space);
        password = (EditText) findViewById(R.id.password);
    }

    private void loadData() {
        ivOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = "";
                stack.push("1");
                for (String c : stack
                        ) {
                    a += c;
                }
                password.setText(a);
            }
        });

        ivTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = "";
                stack.push("2");
                for (String c : stack
                        ) {
                    a += c;
                }
                password.setText(a);
            }
        });

        ivThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = "";
                stack.push("3");
                for (String c : stack
                        ) {
                    a += c;
                }
                password.setText(a);
            }
        });

        ivFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = "";
                stack.push("4");
                for (String c : stack
                        ) {
                    a += c;
                }
                password.setText(a);
            }
        });

        ivFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = "";
                stack.push("5");
                for (String c : stack
                        ) {
                    a += c;
                }
                password.setText(a);
            }
        });

        ivSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = "";
                stack.push("6");
                for (String c : stack
                        ) {
                    a += c;
                }
                password.setText(a);
            }
        });

        ivSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = "";
                stack.push("7");
                for (String c : stack
                        ) {
                    a += c;
                }
                password.setText(a);
            }
        });

        ivEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = "";
                stack.push("8");
                for (String c : stack
                        ) {
                    a += c;
                }
                password.setText(a);
            }
        });

        ivNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = "";
                stack.push("9");
                for (String c : stack
                        ) {
                    a += c;
                }
                password.setText(a);
            }
        });

        ivZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = "";
                stack.push("0");
                for (String c : stack
                        ) {
                    a += c;
                }
                password.setText(a);
            }
        });

        ivBackSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //stack.pop();
                String temp = "";

                if (!stack.isEmpty()) {
                    stack.pop();
                    for (String b : stack
                            ) {
                        temp += b;
                    }

                    password.setText(temp);
                }
            }
        });
    }
}
