package com.jimguo.foodorderapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SecondActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_activity);
		Intent intent = getIntent();
		int myAge = intent.getIntExtra("com.jimguo.foodorderapp.MyAge",15);
		System.out.println("My age get from the first Activity is "+myAge);
	}
	

}
