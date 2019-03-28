package android.sample.com.topreposgithub;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

public class RepositoryRemote {

    private Retrofit retrofit;

    private static final String VALUE_HEADER_APPLICATION = "application/vnd.github.mercy-preview+json";
    private static final String KEY_ITEMS = "items";
    private static final String KEY_HEADER_ACCEPT = "Accept";
    private static final String URL = "https://api.github.com/search/repositories?q=topic:";
    private static final String BASE_URL = "https://api.github.com/search/";

    private static RepositoryRemote sInstance;

    public static RepositoryRemote getInstance() {
        if(sInstance == null) {
            sInstance = new RepositoryRemote();
        }

        return sInstance;
    }

    private RepositoryRemote(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .build();
    }

    public List<Repository> getTopicRepos(String topic) {
        Request request = new Request.Builder()
                .addHeader(KEY_HEADER_ACCEPT, VALUE_HEADER_APPLICATION)
                .url(URL + topic)
                .build();

        List<Repository> repositories = new ArrayList<>();
        try {
            Response response = retrofit.callFactory().newCall(request).execute();
            JSONObject jsonResponseObject = new JSONObject(response.body().string());
            JSONArray jsonReposArray = jsonResponseObject.getJSONArray(KEY_ITEMS);
            for (int i = 0; i < jsonReposArray.length(); i++) {
                JSONObject jsonRepoObject = jsonReposArray.getJSONObject(i);
                repositories.add(Utils.JSONObject2Repository(jsonRepoObject));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return repositories;
    }
}
