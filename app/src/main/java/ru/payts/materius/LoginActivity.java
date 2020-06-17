package ru.payts.materius;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {
    Button loginButton;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prepareFullScreenWindow();
        setContentView(R.layout.activity_login);
        InitViews();

    }

    private void InitViews() {
        loginButton = findViewById(R.id.buttonLogin);
        editText = findViewById(R.id.editTextName);
        loginButton.setOnClickListener(view -> {
            String nickname = editText.getText().toString();
            if (nickname.isEmpty()){
                Snackbar.make(view, "Field couldn't be empty!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
            else
            {// Start Basic Activity
                startDetailsActivity(nickname);
            }

        });
    }

    private void prepareFullScreenWindow() {
        // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActionBar actionBar = getSupportActionBar ();
        if (actionBar!=null){
            actionBar.hide();
        }
    }

    public void startDetailsActivity(String nickname) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("nickname", nickname);
        startActivity(intent);
    }

    public void closeButton(View view) {
        this.finish();
    }
}