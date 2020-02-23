package com.example.demo.services;

import org.springframework.stereotype.Service;
import com.example.demo.models.Widget;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;

@Service
public class WidgetService {

    private Map<String, Map<String, Widget>> widgetMap;

    public WidgetService() {
        widgetMap = new HashMap<>();
    }

    public Widget createWidget(String tid, Widget widget) {
        widget.setId(new Date().getTime() + "");
        if(widgetMap.containsKey(tid))
            widgetMap.get(tid).put(widget.getId(),widget);
        else{
            Map<String, Widget> map = new HashMap<>();
            map.put(widget.getId(),widget);
            widgetMap.put(tid, map);
        }
        return widget;
    }

    public Widget findWidgetById(String wid) {
        for (Map<String, Widget> map : widgetMap.values()) {
            if(map.containsKey(wid))
            return map.get(wid);
        }
        return null;
    }

    public int deleteWidget(String wid) {
        for (Map<String, Widget> map : widgetMap.values()) {
            if(map.containsKey(wid)) {
                map.remove(wid);
                return 1;
            }
        }
        return 0;
    }

    public List<Widget> findWidgetsForTopic(String tid) {
        return new ArrayList<>(widgetMap.get(tid).values());
    }

}