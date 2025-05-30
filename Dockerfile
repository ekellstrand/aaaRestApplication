FROM openjdk:17-jdk-alpine
RUN addgroup -S aaaRestApplication && adduser -S aaaRestApplication -G aaaRestApplication
USER aaaRestApplication:aaaRestApplication
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.kellstrand.aaarest.AaaRestApplication"]
