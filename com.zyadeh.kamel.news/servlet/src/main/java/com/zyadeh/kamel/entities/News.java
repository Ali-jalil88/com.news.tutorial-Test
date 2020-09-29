package com.zyadeh.kamel.entities;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Component
public class News extends Entity {
    private String fullText;
    private String shortText;
    private String title;
    private LocalDate publishedIn;
    private LocalDate createdIn;
    private Author author;
    private List<String> urls;

    public String getFullText() {
        return fullText;
    }
    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    public String getShortText() {
        return shortText;
    }
    public void setShortText(String shortText) {
        this.shortText = shortText;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublishedIn() {
        return publishedIn;
    }
    public void setPublishedIn(LocalDate publishedIn) {
        this.publishedIn = publishedIn;
    }

    public LocalDate getCreatedIn() {
        return createdIn;
    }
    public void setCreatedIn(LocalDate createdIn) {
        this.createdIn = createdIn;
    }

    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<String> getUrls() {
        return urls;
    }
    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        News news = (News) o;
        return Objects.equals(fullText, news.fullText) &&
                Objects.equals(shortText, news.shortText) &&
                Objects.equals(title, news.title) &&
                Objects.equals(publishedIn, news.publishedIn) &&
                Objects.equals(createdIn, news.createdIn) &&
                Objects.equals(author, news.author) &&
                Objects.equals(urls, news.urls);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), fullText, shortText, title, publishedIn, createdIn, author, urls);
    }
    public String news(){
        return "Hello news Bean";
    }
    @Override
    public String toString() {
        return "News{" +
                "fullText='" + fullText + '\'' +
                ", shortText='" + shortText + '\'' +
                ", title='" + title + '\'' +
                ", publishedIn=" + publishedIn +
                ", createdIn=" + createdIn +
                ", author=" + author +
                ", urls=" + urls +
                '}';
    }
}
