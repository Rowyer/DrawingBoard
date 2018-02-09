package com.example.customizetitlebar;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/2/9.
 */

public class TitleActivity extends Activity implements View.OnClickListener {


    private Button blackBtn;
    private Button redBtn;
    private Button blueBtn;
    private Button greenBtn;
    private Button yellowBtn;
    private Button grayBtn;


    private TextView mTitleTextView;
    private Button mBackwardBtn;
    private FrameLayout mContentLayout;

    private  Button mClearBtn;
    private  MyView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupViews();   //加载activity_title布局，并获取标题及两侧按钮
        setPenColor();

    }


    public void setPenColor(){
        blackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mView.p.setColor(Color.BLACK);
            }
        });

        redBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mView.p.setColor(Color.RED);
            }
        });

        blueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mView.p.setColor(Color.BLUE);
            }
        });

        greenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mView.p.setColor(Color.GREEN);
            }
        });

        yellowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mView.p.setColor(Color.YELLOW);
            }
        });

        grayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mView.p.setColor(Color.GRAY);
            }
        });
    }

    private void setupViews() {
        super.setContentView(R.layout.activity_title);


        blackBtn = (Button)findViewById(R.id.button_black);
        redBtn = (Button)findViewById(R.id.button_red);
        blueBtn = (Button)findViewById(R.id.button_blue);
        greenBtn = (Button)findViewById(R.id.button_green);
        yellowBtn = (Button)findViewById(R.id.button_yellow);
        grayBtn = (Button)findViewById(R.id.button_gray);

        mTitleTextView = (TextView)findViewById(R.id.text_title);
        mContentLayout = (FrameLayout)findViewById(R.id.layout_content);
        mBackwardBtn = (Button)findViewById(R.id.button_backward);

        mClearBtn = (Button)findViewById(R.id.button_clear);
        mView =(MyView)findViewById(R.id.draw);
    }


    /**
     *是否显示返回按钮
     *@param backwardResid 显示的文字
     *@param show == true 显示
     */

    protected void showBackwardView(int backwardResid,boolean show){
        if(mBackwardBtn != null){
            if(show){
                mBackwardBtn.setText(backwardResid);
                mBackwardBtn.setVisibility(View.VISIBLE);
            }else{
                mBackwardBtn.setVisibility(View.INVISIBLE);
            }
        }//else ignore

    }

    /**
     *是否显示清除按钮
     * @param clearResid  显示的文字
     * @param show == true  显示
     */
    protected  void showClearView(int clearResid,boolean show){

        if(mClearBtn != null){
            if(show){
                mClearBtn.setText(clearResid);
                mClearBtn.setVisibility(View.VISIBLE);
            }else{
                mClearBtn.setVisibility(View.INVISIBLE);
            }
        }
    }

    /**
     * 返回按钮点击后触发
     * @param backwardView
     */
    protected  void onBackward(View backwardView){

        finish();
    }


    /**
     * 清除按钮点击后触发
     * @param forwardView
     */
    protected  void onClear(View forwardView){
        Toast.makeText(this,"已清除",Toast.LENGTH_LONG).show();
        mView.clear();
    }


    //设置标题内容
    @Override
    public void setTitle(int titleID){
        mTitleTextView.setText(titleID);
    }

    //设置标题内容
    @Override
    public void setTitle(CharSequence title){
        mTitleTextView.setText(title);
    }

    //设置标题文字颜色
    @Override
    public void setTitleColor(int textColor) {
        mTitleTextView.setTextColor(textColor);
    }

    //取出FrameLayout并调用父类removeAllViews()方法
    @Override
    public void setContentView(int layoutResID) {
        mContentLayout.removeAllViews();
        View.inflate(this,layoutResID,mContentLayout);
        onContentChanged();
    }

    @Override
    public void setContentView(View view) {
        mContentLayout.removeAllViews();
        mContentLayout.addView(view);
        onContentChanged();
    }

    /* (non-Javadoc)
     * @see android.app.Activity#setContentView(android.view.View, android.view.ViewGroup.LayoutParams)
     */
    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        mContentLayout.removeAllViews();
        mContentLayout.addView(view,params);
        onContentChanged();
    }

    /* (non-Javadoc)
     * @see android.view.View.OnClickListener#onClick(android.view.View)
     * 按钮点击调用的方法
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_backward:
                onBackward(v);
                break;
            case R.id.button_clear:
                onClear(v);
                break;


            default:
                break;
        }

    }


}
