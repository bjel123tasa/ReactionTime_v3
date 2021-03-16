package com.example.reactiontime_v1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {

    private List<UserWithTimeReaction> users = new ArrayList<>();

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new UserHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        UserWithTimeReaction currentUser = users.get(position);
        holder.textViewTitle.setText(currentUser.getUser().getName());
        holder.textViewSubtitle.setText(currentUser.getTimeReactions().toString());

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void setUsers(List<UserWithTimeReaction> users){
        this.users = users;
        notifyDataSetChanged();
    }

     class UserHolder extends RecyclerView.ViewHolder {
        private  TextView textViewTitle;
        private TextView textViewSubtitle;
        public UserHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_view_title);
            textViewSubtitle = itemView.findViewById(R.id.text_view_subtitle);

        }
    }
}
