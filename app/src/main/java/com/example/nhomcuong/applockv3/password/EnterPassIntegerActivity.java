package com.example.nhomcuong.applockv3.password;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nhomcuong.applockv3.R;
import com.example.nhomcuong.applockv3.activities.MainActivity;
import com.example.nhomcuong.applockv3.model.DataUse;

import java.util.Stack;

public class EnterPassIntegerActivity extends AppCompatActivity {
    String rePassword;
    boolean fromService=false;
    String blockedPackageName;
    View ivOne, ivTwo, ivThree, ivFour, ivFive, ivSix, ivSeven, ivEight, ivNine, ivZero, ivCheck, ivBackSpace;
    Stack<String> stack = new Stack<>();
    EditText password;
    DataUse dataUse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_pass_integer);
        Log.d("long", "onCreate: " + rePassword);
        dataUse= new DataUse(getApplicationContext());
        fromService=false;
        rePassword=dataUse.getPassInt();

        //Nhan data tu intent cua service
        Intent i = getIntent();

        if(i.hasExtra("packet")  ){
            fromService = true;
            blockedPackageName = i.getStringExtra("packet");
           // blockedActivityName = i.getStringExtra("activity");
        }

        setupUI();
        loadData();



       ivCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String edit = password.getText().toString();
                if(edit.equals(""))
                    Toast.makeText(EnterPassIntegerActivity.this, "Không có mật khẩu, hãy nhập mật khẩu", Toast.LENGTH_SHORT).show();
                else
                {
                    if(edit.equals(rePassword)){
                        if(fromService==false){
                            dataUse.setIsAppLock("false");
                            Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);
                            finish();}
                        else{

                            Log.e("CUONG","Nhan duoc packet la "+blockedPackageName);
//                            Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage(blockedPackageName);
//                            startActivity( LaunchIntent );
                            dataUse.setChoPhep(blockedPackageName);
                            setResult(RESULT_OK);
                            finish();
                        }

                    }
                    else
                        Toast.makeText(EnterPassIntegerActivity.this, "Mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (fromService) {
            cancel();
        } else {
            setResult(RESULT_OK);
            finish();
        }

    }
    private void cancel(){
        Log.e("CUONG", "cancel");
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);;
        startActivity(startMain);
        finish();
    }


    private void setupUI() {

        ivOne = findViewById(R.id.iv_one);
        ivTwo = findViewById(R.id.iv_two);
        ivThree =  findViewById(R.id.iv_three);
        ivFour =  findViewById(R.id.iv_four);
        ivFive =  findViewById(R.id.iv_five);
        ivSix =  findViewById(R.id.iv_six);
        ivSeven =  findViewById(R.id.iv_seven);
        ivEight =  findViewById(R.id.iv_eight);
        ivNine =  findViewById(R.id.iv_nine);
        ivZero =  findViewById(R.id.iv_zero);
        ivCheck =  findViewById(R.id.iv_check);
        ivBackSpace =  findViewById(R.id.tv_back_space);
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
