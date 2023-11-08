package com.example.springnews.services;

import com.example.springnews.model.Story;
import com.example.springnews.repository.StoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoryService {
    StoryRepository repository;

    public StoryService(StoryRepository storyRepository) {
        this.repository = storyRepository;

    }



    public Iterable<Story> getStories(String depName) {
        return repository.findAllByDepartment(depName);
    }

    public List<Story> getAllStories() {
        return repository.findAllStories();
    }


    public Story addStory(Story story) {
        return repository.save(story);
    }

    public void deleteStory(int id) {
        repository.deleteById(id);
    }
}