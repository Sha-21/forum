package com.m2i.forum.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sujets")
@AllArgsConstructor
public class Sujet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 200)
    private String title;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "section_id")
    private Section section;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    private User author;

    @JsonIgnore
    @OneToMany(mappedBy = "sujet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messages = new ArrayList<>();

    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String firstMessage;

    private int likes;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Sujet() {
    }

    public Sujet(String title, Section section, User author, String firstMessage) {
        this.title = title;
        this.section = section;
        this.author = author;
        this.firstMessage = firstMessage;
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
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title title à définir
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return section
     */
    public Section getSection() {
        return section;
    }

    /**
     * @param section section à définir
     */
    public void setSection(Section section) {
        this.section = section;
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
     * @return messages
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * @return firstMessage
     */
    public String getFirstMessage() {
        return firstMessage;
    }

    /**
     * @param firstMessage author à définir
     */
    public void setFirstMessage(String firstMessage) {
        this.firstMessage = firstMessage;
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
     * @return likes
     */
    public int getLikes() {
        return likes;
    }

    /**
     *
     * @param likes nombre de like d'un sujet
     */
    public void setLikes(int likes) {
        this.likes = likes;
    }
}
