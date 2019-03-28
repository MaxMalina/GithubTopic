package android.sample.com.topreposgithub;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    private static final String KEY_FULL_NAME = "full_name";
    private static final String KEY_HTML_URL = "html_url";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_LANGUAGE = "language";
    private static final String KEY_STAR_COUNT = "stargazers_count";
    private static final String KEY_TOPICS = "topics";

    public static Repository JSONObject2Repository(JSONObject jsonRepoObject) throws JSONException {
        Repository repository = new Repository();

        repository.setFullName(jsonRepoObject.getString(KEY_FULL_NAME));
        repository.setUrl(jsonRepoObject.getString(KEY_HTML_URL));
        repository.setDescription(jsonRepoObject.getString(KEY_DESCRIPTION));
        repository.setLanguage(jsonRepoObject.getString(KEY_LANGUAGE));
        repository.setStars(jsonRepoObject.getInt(KEY_STAR_COUNT));

        List<String> topics = new ArrayList<>();
        JSONArray jsonTopicsArray = jsonRepoObject.getJSONArray(KEY_TOPICS);
        for (int i = 0; i < jsonTopicsArray.length(); i++) {
            topics.add(jsonTopicsArray.getString(i));
        }
        repository.setTopics(topics);

        return repository;
    }
}
