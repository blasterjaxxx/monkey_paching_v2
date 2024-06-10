package com.monkey.project;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;
import java.util.Objects;

public class JpaInterceptorAgent {

    public static void premain(String agentArgs, Instrumentation instrumentation) {
        PostData response = new PostData();
        response.setId(10L);
        response.setName("Java Agent");
        response.setContents("Mocked Contents");
        if(Objects.equals(agentArgs, "RECORD")) {
            return;
        }

        new AgentBuilder.Default()
//                .with(AgentBuilder.Listener.StreamWriting.toSystemOut())
                .type(ElementMatchers.nameEndsWith("SimpleJpaRepository"))
                .transform((builder, typeDescription, classLoader, module) -> builder
                        .method(ElementMatchers.named("save"))
                        .intercept(FixedValue.value(response))
                ).installOn(instrumentation);
    }
}
