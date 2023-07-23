package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    //playerID--->1=X turn
    //playerID--->0=O turn

    int[] state ={2,2,2,2,2,2,2,2,2};
    int playerID=1;




    int[][] winning_position ={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void generator(View view){


        ImageView img=(ImageView)view;
        TextView status_bar_text=findViewById(R.id.status_bar);
        status_bar_text.setText(R.string.start_text);

    //    int image_tag=(int)img.getTag();
        int image_tag=Integer.parseInt(img.getTag().toString());

        int clicked_position=image_tag;

        if(state[clicked_position]==2){
            if(playerID==1){
                img.setImageResource(R.drawable.xx);
                status_bar_text.setText(R.string.player_0_turn);
                state[clicked_position]=playerID;
                playerID=0;
            }
            else
            {
                img.setImageResource(R.drawable.oo);
                status_bar_text.setText(R.string.player_x_turn);
                state[clicked_position]=playerID;
                playerID=1;
            }
        }
        else{
            status_bar_text.setText(R.string.space_error);
        }

        int check=check_win(winning_position,state);

        if(check==0 || check==1){
            if(check==0){
                status_bar_text.setText(R.string.winning_0);
            }
            else{
                status_bar_text.setText(R.string.winning_X);

            }

        }

    }

    public void reset_func(View view){

        TextView status_bar_text=findViewById(R.id.status_bar);
        status_bar_text.setText(R.string.start_text);

        ((ImageView)findViewById(R.id.imageView11)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView12)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView13)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView21)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView22)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView23)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView31)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView32)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView33)).setImageResource(0);

        for(int i=0;i<9;i++){
            state[i]=2;
        }

    }

    public int check_win(int[][] winning_position,int [] state){

        for(int[] index:winning_position){
            if(state[index[0]]==state[index[1]] && state[index[1]]==state[index[2]]){
                return state[index[0]];
            }
        }

        return 2;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}