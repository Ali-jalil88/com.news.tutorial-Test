package com.zyadeh.kamel.entities;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class Author extends Entity{

    private String name;
    private String lastName;
    private News news;
    private Role role;
    private Tag tag;
    private User user;
    private Entity entity;
    @Autowired
    public Author (News news){
        this.news=news;
    }
    public Author (Role role){
        this.role=role;
    }
    public Author(Tag tag){
        this.tag=tag;
    }
    public Author(User user){
        this.user=user;
    }
    public Author(Entity entity){
        this.entity=entity;
    }

    public Author() {

    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name) &&
                Objects.equals(lastName, author.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, lastName);
    }
    public String author(){
        return"Hello spring! Welcome java"+entity.entity()+news.news()+role.role()+tag.tag()+user.user();
    }
    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
