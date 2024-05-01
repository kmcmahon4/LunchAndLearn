FROM amazoncorretto:17

ENV JAR_FILE target/LetsLunchAndLearn-1.0-SNAPSHOT.jar

COPY ${JAR_FILE} LetsLunchAndLearn-1.0-SNAPSHOT.jar

CMD java -jar LetsLunchAndLearn-1.0-SNAPSHOT.jar & \
    sleep 10s && \
    pid=$(jcmd | grep LetsLunchAndLearn-1.0-SNAPSHOT.jar | awk '{print $1}') && \
    jcmd $pid JFR.start duration=30s filename=recording.jfr && \
    sleep 30s