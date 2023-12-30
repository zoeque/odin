package zoeque.odin.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import zoeque.odin.R;
import zoeque.odin.domain.entity.Word;
import zoeque.odin.domain.repository.OdinDatabase;
import zoeque.odin.domain.repository.OdinDatabaseSingleTon;
import zoeque.odin.service.DeleteWordAsyncTaskExecutor;

public class MaintenanceListAdapter extends ArrayAdapter<Word> {
    private LayoutInflater inflater;
    Context context;

    public MaintenanceListAdapter(Context context, List<Word> words) {
        super(context, 0, words);
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.word_list_maintenance, parent, false);
        }

        Word word = getItem(position);

        Button buttonToDelete = convertView.findViewById(R.id.button_to_delete);
        TextView textViewWord = convertView.findViewById(R.id.text_view_word);
        TextView textViewMeaning = convertView.findViewById(R.id.text_view_meaning);

        textViewWord.setText(word.getWord());
        textViewMeaning.setText(word.getMeaning());

        OdinDatabase db = OdinDatabaseSingleTon.getInstance(this.context);
        buttonToDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteWordAsyncTaskExecutor
                        .getDatabaseWriteExecutor()
                        .execute(new Runnable() {
                    @Override
                    public void run() {
                        db.wordDao().delete(word);
                        ((Activity) context).runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                remove(word);
                                notifyDataSetChanged();
                            }
                        });
                    }
                });
            }
        });

        return convertView;
    }
}