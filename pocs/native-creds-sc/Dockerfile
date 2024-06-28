#FROM alpine:3.14
FROM ubuntu:latest
#FROM ghcr.io/graalvm/native-image-community:21-muslib
RUN apt-get update && apt-get install -y curl zip unzip
RUN curl -s "https://get.sdkman.io" | bash
RUN source "/root/.sdkman/bin/sdkman-init.sh"   \
                && sdk install 21-graalce
RUN mkdir -p /app/
WORKDIR /app
ADD ./target/native-creds-sc /app/
RUN chmod +x /app/native-creds-sc
ENTRYPOINT ["/app/native-creds-sc"]