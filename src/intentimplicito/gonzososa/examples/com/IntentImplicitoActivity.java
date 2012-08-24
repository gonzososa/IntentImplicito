package intentimplicito.gonzososa.examples.com;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class IntentImplicitoActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public void callIntent (View view)
    {
    	Intent intent = null;
    	
    	try {
	    	switch (view.getId ()) {  
		    	case R.id.Button01: 
		    		intent = new Intent (Intent.ACTION_VIEW, Uri.parse("http://www.gmail.com"));
		    		break;
		    	case R.id.Button02:
		    		intent = new Intent (Intent.ACTION_CALL, Uri.parse("tel:(+49)12345789"));
		    		break;
		    	case R.id.Button03:
		    		intent = new Intent (Intent.ACTION_DIAL, Uri.parse("tel:(+49)12345789"));
		    		break;
		    	case R.id.Button04:
		    		intent = new Intent (Intent.ACTION_VIEW, Uri.parse("geo:50.123,7.1434?z=19"));
		    		break;
		    	case R.id.Button05:
		    		intent = new Intent (Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=query"));
		    		break;
		    	case R.id.Button06:
		    		intent = new Intent (Intent.ACTION_VIEW, Uri.parse("android.media.action.IMAGE_CAPTURE"));
		    		break;
		    	case R.id.Button07:
		    		intent = new Intent (Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
		    		break;
		    	default:
		    		return;
	    	}
	    	
	    	startActivity (intent);
	    	
    	} catch (Exception ex) {
    		Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
    	
    	}
    }
    
    @Override
    public void onActivityResult (int requestCode, int resultCode, Intent data)
    {
    	if (resultCode == Activity.RESULT_OK && requestCode == 0) {
    		String result = data.toURI ();
    		Toast.makeText(this, result, Toast.LENGTH_LONG).show ();
    	}
    }
}