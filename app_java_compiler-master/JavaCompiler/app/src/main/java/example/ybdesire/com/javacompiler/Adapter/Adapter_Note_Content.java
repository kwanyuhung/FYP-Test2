package example.ybdesire.com.javacompiler.Adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.net.PortUnreachableException;
import java.util.ArrayList;

import example.ybdesire.com.javacompiler.R;

public class Adapter_Note_Content extends RecyclerView.Adapter<Adapter_Note_Content.ViewHolder> {
    private Context mContext;
    private ArrayList<String> mData;

    private AppCompatImageView content_image;
    private AppCompatTextView content_text;

    public Adapter_Note_Content(Context context, ArrayList<String> data) {
        this.mContext = context;
        this.mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_textlayout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        holder.appCompatTextView = (AppCompatTextView) view.findViewById(R.id.text_layout);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String post = mData.get(position);
        holder.appCompatTextView.setText(post);
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        AppCompatTextView appCompatTextView;

        ViewHolder(View itemView) {
            super(itemView);
        }
    }


}
