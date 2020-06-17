package com.example.reactiontime_v1;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReactionsAdapter extends RecyclerView.Adapter<ReactionsAdapter.ViewHolder> {

    private List<ReactionModel> listOfReactionModels;
    private Context context;
    private IOnnReactionClick onReactionClick;

    public interface IOnnReactionClick {
        void reactionSelected(int position, ReactionModel reactionModel);
    }

    public ReactionsAdapter(Context context, List<ReactionModel> listOfReactionModels, IOnnReactionClick onReactionClick) {
        this.context = context;
        this.listOfReactionModels = listOfReactionModels;
        this.onReactionClick = onReactionClick;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final ReactionModel reactionModel = listOfReactionModels.get(position);
        holder.singleItemImageView.setImageResource(reactionModel.isShouldBeSelected() ? R.drawable.image_red : R.drawable.image_black);
        holder.singleItemImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onReactionClick.reactionSelected(position, reactionModel);
            }
        });
    }

    public void setReactionModelShouldBeSelected(int position) {
        setListOfReactionModelsToFalse();
        listOfReactionModels.get(position).setShouldBeSelected(true);
        notifyDataSetChanged();
    }

    public void setAllToFalse() {
        setListOfReactionModelsToFalse();
        notifyDataSetChanged();
    }

    private void setListOfReactionModelsToFalse() {
        for (ReactionModel reactionModel : listOfReactionModels) {
            reactionModel.setShouldBeSelected(false);
        }
    }

    @Override
    public int getItemCount() {
        // zastita od null pointer exceptiona
        if (listOfReactionModels == null) {
            return 0;
        }
        return listOfReactionModels.size();
    }

    //ViewHolder predstavlja view za svaki model u listi
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView singleItemImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            singleItemImageView = itemView.findViewById(R.id.image_reaction);
        }
    }
}
