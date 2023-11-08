package com.example.springnews.repository;

import com.example.springnews.model.Story;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class StoryRepository  {
    private static final Map<Integer, Story> storyMap = new HashMap<>();

    static {
        initDataSource();
    }

    private static void initDataSource() {
        Story s1 = new Story(3, "kmfkm", "fjkfng", "jkjfkngf");
        storyMap.put(s1.getId(), s1);

    }

    public Story save(Story s) {
        storyMap.put(s.getId(), s);
        return s;

    }

    public Story findById(int id){return  storyMap.get(id);}

    public void deleteById(int id){storyMap.remove(id);}
    public List<Story> findAllStories(){
        Collection<Story> s=storyMap.values();
        List<Story> storyList=new ArrayList<>();
        storyList.addAll(s);
        return storyList;
    }
    public  List<Story> findAllByDepartment(String dep){
        Collection<Story> s=storyMap.values().stream()
                .filter(story -> story.getDepartment().equalsIgnoreCase(dep)).collect(Collectors.toList());
        List<Story> storyList=new ArrayList<>();
        storyList.addAll(s);
        return storyList;
    }
}
