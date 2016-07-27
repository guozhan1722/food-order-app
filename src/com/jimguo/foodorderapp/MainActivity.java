package com.jimguo.foodorderapp;

import redis.clients.jedis.Jedis;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

	public TextView textView;
	public Button button;
	public EditText editText;
	public Thread jedisThread;
	public String val;
	public Jedis jedis;
	
	public class JedisRunnable implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try{
				jedis.set("myInfo",val);
			}catch (Exception e){
				e.printStackTrace();
			}
		}

	}
	
    class ButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
	        jedisThread = new Thread(new JedisRunnable());
			jedisThread.start();
			val = editText.getText()+"";
			textView.setText(val);
			editText.setText("");
		}
    	
    }

	protected void init()
	{
        textView = (TextView)findViewById(R.id.textView1);
        button = (Button)findViewById(R.id.button1);
        editText = (EditText)findViewById(R.id.editText1);
        jedis = new Jedis("192.168.216.114");
        
        
        OnClickListener buttonListener = new ButtonListener();
        button.setOnClickListener(buttonListener);
        
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
}
