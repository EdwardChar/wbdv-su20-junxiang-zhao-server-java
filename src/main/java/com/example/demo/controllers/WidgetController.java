package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.WidgetService;
import com.example.demo.models.Widget;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {

    @Autowired
    WidgetService service;

    @GetMapping("/api/widgets/create")
    public Widget createWidgetTest() {
        Widget w1 = new Widget();
        w1.setName("New Widget");
        w1.setSize(4);
        return service.createWidget(1, w1);
    }

    @PostMapping("/api/topics/{tid}/widgets")
    public Widget createWidget(
            @PathVariable("tid") Integer topicId,
            @RequestBody Widget widget) {
        return service.createWidget(topicId, widget);
    }

    @PutMapping("/api/widgets/{widgetId}")
    public int updateWidget(
            @PathVariable("widgetId") Integer widgetId,
            @RequestBody Widget widget){
        return service.updateWidget(widgetId, widget);
    }

    @GetMapping("/api/delete/widgets/{widgetId}")
    public int deleteWidgetTest(@PathVariable("widgetId") Integer wid) {
        return service.deleteWidget(wid);
    }

    @DeleteMapping("/api/widgets/{widgetId}")
    public int deleteWidget(@PathVariable("widgetId") Integer wid) {
        return service.deleteWidget(wid);
    }

    @GetMapping("/api/widgets")
    public List<Widget> findAllWidgets() {
        return service.findAllWidgets();
    }

    @GetMapping("/api/widgets/{widgetId}")
    public Widget findWidgetById(@PathVariable("widgetId") Integer wid) {
        return service.findWidgetById(wid);
    }

    @GetMapping("/api/topics/{tid}/widgets")
    public List<Widget> findWidgetsForTopic(
            @PathVariable("tid") Integer topicId) {
        return service.findWidgetsForTopic(topicId);
    }
}