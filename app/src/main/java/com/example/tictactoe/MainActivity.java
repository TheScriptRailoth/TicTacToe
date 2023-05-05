package com.example.tictactoe;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean iswinner=false;
    int imageclick=-1;
    int player=1;
    int [][]winstates={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int []gamestates={-1,-1,-1,-1,-1,-1,-1,-1,-1};
    public void load(View view)
    {
        if(iswinner==false && imageclick==-1) {
            ImageView v = (ImageView) view;
            int tag = Integer.parseInt(v.getTag().toString());
            imageclick=gamestates[tag];
            if (player == 1) {
                v.setImageResource(R.drawable.x);
                gamestates[tag] = player;
                Toast.makeText(this, tag + " " + "Cross", Toast.LENGTH_SHORT).show();
                player = 0;
            } else {
                v.setImageResource(R.drawable.o);
                gamestates[tag] = player;
                Toast.makeText(this, tag + " " + "Zero", Toast.LENGTH_SHORT).show();
                player = 1;
            }
            for (int i = 0; i < winstates.length; i++) {
                if (gamestates[winstates[i][0]] == gamestates[winstates[i][1]] && gamestates[winstates[i][1]] == gamestates[winstates[i][2]] && gamestates[winstates[i][0]] > -1) {
                    Toast.makeText(this, "Winnner is Player" + (player == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
                    iswinner=true;
                }
            }
        }
    }
    public void reset(View view)
    {
        GridLayout gridLayout=findViewById(R.id.grid_layout);
        int total=gridLayout.getChildCount();
        for(int i=0;i<total;i++)
        {
            ImageView v= (ImageView) gridLayout.getChildAt(i);
            v.setImageDrawable(null);
        }
        iswinner=false;
        imageclick=-1;
        player=1;
        for(int i=0;i< gamestates.length;i++)
            gamestates[i]=-1;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}