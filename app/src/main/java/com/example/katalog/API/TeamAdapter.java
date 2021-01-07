package com.example.katalog.API;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.katalog.R;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {
    private List<TeamData> listOfTeamData;
    private Context context;

    public TeamAdapter(List<TeamData> listOfTeamData, Context context){
        this.listOfTeamData = listOfTeamData;
        this.context = context;
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_catalog, parent, false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        TeamData teamData = listOfTeamData.get(position);

        holder.teamName.setText(teamData.getStrTeam());
        holder.teamInformedYear.setText(teamData.getIntFormedYear());
        holder.teamDescription.setText(teamData.getStrDescriptionEN());

        Glide.with(context)
                .load(teamData.getStrTeamBadge())
                .into(holder.teamImage);
    }

    @Override
    public int getItemCount() {
        return listOfTeamData.size();
    }

    public class TeamViewHolder extends RecyclerView.ViewHolder {
        TextView teamName, teamInformedYear, teamDescription;
        ImageView teamImage;

        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);

            teamName = itemView.findViewById(R.id.tv_name);
            teamInformedYear = itemView.findViewById(R.id.tv_informedyear);
            teamDescription = itemView.findViewById(R.id.tv_description);
            teamImage = itemView.findViewById(R.id.image_team);
        }
    }
}
