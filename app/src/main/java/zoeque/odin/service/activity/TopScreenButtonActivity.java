package zoeque.odin.service.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import zoeque.odin.R;
import zoeque.odin.domain.repository.OdinDatabaseHelper;

/**
 * The top screen component class.
 */
public class TopScreenButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OdinDatabaseHelper dbHelper = new OdinDatabaseHelper(this);
        dbHelper.getWritableDatabase();

        buttonClickToScreen(R.id.button_to_start, StudyingActivity.class);
        buttonClickToScreen(R.id.button_to_register, RegisterScreenMoveActivity.class);
        buttonClickToScreen(R.id.button_to_maintenance, MaintenanceScreenButtonActivity.class);
    }


    private void buttonClickToScreen(int screenId, Class clazz) {
        Button button = findViewById(screenId);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TopScreenButtonActivity.this, clazz);
                startActivity(intent);
            }
        });
    }
}