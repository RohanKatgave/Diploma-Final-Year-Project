package rakesh.project.mapsproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class EmpLoginActivity extends AppCompatActivity {

    private EditText email1,pass1;
    private ProgressBar mprog;
    Button btnemp1;
    private TextView count1,forgetpass;
    private int counter = 5;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_login);

        email1=(EditText)findViewById(R.id.editTextEmail1);
        pass1=(EditText)findViewById(R.id.editTextPassword1);
        btnemp1=(Button)findViewById(R.id.buttonEmp1);
        count1=(TextView)findViewById(R.id.tvcount);
        forgetpass=(TextView)findViewById(R.id.tvforgetpass);
        mprog=(ProgressBar)findViewById(R.id.progressBar2);


        count1.setText("No of attempts remaining: 5");

        mAuth = FirebaseAuth.getInstance();


        btnemp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isEmpty()) return;

                mAuth.signInWithEmailAndPassword(email1.getText().toString(),pass1.getText().toString())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                inProgress(true);
                                Toast.makeText(EmpLoginActivity.this,"User Logged In",Toast.LENGTH_LONG).show();
                                Intent intent=new Intent(EmpLoginActivity.this,Emp1Activity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                                finish();

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        inProgress(false);
                        Toast.makeText(EmpLoginActivity.this,"Login in Failed",Toast.LENGTH_SHORT).show();
                        counter--;
                        count1.setText("No of attempts remaining: " + counter);

                          if(counter==0) {
                            btnemp1.setEnabled(false);

                        }
                        }
                });
            }
        });


        forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EmpLoginActivity.this,ResetpasswordActivity.class));
            }
        });

    }



    //isEmpty()

    private boolean isEmpty()
    {
        if(TextUtils.isEmpty(email1.getText().toString())){
            email1.setError("Required");
            return true;
        }
        if(TextUtils.isEmpty(pass1.getText().toString())){
            pass1.setError("Required");
            return true;
        }
        return false;

    }


    //in progress [progress bar]
    private void inProgress(boolean x)
    {
        if(x){
            mprog.setVisibility(View.VISIBLE);
            btnemp1.setEnabled(false);
        }
        else
        {
            mprog.setVisibility(View.GONE);
            btnemp1.setEnabled(true);
        }
    }
}


