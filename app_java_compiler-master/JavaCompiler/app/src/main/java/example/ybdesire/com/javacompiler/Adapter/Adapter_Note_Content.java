package example.ybdesire.com.javacompiler.Adapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import java.net.PortUnreachableException;
import java.util.ArrayList;

import example.ybdesire.com.javacompiler.R;

public class Adapter_Note_Content extends RecyclerView.Adapter<Adapter_Note_Content.ViewHolder> {
    private Context mContext;
    private ArrayList<String> mData;

    private Note_Enum viewType;

    public Adapter_Note_Content(Context context, ArrayList<String> data) {
        this.mContext = context;
        this.mData = data;
    }


    @Override
    public int getItemViewType(int position) {
        this.viewType = getType(position);
        return viewType.getType();

    }


    private Note_Enum getType(int position) {
        String val = mData.get(position);
        if (val.startsWith("R.drawable")) {
            return Note_Enum.image;
        }
        return Note_Enum.test;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        if (this.viewType.getType() == Note_Enum.image.getType()) {
            view = LayoutInflater.from(mContext).inflate(R.layout.adapter_imagelayout, parent, false);
        } else {
            view = LayoutInflater.from(mContext).inflate(R.layout.adapter_textlayout, parent, false);
        }

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if (mData.get(position).startsWith("R.drawable")) {
            String imagePath = mData.get(position);
            String name = imagePath.substring(imagePath.lastIndexOf(".") + 1);
            holder.appCompatImageView = holder.itemView.findViewById(R.id.image_layout);
            holder.appCompatImageView.setImageResource(getImagePath(name));
        } else {
            holder.appCompatTextView = holder.itemView.findViewById(R.id.text_layout);

            holder.appCompatTextView.setText(mData.get(position));
        }
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        AppCompatTextView appCompatTextView;
        AppCompatImageView appCompatImageView;

        ViewHolder(View itemView) {
            super(itemView);
        }
    }


    private int getImagePath(String name) {
        return mContext.getResources().getIdentifier(name, "drawable", mContext.getPackageName());
    }
}
