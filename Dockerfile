FROM openjdk:17-jdk-slim
# Set the time zone for the container
# ENV TZ=Asia/Tehran
# RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# remove united states, from sources list
# RUN sed -i 's|http://us.|http://|g' /etc/apt/sources.list

# add iran to sources
# RUN > /etc/apt/sources.list
# RUN echo "deb http://debian.asis.ai/debian buster main" >> /etc/apt/sources.list
# RUN echo "deb http://debian.asis.ai/debian-security buster/updates main" >> /etc/apt/sources.list
# update sources
RUN apt-get update
# install some packages
RUN apt-get install -y curl
# run under a user. This makes the whole thing more secure
RUN groupadd normalgroup
RUN useradd -G normalgroup normaluser
USER normaluser:normalgroup
# run app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]