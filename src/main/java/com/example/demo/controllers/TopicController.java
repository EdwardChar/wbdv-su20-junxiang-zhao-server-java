package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.TopicService;
import com.example.demo.models.Topic;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;

@RestController
@CrossOrigin(origins = "*")
public class TopicController {
    @Autowired
    TopicService service;
    
    @GetMapping("/api/topic/create")
    public Topic createTopicTest() {
        Topic w1 = new Topic();
        w1.setTitle("New Topic");
        return service.createTopic("lorem", w1);
    }
    
    @PostMapping("/api/lessons/{lid}/topics")
    public Topic createTopic(
            @PathVariable("lid") String lessonId,
            @RequestBody Topic topic) {
        return service.createTopic(lessonId, topic);
    }


    @PutMapping("/api/topics/{topicId}")
    public int updateTopic(
            @PathVariable("topicId") Integer topicId,
            @RequestBody Topic topic){
        return service.updateTopic(topicId, topic);
    }

    @GetMapping("/api/delete/topics/{topicId}")
    public int deleteTopicTest(@PathVariable("topicId") Integer tid) {
        return service.deleteTopic(tid);
    }

    @DeleteMapping("/api/topics/{topicId}")
    public int deleteTopic(@PathVariable("topicId") Integer tid) {
        return service.deleteTopic(tid);
    }

    @GetMapping("/api/topics")
    public List<Topic> findAllTopics() {
        return service.findAllTopics();
    }


    @GetMapping("/api/topics/{topicId}")
    public Topic findTopicById(@PathVariable("topicId") Integer tid) {
        return service.findTopicById(tid);
    }

    @GetMapping("/api/lessons/{lid}/topics")
    public List<Topic> findTopicsForLesson(
            @PathVariable("lid") String lessonId) {
        return service.findTopicsForLesson(lessonId);
    }
}
