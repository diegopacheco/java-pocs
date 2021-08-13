### Build
```bash
./mvnw clean install
```
### Commands
```bash
keytool -genkeypair -alias nt-gateway -keyalg RSA -keysize 2048 -storetype JKS -keystore nt-gateway.jks -validity 3650 -ext SAN=dns:localhost,ip:127.0.0.1 

keytool -genkeypair -alias nt-ms -keyalg RSA -keysize 2048 -storetype JKS -keystore nt-ms.jks -validity 3650 -ext SAN=dns:localhost,ip:127.0.0.1

keytool -export -alias nt-gateway -file nt-gateway.crt -keystore nt-gateway.jks

keytool -export -alias nt-ms -file nt-ms.crt -keystore nt-ms.jks

keytool -import -alias nt-gateway -file nt-gateway.crt -keystore nt-ms.jks

keytool -import -alias nt-ms -file nt-ms.crt -keystore nt-gateway.jks

keytool -importkeystore -srckeystore nt-ms.jks -destkeystore nt-ms.p12 -srcstoretype JKS -deststoretype PKCS12 -srcstorepass 123456 -deststorepass 123456 -srcalias nt-ms -destalias nt-ms -srckeypass 123456 -destkeypass 123456 -noprompt
```

more on https://medium.com/@niral22/2-way-ssl-with-spring-boot-microservices-2c97c974e83