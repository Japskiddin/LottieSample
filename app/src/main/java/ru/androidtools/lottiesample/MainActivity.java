package ru.androidtools.lottiesample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;

public class MainActivity extends AppCompatActivity {
  private LottieAnimationView animationView;
  private Button btnStartPause;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    animationView = findViewById(R.id.animationView);
    btnStartPause = findViewById(R.id.btnStartPause);
    btnStartPause.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        if (animationView.isAnimating()) {
          animationView.pauseAnimation();
          btnStartPause.setText("Старт");
        } else {
          animationView.resumeAnimation();
          btnStartPause.setText("Пауза");
        }
      }
    });

    animationView.setRepeatCount(LottieDrawable.INFINITE);
    animationView.setRepeatMode(LottieDrawable.REVERSE);
    animationView.setAnimation("anim/scary-cat.json");
    animationView.playAnimation();
  }
}