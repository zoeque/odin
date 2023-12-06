package zoeque.odin.front.button;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import zoeque.odin.R;

/**
 * The menu button to move to creation view.
 */
public class ButtonController extends AppCompatActivity {
    private TextView textView;
    private boolean buttonTap = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        textView = findViewById(R.id.text_view);
        button.setOnClickListener(c -> {
            if (buttonTap) {
                textView.setText("Hello");
                buttonTap = false;
            } else {
                textView.setText("world");
                buttonTap = true;
            }
        });
    }
}
