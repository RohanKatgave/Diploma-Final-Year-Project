package rakesh.project.mapsproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.view.View.*;

public class A1Activity extends AppCompatActivity {

    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1);

      b1=(Button)findViewById(R.id.buttonAdmin);
      b2=(Button)findViewById(R.id.buttonEmp);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(A1Activity.this,A2Activity.class);
                startActivity(myIntent);


            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent1 = new Intent(A1Activity.this,EmpLoginActivity.class);
                startActivity(myIntent1);
            }
        });


    }
}
