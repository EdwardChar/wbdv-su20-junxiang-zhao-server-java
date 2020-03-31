package com.example.demo.repositories;

import com.example.demo.models.Topic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicRepository extends CrudRepository<Topic, Integer> {
    @Query("SELECT topic FROM Topic topic where topic.lessonId=:lid")
    public List<Topic> findTopicsForLesson(@Param("lid") String lessonId);


    @Query(value = "SELECT * FROM topics",
            nativeQuery = true)
    public List<Topic> findAllTopics();

    @Query("SELECT topic FROM Topic topic WHERE topic.id=:tid")
    public Topic findTopicsById(@Param("tid") Integer topicId);
}