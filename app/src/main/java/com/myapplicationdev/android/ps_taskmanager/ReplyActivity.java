package com.myapplicationdev.android.ps_taskmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.RemoteInput;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class ReplyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply);

        CharSequence reply = null;
        Intent intent = getIntent();
        Bundle remoteInput = RemoteInput.getResultsFromIntent(intent);
        if (remoteInput != null){
            reply = remoteInput.getCharSequence("status");
        }

        if(reply != null){
            Toast.makeText(ReplyActivity.this, "You have indicated: " + reply,
                    Toast.LENGTH_SHORT).show();

            String s1 = reply.toString();
            Log.d("String reply", s1+ " TEST");
            if(s1.equalsIgnoreCase("Completed")){

                DBHelper dbh = new DBHelper(ReplyActivity.this);
                int size = dbh.getTasks().size();
                dbh.deleteNote(dbh.getTasks().get(size-1).getId());
                dbh.close();
                Log.d("Success", "IT WORKS!!!");

            }
            finish();
        }

    }
}