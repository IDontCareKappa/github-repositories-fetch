package pl.tostrowski.githubfetcher.model;

public class GitRepo {

    private String name;
    private String owner;
    private String description;
    private String created_at;
    private int stars;
    private String language;
    private String url;

    public GitRepo(String name, String owner, String description, String created_at, int stars, String language, String url) {
        this.name = name;
        this.owner = owner;
        this.description = description;
        this.created_at = created_at;
        this.stars = stars;
        this.language = language;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
