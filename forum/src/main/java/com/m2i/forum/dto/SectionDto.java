package com.m2i.forum.dto;

import com.m2i.forum.models.Sujet;

import java.util.List;

public class SectionDto {

    public Long id;
    public String title;
    public String detail;
    public List<Sujet> sujets;

    public SectionDto(Long id, String title, String detail, List<Sujet> sujets) {
        this.id = id;
        this.title = title;
        this.detail = detail;
        this.sujets = sujets;
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
     * @return detail
     */
    public String getDetail() {
        return detail;
    }

    /**
     * @param detail detail à définir
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * @return sujets
     */
    public List<Sujet> getSujets() {
        return sujets;
    }
}
