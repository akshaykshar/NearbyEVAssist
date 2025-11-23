package com.nearby.evassist.presentation.splash;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import com.nearby.evassist.R;
import com.nearby.evassist.presentation.main.MainActivity;
public class SplashActivity extends ComponentActivity {
    @Override protected void onCreate(Bundle s){
        super.onCreate(s);
        setTheme(R.style.Theme_NearbyEVAssist_Splash);
        setContentView(R.layout.activity_splash);
        // simple 1.2s splash then main
        findViewById(R.id.ivLogo).postDelayed(() -> startActivity(new Intent(this, MainActivity.class)), 1200);
    }
}
