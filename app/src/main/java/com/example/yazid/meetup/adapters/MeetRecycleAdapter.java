package com.example.yazid.meetup.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yazid.meetup.R;
import com.example.yazid.meetup.model.MenuListElement;

import java.util.Collections;
import java.util.List;

/**
 * Created by Yazid on 18/09/2015.
 */
public class MeetRecycleAdapter extends RecyclerView.Adapter<MeetRecycleAdapter.MeetingHolder> {

    private LayoutInflater inflater;
    List<MenuListElement> listContent= Collections.emptyList();

    public MeetRecycleAdapter(Context context,List<MenuListElement> data){
        this.inflater=LayoutInflater.from(context);
        this.listContent=data;
    }

    class MeetingHolder extends RecyclerView.ViewHolder{
        private final ImageView imgV;
        private final TextView txtV;
        public MeetingHolder(View itemView) {
            super(itemView);
            this.imgV = ((ImageView)itemView.findViewById(R.id.menu_element_image));
            this.txtV = ((TextView)itemView.findViewById(R.id.menu_element_text));
        }

        public ImageView getImgV(){
            return this.imgV;
        }
        public TextView getTxtV(){
            return this.txtV;
        }
    }

    @Override
    public MeetRecycleAdapter.MeetingHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v=this.inflater.inflate(R.layout.meet_menu_element,viewGroup,false);
        MeetingHolder holder=new MeetingHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MeetingHolder meetingHolder, int position) {
        MenuListElement element=this.listContent.get(position);
        meetingHolder.getTxtV().setText(element.text);
        meetingHolder.getImgV().setImageResource(element.idIcon);
    }


    @Override
    public int getItemCount() {
        return this.listContent.size();
    }
}
