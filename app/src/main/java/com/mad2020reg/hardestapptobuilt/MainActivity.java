package com.mad2020reg.hardestapptobuilt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText name, idNumber, email, phoneNumber;
    DatabaseReference dbRef;
    Student std;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.edtName);
        idNumber = findViewById(R.id.edtId);
        email = findViewById(R.id.edtEmail);
        phoneNumber = findViewById(R.id.edtMobile);

        std = new Student();
    }

    private void clearControls(){
        name.setText("");
        idNumber.setText("");
        email.setText("");
        phoneNumber.setText("");
    }

    public void registerStudent(View view){

        dbRef = FirebaseDatabase.getInstance().getReference().child("Student");

        try{
            if(TextUtils.isEmpty(name.getText().toString())){
                Toast.makeText(this, "Name field is Empty", Toast.LENGTH_SHORT).show();
            }else if (TextUtils.isEmpty(idNumber.getText().toString())){
                Toast.makeText(this, "ID field is Empty", Toast.LENGTH_SHORT).show();
            }else if(TextUtils.isEmpty(email.getText().toString())){
                Toast.makeText(this, "Email field is empty", Toast.LENGTH_SHORT).show();
            }else if(TextUtils.isEmpty(phoneNumber.getText().toString())){
                Toast.makeText(this, "Phone number field is Empty", Toast.LENGTH_SHORT).show();
            }else {
                std.setStudentName(name.getText().toString());
                std.setStudentId(idNumber.getText().toString());
                std.setEmail(email.getText().toString());
                std.setPhoneNo(phoneNumber.getText().toString());

                dbRef.push().setValue(std);
                Toast.makeText(this, "Data Save Successfully", Toast.LENGTH_SHORT).show();
                clearControls();
            }

        }catch (Exception e){
            Toast.makeText(this, "Something went wrong :(", Toast.LENGTH_SHORT).show();

        }

    }

    public void viewAll(View view){
        Intent intent = new Intent(MainActivity.this, ViewAll.class);
        startActivity(intent);
    }
}