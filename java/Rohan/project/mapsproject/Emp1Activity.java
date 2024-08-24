package rakesh.project.mapsproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Emp1Activity extends AppCompatActivity {

    private Button btv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp1);


        btv=(Button)findViewById(R.id.btview);

        btv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in1 = new Intent(Emp1Activity.this,MapsActivity.class);
                startActivity(in1);
            }
        });
    }
}
