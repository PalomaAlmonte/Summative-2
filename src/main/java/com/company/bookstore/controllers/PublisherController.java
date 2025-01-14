package com.company.bookstore.controllers;

import com.company.bookstore.models.Publisher;
import com.company.bookstore.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PublisherController {
    @Autowired
    PublisherRepository Publisher_repository;
    @GetMapping("/publishers")
    public List<Publisher> getAllPublishers(){
        return Publisher_repository.findAll();
    }

    @GetMapping("/publishers/{id}")
    public Publisher getPublisherById(@PathVariable Integer id){
        Optional<Publisher> publisher = Publisher_repository.findById(id);
        if(publisher.isPresent()){
            return publisher.get();
        }else{
            return null;
        }
    }
// create
    @PostMapping("/publishers")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher createPublisher(@RequestBody Publisher publisher){
        return Publisher_repository.save(publisher);
    }
    //updates
    @PutMapping("/publishers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePublisher(@RequestBody Publisher publisher){
        Publisher_repository.save(publisher);
    }

    //delete publisher by id
    @DeleteMapping("/publishers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePublisher(@PathVariable Integer id){
        Publisher_repository.deleteById(id);
    }
}
