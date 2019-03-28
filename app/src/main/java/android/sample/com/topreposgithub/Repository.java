package android.sample.com.topreposgithub;

import java.util.List;

public class Repository {
    private String url;
    private String fullName;
    private String description;
    private String language;
    private List<String> topics;
    private int stars;

    public Repository() {

    }

    public Repository(String url, String fullName, String description, String language, List<String> topics, int stars) {
        this.url = url;
        this.fullName = fullName;
        this.description = description;
        this.language = language;
        this.topics = topics;
        this.stars = stars;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
