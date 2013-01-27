package com.mycompany.wanretriever;
import android.webkit.*;
import android.widget.*;

public class CustomWebViewClient extends WebViewClient
{

	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		if(url.startsWith("http://:")) {
	//		Toast.makeText(WebVie.this, "Custom protocol call", Toast.LENGTH_LONG).show();
			return true;	
		}
		return false;
	}
}
