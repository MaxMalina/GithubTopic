package android.sample.com.topreposgithub;

import android.app.Application;

public class TopReposGithubApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public RepositoryRemote getRepositoryRemote() {
        return RepositoryRemote.getInstance();
    }

}
