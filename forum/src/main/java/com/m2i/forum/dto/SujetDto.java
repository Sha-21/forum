package com.m2i.forum.dto;

import com.m2i.forum.models.Message;
import com.m2i.forum.models.Section;
import lombok.AllArgsConstructor;

import java.util.List;

public class SujetDto {

    public Long id;
    public String title;
    public Section section;
    public UserDto author;
    public List<Message> messages;
    public String firstMessage;
    private int likes;

    public SujetDto() {
    }

    /**
     * @param title
     * @param section
     * @param author
     * @param messages
     * @param firstMessage
     * @apram id
     */
    public SujetDto(Long id, String title, Section section, UserDto author, List<Message> messages, String firstMessage, int likes) {
        this.id = id;
        this.title = title;
        this.section = section;
        this.author = author;
        this.messages = messages;
        this.firstMessage = firstMessage;
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
     * @param firstMessage firstMessage à définir
     */
    public void setFirstMessage(String firstMessage) {
        this.firstMessage = firstMessage;
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
     * @param likes à définir
     */
    public void setLikes(int likes) {
        this.likes = likes;
    }
}
