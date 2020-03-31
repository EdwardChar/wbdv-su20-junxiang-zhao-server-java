package com.example.demo.repositories;

import com.example.demo.models.Widget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WidgetRepository
        extends CrudRepository<Widget, Integer> {

    // SELECT * FROM widgets WHERE topic_id=tid
    @Query("SELECT widget FROM Widget widget where widget.topic.id=:tid")
    public List<Widget> findWidgetsForTopic
    (@Param("tid") Integer topicId);

    @Query(value = "SELECT * FROM widgets",
            nativeQuery = true)
    public List<Widget> findAllWidgets();

    @Query(value = "SELECT * FROM widgets WHERE id=:wid",
            nativeQuery = true)
    public List<Widget> findWidgetsById(@Param("wid") Integer widgetId);
}