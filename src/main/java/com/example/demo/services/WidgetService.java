package com.example.demo.services;

import com.example.demo.models.Topic;
import com.example.demo.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.Widget;
import com.example.demo.repositories.WidgetRepository;

import java.util.*;

@Service
public class WidgetService {

    @Autowired
    WidgetRepository widgetRepository;

    @Autowired
    TopicRepository topicRepository;

    public Widget createWidget(Integer tid, Widget widget) {
        Topic topic = topicRepository.findById(tid).get();
        widget.setTopic(topic);
        return widgetRepository.save(widget);
    }

    public int updateWidget(Integer wid, Widget widget) {
        Optional<Widget> opt = widgetRepository.findById(wid);
        if (opt.isPresent()) {
            widget.setTopic(opt.get().getTopic());
            widgetRepository.save(widget);
            return 1;
        }
        else
            return 0;
    }

    public Widget findWidgetById(Integer wid) {
        return widgetRepository.findById(wid).orElse(null);
    }

    public int deleteWidget(Integer wid) {
        Optional<Widget> opt = widgetRepository.findById(wid);
        if (opt.isPresent()) {
            widgetRepository.deleteById(wid);
            return 1;
        }
        else
            return 0;
    }

    public List<Widget> findWidgetsForTopic(Integer topicId) {
        Topic topic = topicRepository.findById(topicId).orElse(new Topic());
        return topic.getWidgets();
    }

    public List<Widget> findAllWidgets() {
        return (List<Widget>) widgetRepository.findAllWidgets();
    }

}