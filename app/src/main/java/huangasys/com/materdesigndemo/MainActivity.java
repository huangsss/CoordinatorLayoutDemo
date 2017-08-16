 package huangasys.com.materdesigndemo;

 import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //activity_coordinator_test -- CoordinatorLayout练习;
        //activity_main -- CoordinatorLayout - Appbar - CollapsingToolbarLayout - Toolbar - FloatingActionButton联动;
        // -----具体效果运行一下就明白了-------
        setContentView(R.layout.activity_main);

    }
}
