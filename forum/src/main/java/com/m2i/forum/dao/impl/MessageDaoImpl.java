package com.m2i.forum.dao.impl;

import com.m2i.forum.dao.MessageDao;
import com.m2i.forum.dto.MessageDto;
import com.m2i.forum.models.Message;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
public class MessageDaoImpl extends GenericDaoImpl<Message, Long> implements MessageDao {

    @Override
    public void deleteById(Long id) {
        entityManager.createQuery("DELETE FROM Message WHERE id=:id")
                .setParameter("id", id).executeUpdate();
    }

    @Override
    public void deleteBySujetId(Long id) {
        entityManager.createQuery("DELETE FROM Message m WHERE m.sujet.id =:id")
                .setParameter("id", id).executeUpdate();
    }

    @Override
    public Optional<List<MessageDto>> findMessagesBySujetId(Long id) {
        Query query = entityManager.createQuery(
                "SELECT m FROM Message m WHERE m.sujet.id=:id");
        query.setParameter("id", id).getResultList();
        List<MessageDto> messages = null;
        try {
            messages = query.getResultList();
        } catch (Exception e) {
            logger.error("Error finding messages for sujet id : " + id);
        }
        return Optional.ofNullable(messages);
    }
}
