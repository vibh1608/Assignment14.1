package com.example.user.assignment141;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.locks.ReadWriteLock;

public class MainActivity extends AppCompatActivity {

    //creating reference for buttons
    Button savefile,checkfile;

    //onCreate method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting reference with their ID's
        savefile = findViewById(R.id.save);
        checkfile = findViewById(R.id.check);

        //onClick of SAVE FILE button
        savefile.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                try
                {
                    //Opening the file FileOutputStream
                    FileOutputStream fileOutputStream = openFileOutput("mytextfile",MainActivity.MODE_PRIVATE);

                    //OutputStreamWriter to write in the file.
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);

                    //writing in file
                    outputStreamWriter.write("Hello World !");

                    //closing file
                    outputStreamWriter.close();

                    //displaying toast message
                    Toast.makeText(MainActivity.this,"Data saved in file ",Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

        //onclick of CHECK FILE button
        checkfile.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                try
                {
                    //checking file by opening it
                    FileInputStream fileInputStream = openFileInput("mytextfile");

                    //displaying toast
                    Toast.makeText(MainActivity.this,"File exists",Toast.LENGTH_SHORT).show();

                }
                catch (FileNotFoundException e)
                {
                    //displaying toast
                    Toast.makeText(MainActivity.this,"File does not exists",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
