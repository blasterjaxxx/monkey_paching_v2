package com.monkey.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

}
/*
 * Create javaagent command: jar cvfm "resttemplate-intercept-agent.jar" <path-to-resttemplate-manifest>/MANIFEST.MF <path-to-compiled-resttemplate-class>/RestTemplateInterceptorAgent.class
 * Create javaagent command: jar cvfm "jpa-intercept-agent.jar" <path-to-jpa-manifest>/MANIFEST.MF <path-to-compiled-jpa-class>/JpaInterceptorAgent.class
 * */


/*
* Java agent command: -javaagent:<path-to-jpa-jar>/jpa-intercept-agent.jar=REPLAY -javaagent:<path-to-resttemplate>/resttemplate-intercept-agent.jar=REPLAY
* */

