### Generate Keystore and TrustStore (pass: 123456)
```bash
keytool -keystore clientkeystore -genkey -alias mina

openssl req -newkey rsa:4096 \
            -x509 \
            -sha256 \
            -days 3650 \
            -nodes \
            -out certificate.crt \
            -keyout certificate.key \
            -subj "/C=SI/ST=Ljubljana/L=Ljubljana/O=Security/OU=IT Department/CN=www.example.com"

keytool -import -file certificate.crt  -alias mina -keystore myTrustStore
```

### Build 
```bash
./mvnw clean install 
```
### Run server
```bash
./run.sh
```
### test via telnet (as expeted does not work with SSL)
```bash
❯ telnet 127.0.0.1 9003
Trying 127.0.0.1...
Connected to 127.0.0.1.
Escape character is '^]'.
<time/>   
PConnection closed by foreign host.
```

### Testing with openssl client
```bash
openssl s_client -connect 127.0.0.1:9003
```