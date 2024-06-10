package com.monkey.project;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;
import org.springframework.beans.factory.annotation.Value;

import java.lang.instrument.Instrumentation;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RestTemplateInterceptorAgent {
    
    public static void premain(String agentArgs, Instrumentation instrumentation) {
        Map<String,Object> response = new HashMap<>();
        response.put("abbreviation", "mocked IST");
        response.put("client_ip", "223.185.131.120");
        response.put("datetime", "2024-06-10T02:09:31.566675+05:30");
        response.put("day_of_week", 1);
        response.put("day_of_year", 162);
        response.put("dst", false);
        response.put("dst_from", null);
        response.put("dst_offset", 0);
        response.put("dst_until", null);
        response.put("raw_offset", 19800);
        response.put("timezone", "Asia/Kolkata");
        response.put("unixtime", 1717965571L);
        response.put("utc_datetime", "2024-06-09T20:39:31.566675+00:00");
        response.put("utc_offset", "+05:30");
        response.put("week_number", 24);

        if(Objects.equals(agentArgs, "RECORD")) {
            return;
        }

        new AgentBuilder.Default()
//                .with(AgentBuilder.Listener.StreamWriting.toSystemOut())
                .type(ElementMatchers.nameEndsWith("Post"))
                .transform((builder, typeDescription, classLoader, module) -> builder
                        .method(ElementMatchers.named("getResponse"))
                        .intercept(FixedValue.value(response))
                ).installOn(instrumentation);
    }
}
