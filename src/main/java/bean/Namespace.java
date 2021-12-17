package bean;// Namespace.java

import java.io.Serializable;

public class Namespace implements Serializable {
    private long id;
    private String name;
    private String path;
    private String kind;
    private String fullPath;
    private Object parentid;
    private Object avatarurl;
    private String weburl;

    public long getid() {
        return id;
    }

    public void setid(long value) {
        this.id = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String value) {
        this.path = value;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String value) {
        this.kind = value;
    }

    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(String value) {
        this.fullPath = value;
    }

    public Object getParentid() {
        return parentid;
    }

    public void setParentid(Object value) {
        this.parentid = value;
    }

    public Object getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(Object value) {
        this.avatarurl = value;
    }

    public String getWeburl() {
        return weburl;
    }

    public void setWeburl(String value) {
        this.weburl = value;
    }
}