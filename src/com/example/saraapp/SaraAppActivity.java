package com.example.saraapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SaraAppActivity extends Activity {
    /** Called when the activity is first created. */
  //  public final static String EXTRA_MESSAGE = "com.example.myapp.MESSAGE";
	private View selected_item = null;
    private int offset_x = 0;
    private int offset_y = 0;
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
      
        ViewGroup vg = (ViewGroup)findViewById(R.id.vg);
        vg.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getActionMasked()) {
                    case MotionEvent.ACTION_MOVE:
                        int x = (int)event.getX() - offset_x;
                        int y = (int)event.getY() - offset_y;

                        int w = getWindowManager().getDefaultDisplay().getWidth() - 100;
                        int h = getWindowManager().getDefaultDisplay().getHeight() - 100;
                        if(x > w)
                            x = w;
                        if(y > h)
                            y = h;
                        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        new ViewGroup.MarginLayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT));
                                lp.setMargins(x, y, 0, 0);

                        selected_item.setLayoutParams(lp);
                        break;
                    default:
                        break;
                }
                return true;
            }
});
ImageView img = (ImageView)findViewById(R.id.img);
img.setOnTouchListener(new View.OnTouchListener() {
           
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                    switch(event.getActionMasked())
                    {
                            case MotionEvent.ACTION_DOWN:
                                    offset_x = (int)event.getX();
                                    offset_y = (int)event.getY();
                                    selected_item = v;
                                    break;
                            default:
                                    break;
                    }
                   
                    return false;
            }
    });
}

        
    }
    /** Called when the user selects the Send button */
    //public void sendMessage(View v) {
    	  //  Intent intent = new Intent(this, DisplayMessageActivity.class);
    	 //   EditText editText = (EditText) findViewById(R.id.edit_message);
    	 //   String message = editText.getText().toString();
    	//    intent.putExtra(EXTRA_MESSAGE, message);
    	 //   startActivity(intent);
    //	}
    
