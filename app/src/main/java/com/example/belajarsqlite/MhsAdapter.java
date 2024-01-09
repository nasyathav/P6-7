package com.example.belajarsqlite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MhsAdapter extends RecyclerView.Adapter<MhsAdapter.MhsVH> {

    private ArrayList<Mhs> mhslist ;
    private final OnItemClickListener listener ;

    public MhsAdapter(ArrayList<Mhs> mhslist, OnItemClickListener listener) {
        this.mhslist = mhslist;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MhsVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.item_listmhs, parent, false);

        return new MhsVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MhsVH holder, int position) {
        holder.tvNamaVal.setText(mhslist.get(position).getNama());
        holder.tvNimVal.setText(mhslist.get(position).getNim());
        holder.tvNoHpVal.setText(mhslist.get(position).getNoHp());

        holder.bind(mhslist, position, listener);
    }

    public interface OnItemClickListener{
        void OnItemClick(ArrayList<Mhs> mhsList, int position);
    }

    public void removeItem(int position){
        this.mhslist.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mhslist.size();
    }

    public class MhsVH extends RecyclerView.ViewHolder {

        private TextView tvNamaVal, tvNimVal, tvNoHpVal;
        private CardView cvitem;

        public MhsVH(@NonNull View itemView) {
            super(itemView);

            tvNamaVal = itemView.findViewById(R.id.tvNamaVal);
            tvNimVal = itemView.findViewById(R.id.tvNimVal);
            tvNoHpVal = itemView.findViewById(R.id.tvNoHpVal);

            cvitem = itemView.findViewById(R.id.cvitem);
        }
        public void bind(final ArrayList<Mhs> mhslist, int position, OnItemClickListener listener){
            cvitem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnItemClick(mhslist, position);
                    notifyDataSetChanged();
                }
            });
    }
    }

}
