package a1824jj.jp.ac.aiit.modernarchitectures_sampel;

import a1824jj.jp.ac.aiit.modernarchitectures_sampel.mvc.MVCActivity;
import a1824jj.jp.ac.aiit.modernarchitectures_sampel.mvp.MVPActivity;
import a1824jj.jp.ac.aiit.modernarchitectures_sampel.mvvm.MVVMActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class ArchitecturesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_architectures);
    }

    public void onMVC(View view){
        startActivity(MVCActivity.getIntent(this));
    }

    public void onMVP(View view){
        startActivity(MVPActivity.getIntent(this));
    }

    public void onMVVM(View view){
        startActivity(MVVMActivity.getIntent(this));
    }
}
