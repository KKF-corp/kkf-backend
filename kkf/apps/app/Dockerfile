FROM eclipse-temurin:17.0.4.1_1-jdk-alpine
RUN apk --update add fontconfig ttf-dejavu      # jasperReport needs
RUN mkdir -p /usr/app

# konfiguracja strefy czasowej systemu
ENV TZ=Europe/Warsaw
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

WORKDIR /usr/app

COPY ./target/lib lib
COPY ./src/main/docker/ ./
RUN chmod +x run.sh
COPY ./target/kkf-app.jar kkf-app.jar

VOLUME /usr/app/log
VOLUME /usr/app/config

EXPOSE 8080

ENTRYPOINT ["/bin/sh", "/usr/app/run.sh"]