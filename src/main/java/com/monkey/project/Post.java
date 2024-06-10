package com.monkey.project;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@Data
@ToString
@Getter
@Setter
//@Component
public class Post {
    @JsonProperty("post_name")
    private String postName;
    @JsonProperty("post_contents")
    private String postContents;

    public Map getResponse(){
        String url = "http://worldtimeapi.org/api/timezone/Asia/Kolkata";

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url,Map.class);
    }

}