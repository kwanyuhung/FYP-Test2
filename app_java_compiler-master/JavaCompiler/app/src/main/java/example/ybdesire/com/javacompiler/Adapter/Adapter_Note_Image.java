package example.ybdesire.com.javacompiler.Adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import example.ybdesire.com.javacompiler.R;

public class Adapter_Note_Image extends RecyclerView.Adapter<Adapter_Note_Image.ViewHolder> {
    private Context mContext;
    private ArrayList<Integer> mData;

    public Adapter_Note_Image(Context context, ArrayList<Integer> data) {
        this.mContext = context;
        this.mData = data;
    }

    @Override
    public Adapter_Note_Image.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        View view = LayoutInflater
                .from(mContext)
                .inflate(R.layout.adapter_imagelayout, parent, false);
        Adapter_Note_Image.ViewHolder holder = new Adapter_Note_Image.ViewHolder(view);
        holder.appCompatImageView = (AppCompatImageView) view.findViewById(R.id.image_layout);

        return holder;
    }

    @Override
    public void onBindViewHolder(Adapter_Note_Image.ViewHolder holder, int position) {
        Integer post = mData.get(position);
        holder.appCompatImageView.setBackgroundResource(R.drawable.pet);
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        AppCompatImageView appCompatImageView;

        ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
