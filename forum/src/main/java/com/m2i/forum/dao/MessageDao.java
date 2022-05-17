package com.m2i.forum.dao;

import com.m2i.forum.dto.MessageDto;

import java.util.List;
import java.util.Optional;

public interface MessageDao {

    public void deleteById(Long id);
    public void deleteBySujetId(Long id);

    public Optional<List<MessageDto>> findMessagesBySujetId(Long id);
}
