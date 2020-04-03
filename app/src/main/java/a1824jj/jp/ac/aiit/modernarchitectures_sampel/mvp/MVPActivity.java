package a1824jj.jp.ac.aiit.modernarchitectures_sampel.mvp;

import a1824jj.jp.ac.aiit.modernarchitectures_sampel.R;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class MVPActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        setTitle("MVP Activity");
    }

    public static Intent getIntent(Context context){
        return new Intent(context, MVPActivity.class);
    }
}
