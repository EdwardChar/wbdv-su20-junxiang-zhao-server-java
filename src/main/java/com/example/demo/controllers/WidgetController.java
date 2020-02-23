package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.WidgetService;
import com.example.demo.models.Widget;
import java.util.List;

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
        return service.createWidget(w1.getName(), w1);
    }

    @PostMapping("/api/topics/{tid}/widgets")
    public Widget createWidget(
            @PathVariable("tid") String topicId,
            @RequestBody Widget widget) {
        widget.setTopicId(topicId);
        return service.createWidget(widget.getName(), widget);
    }

    @GetMapping("/api/delete/widgets/{widgetId}")
    public int deleteWidgetTest(@PathVariable("widgetId") String wid) {
        return service.deleteWidget(wid);
    }

    @DeleteMapping("/api/widgets/{widgetId}")
    public int deleteWidget(@PathVariable("widgetId") String wid) {
        return service.deleteWidget(wid);
    }

//    @GetMapping("/api/widgets")
//    public List<Widget> findAllWidgets() {
//        return service.findAllWidgets();
//    }

    @GetMapping("/api/widgets/{widgetId}")
    public Widget findWidgetById(@PathVariable("widgetId") String wid) {
        return service.findWidgetById(wid);
    }

    @GetMapping("/api/topics/{tid}/widgets")
    public List<Widget> findWidgetsForTopic(
            @PathVariable("tid") String topicId) {
        return service.findWidgetsForTopic(topicId);
    }
}