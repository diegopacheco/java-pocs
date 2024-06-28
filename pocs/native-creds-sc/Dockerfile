#FROM alpine:3.14
FROM ubuntu:latest
#FROM ghcr.io/graalvm/native-image-community:21-muslib

ENV SDKMAN_DIR /root/.sdkman
RUN apt-get update && apt-get install -y curl zip unzip
RUN curl -s "https://get.sdkman.io" | bash
RUN curl -s "https://get.sdkman.io" | bash
RUN chmod a+x "$SDKMAN_DIR/bin/sdkman-init.sh"
RUN set -x \
    && echo "sdkman_auto_answer=true" > $SDKMAN_DIR/etc/config \
    && echo "sdkman_auto_selfupdate=false" >> $SDKMAN_DIR/etc/config \
    && echo "sdkman_insecure_ssl=false" >> $SDKMAN_DIR/etc/config
RUN source "$SDKMAN_DIR/bin/sdkman-init.sh" && sdk install java 21-graalce

RUN mkdir -p /app/
WORKDIR /app
ADD ./target/native-creds-sc /app/
RUN chmod +x /app/native-creds-sc

EXPOSE 8080
ENTRYPOINT ["/app/native-creds-sc"]