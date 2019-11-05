package project.qhacks.com.qhacksfirebaseauth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText enterUserEmail = (EditText) findViewById(R.id.emailEditText);
        EditText enterUserPassword = (EditText) findViewById(R.id.passwordEditText);
        Button signInButton = (Button) findViewById(R.id.signInButton);
    }
}
