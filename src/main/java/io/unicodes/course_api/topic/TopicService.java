package io.unicodes.course_api.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;


@Service
public class TopicService {


    private String allTopics = "All Topics";
    private List<TopicDTO> topicsList = new ArrayList<>( Arrays.asList(
            new TopicDTO("116","empathy","You never really understand a person until you consider things from their POV (Harper Lee- To kill a mockingbird"),
            new TopicDTO("202","socialisation","Children are great imitators. Give them something great to imitate"),
            new TopicDTO("341","compassion","If you want others to be happy, practice compassion. If you yourself wants to be happy, practice compassion"),
            new TopicDTO("2","persistence","GREAT THINGS TAKE TIME - PLAY FOR THE LONG TERM")
    )
    );


    public String getTopicsString() {
        return this.allTopics;
    }

    public List<TopicDTO> getTopicsList(){
        return this.topicsList;
    }


    public TopicDTO getTopicById(String id) {
            TopicDTO topic =  topicsList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
            if(topic == null)
                return null;
            return topic;
    }

    public void addTopic(TopicDTO newTopic) {
        topicsList.add(newTopic);
    }

    public TopicDTO updateTopic(TopicDTO newTopic, String topicId) {
        return IntStream.range(0, topicsList.size())
                .filter(i -> topicsList.get(i).getId().equals(topicId))
                .mapToObj(i -> {
                    topicsList.set(i, newTopic);
                    return topicsList.get(i);
                })
                .findFirst()
                .orElse(null);
    }

    public List<TopicDTO> deleteTopic(String topicId) {
        topicsList.removeIf(topic -> topic.getId().equals(topicId));
        return topicsList;
    }
}