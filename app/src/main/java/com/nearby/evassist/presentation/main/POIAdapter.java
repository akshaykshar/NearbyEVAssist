package com.nearby.evassist.presentation.main;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.nearby.evassist.R;
import com.nearby.evassist.domain.model.PointOfInterest;
import java.util.List;
public class POIAdapter extends RecyclerView.Adapter<POIAdapter.VH> {
    private List<PointOfInterest> list;
    public POIAdapter(List<PointOfInterest> list){ this.list = list; }
    public void updateList(List<PointOfInterest> newList){ this.list = newList; notifyDataSetChanged(); }
    @NonNull @Override public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_poi, parent, false);
        return new VH(v);
    }
    @Override public void onBindViewHolder(@NonNull VH holder, int position){
        PointOfInterest p = list.get(position);
        holder.tvName.setText(p.getName());
        holder.tvDetails.setText(p.getCategory() + " • " + String.format("%.1f km", p.getDistanceKm()));
        ImageView iv = holder.ivCat;
        switch (p.getCategory()){
            case "Charger": iv.setImageResource(R.drawable.ic_charger); break;
            case "Parking": iv.setImageResource(R.drawable.ic_parking); break;
            default: iv.setImageResource(R.drawable.ic_restaurant); break;
        }
        // simple fade-in animation
        holder.itemView.setAlpha(0f);
        holder.itemView.animate().alpha(1f).setDuration(300).start();
    }
    @Override public int getItemCount(){ return list==null?0:list.size(); }
    static class VH extends RecyclerView.ViewHolder {
        ImageView ivCat; TextView tvName, tvDetails;
        VH(@NonNull View itemView){ super(itemView);
            ivCat = itemView.findViewById(R.id.ivCategory);
            tvName = itemView.findViewById(R.id.tvName);
            tvDetails = itemView.findViewById(R.id.tvDetails);
        }
    }
}
