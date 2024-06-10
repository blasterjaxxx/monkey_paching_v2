This project uses monkey patching concept and byte buddy to override runtime files

All the things are configured. 
Only runtime configuration has to be set up :
-javaagent:/Users/sparshduggal/Downloads/project/jpa-intercept-agent.jar=REPLAY -javaagent:/Users/sparshduggal/Downloads/project/resttemplate-intercept-agent.jar=REPLAY

Replacing REPLAY with RECORD functions as mentioned in the assignment. 
Dockerfile is not implemented.


