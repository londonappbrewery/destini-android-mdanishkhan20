package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    Button mButtonTop;
    Button mButtonBottom;
    TextView mTextView;
    int mTopClick;
    int mBottomClick;
    // TODO: Create Objects of Model Class and link with string resources
    Story mStory[] = new Story[]{
            new Story(R.string.T1_Story,R.string.T1_Ans1,R.string.T1_Ans2),
            new Story(R.string.T2_Story,R.string.T2_Ans1,R.string.T2_Ans2),
            new Story(R.string.T3_Story,R.string.T3_Ans1,R.string.T3_Ans2)
    };

    EndingClass end[] = new EndingClass[]{
            new EndingClass(R.string.T4_End),
            new EndingClass(R.string.T5_End),
            new EndingClass(R.string.T6_End)
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);
        mTextView = (TextView) findViewById(R.id.storyTextView);




        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateScreen(true);

            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateScreen(false);

            }
        });

    }
    public void updateScreen(boolean click){
        if(click == true){
            if(mTopClick == 0) {
                mTextView.setText(mStory[2].getStory());
                mButtonTop.setText(mStory[2].getAns1());
                mButtonBottom.setText(mStory[2].getAns2());
                }else if(mTopClick == 1){
                mTextView.setText(R.string.T6_End);
                mButtonTop.setText("Happy Ending!");
                mButtonBottom.setVisibility(Button.GONE);
                exitCall();

                }
                mTopClick = mTopClick + 1;
           }else if(click == false){
                if(mBottomClick == 0 && mTopClick == 1) {
                    mTextView.setText(R.string.T5_End);
                    mButtonTop.setVisibility(Button.GONE);
                    mButtonBottom.setText("Dead Man");
                    exitCall();

                }else if (mBottomClick == 0){
                    mTextView.setText(mStory[1].getStory());
                    mButtonTop.setText(mStory[1].getAns1());
                    mButtonBottom.setText(mStory[1].getAns2());
                }
            else if(mBottomClick == 1 && mTopClick == 1) {
                    mTextView.setText(R.string.T5_End);
                    mButtonTop.setVisibility(Button.GONE);
                    mButtonBottom.setText("Dead Man");
                    exitCall();

                }else if(mTopClick == 0 && mBottomClick == 1){
                    mTextView.setText(R.string.T4_End);
                    mButtonTop.setText("Okay");
                    mTopClick = 100;
                    mButtonBottom.setVisibility(Button.GONE);
                    exitCall();
                }
                mBottomClick = mBottomClick + 1;
        }
    }

    public void exitCall(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                finish();
            }
        }, 3000);
    }
}
