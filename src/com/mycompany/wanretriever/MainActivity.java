package com.mycompany.wanretriever;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import org.jsoup.nodes.*;
import org.jsoup.*;
import java.io.*;
import android.util.*;

public class MainActivity extends Activity
{
	String title;
	String body;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
		Thread downloadThread = new Thread() {                     
			public void run() {                                    
				System.out.print("THIS IS THE TITLE ");                       
				
				Document doc;                                      
				try {                                              
					Connection.Response response = Jsoup.connect("http://www.google.com").timeout(7000).execute();
				   doc = response.parse();
				   title = doc.title(); 
				   body = doc.html();           
					Log.d("WANRetriever",title);	
					Log.d("WANRetriever",body);
				} catch (IOException e) {                          
					e.printStackTrace();        
				}                                                  
			}   
			
		};                                                         
		
		downloadThread.start();                                    
		
        setContentView(R.layout.main);
    
		//Toast sizeToast = Toast.makeText(getApplicationContext(),title,10000000);
		//sizeToast.show();
		
	}
}
