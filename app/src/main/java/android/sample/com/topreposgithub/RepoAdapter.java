package android.sample.com.topreposgithub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.ViewHolder> {

    private List<Repository> mData;
    private LayoutInflater mInflater;

    private static final String TOPICS_DIVIDER = " / ";
    private static final String DEFAULT_LANGUAGE = "Unknown";

    RepoAdapter(Context context, List<Repository> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Repository repository = mData.get(position);
        holder.mRepoName.setText(repository.getFullName());
        holder.mRepoDesc.setText(repository.getDescription());
        holder.mRepoStars.setText(String.valueOf(repository.getStars()));

        if(!repository.getLanguage().equals("null")) {
            holder.mRepoLanguage.setText(repository.getLanguage());
        } else {
            holder.mRepoLanguage.setText(DEFAULT_LANGUAGE);
        }

        String strTopic = "";
        for (String topic : repository.getTopics()) {
            strTopic += topic + TOPICS_DIVIDER;
        }

        holder.mRepoTopic.setText(strTopic);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mRepoName;
        TextView mRepoDesc;
        TextView mRepoStars;
        TextView mRepoLanguage;
        TextView mRepoTopic;

        ViewHolder(View itemView) {
            super(itemView);

            mRepoName = itemView.findViewById(R.id.tvRepoName);
            mRepoDesc = itemView.findViewById(R.id.tvRepoDesc);
            mRepoStars = itemView.findViewById(R.id.tvRepoStars);
            mRepoLanguage = itemView.findViewById(R.id.tvRepoLanguage);
            mRepoTopic = itemView.findViewById(R.id.tvRepoTopics);
        }
    }
}
