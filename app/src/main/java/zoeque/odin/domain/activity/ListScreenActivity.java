package zoeque.odin.domain.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import zoeque.odin.R;
import zoeque.odin.adapter.WordAdapter;
import zoeque.odin.domain.entity.IWord;
import zoeque.odin.domain.repository.OdinDatabaseHelper;

public class ListScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenance_list);

        WordRepository repository = new WordRepository(new OdinDatabaseHelper(ListScreenActivity.this));
        List<IWord> allWords = repository.getAllWords();

        WordAdapter adapter = new WordAdapter(this, allWords);

        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);

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
