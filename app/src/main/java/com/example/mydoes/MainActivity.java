package com.example.mydoes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatabaseReference reference;
    RecyclerView homeView;
    ArrayList<DatabaseClass> list;
    DoitAdapter mydoitAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton button;
        button = findViewById(R.id.newItemBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenAddItem();
            }
        });


        //working with data
        homeView = findViewById(R.id.homeView);
        homeView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<DatabaseClass>();

        //get data
        reference = FirebaseDatabase.getInstance().getReference().child("doit");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                {
                    DatabaseClass d = dataSnapshot1.getValue(DatabaseClass.class);
                    list.add(d);
                }
                mydoitAdapter = new DoitAdapter(MainActivity.this,list);
                homeView.setAdapter(mydoitAdapter);
                mydoitAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"No Data",Toast.LENGTH_SHORT).show();;
            }
        });
    }

    public void OpenAddItem() {
        Intent intent = new Intent(this,AddItems.class);
        startActivity(intent);

    }
}