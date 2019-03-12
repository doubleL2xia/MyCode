package com.example.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button signup=(Button)findViewById(R.id.su);
        Button signin=(Button)findViewById(R.id.si);
       signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SignUp().execute();
                //Log.d("1","1");
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SignIn().execute();
               // Log.d("2","2");
            }
        });
    }

    class SignUp extends AsyncTask<Void,Integer,Boolean>{
        EditText name=(EditText)findViewById(R.id.name);
        EditText pw=(EditText)findViewById(R.id.name);
        protected  Boolean doInBackground(Void... params){
            SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();
            editor.putString("name",name.getText().toString());
            editor.putString("password",pw.getText().toString());
            editor.apply();;
            return true;
        }
        protected void onPostExecute(Boolean result) {
            if (result)
                Toast.makeText(MainActivity.this,"register successful",Toast.LENGTH_SHORT).show();
        }

    }

    class SignIn extends AsyncTask<Void,Integer,Boolean>{
        EditText name=(EditText)findViewById(R.id.name);
        EditText pw=(EditText)findViewById(R.id.name);

        protected  Boolean doInBackground(Void... params){
                    SharedPreferences preferences=getSharedPreferences("data",MODE_PRIVATE);
                    String n=preferences.getString("name","");
                    String p=preferences.getString("password","");
                    if(n.equals(name.getText().toString())&&p.equals(pw.getText().toString())){
                        return true;
                    }
                    else{
                        Log.d("name",n);
                        Log.d("pw",p);
                        return false;
                    }
        }

        protected void onPostExecute(Boolean result) {
            if (result)
                Toast.makeText(MainActivity.this,"successful",Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(MainActivity.this,"failed",Toast.LENGTH_SHORT).show();
        }
    }
}

