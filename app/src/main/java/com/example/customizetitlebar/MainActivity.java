package com.example.customizetitlebar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends TitleActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout_color.activity_main);

        setTitle(R.string.application_name);
        showBackwardView(R.string.text_back,true);
        showClearView(R.string.text_forward,true);





    }
}
