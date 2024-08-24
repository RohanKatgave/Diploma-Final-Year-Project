package rakesh.project.mapsproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class A3Activity extends AppCompatActivity {

    Button btnadmin2,btnadmin3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a3);

        btnadmin2=(Button)findViewById(R.id.buttonAdminAdd);
        btnadmin3=(Button)findViewById(R.id.buttonAdminView);

        btnadmin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent3 = new Intent(A3Activity.this,RegisterActivity.class);
                startActivity(myIntent3);
            }
        });

        btnadmin3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent3 = new Intent(A3Activity.this,A4Activity.class);
                startActivity(myIntent3);
            }
        });
    }
}
