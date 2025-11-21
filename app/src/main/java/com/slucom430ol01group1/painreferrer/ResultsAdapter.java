package com.slucom430ol01group1.painreferrer;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ResultsAdapter extends RecyclerView.Adapter<ResultsAdapter.ViewHolder> {

    private List<ResultItem> items;

    public ResultsAdapter(List<ResultItem> items) {

        this.items = items;

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView symptom_text;
        TextView cause_text;

        TextView save_button;
        TextView info_button;


        public ViewHolder(View view) {

            super(view);

            symptom_text = view.findViewById(R.id.symptom_text);
            cause_text = view.findViewById(R.id.cause_text);
            save_button = view.findViewById(R.id.save_button);
            info_button = view.findViewById(R.id.info_button);

        }

    }

    @NonNull
    @Override
    public ResultsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.result_item, parent, false);

        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ResultItem item = items.get(position);

        String text = item.disease;
        if (text.length() > 20) {

            text = text.substring(0, 20) + "...";

        }

        holder.symptom_text.setText(text);
        holder.cause_text.setText(item.painType);


        holder.save_button.setOnClickListener(v -> {

            // ⚠️⚠️⚠️⚠️⚠️⚠️⚠️

        });

        holder.info_button.setOnClickListener(v -> {

            String query = item.disease + " " + item.painType;
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://google.com/search?q=" + Uri.encode(query)));

            v.getContext().startActivity(intent);

        });

    }


    @Override
    public int getItemCount() {

        return items.size();

    }

}
