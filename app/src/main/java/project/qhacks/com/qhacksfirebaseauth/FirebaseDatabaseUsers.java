package project.qhacks.com.qhacksfirebaseauth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirebaseDatabaseUsers extends AppCompatActivity {

    EditText userID;
    EditText password;
    EditText payee;
    EditText balance;

    DatabaseReference databaseUsers;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.storing_into_database);

        userID = (EditText)findViewById(R.id.userIDDatabaseEditText);
        password = (EditText)findViewById(R.id.passwordDatabaseEditText);
        payee = (EditText)findViewById(R.id.payeeDatabaseEditText);
        balance = (EditText)findViewById(R.id.balanceDatabaseEditText);

        databaseUsers = com.google.firebase.database.FirebaseDatabase.getInstance().getReference("user");

        Button addDatabase = (Button) findViewById(R.id.databaseAddButton);
        addDatabase.setOnClickListener((View v)->{
            AddUser();
        });

        Button seeData = (Button) findViewById(R.id.goSeeDataButton);
        seeData.setOnClickListener((View v)->{
            Intent intent = new Intent(this, showUserData.class);
            startActivity(intent);
        });

    }

    private void AddUser(){
        String userIDString = userID.getText().toString();
        String passwordString = password.getText().toString();
        String payeeString = payee.getText().toString();
        String[] payeeArray = {payeeString};
        List<String> payeeList = new ArrayList<String>(Arrays.asList(payeeArray));

        UserAttributes userAttributes = new UserAttributes(userIDString, passwordString, payeeList, "$100" );
        databaseUsers.child(userIDString).setValue(userAttributes);
    }
}
