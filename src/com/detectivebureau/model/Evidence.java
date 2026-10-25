package com.detectivebureau.model;

public class Evidence {
    private final String title;
    private final String type;

    public Evidence(String title, String type) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Evidence title is required.");
        }
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Evidence type is required.");
        }
        this.title = title.trim();
        this.type = type.trim();
    }

    public String getTitle() {
        return title;
    }

    public String getType()
    {
        return type;
    }
}
