package com.m2i.forum.models;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@AllArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "sujet_id")
    private Sujet sujet;

    private int likes;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Message() {
    }

    public Message(User author, String content, Sujet sujet) {
        this.author = author;
        this.content = content;
        this.sujet = sujet;
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
     * @return content
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
    public User getAuthor() {
        return author;
    }

    /**
     * @param author author à définir
     */
    public void setAuthor(User author) {
        this.author = author;
    }

    /**
     * @return sujet
     */
    public Sujet getSujet() {
        return sujet;
    }

    /**
     * @param sujet sujet à définir
     */
    public void setSujet(Sujet sujet) {
        this.sujet = sujet;
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
    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }

    /**
     *
     * @return nombre de likes
     */
    public int getLikes() {
        return likes;
    }

    /**
     *
     * @param likes
     */
    public void setLikes(int likes) {
        this.likes = likes;
    }
}
