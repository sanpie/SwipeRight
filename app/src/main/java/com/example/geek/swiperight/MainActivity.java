package com.example.geek.swiperight;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Debug;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView t1,t2,t3,t4,t5,t6;
    int counter=40,thresold=3,score=0,time,flag,min=0,set=0,incre=1,total=0,last=0;
    ImageView im1,im2,im3,im4,im5;
    float x1,x2;
    RelativeLayout r1;

    float y1, y2;
    float diffx, diffy;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r1=(RelativeLayout)findViewById(R.id.rootlayot);
        b1=(Button)findViewById(R.id.button);
        t6=(TextView)findViewById(R.id.textView6);
        t1=(TextView)findViewById(R.id.textView);  //score
        t2=(TextView)findViewById(R.id.textView3); //time
       t5=(TextView)findViewById(R.id.textView2);
        t3=(TextView)findViewById(R.id.textView4);
        t4=(TextView)findViewById(R.id.textView5);
        im1=(ImageView)findViewById(R.id.imageView);
        im2=(ImageView)findViewById(R.id.imageView2);
        im3=(ImageView)findViewById(R.id.imageView3);
        im4=(ImageView)findViewById(R.id.imageView4);
        im5=(ImageView)findViewById(R.id.imageView5);
        t2.setText(counter+"");
        t1.setText(set+"");
        im5.setVisibility(View.INVISIBLE);
       Integer[] imid={R.drawable.left ,R.drawable.right, R.drawable.up , R.drawable.down , R.drawable.question};
        random1();
        FillDataTask f=new FillDataTask();
        f.execute();
        Snackbar.make(r1,"swipe in missing arrow direction", Snackbar.LENGTH_LONG).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showToastMessage(String text, int duration){
        final Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        toast.show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        }, duration);
    }

    private class FillDataTask extends AsyncTask<Context, Integer, String> {

        @Override
        protected String doInBackground(Context... params) {
for(int i=0;i<counter;) {
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    runOnUiThread(new Runnable() {
        public void run() {
            t2.setText(counter+"");
        }
    });
    counter--;
}
                return "s";
        }
        @Override
        protected void onPostExecute(String value) {
            super.onPostExecute(value);
            // dismiss the dialog once done
            t1.setVisibility(View.INVISIBLE);
            t6.setVisibility(View.INVISIBLE);
            t2.setVisibility(View.INVISIBLE);
            t3.setVisibility(View.VISIBLE);
            t4.setVisibility(View.VISIBLE);
            t4.setText("Score : " + set);
            t5.setVisibility(View.INVISIBLE);
            im1.setVisibility(View.INVISIBLE);
            im2.setVisibility(View.INVISIBLE);
            im3.setVisibility(View.INVISIBLE);
            im4.setVisibility(View.INVISIBLE);
            b1.setVisibility(View.VISIBLE);


        }
    }
    public void playagain(View v)
    {
       Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);

    }

    public void random1() {
        ArrayList<Integer> list = new ArrayList<>(5);
        for (int i = 0; i <= 3; i++){
            list.add(i);
        }
        int[] a = new int[4];
        for (int count = 0; count < 4; count++){
            a[count] = list.remove((int)(Math.random() * list.size()));
        }
        for (int count = 0; count < 4; count++){
            if(count==0){
                if(a[count]==0){
                    im1.setImageResource(R.drawable.up);
                }
                if(a[count]==1){
                    im1.setImageResource(R.drawable.down);
                }
                if(a[count]==2){
                    im1.setImageResource(R.drawable.left);
                }
                if(a[count]==3){
                    im1.setImageResource(R.drawable.right);
                }
            }
            if(count==1){
                if(a[count]==0){
                    im3.setImageResource(R.drawable.up);
                }
                if(a[count]==1){
                    im3.setImageResource(R.drawable.down);
                }
                if(a[count]==2){
                    im3.setImageResource(R.drawable.left);
                }
                if(a[count]==3){
                    im3.setImageResource(R.drawable.right);
                }
            }
            if(count==2){
                if(a[count]==0){
                    im4.setImageResource(R.drawable.up);
                }
                if(a[count]==1){
                    im4.setImageResource(R.drawable.down);
                }
                if(a[count]==2){
                    im4.setImageResource(R.drawable.left);
                }
                if(a[count]==3){
                    im4.setImageResource(R.drawable.right);
                }
            }
            if(count==3){
                if(a[count]==0){
                    im2.setImageResource(R.drawable.up);
                }
                if(a[count]==1){
                    im2.setImageResource(R.drawable.down);
                }
                if(a[count]==2){
                    im2.setImageResource(R.drawable.left);
                }
                if(a[count]==3){
                    im2.setImageResource(R.drawable.right);
                }
            }
        }
        ArrayList<Integer> list2 = new ArrayList<>(5);
        for (int i = 0; i <= 3; i++){
            list2.add(i);
        }
        int[] b = new int[4];
        for (int count = 0; count < 4; count++){
            b[count] = list2.remove((int)(Math.random() * list2.size()));
        }
        for(int i=0;i<4;i++){
            if(b[i]==0){
                if(a[i]==0){//replace up arrow
                    if(i==0){//up position
                        im1.setImageResource(R.drawable.question);

                    }
                    if(i==1){//down position
                        im3.setImageResource(R.drawable.question);

                    }
                    if(i==2){//left position
                        im4.setImageResource(R.drawable.question);

                    }
                    if(i==3){//right position
                        im2.setImageResource(R.drawable.question);

                    }
                    flag=3;
                }
                if(a[i]==1){//replace up arrow
                    if(i==0){//up position
                        im1.setImageResource(R.drawable.question);

                    }
                    if(i==1){//down position
                        im3.setImageResource(R.drawable.question);

                    }
                    if(i==2){//left position
                        im4.setImageResource(R.drawable.question);

                    }
                    if(i==3){//right position
                        im2.setImageResource(R.drawable.question);

                    }
                    flag=4;
                }
                if(a[i]==2){//replace up arrow
                    if(i==0){//up position
                        im1.setImageResource(R.drawable.question);

                    }
                    if(i==1){//down position
                        im3.setImageResource(R.drawable.question);

                    }
                    if(i==2){//left position
                        im4.setImageResource(R.drawable.question);

                    }
                    if(i==3){//right position
                        im2.setImageResource(R.drawable.question);

                    }
                    flag=1;
                }
                if(a[i]==3){//replace up arrow
                    if(i==0){//up position
                        im1.setImageResource(R.drawable.question);

                    }
                    if(i==1){//down position
                        im3.setImageResource(R.drawable.question);

                    }
                    if(i==2){//left position
                        im4.setImageResource(R.drawable.question);

                    }
                    if(i==3){//right position
                        im2.setImageResource(R.drawable.question);

                    }
                    flag=2;
                }
            }
        }

    }
    @Override
    public boolean onTouchEvent(MotionEvent touchevent)
    {
        switch (touchevent.getAction())
        {
            // when user first touches the screen we get x and y coordinate
            case MotionEvent.ACTION_DOWN:
            {
                x1 = touchevent.getX();
                y1 = touchevent.getY();
                break;
            }
            case MotionEvent.ACTION_UP:
            {
                x2 = touchevent.getX();
                y2 = touchevent.getY();
                diffx = x2-x1;
                diffy = y2-y1;

                //if left to right sweep event on screen
                if (x1 < x2 && Math.abs(diffy) < Math.abs(diffx))
                {

                    if(flag==2)
                    {

                        random1();
                        set=set+incre;
                        t1.setText(set + "");
                        showToastMessage("+"+incre, 100);
                        if(total==last)
                        {
                            min++;
                            if(min>=thresold)
                            {
                                incre++;
                                min=0;
                            }
                        }
                        total++;
                        last=total;


                    }
                    else
                    {
                        showToastMessage("wrong", 100);
                        random1();
                        total++;
                        incre=1;
                        min=0;
                    }

                }

                // if right to left sweep event on screen
                if (x1 > x2 && Math.abs(diffy) < Math.abs(diffx))
                {

                    if(flag==1)
                    {

                        random1();
                        set=set+incre;
                        t1.setText(set + "");

                        showToastMessage("+" + incre, 100);
                        if(total==last)
                        {
                            min++;
                            if(min>=thresold)
                            {
                                incre++;
                                min=0;
                            }
                        }
                        total++;
                        last=total;
                    }
                    else
                    {
                        showToastMessage("wrong", 100);
                        random1();
                        total++;
                        min=0;
                        incre=1;
                    }
                }

                // if UP to Down sweep event on screen
                if (y1 < y2 && Math.abs(diffy) > Math.abs(diffx))
                {

                    if(flag==4)
                    {

                        random1();
                        set=set+incre;
                        showToastMessage("+"+incre, 100);
                        t1.setText(set + "");
                        if(total==last)
                        {
                            min++;
                            if(min>=thresold)
                            {
                                incre++;
                                min=0;
                            }
                        }
                        total++;
                        last=total;
                    }
                    else
                    {
                        showToastMessage("wrong", 100);
                        random1();
                        total++;
                        incre=1;
                        min=0;
                    }
                }

                //if Down to UP sweep event on screen
                if (y1 > y2 && Math.abs(diffy) > Math.abs(diffx))
                {

                    if(flag==3)
                    {

                        random1();
                        set=set+incre;
                        t1.setText(set + "");
                        showToastMessage("+"+incre, 100);
                        if(total==last)
                        {
                            min++;
                            if(min>=thresold)
                            {
                                incre++;
                                min=0;
                            }
                        }
                        total++;
                        last=total;
                    }
                    else
                    {
                        showToastMessage("wrong", 100);
                        random1();
                        total++;
                        incre=1;
                        min=0;
                    }
                }
                break;
            }
        }
        return false;
    }
}
