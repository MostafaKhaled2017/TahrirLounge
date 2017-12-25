package com.mostafa.tahrirlounge.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mostafa.tahrirlounge.CircleTransform;
import com.mostafa.tahrirlounge.R;
import com.mostafa.tahrirlounge.pojoClasses.TeamMemberPojoClass;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class TeamMembersAdapter extends RecyclerView.Adapter<TeamMembersAdapter.OurTeamViewHolder> {
private List<TeamMemberPojoClass> teamMembersList;
    private Context mContext;
    public TeamMembersAdapter(Context context, List<TeamMemberPojoClass> teamMembersList){
        this.mContext=context;
        this.teamMembersList=teamMembersList;

    }
    @Override
    public OurTeamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row= LayoutInflater.from(parent.getContext()).inflate(R.layout.our_team_card,parent,false);
        return new OurTeamViewHolder(row);
    }
    @Override
    public void onBindViewHolder(OurTeamViewHolder holder, int position) {
        final TeamMemberPojoClass teamMember = teamMembersList.get(position);
        holder.memberName.setText(teamMember.getName());
        holder.memberPosition.setText(teamMember.getPosition());
        /*Picasso.with(mContext)
                .load(teamMember.getImage())
                .placeholder(R.drawable.image_background)
                .resize(150,150)
                .centerCrop()
                .into(holder.memberImage);*/
        Picasso.with(mContext)
                .load(teamMember.getImage())
                .transform(new CircleTransform())
                .placeholder(R.drawable.image_background)
                .into(holder.memberImage);
        Log.w("Logging","image link is : " + teamMember.getImage());
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return teamMembersList.size();
    }
    class OurTeamViewHolder extends RecyclerView.ViewHolder{
        CardView ourTeamCard;
        TextView memberName, memberPosition;
        ImageView memberImage;
        OurTeamViewHolder(View itemView) {
            super(itemView);
            ourTeamCard =(CardView) itemView.findViewById(R.id.our_team_card_view) ;
            memberName = (TextView) itemView.findViewById(R.id.team_member_name);
            memberPosition =(TextView) itemView.findViewById(R.id.team_member_position);
            memberImage =(ImageView) itemView.findViewById(R.id.team_member_image);
        }

    }
}

