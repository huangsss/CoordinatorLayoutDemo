 package huangasys.com.materdesigndemo;

 import android.graphics.Color;
 import android.os.Build;
 import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
 import android.view.View;
 import android.view.Window;
 import android.view.WindowManager;

 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //activity_coordinator_test -- CoordinatorLayout练习;
        //activity_main -- CoordinatorLayout - Appbar - CollapsingToolbarLayout - Toolbar - FloatingActionButton联动;
        // -----具体效果运行一下就明白了-------测试

/*        View decorView = getWindow().getDecorView();
        int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        decorView.setSystemUiVisibility(option);
        getWindow().setStatusBarColor(Color.TRANSPARENT);*/
     /*   if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }*/
        StatusBarUtil.darkMode(this);
        setContentView(R.layout.activity_main);
    }
}
