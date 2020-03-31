package com.example.demo.services;

import com.example.demo.models.Topic;
import com.example.demo.models.Widget;
import com.example.demo.repositories.TopicRepository;
import com.example.demo.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    @Autowired
    WidgetRepository widgetRepository;

    @Autowired
    TopicRepository topicRepository;

    public Topic createTopic(String lid, Topic topic) {
        topic.setLessonId(lid);
        return topicRepository.save(topic);
    }

    public int updateTopic(Integer tid, Topic topic) {
        if (topicRepository.findById(tid).isPresent()) {
            topicRepository.save(topic);
            return 1;
        }
        else
            return 0;
    }

    public Topic findTopicById(Integer tid) {
        return topicRepository.findById(tid).orElse(null);
    }

    public int deleteTopic(Integer tid) {
        List<Widget> widgets = topicRepository.findById(tid).orElse(new Topic()).getWidgets();
        for(Widget w : widgets){
            widgetRepository.deleteById(w.getId());
        }
        topicRepository.deleteById(tid);
        return 1;
    }

    public List<Topic> findTopicsForLesson(String lessonId) {
        return topicRepository.findTopicsForLesson(lessonId);
    }

    public List<Topic> findAllTopics() {
        return (List<Topic>) topicRepository.findAllTopics();
    }

}