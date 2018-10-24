package com.example.user.helloworld2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import java.io.IOException;
import java.util.UUID;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_upload:
                    Intent intent = new Intent(SearchActivity.this, UploadActivity.class);
                    startActivity(intent);
                    finish();
                    return true;
                case R.id.navigation_formats:
                    Intent intent2 = new Intent(SearchActivity.this, FormatsActivity.class);
                    startActivity(intent2);
                    finish();
                    return true;
                case R.id.navigation_search:
                    Intent intent3 = new Intent(SearchActivity.this, SearchActivity.class);
                    startActivity(intent3);
                    finish();
                    return true;
            }
            return false;
        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formats);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { switch(item.getItemId()) {
        case R.id.logout:
            Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
            signOut();
            Intent intent_temp = new Intent(SearchActivity.this, LoginActivity.class);
            startActivity(intent_temp);
            finish();
            return(true);

    }
        return(super.onOptionsItemSelected(item));
    }

    private FirebaseAuth auth =  FirebaseAuth.getInstance();


    public void signOut() {
        auth.signOut();
    }

}
