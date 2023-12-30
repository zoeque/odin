package zoeque.odin.service.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import java.util.ArrayList;
import java.util.List;

import zoeque.odin.R;
import zoeque.odin.adapter.MaintenanceListAdapter;
import zoeque.odin.domain.entity.Word;
import zoeque.odin.domain.repository.OdinDatabase;
import zoeque.odin.domain.repository.OdinDatabaseSingleTon;

public class ListScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenance_list);

        OdinDatabase db = OdinDatabaseSingleTon.getInstance(getApplicationContext());

        // The process of list view
        MaintenanceListAdapter adapter = new MaintenanceListAdapter(this, new ArrayList<>());
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        db.wordDao()
                .getAll()
                .observe(this, new Observer<List<Word>>() {
                    @Override
                    public void onChanged(List<Word> allWords) {
                        adapter.clear();
                        adapter.addAll(allWords);
                        adapter.notifyDataSetChanged();
                    }
                });


        // the button control to back to the top maintenance screen
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
