package a1824jj.jp.ac.aiit.modernarchitectures_sampel.mvvm;

import a1824jj.jp.ac.aiit.modernarchitectures_sampel.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

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

public class MVVMActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvm);
        setTitle("MVVM Activity");

        viewModel = new ViewModelProvider(this).get(CountriesViewModel.class);

        list = findViewById(R.id.list);
        retryButton = findViewById(R.id.retryButton);
        progress = findViewById(R.id.progress);
        adapter = new ArrayAdapter<>(this, R.layout.row_layout, R.id.listText, listValues);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MVVMActivity.this, "You Clicked " + listValues.get(position), Toast.LENGTH_LONG).show();
            }
        });

        observeViewModel();
    }

    public static Intent getIntent(Context context){
        return new Intent(context, MVVMActivity.class);
    }

    private List<String> listValues = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private ListView list;
    private CountriesViewModel viewModel;
    private Button retryButton;
    private ProgressBar progress;

    public void onRetry(View view){
        viewModel.onRefresh();
        retryButton.setVisibility(View.GONE);
        progress.setVisibility(View.VISIBLE);
        list.setVisibility(View.GONE);
    }

    private void observeViewModel() {
        viewModel.getCountries().observe(this, countries -> {
            if(countries != null){
                listValues.clear();
                listValues.addAll(countries);
                list.setVisibility(View.VISIBLE);
                adapter.notifyDataSetChanged();
            }else{
                list.setVisibility(View.GONE);
            }
        });

        viewModel.getCountryError().observe(this, error ->{
            progress.setVisibility(View.GONE);
            if(error){
                Toast.makeText(MVVMActivity.this, "Unable to get country names. Please retry later", Toast.LENGTH_LONG).show();
                retryButton.setVisibility(View.VISIBLE);
            }else{
                retryButton.setVisibility(View.GONE);
            }
        });
    }
}
