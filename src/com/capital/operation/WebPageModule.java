package com.capital.operation;

import android.os.Build;
import android.webkit.WebView;
import com.uzmap.pkg.openapi.ExternalActivity;

import android.os.Bundle;

public class WebPageModule extends ExternalActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			WebView.setWebContentsDebuggingEnabled(true);
		}
		super.onCreate(savedInstanceState);

	}
	
	@Override
	public void onBackPressed() {
		finish();
		super.onBackPressed();
	}
}
