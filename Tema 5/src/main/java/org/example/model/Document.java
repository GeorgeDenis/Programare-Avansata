package org.example.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Document implements Serializable {
    private String id;
    private String title;
    private String location; // file name or Web page
    private Map<String, Object> tags = new HashMap<>();

    public Document(String id, String title, String location) {
        this.id = id;
        this.title = title;
        this.location = location;
    }

    public Document() {
    }

    public Document(String id, String title, String location, Map<String, Object> tags){
        this.id = id;
        this.title = title;
        this.location = location;
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Map<String, Object> getTags() {
        return tags;
    }

    public void setTags(Map<String, Object> tags) {
        this.tags = tags;
    }

    public void addTag(String key, Object value) {
        tags.put(key, value);
    }

    @Override
    public String toString() {
        return "Document{" + "id=" + id + ", title=" + title + ", location=" + location + ", tags=" + tags + '}';
    }
}
