package com.inti.student.androidassign.Score;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.inti.student.androidassign.Question.Question;
import com.inti.student.androidassign.R;

import java.util.List;
public class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.ScoreViewHolder>{

    private Context mCtx;
    private List<Question> scoreList;

    public ScoreAdapter(Context ctx, List<Question> scoreList) {
        this.mCtx = ctx;
        this.scoreList = scoreList;
    }

    @NonNull
    @Override
    public ScoreViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.score_list_layout, null);
        ScoreViewHolder holder = new ScoreViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ScoreViewHolder scoreViewHolder, int i) {
        Question question = scoreList.get(i);

        scoreViewHolder.textViewName.setText(question.getName());
        scoreViewHolder.textViewScore.setText(question.getScore());



    }

    @Override
    public int getItemCount() {
        return scoreList.size();
    }

    class ScoreViewHolder extends RecyclerView.ViewHolder{

        TextView textViewId,textViewName,textViewScore;

        public ScoreViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewId = itemView.findViewById(R.id.textViewId);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewScore=itemView.findViewById(R.id.textViewScore);
        }
    }
}
