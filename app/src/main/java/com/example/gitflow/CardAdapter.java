package com.example.gitflow;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    private Context context;
    private ArrayList<CardItem> arrayList;
    private OnItemClickListener mlistener;

    public interface  OnItemClickListener{
       void  onItemClick(int position);

    }
    public void setOnClickListener(OnItemClickListener listener){
        mlistener = listener;
    }

    public CardAdapter(Context context, ArrayList<CardItem> arrayList){
            this.context = context;
            this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CardItem cardItem = arrayList.get(position);
        String imageUrl = cardItem.getmImageUrl();
        String createName = cardItem.getmCreator();
        int like = cardItem.getmLikes();

        holder.textViewCreator.setText(createName);
        holder.textViewLike.setText("Like: " + like);
        Picasso.with(context).load(imageUrl).fit().centerInside().into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textViewCreator, textViewLike;

        public ViewHolder(@NonNull View view) {
            super(view);
            imageView = view.findViewById(R.id.img_card);
            textViewCreator = view.findViewById(R.id.text_view_creator);
            textViewLike = view.findViewById(R.id.text_view_downloads);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mlistener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            mlistener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
