package dev.chaz.contentcalendar.controller.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import dev.chaz.contentcalendar.model.Content;
import dev.chaz.contentcalendar.model.Status;

public interface ContentRepository extends ListCrudRepository<Content, Integer>{

    List<Content> findAllByTitleEquals(String keyword);
    List<Content> findAllByDescContains(String keyword);
    List<Content> findAllByDescContainsAndTitleContains(String key1, String key2);
    List<Content> findAllByDescContainsOrTitleContains(String key1, String key2);

    @Query ("SELECT * FROM Content WHERE status = :status")
    List<Content> filterByStatus(@Param("status") Status status);
    
    
}
