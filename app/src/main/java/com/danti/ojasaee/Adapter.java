package com.danti.ojasaee;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<ModelClass> modelClassList;

    public Adapter(List<ModelClass> modelClassList) {
        this.modelClassList = modelClassList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        int resource = modelClassList.get(position).getImageIcon();
        String title = modelClassList.get(position).getTitle();
        String body = modelClassList.get(position).getBody();
        viewHolder.setData(resource, title, body);
    }

    @Override
    public int getItemCount() {
        return modelClassList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView title, body;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
            this.title = (TextView) itemView.findViewById(R.id.textView3);
            this.body = (TextView) itemView.findViewById(R.id.textView4);
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                title.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
//            }
        }

        private void setData(int imageResource, String titleText, String bodyText) {
            imageView.setImageResource(imageResource);
            title.setText(titleText);
            body.setText(bodyText);
        }
    }
}