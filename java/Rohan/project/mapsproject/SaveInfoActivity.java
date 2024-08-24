package rakesh.project.mapsproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SaveInfoActivity extends AppCompatActivity {


    private FirebaseAuth mAuth;
    private DatabaseReference databaseReference;

    Button save;

    String n1,id1,p1,l1,l2,d,str1,str2,s1,s2,s3,s4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_info);


        str1=getIntent().getExtras().getString("Value11");
        str2=getIntent().getExtras().getString("Value22");

        mAuth = FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, EmpLoginActivity.class));
        }


        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat format= new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
        d=format.format(calendar.getTime());

        FirebaseUser user=mAuth.getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference("Employee" ).child(user.getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                User u1=dataSnapshot.getValue(User.class);
                assert u1 != null;
                n1=u1.getName();
                id1=u1.getId();
                p1=u1.getPhone();
                l1=u1.getLatitude();
                l2=u1.getLongitude();
                s1=n1;
                s2=id1;
                s3=p1;
                l1=str1;
                l2=str2;
                s4=d;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        save = (Button) findViewById(R.id.buttons1);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                User u1=new User(s1,s2,s3,l1,l2,s4);

                databaseReference.setValue(u1);
                Toast.makeText(SaveInfoActivity.this,"Information Saved",Toast.LENGTH_LONG).show();
            }
        });



    }

}


