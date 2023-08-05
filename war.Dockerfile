FROM tomcat:9
COPY target/hr.war /usr/local/tomcat/webapps/
EXPOSE 8080
ENTRYPOINT [ "catalina.sh","run" ]