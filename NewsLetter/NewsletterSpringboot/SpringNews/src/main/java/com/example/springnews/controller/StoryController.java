package com.example.springnews.controller;

import com.example.springnews.model.Story;
import com.example.springnews.repository.StoryRepository;
import com.example.springnews.services.StoryService;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class StoryController {
    private StoryService storyService;
    private StoryRepository storyRepository;

    private Logger logger = LoggerFactory.getLogger(StoryController.class);

    public StoryController(StoryService storyService, StoryRepository storyRepository) {
        this.storyService = storyService;
        this.storyRepository = storyRepository;
    }

    @GetMapping("/stories")
    public ResponseEntity<Object> getAllStories() {
        try {
            Iterable<Story> stories= storyService.getAllStories();
            logger.info("We are showing: "+ stories.toString() );
            return new ResponseEntity<Object>(stories, HttpStatus.OK);
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }

    }

   /* @RequestMapping(value = "/stories", //
            method = RequestMethod.GET, //,
            produces = {MediaType.APPLICATION_JSON_VALUE})

    @ResponseBody

    public List<Story> getAllStories() throws SQLException {
        List<Story> list = storyRepository.findAllStories();
        return list;
    }*/

    @PostMapping("/stories")
    public ResponseEntity<Object> addStory(@RequestBody Story story){
        try {
            Story created = storyService.addStory(story);
            logger.info("We are adding");

            return new ResponseEntity<Object>(created, HttpStatus.OK);

        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    /*@RequestMapping(value = "/stories",
            method = RequestMethod.POST)
    @ResponseBody
    public Story createStory(@RequestBody Story story) {
        logger.info("We are adding");

        return storyRepository.save(story);


    }*/


    @RequestMapping(value = "/stories/{id}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Story getStoryById(@PathVariable int id) {
        logger.info("We are displaying");
        return storyRepository.findById(id);
    }


   /* @PostMapping
    public ResponseEntity<Object> addStory(@RequestBody Story newStory) {
        Story createdNew=storyService.addStory(newStory);
        if(createdNew==null){
            return ResponseEntity.badRequest().build();
        }
        logger.info("We are adding");

        return new ResponseEntity<>(HttpStatus.OK);
    }*/

    @DeleteMapping("/stories/{id}")
    public ResponseEntity<HttpStatus> deleteStory(@PathVariable("id") int id) {
        try {
            storyService.deleteStory(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = "/stories/by-department/{department}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<Story> getStoriesByDepartment(@PathVariable("department") String dep) {
        return storyRepository.findAllByDepartment(dep);
    }

    /*@GetMapping("/stories")
    public Story getTaskDetails(@PathVariable String departmentName,
                                @PathVariable String storyId) {
        return storyService.getStory(departmentName,storyId);
    }*/
}

