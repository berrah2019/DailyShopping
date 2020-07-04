package com.example.dailyshopping;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration_Activity extends AppCompatActivity {
    private EditText email;
    private EditText pass;
    private TextView signin;
    private Button btn_reg;
    private FirebaseAuth mauth;
    private ProgressDialog mDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_);
        mDialog=new ProgressDialog(this);
        email=findViewById(R.id.Email_Registration);
        pass=findViewById(R.id.Password_reg);
        signin=findViewById(R.id.signin_txt);
        btn_reg=findViewById(R.id.btn_reg);
        mauth=FirebaseAuth.getInstance();


        signin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class)
                );
            }
        });
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mEmail=email.getText().toString().trim();
                String mPassord= pass.getText().toString().trim();
               if(TextUtils.isEmpty(mEmail)){
               email.setError("Required Email");
               return;
               }
                if(TextUtils.isEmpty(mPassord)){
                pass.setError("Required Password");
                return;
                }
                mDialog.setMessage("Prossesing ...");
                mDialog.show();
                mauth.createUserWithEmailAndPassword(mEmail,mPassord).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isComplete()){
                            Toast.makeText(getApplicationContext(),"Sucessful..",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                            mDialog.dismiss();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Failed..",Toast.LENGTH_SHORT).show();
                            mDialog.dismiss();
                        }

                    }
                });
            }
        });{

        };

    }
}
