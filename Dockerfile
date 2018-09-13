FROM ubuntu
MAINTAINER TaniaAzarova
RUN apt-get update \
&& apt-get install -y git openjdk-8-jdk\
&& cd /root \
&& git clone https://github.com/TaniaAzar/clientSpringSecondTask.git \
&& cd /root/clientSpringSecondTask/ \
&& gradle build \
&& cd build/libs/ \
&& mv console-1.0-SNAPSHOT.jar