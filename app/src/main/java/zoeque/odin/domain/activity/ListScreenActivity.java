package zoeque.odin.domain.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import zoeque.odin.R;

public class ListScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenance_list);
        Button buttonToMaintenanceScreen = findViewById(R.id.button_to_maintenance);
        buttonToMaintenanceScreen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ListScreenActivity.this,
                        MaintenanceScreenButtonActivity.class);
                startActivity(intent);
            }
        });
    }
}
