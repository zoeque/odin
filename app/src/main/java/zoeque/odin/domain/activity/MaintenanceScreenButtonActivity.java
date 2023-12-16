package zoeque.odin.domain.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import zoeque.odin.R;
import zoeque.odin.domain.model.OdinSettingModel;

public class MaintenanceScreenButtonActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenance);


        // The listener for toggle button to set the random state
        SharedPreferences preferences = getSharedPreferences(OdinSettingModel.SETTING.getSettingModel(), 0);
        Switch toggleRandom = findViewById(R.id.toggleRandom);

        // get the last status of the random order setting
        boolean randomSetting
                = preferences.getBoolean(OdinSettingModel.RANDOM_ORDER.getSettingModel(), false);
        toggleRandom.setChecked(randomSetting);
        toggleRandom.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /**
             * The event listener when the random order toggle button is changed.
             *
             * @param buttonView The compound button view whose state has changed.
             * @param input  The new checked state of buttonView.
             */
            public void onCheckedChanged(CompoundButton buttonView, boolean input) {
                // save the state
                SharedPreferences settings = getSharedPreferences(OdinSettingModel.SETTING.getSettingModel(), 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean(OdinSettingModel.RANDOM_ORDER.getSettingModel(), input);
                editor.apply();
            }
        });

        // The listener to except the learned word from study part
        Switch toggleExceptLearned = findViewById(R.id.toggleLearned);

        // get last state of the setting to except learned words.
        boolean learnedSetting
                = preferences.getBoolean(OdinSettingModel.EXCEPT_LEARNED.getSettingModel(), false);
        toggleExceptLearned.setChecked(learnedSetting);

        toggleExceptLearned.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean input) {
                // save the state
                SharedPreferences settings = getSharedPreferences(OdinSettingModel.SETTING.getSettingModel(), 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean(OdinSettingModel.EXCEPT_LEARNED.getSettingModel(), input);
                editor.apply();
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
