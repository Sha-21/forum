package com.m2i.forum.dao.impl;

import com.m2i.forum.dao.SujetDao;
import com.m2i.forum.models.Sujet;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.Optional;

@Repository
public class SujetDaoImpl extends GenericDaoImpl<Sujet, Long> implements SujetDao {

    @Override
    public Optional<Sujet> findByTitle(String title) {
        Query query = entityManager.createQuery("from Sujet WHERE title=:title");
        query.setParameter("title", title);
        Sujet sujet = null;
        try {
            sujet = (Sujet) query.getSingleResult();
        } catch (Exception e) {
            logger.error("Error finding sujet with title: " + title);
        }
        return Optional.ofNullable(sujet);
    }

    @Override
    public void deleteById(Long id) {
        entityManager.createQuery("DELETE FROM Sujet WHERE id=:id")
                .setParameter("id", id).executeUpdate();
    }
}
