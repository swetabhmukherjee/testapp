package com.example.testapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
EditText editname,editbr,editgr,editroll;
Button submit,clear,gobutton;
DatabaseReference reff;
Member member;
long maxid=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editname=(EditText)findViewById(R.id.editname);
        editbr=(EditText)findViewById(R.id.editbr);
        editgr=(EditText)findViewById(R.id.editgr);
        editroll=(EditText)findViewById(R.id.editroll);
        submit=(Button)findViewById(R.id.submit);
        gobutton=(Button)findViewById(R.id.button3);
        member= new Member();
        reff= FirebaseDatabase.getInstance().getReference().child("Member");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    maxid=(dataSnapshot.getChildrenCount());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        Toast.makeText(MainActivity.this,"Back-end DB ready", Toast.LENGTH_LONG).show();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=editname.getText().toString().trim();
                String br=editbr.getText().toString().toUpperCase().trim();
                String gr=editgr.getText().toString().toUpperCase().trim();
                int roll=Integer.parseInt(editroll.getText().toString().trim());
                member.setName(editname.getText().toString().trim());
                member.setBranch(br);
                member.setGroup(gr);
                member.setRoll(roll);
               // reff.push().setValue(member);
                reff.child(String.valueOf(maxid+1)).setValue(member);
                Toast.makeText(MainActivity.this, "Successfully inserted data", Toast.LENGTH_LONG).show();

            }
        });

        clear=(Button)findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editname.setText("");
                editgr.setText("");
                editbr.setText("");
                editroll.setText("");
                editname.setFocusable(true);
            }
        });
        gobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startactivity2();
            }

            private void startactivity2() {
                Intent intent;
                intent = new Intent(MainActivity.this, mainscreen.class);
                startActivity(intent);

            }
        });

    }


}
