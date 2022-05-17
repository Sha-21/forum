package com.m2i.forum.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sections",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "title")
        })
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String title;

    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String detail;

    @JsonIgnore
    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL)
    private List<Sujet> sujets = new ArrayList<>();

    public Section() {
    }

    public Section(String detail, String title) {
        this.title = title;
        this.detail = detail;
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
