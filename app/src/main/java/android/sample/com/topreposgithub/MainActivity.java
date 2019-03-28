package android.sample.com.topreposgithub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.AsyncTask;
import android.os.Bundle;
import android.sample.com.topreposgithub.databinding.MainActivityBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainActivityBinding binding;
    private static final String TOPIC = "android";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity);

        new RepositoryTask().execute(TOPIC);
    }

    private class RepositoryTask extends AsyncTask<String, Void, List<Repository>> {

        @Override
        protected List<Repository> doInBackground(String... params) {
            RepositoryRemote repositoryRemote = ((TopReposGithubApplication) getApplication()).getRepositoryRemote();
            return repositoryRemote.getTopicRepos(params[0]);
        }

        @Override
        protected void onPostExecute(List<Repository> result) {
            super.onPostExecute(result);
            binding.recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

            RepoAdapter adapter = new RepoAdapter(getApplicationContext(), result);
            binding.recycler.setAdapter(adapter);
        }
    }
}
