package rakesh.project.mapsproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class A4Activity extends AppCompatActivity {

    private EditText latitude1;
    private EditText longitude1;
    Button bt1;
    String st1,st2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a4);

        latitude1=(EditText)findViewById(R.id.etlat);
        longitude1=(EditText)findViewById(R.id.etlong);
        bt1=(Button)findViewById(R.id.buttona4);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(A4Activity.this,MapsActivity2.class);
                st1=latitude1.getText().toString();
                st2=longitude1.getText().toString();
                i.putExtra("Value1",st1);
                i.putExtra("Value2",st2);
                startActivity(i);
                finish();
            }
        });
    }
}
