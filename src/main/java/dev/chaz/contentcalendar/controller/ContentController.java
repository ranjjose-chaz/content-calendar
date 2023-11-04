package dev.chaz.contentcalendar.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import dev.chaz.contentcalendar.controller.repository.ContentRepository;
import dev.chaz.contentcalendar.model.Content;
import dev.chaz.contentcalendar.model.Status;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    
    //private final ContentCollectionRepository repository;
    private final ContentRepository repository;

    public ContentController(ContentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<Content> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Unknown Id found!"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Content content){
        repository.save(content);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!");

        }
        repository.save(content);

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        // if(!repository.removeById(id)){
        //     throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!");

        // }
        repository.deleteById(id);
        

    }

    @GetMapping("/filter/{keyword}")
    public List<Content>  findByTitle(@PathVariable String keyword) {
        return repository.findAllByTitleEquals(keyword);

    }

    @GetMapping("/filter2/{keyword}")
    public List<Content>  findAllByDesc(@PathVariable String keyword) {
        return repository.findAllByDescContains(keyword);
    }

    @GetMapping("/filter3/{key1}/{key2}")
    public List<Content>  findAllByTitleAndDesc(@PathVariable String key1, @PathVariable String key2) {
        return repository.findAllByDescContainsAndTitleContains(key1, key2);
    }

    @GetMapping("/filter4/{key}")
    public List<Content>  findAllByTitleOrDesc(@PathVariable String key) {
        return repository.findAllByDescContainsOrTitleContains(key, key);
    }

    @GetMapping("/filter5/")
    public List<Content>  filterViaQueryParams(@RequestParam(required=false) Map<String,String> qparams) {
        qparams.forEach((a,b) -> {
            System.out.println(String.format("%s -> %s",a,b));
        });
        return repository.findAll();
    } 
    
    @GetMapping("/status-filter/{status}")
    public List<Content> filterByStatus(@PathVariable Status status){
        return repository.filterByStatus(status);
    }


    
        
}
