package rakesh.project.mapsproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class A2Activity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    Button btnadmin1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a2);

        Name=(EditText)findViewById(R.id.editTextName);
        Password=(EditText)findViewById(R.id.editTextPassword);
        btnadmin1=(Button)findViewById(R.id.buttonAdmin1);

        btnadmin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(),Password.getText().toString());
                ;
            }
        });
    }
    private void validate(String name,String password)
    {
        if((name.equals("Admin")) && (password.equals("Admin123")))
        {
            Intent myIntent2 = new Intent(A2Activity.this,A3Activity.class);
            startActivity(myIntent2);
            Name.setText("");
            Password.setText("");
        }
        else
        {
            Toast.makeText(this,"Login Failed",Toast.LENGTH_LONG).show();
        }
    }

}

