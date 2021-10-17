package com.hadimusthafa.apiresponseparcelable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    ArrayList<User> mDataModelArrayList;
    private Context mContext;

    public Adapter(Context context, ArrayList<User> dataModelArrayList){
        mDataModelArrayList = dataModelArrayList;
        mContext = context;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item_user,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.nameT.setText(mContext.getString(R.string.name) + " " + mDataModelArrayList.get(position).getName());
        holder.emailT.setText(mContext.getString(R.string.email) + " " + mDataModelArrayList.get(position).getEmail());
        holder.genderT.setText(mContext.getString(R.string.gender) + " " + mDataModelArrayList.get(position).getGender());
        holder.statusT.setText(mContext.getString(R.string.status) + " " + mDataModelArrayList.get(position).getStatus());
        holder.idT.setText(mContext.getString(R.string.id) + " " + mDataModelArrayList.get(position).getId() + "");

    }

    @Override
    public int getItemCount() {
      return mDataModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        AppCompatTextView idT, nameT, emailT, genderT, statusT;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            idT = itemView.findViewById(R.id.idT);
            nameT = itemView.findViewById(R.id.nameT);
            emailT = itemView.findViewById(R.id.emailT);
            genderT = itemView.findViewById(R.id.genderT);
            statusT = itemView.findViewById(R.id.statusT);

        }
    }
}
