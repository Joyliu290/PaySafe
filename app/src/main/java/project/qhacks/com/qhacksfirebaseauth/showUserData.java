package project.qhacks.com.qhacksfirebaseauth;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class showUserData extends AppCompatActivity {

    EditText getUserID;
    EditText getUserPayee;
    TextView userBalance;
    TextView userPayee;
    EditText getNewPayeeName;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_user_data);

        getUserID = (EditText) findViewById(R.id.getUserIDEditText);
        userBalance = (TextView)findViewById(R.id.TextViewShowUserBalance);
        userPayee = (TextView)findViewById(R.id.TextViewShowUserPayee);
        getUserPayee = (EditText)findViewById(R.id.getUserPayeeEditText);
        getNewPayeeName = (EditText)findViewById(R.id.addNewPayeeNameEditText);

        Button seeData = (Button) findViewById(R.id.buttonToSeeData);
        seeData.setOnClickListener((View view)->{
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("user");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               for(DataSnapshot ds: dataSnapshot.getChildren()){
                   String key = (String) ds.getKey();
                   String userIDString = getUserID.getText().toString();
                   String userPayeeString = getUserPayee.getText().toString();

                   if (key.equals(userIDString)){
                       DatabaseReference keyReference = FirebaseDatabase.getInstance().getReference().child("user").child(key);
                       keyReference.addValueEventListener(new ValueEventListener() {
                           @Override
                           public void onDataChange(DataSnapshot dataSnapshot) {
                              String balanceText = dataSnapshot.child("balance").getValue(String.class);
                               userBalance.setText(balanceText);

                               for (DataSnapshot dataSnapshotUser: dataSnapshot.child("payee").getChildren()){
                                   if (dataSnapshotUser.getValue().equals(userPayeeString)){
                                       userPayee.setText(dataSnapshotUser.getValue(String.class));
                                   }
                               }
                           }

                           @Override
                           public void onCancelled(DatabaseError databaseError) {
                           }
                       }); // [End of keyReference]
                       break;
                   }

               }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        });
    }
}
