package a1824jj.jp.ac.aiit.modernarchitectures_sampel.mvc;

import a1824jj.jp.ac.aiit.modernarchitectures_sampel.R;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MVCActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        setTitle("MVC Activity");

        list = findViewById(R.id.list);

        controller = new CountriesController(this);
        retryButton = findViewById(R.id.retryButton);
        progress = findViewById(R.id.progress);

        adapter = new ArrayAdapter<>(this, R.layout.row_layout, R.id.listText, listValues);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MVCActivity.this, "You Clicked " + listValues.get(position), Toast.LENGTH_LONG).show();
            }
        });
    }

    public static Intent getIntent(Context context){
        return new Intent(context, MVCActivity.class);
    }


    private List<String> listValues = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private ListView list;

    public void setValues(List<String> values){
        listValues.clear();
        listValues.addAll(values);
        retryButton.setVisibility(View.GONE);
        progress.setVisibility(View.GONE);
        list.setVisibility(View.VISIBLE);
        adapter.notifyDataSetChanged();
    }

    private CountriesController controller;

    private Button retryButton;
    private ProgressBar progress;

    public void onRetry(View view){
        controller.onRefresh();
        retryButton.setVisibility(View.GONE);
        progress.setVisibility(View.VISIBLE);
        list.setVisibility(View.GONE);
    }

    public void onError() {
        Toast.makeText(MVCActivity.this, "Unable to get country names. Please retry later", Toast.LENGTH_LONG).show();
        retryButton.setVisibility(View.VISIBLE);
        progress.setVisibility(View.GONE);
        list.setVisibility(View.GONE);
    }
}
