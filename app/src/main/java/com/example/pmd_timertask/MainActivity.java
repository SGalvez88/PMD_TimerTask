package com.example.pmd_timertask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Tarea tarea = new Tarea();
        timer.schedule(tarea,1000,3000);

    }

    public class Tarea extends TimerTask {
        int contador;
        Timer timer;

        @Override
        public void run() {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "Tarea Finalizada", Toast.LENGTH_SHORT).show();
                    contador++;
                    if (contador > 5) timer.cancel();
                }
            });
        }
    }
}


