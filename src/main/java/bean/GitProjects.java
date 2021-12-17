// GitProjects.java

package bean;

import java.io.Serializable;
import java.util.List;

public class GitProjects implements Serializable {
    private long id;
    private String description;
    private String name;
    private String nameWithNamespace;
    private String path;
    private String pathWithNamespace;
    private String createdAt;
    private String defaultBranch;
    private List<Object> tagList;
    private String sshurlToRepo;
    private String httpurlToRepo;
    private String weburl;
    private String readmeurl;
    private Object avatarurl;
    private long starCount;
    private long forksCount;
    private String lastActivityAt;
    private Namespace namespace;

    public long getid() {
        return id;
    }

    public void setid(long value) {
        this.id = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getNameWithNamespace() {
        return nameWithNamespace;
    }

    public void setNameWithNamespace(String value) {
        this.nameWithNamespace = value;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String value) {
        this.path = value;
    }

    public String getPathWithNamespace() {
        return pathWithNamespace;
    }

    public void setPathWithNamespace(String value) {
        this.pathWithNamespace = value;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String value) {
        this.createdAt = value;
    }

    public String getDefaultBranch() {
        return defaultBranch;
    }

    public void setDefaultBranch(String value) {
        this.defaultBranch = value;
    }

    public List<Object> getTagList() {
        return tagList;
    }

    public void setTagList(List<Object> value) {
        this.tagList = value;
    }

    public String getSshurlToRepo() {
        return sshurlToRepo;
    }

    public void setSshurlToRepo(String value) {
        this.sshurlToRepo = value;
    }

    public String getHttpurlToRepo() {
        return httpurlToRepo;
    }

    public void setHttpurlToRepo(String value) {
        this.httpurlToRepo = value;
    }

    public String getWeburl() {
        return weburl;
    }

    public void setWeburl(String value) {
        this.weburl = value;
    }

    public String getReadmeurl() {
        return readmeurl;
    }

    public void setReadmeurl(String value) {
        this.readmeurl = value;
    }

    public Object getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(Object value) {
        this.avatarurl = value;
    }

    public long getStarCount() {
        return starCount;
    }

    public void setStarCount(long value) {
        this.starCount = value;
    }

    public long getForksCount() {
        return forksCount;
    }

    public void setForksCount(long value) {
        this.forksCount = value;
    }

    public String getLastActivityAt() {
        return lastActivityAt;
    }

    public void setLastActivityAt(String value) {
        this.lastActivityAt = value;
    }

    public Namespace getNamespace() {
        return namespace;
    }

    public void setNamespace(Namespace value) {
        this.namespace = value;
    }
}


