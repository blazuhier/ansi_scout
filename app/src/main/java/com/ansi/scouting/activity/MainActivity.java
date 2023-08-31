package com.ansi.scouting.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import com.ansi.scouting.R;
import com.google.firebase.messaging.FirebaseMessaging;

/**
 * <p>
 *     Splash activity.
 * </p>
 */
public class MainActivity extends AppCompatActivity {

    /**
     *Image logo scout
     */
    private ImageView ivLogo;

    /**
     *Instance to animate splash logo.
     */
    private ObjectAnimator animator;

    /**
     *Instance to set velocity to splash logo.
     */
    public long animationDuration = 6000;


    /**
     * Main method for create splash activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        initFields();
    }

    /**
     * Method for init all activity fields.
     */
    public void initFields(){
        ivLogo = findViewById(R.id.iv_logo);
        animation();
        refreshFirebasePushNotificationTokens();
    }

    /**
     * Method for init animation scout logo.
     */
    public void animation() {
        //**** Init launch app *****
        animator = ObjectAnimator.ofFloat(ivLogo, View.ALPHA, 0.0f, 0.9f);
        animator.setDuration(animationDuration);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(animator);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });
    }

    public void refreshFirebasePushNotificationTokens() {
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(task -> {
                    if (!task.isSuccessful()) {
                        Log.w("FIREBASE_PUSH_TOKEN", "Fetching FCM registration token failed", task.getException());
                        return;
                    }

                    // Get new FCM registration token
                    String token = task.getResult();

                    Log.d("FIREBASE_PUSH_TOKEN", token);
                });
    }
}