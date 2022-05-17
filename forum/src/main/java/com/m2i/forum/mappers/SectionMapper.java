package com.m2i.forum.mappers;

import com.m2i.forum.dto.SectionDto;
import com.m2i.forum.models.Section;
import com.m2i.forum.models.Sujet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SectionMapper {

    public SectionDto toDto(Section section) {
        Long id = section.getId();
        String title = section.getTitle();
        String detail = section.getDetail();
        List<Sujet> sujets = section.getSujets();

        return new SectionDto(id, title, detail, sujets);
    }

    public Section toEntity(SectionDto sectionDto) {
        return new Section(sectionDto.getDetail(), sectionDto.getTitle());
    }

}
