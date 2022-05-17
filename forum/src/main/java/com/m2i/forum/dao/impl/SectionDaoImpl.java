package com.m2i.forum.dao.impl;

import com.m2i.forum.dao.SectionDao;
import com.m2i.forum.models.Section;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.Optional;

@Repository
public class SectionDaoImpl extends GenericDaoImpl<Section, Long> implements SectionDao {

    @Override
    public Optional<Section> findByTitle(String title) {
        Query query = entityManager.createQuery(
                "from Section " +
                        "where title=:title");
        query.setParameter("title", title);
        Section section = null;
        try {
            section = (Section) query.getSingleResult();
        } catch (Exception e) {
            logger.error("Error finding section with title: " + title);
        }
        return Optional.ofNullable(section);
    }

    @Override
    public void deleteById(Long id) {
        entityManager.createQuery("DELETE FROM Section WHERE id=:id")
                .setParameter("id", id).executeUpdate();
    }
}
