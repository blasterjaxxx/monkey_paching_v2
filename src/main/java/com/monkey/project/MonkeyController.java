package com.monkey.project;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api")
public class MonkeyController {

    private final PostDataRepo postDataRepo;

    public MonkeyController(PostDataRepo postDataRepo) {
        this.postDataRepo = postDataRepo;
    }

    @PostMapping("createNewPost")
    public Map<String, Object> createNewPost(@RequestBody Post post) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        PostData postData = this.postDataRepo.save(
                PostData.builder()
                        .name(post.getPostName())
                        .contents(post.getPostName())
                        .build()
        );
        Object worldtimeResponse = new Post().getResponse();
        Map<String, Object> reponse = new HashMap<>();
        reponse.put("db_post", postData.getId());
        reponse.put("http_outbound", worldtimeResponse);
        return reponse;
    }

}
