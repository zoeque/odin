package zoeque.odin.domain.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import zoeque.odin.R;

public class MaintenanceScreenButtonActivity extends AppCompatActivity {
    private Boolean isRandom = false;
    private Boolean isOnlyLearnedWord = false;
    private Integer numberOfListedWords = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenance);

        // The listener for toggle button to set the random state
        Switch toggleRandom = findViewById(R.id.toggleRandom);
        toggleRandom.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean input) {
                isRandom = input;
            }
        });

        // The listener to except the learned word from study part
        Switch toggleLearned = findViewById(R.id.toggleLearned);
        toggleLearned.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean input) {
                isOnlyLearnedWord = input;
            }
        });


        Button button = findViewById(R.id.button_to_top);
        button.setOnClickListener(new View.OnClickListener() {
            /**
             * The button action to move to top screen.
             *
             * @param v The view that was clicked.
             */
            public void onClick(View v) {
                Intent intent = new Intent(MaintenanceScreenButtonActivity.this,
                        TopScreenButtonActivity.class);
                startActivity(intent);
            }
        });
    }
}
