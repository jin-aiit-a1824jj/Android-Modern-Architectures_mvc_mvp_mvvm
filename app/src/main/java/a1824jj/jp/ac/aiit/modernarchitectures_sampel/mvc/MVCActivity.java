package a1824jj.jp.ac.aiit.modernarchitectures_sampel.mvc;

import a1824jj.jp.ac.aiit.modernarchitectures_sampel.R;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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
        adapter = new ArrayAdapter<>(this, R.layout.row_layout, R.id.listText, listValues);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MVCActivity.this, "You Clicked " + listValues.get(position), Toast.LENGTH_LONG).show();
            }
        });

        ArrayList<String> vals = new ArrayList<>();
        vals.add("UK");
        vals.add("USA");
        vals.add("France");
        vals.add("Italy");
        vals.add("China");
        vals.add("Japan");
        vals.add("UK");
        vals.add("USA");
        vals.add("France");
        vals.add("Italy");
        vals.add("China");
        vals.add("Japan");
        vals.add("UK");
        vals.add("USA");
        vals.add("France");
        vals.add("Italy");
        vals.add("China");
        vals.add("Japan");
        vals.add("UK");
        vals.add("USA");
        vals.add("France");
        vals.add("Italy");
        vals.add("China");
        vals.add("Japan");
        vals.add("UK");
        vals.add("USA");
        vals.add("France");
        vals.add("Italy");
        vals.add("China");
        vals.add("Japan");
        vals.add("UK");
        vals.add("USA");
        vals.add("France");
        vals.add("Italy");
        vals.add("China");
        vals.add("Japan");
        setValues(vals);
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
        adapter.notifyDataSetChanged();
    }
}
