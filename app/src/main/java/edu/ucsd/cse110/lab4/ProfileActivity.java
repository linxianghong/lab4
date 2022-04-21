package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        this.loadProfile();


    }

   @Override
   protected void onDestroy(){
        super.onDestroy();
        saveProfile();
   }

   public void loadProfile(){
       SharedPreferences preferences = getPreferences(MODE_PRIVATE);
       TextView name = findViewById(R.id.name_textView);
       TextView status = findViewById(R.id.status_textView);

       name.setText(preferences.getString("name", name.getText().toString()));
       status.setText(preferences.getString("status", status.getText().toString()));

       //
   }
   public void saveProfile(){

       TextView name = findViewById(R.id.name_textView);
       TextView status = findViewById(R.id.status_textView);

       SharedPreferences preferences = getPreferences(MODE_PRIVATE);
       SharedPreferences.Editor editor = preferences.edit();
       editor.putString("name", name.getText().toString());
       editor.putString("status", status.getText().toString());

       editor.apply();
   }

    public void goBackMainActivity(View view) {
        finish();
    }
}