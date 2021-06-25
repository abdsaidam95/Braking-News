package com.haroonstudios.newsapitutorial.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.haroonstudios.newsapitutorial.Activities.ListStackActivity;
import com.haroonstudios.newsapitutorial.Models.Source;
import com.haroonstudios.newsapitutorial.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class SourcesAdapter extends RecyclerView.Adapter<SourcesAdapter.SourcesViewHolder>
{

    Context context;
    List<Source> sourceList;

    public SourcesAdapter(Context context, List<Source> sourceList)
    {
        this.context = context;
        this.sourceList = sourceList;

    }

    @NonNull
    @Override
    public SourcesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_source,viewGroup,false);
        return new SourcesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SourcesViewHolder sourcesViewHolder, int i) {
        sourcesViewHolder.textViewName.setText(sourceList.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return sourceList.size();
    }

    public class SourcesViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.source_image) CircleImageView circleImageView;
        @BindView(R.id.source_name) TextView textViewName;

        public SourcesViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Source sourceItem = sourceList.get(getAdapterPosition());

                    Intent intent = new Intent(context, ListStackActivity.class);
                    intent.putExtra("sourceId",sourceItem.getId());
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);

                }
            });

        }
    }
}
