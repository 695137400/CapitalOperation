package com.capital.operation;

import com.uzmap.pkg.openapi.ExternalActivity;

import android.os.Bundle;

public class WebPageModule extends ExternalActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public void onBackPressed() {
		finish();
		super.onBackPressed();
		
	}
}
