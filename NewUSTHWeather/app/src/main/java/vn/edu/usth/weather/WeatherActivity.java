package vn.edu.usth.weather;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class WeatherActivity extends AppCompatActivity {

    public static final String TAG = "Weather Activity";
    ImageButton sb;
    ImageButton rb;
    ViewPager2 viewPager2;
    TabLayout tabLayout;

    public void setTabDivider() {
        View root = tabLayout.getChildAt(0);
        if (root instanceof LinearLayout) {
            ((LinearLayout) root).setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
            GradientDrawable drawable = new GradientDrawable();
            drawable.setColor(Color.BLACK);
            drawable.setSize(2, 1);
            ((LinearLayout) root).setDividerPadding(10);
            ((LinearLayout) root).setDividerDrawable(drawable);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_weather);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Log.i(TAG, "onCreate: ");
        viewPager2 = findViewById(R.id.view_pager);
        PagerAdapter adapter = new PagerAdapter(this);
        viewPager2.setAdapter(adapter);
        viewPager2.setOffscreenPageLimit(3);
        tabLayout = findViewById(R.id.tab_layout);
        setTabDivider();

        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("HANOI, VIETNAM");
                    break;
                case 1:
                    tab.setText("PARIS, FRANCE");
                    break;
                case 2:
                    tab.setText("TOULOUSE, FRANCE");
                    break;
            }
        }).attach();

        ImageButton sb = findViewById(R.id.setting_button);
        sb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Setting!");
            }
        });

        ImageButton rb = findViewById(R.id.refresh_button);
        rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Refresh!");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }
}