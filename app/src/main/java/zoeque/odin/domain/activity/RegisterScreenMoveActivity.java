package zoeque.odin.domain.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import zoeque.odin.R;

/**
 * The screen component to save new word.
 */
public class RegisterScreenMoveActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        Button button = findViewById(R.id.button_to_top);
        button.setOnClickListener(new View.OnClickListener() {
            /**
             * The button action to move to top screen.
             *
             * @param v The view that was clicked.
             */
            public void onClick(View v) {
                Intent intent = new Intent(RegisterScreenMoveActivity.this,
                        TopScreenButtonActivity.class);
                startActivity(intent);
            }
        });
    }
}
