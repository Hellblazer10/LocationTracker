package viet.umesh.locationtracker;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Button btn_signIn;
    private static final int LOGIN_PERMISSION = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_signIn = findViewById(R.id.btn_sign_in);
        btn_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(Arrays.asList(
                                new AuthUI.IdpConfig.EmailBuilder().build()
                        )).build();
                startActivityForResult(i, LOGIN_PERMISSION);


            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == LOGIN_PERMISSION){
            startNewActivity(resultCode, data);
        }
    }

    private void startNewActivity(int resultCode, Intent data){
        if(resultCode == RESULT_OK){


            Intent intent = new Intent(MainActivity.this, ListOnline.class);
            startActivity(intent);
            finish();

        }else{
            Toast.makeText(this, "LOGIN FAILED", Toast.LENGTH_SHORT).show();
        }
    }
}
