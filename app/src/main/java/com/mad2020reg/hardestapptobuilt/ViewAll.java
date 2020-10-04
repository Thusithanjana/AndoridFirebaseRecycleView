package com.mad2020reg.hardestapptobuilt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewAll extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    DatabaseReference dbRef;
    private static final String TAG = "ViewAll";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        //String[] myDataset = {"Hello", "Recycle View", "I am a Student"};
         final List <Student> myDataset = new ArrayList<Student>();

        dbRef = FirebaseDatabase.getInstance().getReference().child("Student");
        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                Student std = new Student();
//                std.setStudentName(snapshot.get);
//                std.setStudentId();
//                std.setEmail();
//                std.setPhoneNo();

               //myDataset.add(std);
                for(DataSnapshot ds : snapshot.getChildren()){
                    Student std =  ds.getValue(Student.class);
                    Log.i(TAG, "onDataChange: "+ std.getStudentName());
                    myDataset.add(std);
                }
                mAdapter = new StudentAdapter(myDataset);
                recyclerView.setAdapter(mAdapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

//        for(int i = 0; i<5;i++){
//            Student std = new Student();
//            std.setStudentName("Student "+i);
//            std.setStudentId("IT12121"+i);
//            std.setEmail("student"+i+"@xyz.com");
//            std.setPhoneNo("071712312"+i);
//
//            myDataset.add(std);
//        }


    }
}