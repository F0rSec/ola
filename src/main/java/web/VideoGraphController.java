package web;

import dao.entities.Creator;
import dao.entities.Video;
import dao.reporities.CreatorRepo;
import dao.reporities.VideoRepo;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class VideoGraphController {

    private CreatorRepo creatorRepo ;
    private VideoRepo videoRepo;

    VideoGraphController(CreatorRepo creatorRepo , VideoRepo videoRepo){
        this.creatorRepo = creatorRepo;
        this.videoRepo = videoRepo ;

    }
    @QueryMapping
    public List<Video>videoList(){
        return videoRepo.findAll();
    }

    @QueryMapping
    public Creator createById(@Argument Long id){
        return creatorRepo.findById(id).orElseThrow(()->new RuntimeException(String.format("Creator %s not found ",id)));
    }

    public Creator saveCreator(@Argument Creator creator){
        return creatorRepo.save(creator);
    }

    @MutationMapping
    public Video saveVideo(@Argument Video video){
        creatorRepo.save(video.getCreator());
        return videoRepo.save(video);
    }


}
