package com.example.newsapp;

import java.io.Serializable;
import java.util.List;

public class NewsItem implements Serializable {
    private String title;
    private String description;
    private String imageUrl;
    private String content; // Add this field
    private List<NewsItem> relatedNews;

    // Updated constructor with content
    public NewsItem(String title, String description, String imageUrl, String content, List<NewsItem> relatedNews) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.content = content; // Initialize content
        this.relatedNews = relatedNews;
    }

    // Getters
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getImageUrl() { return imageUrl; }
    public String getContent() { return content; } // Add this getter
    public List<NewsItem> getRelatedNews() { return relatedNews; }
}