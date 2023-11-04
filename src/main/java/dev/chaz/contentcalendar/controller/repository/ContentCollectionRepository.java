package dev.chaz.contentcalendar.controller.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import dev.chaz.contentcalendar.model.Content;
import dev.chaz.contentcalendar.model.Status;
import dev.chaz.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;

@Repository
public class ContentCollectionRepository {
    private final List<Content> contents = new ArrayList<>();

    public ContentCollectionRepository() {

    }

    public List<Content> findAll() {
        return contents;
    }

    public Optional<Content> findById(Integer id){
        return contents.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    @PostConstruct
    public void init() {

        Content c1 = new Content(1, 
        4,
        "My First Blog Post",
         "My first blog post content", 
         Status.IDEA,
         Type.ARTICLE, 
         LocalDateTime.now(),
          null, 
          "");

          Content c2 = new Content(2, 5,
        "രണ്ടാം ബ്ലോഗം ",
         "സഗൃതകൃതാവായ നാട്ടുകാരെ, ഇത് എന്റെ രണ്ടാമത്തെ ബ്ലോഗ് ആണ് ", 
         Status.IDEA,
         Type.ARTICLE, 
         LocalDateTime.now(),
          null, 
          "");


        contents.add(c1);
        contents.add(c2);

    }

    public void save(Content content) {
        contents.removeIf(c -> c.id().equals(content.id()));
        contents.add(content); 
    }

    public boolean existsById(Integer id) {
        return contents.stream().anyMatch(c -> c.id().equals(id));
    }

    public boolean removeById(Integer id) {
        return contents.removeIf(c -> c.id().equals(id));
    }







     
    
    
    
}
