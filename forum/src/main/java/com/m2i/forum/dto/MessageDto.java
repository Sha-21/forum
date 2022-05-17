package com.m2i.forum.dto;

import com.m2i.forum.models.Sujet;

import java.time.LocalDateTime;


public class MessageDto {

    public Long id;
    public String content;
    public UserDto author;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
    public Sujet sujet;
    private int likes;

    public MessageDto(Long id, String content, UserDto author, Sujet sujet, LocalDateTime createdAt, LocalDateTime updatedAt, int likes) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.sujet = sujet;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.likes = likes;
    }

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id id à définir
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return message
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content content à définir
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return author
     */
    public UserDto getAuthor() {
        return author;
    }

    /**
     * @param author author à définir
     */
    public void setAuthor(UserDto author) {
        this.author = author;
    }

    /**
     * @return createdAt
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * createdAt à définir
     */
    public void setCreatedAt() {
        this.createdAt = LocalDateTime.now();
    }

    /**
     * @return updatedAt
     */
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * updatedAt à définir
     */
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * @return sujet
     */
    public Sujet getSujet() {
        return sujet;
    }

    /**
     * sujet à définir
     */
    public void setSujet(Sujet sujet) {
        this.sujet = sujet;
    }
}
