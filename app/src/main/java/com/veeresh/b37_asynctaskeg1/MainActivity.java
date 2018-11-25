package com.veeresh.b37_asynctaskeg1;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startTask(View view) {
        //WE WILL START ASYNC TASK HERE
        MyTask myTask = new MyTask();
        myTask.execute(10);
    }
    //CREATE ASYNC TASK - inner class
    public class MyTask extends AsyncTask<Integer, Character, Boolean>{
        @Override
        protected void onPreExecute() { //RUNS ON MAIN THREAD
            super.onPreExecute();
            Toast.makeText(MainActivity.this, "1", Toast.LENGTH_SHORT).show();
            Log.d("B37","ASYNC - ONPRE EXECUTE");
        }
        @Override
        protected Boolean doInBackground(Integer... integers) {
            //RUNS ON WORKER THREAD [BACKGROUND THREAD]
            //Toast.makeText(MainActivity.this, "2", Toast.LENGTH_SHORT).show();
            Log.d("B37","ASYNC - DO IN BG.."+integers[0]);
            publishProgress('a');
            return true;
        }
        @Override
        protected void onProgressUpdate(Character... values) { //RUNS ON MAIN THREAD
            super.onProgressUpdate(values);
            Log.d("B37","ASYNC - ON PROGRESS UPDATE.."+values[0]);
            Toast.makeText(MainActivity.this, "3", Toast.LENGTH_SHORT).show();
        }
        @Override
        protected void onPostExecute(Boolean aBoolean) { //RUNS ON MAIN THREAD
            super.onPostExecute(aBoolean);
            Log.d("B37","ASYNC - ON POST EXECUTE.."+aBoolean);
            Toast.makeText(MainActivity.this, "4", Toast.LENGTH_SHORT).show();
        }
    }
}
