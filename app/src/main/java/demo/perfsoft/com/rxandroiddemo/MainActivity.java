package demo.perfsoft.com.rxandroiddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {
    private EditText etData;
    private Button btnEmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEmit = (Button) findViewById(R.id.btnEmit);
        etData = (EditText) findViewById(R.id.etData);

        emitData();
    }

    private void emitData() {
        btnEmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = etData.getText().toString();
                Observable<String> myObservable = Observable.just(data);

                Observer<String> myObserver = new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull String s) {
                        Toast.makeText(MainActivity.this, "Has cached data: " +s, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                };

                myObservable.subscribe(myObserver);
            }
        });
    }
}
