package io.unicodes.course_api.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;



    @RequestMapping("/topicsString")
    private String getTopicsString(){
        return topicService.getTopicsString();
    }



    @RequestMapping("/topics")
    private List<TopicDTO> getTopicsList(){
        return topicService.getTopicsList();
    }


    @RequestMapping("/topics/{id}")
    private TopicDTO getTopicById(@PathVariable("id") String topicId){
        return topicService.getTopicById(topicId);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    private void addTopic(@RequestBody TopicDTO newTopic){
        topicService.addTopic(newTopic);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    private TopicDTO updateTopic(@RequestBody TopicDTO newTopic, @PathVariable("id") String topicId){
        return topicService.updateTopic(newTopic, topicId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    private List<TopicDTO> deleteTopic(@PathVariable("id") String topicId){
        return topicService.deleteTopic(topicId);
    }


}