FROM tomcat:tomcat 8.0

ADD target/*.war /usr/local/tomcat/webapps/MyBlog.war

ADD setenv.sh /usr/local/tomcat/bin/setenv.sh
