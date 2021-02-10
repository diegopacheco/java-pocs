### Generate Keystore and TrustStore (pass: 123456)
```bash
openssl genrsa -out serverCA.key 2048

openssl req -x509 -new -nodes -key serverCA.key -sha256 -days 1024 -out serverCA.pem

# add 123456 as password
openssl pkcs12 -export -name server-cert -in serverCA.pem -inkey serverCA.key -out serverkeystore.p12

keytool -importkeystore -destkeystore server.keystore -srckeystore serverkeystore.p12 -srcstoretype pkcs12 -alias server-cert

keytool -import -alias server-cert -file serverCA.pem -keystore server.truststore

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
─❯ openssl s_client -connect 127.0.0.1:9003                                                             ─╯
❯ openssl s_client -connect 127.0.0.1:9003
CONNECTED(00000003)
Can't use SSL_get_servername
depth=0 C = US, ST = CA, L = SF, O = XXX, OU = XXX, CN = XXX, emailAddress = XXX@XXX.com.uk
verify error:num=18:self signed certificate
verify return:1
depth=0 C = US, ST = CA, L = SF, O = XXX, OU = XXX, CN = XXX, emailAddress = XXX@XXX.com.uk
verify return:1
---
Certificate chain
 0 s:C = US, ST = CA, L = SF, O = XXX, OU = XXX, CN = XXX, emailAddress = XXX@XXX.com.uk
   i:C = US, ST = CA, L = SF, O = XXX, OU = XXX, CN = XXX, emailAddress = XXX@XXX.com.uk
---
Server certificate
-----BEGIN CERTIFICATE-----
MIIDwTCCAqmgAwIBAgIUWPt2hcNeGoLQnO3GimD8LeDiR7gwDQYJKoZIhvcNAQEL
BQAwcDELMAkGA1UEBhMCVVMxCzAJBgNVBAgMAkNBMQswCQYDVQQHDAJTRjEMMAoG
A1UECgwDWFhYMQwwCgYDVQQLDANYWFgxDDAKBgNVBAMMA1hYWDEdMBsGCSqGSIb3
DQEJARYOWFhYQFhYWC5jb20udWswHhcNMjEwMjEwMjIyNTIxWhcNMjMxMjAxMjIy
NTIxWjBwMQswCQYDVQQGEwJVUzELMAkGA1UECAwCQ0ExCzAJBgNVBAcMAlNGMQww
CgYDVQQKDANYWFgxDDAKBgNVBAsMA1hYWDEMMAoGA1UEAwwDWFhYMR0wGwYJKoZI
hvcNAQkBFg5YWFhAWFhYLmNvbS51azCCASIwDQYJKoZIhvcNAQEBBQADggEPADCC
AQoCggEBALtkq2RYWD29b/gcRyl6GiO1EyQeuGGZxVxRyuRR/vqcO8RpaGHvGhuh
2Sd5c0w6Sotu49hshpdgRRAU5LSpDM85Dp5snQfwDzUomhf6dygGA+VWRPSfFt0x
wzLUpXxggrnzO7/qPWJfJMSMK+DgLxY/cJ1splGU45dOHz8Heq2Bng6HXnBRpXrK
qr7EGWdWZPWF4hftx+zhQ6a1n8rsjVx/H3L5EQZDzU8wtUpQrjvJlylKpXojiKvE
FxAk1LUuaL7oQdCt3cYhaOfCK+ggSYBZrtcYHQRa21hq9jbyrJ4rBuFsAhOQstzH
/n60aRBfTJTUdZlT3X2CwBTuN4lxEtUCAwEAAaNTMFEwHQYDVR0OBBYEFFtf72IJ
OukbjOKidOk+EMs/qX09MB8GA1UdIwQYMBaAFFtf72IJOukbjOKidOk+EMs/qX09
MA8GA1UdEwEB/wQFMAMBAf8wDQYJKoZIhvcNAQELBQADggEBADctvam0SpZV292k
YbEebq1OoiSYReTcXjUMNCpGTks7hlVOdsQ1wINwNY3mRrHxR3qfUSN6bVRCp/AA
JLHL1TZ/SOMeYZWkJbA4GEDXWYmYgjU7krc86Rx00hnEw1XQz9sosrzs/gphSZLN
HA5lQwwOfh32sVp2wAtTejnj079THrHJUmJ006lTr/hs1FB6gIpjcBuDIO/Hycsh
E/fTeTvuhljQseHsAt8Sg0KTCPlGtGFsd8+pCkwN57mXijAaDGhEmus/s9gGenow
SO9GXv3wlXS6w7Y7O3fWBZZjFKaLjE5pILxwPTCPr6VLxAcmGqEkNdsGHbk/24cm
WWw7eFU=
-----END CERTIFICATE-----
subject=C = US, ST = CA, L = SF, O = XXX, OU = XXX, CN = XXX, emailAddress = XXX@XXX.com.uk

issuer=C = US, ST = CA, L = SF, O = XXX, OU = XXX, CN = XXX, emailAddress = XXX@XXX.com.uk

---
No client certificate CA names sent
Peer signing digest: SHA256
Peer signature type: RSA-PSS
Server Temp Key: X25519, 253 bits
---
SSL handshake has read 1497 bytes and written 373 bytes
Verification error: self signed certificate
---
New, TLSv1.3, Cipher is TLS_AES_256_GCM_SHA384
Server public key is 2048 bit
Secure Renegotiation IS NOT supported
Compression: NONE
Expansion: NONE
No ALPN negotiated
Early data was not sent
Verify return code: 18 (self signed certificate)
---
---
Post-Handshake New Session Ticket arrived:
SSL-Session:
    Protocol  : TLSv1.3
    Cipher    : TLS_AES_256_GCM_SHA384
    Session-ID: F507B0E33148D117BB4D0D4F4E10BF6786EE6F9F062B1D07543071674C38D227
    Session-ID-ctx: 
    Resumption PSK: 30AE76EFA70F1DE7482372EF2F9A932C27DBC2A11113560546B7C8AD339357CF1A28B28C96AF9A5022B0013AFAAE47C5
    PSK identity: None
    PSK identity hint: None
    SRP username: None
    TLS session ticket lifetime hint: 86400 (seconds)
    TLS session ticket:
    0000 - 96 0c c0 83 02 a6 2b f7-66 b3 f1 d9 86 60 21 3a   ......+.f....`!:
    0010 - 20 56 46 d1 c9 28 f1 30-d1 7b 76 f6 ca 02 f5 c2    VF..(.0.{v.....
    0020 - 38 09 13 8d 7f 4b 26 16-59 48 6b 5c b7 e6 6f 4c   8....K&.YHk\..oL
    0030 - 90 55 08 9f fb 5d 2d 02-9f 70 65 78 6a 68 b1 9b   .U...]-..pexjh..
    0040 - dd e7 e0 92 c1 d2 63 ef-7a ba fd 23 d2 c6 e9 73   ......c.z..#...s
    0050 - fe 61 44 69 ea ca 26 88-30 e6 b2 cc 32 f5 ef 70   .aDi..&.0...2..p
    0060 - c0 5e 71 9e c5 11 d7 1f-f9 d7 33 90 02 30 61 b4   .^q.......3..0a.
    0070 - 7b 06 6e 2a 91 7c 04 39-51 b9 9b 72 8c b1 a2 0b   {.n*.|.9Q..r....
    0080 - 40 24 bc 29 3a 41 7e e4-5c d4 e1 3e de 2b 6c 0c   @$.):A~.\..>.+l.
    0090 - a2 d4 79 f3 36 57 b8 12-38 2d 70 47 6a 89 f3 d2   ..y.6W..8-pGj...
    00a0 - cf af 70 3b 8b c6 50 1b-9c 4e a6 4f 40 01 cc 6a   ..p;..P..N.O@..j
    00b0 - ff 8c c6 bf 6c ff 35 e6-ef 8c c2 58 7c 3f 22 a3   ....l.5....X|?".
    00c0 - 27 a4 53 68 58 43 3f fa-8f 41 3f 37 51 9f e0 d9   '.ShXC?..A?7Q...
    00d0 - a0 ad fd 5b d2 e7 af 02-14 03 b4 ff 9e 23 e5 c9   ...[.........#..
    00e0 - cf 8b 97 4e 40 c2 57 11-1e e3 95 59 b0 3c a3 99   ...N@.W....Y.<..
    00f0 - 62 b9 83 56 34 e6 7e 99-0a e8 38 f7 87 a0 cd 43   b..V4.~...8....C
    0100 - e7 92 40 f2 84 c5 cd d9-e6 a4 38 02 dc 9f a9 c1   ..@.......8.....
    0110 - 3b 87 30 bc ca 8d 23 fe-a8 33 d0 d8 05 d4 a3 68   ;.0...#..3.....h
    0120 - d0 17 df ea 36 86 23 58-1c 83 4a d7 69 3e 17 0c   ....6.#X..J.i>..
    0130 - 02 07 be 99 4a 53 79 64-fc fd 6b d3 31 15 7f 4a   ....JSyd..k.1..J
    0140 - 28 89 3e ee 9c be 3d f8-69 fa 49 cf bb 44 46 84   (.>...=.i.I..DF.
    0150 - 9b d7 57 70 fa 09 bc fc-3c b6 0a 05 dc 20 13 de   ..Wp....<.... ..
    0160 - 62 e1 f9 6f 5d 0c ff 26-aa 52 6e 37 97 37 e5 ee   b..o]..&.Rn7.7..
    0170 - 20 7a 1c 31 0f 17 65 35-04 16 38 4e 3d 19 66 5c    z.1..e5..8N=.f\
    0180 - 6f ee 3c 82 6e fa 10 b9-5f 28 63 cd 85 21 3e e6   o.<.n..._(c..!>.
    0190 - b9 fa 06 6b 58 e8 35 92-5f 3e bb e5 0e 1a ba 04   ...kX.5._>......
    01a0 - 9b 22 05 29 93 3b 53 cb-bd f3 b3 fd a0 a7 7a 42   .".).;S.......zB
    01b0 - c5 ca a5 b9 ee c1 1e 4d-33 66 37 3a 93 21 62 cd   .......M3f7:.!b.
    01c0 - 7e 84 fd 0b 2e cb 71 46-f0 df 83 ab 5e eb c9 2d   ~.....qF....^..-
    01d0 - a7 6c d3 39 63 e7 3d f8-d4 18 58 19 6a e5 d7 28   .l.9c.=...X.j..(
    01e0 - 53 72 a9 fa f1 28 46 46-63 72 2c a7 6e c4 7e 7e   Sr...(FFcr,.n.~~
    01f0 - 14 f4 fd 98 c5 7a 03 bc-df b6 37 ee d0 bb 5e fc   .....z....7...^.
    0200 - 3b 83 15 87 5a 39 e9 30-44 11 51 b3 0b 4b fd 5d   ;...Z9.0D.Q..K.]
    0210 - 36 f9 46 73 14 29 42 e4-37 da 7c 92 8f 65 9e 43   6.Fs.)B.7.|..e.C
    0220 - f8 4c 8e 32 5d 1d 40 d8-f2 1c a1 00 45 f8 b8 c9   .L.2].@.....E...
    0230 - b3 5e c9 df 8d c5 78 f6-d3 5b 09 60 17 1c 25 bd   .^....x..[.`..%.
    0240 - e6 03 b0 23 80 5b 6f db-13 e2 87 df 6a 6b 18 2d   ...#.[o.....jk.-
    0250 - 88 03 93 d1 4e 50 1c a1-ab 2c 7b da 49 2a 8f 2d   ....NP...,{.I*.-
    0260 - 94 78 13 71 30 04 20 ea-66 a1 00 c1 a9 04 16 76   .x.q0. .f......v
    0270 - 98 60 5c fa 32 03 30 63-e3 bf 9d 8d 8d 52 48 64   .`\.2.0c.....RHd
    0280 - c7 b0 1b ab 08 56 5d 68-80 e0 e3 28 a2 fc 01 3b   .....V]h...(...;
    0290 - 03 53 d4 09 17 5e 42 ca-31 2e 38 58 91 73 eb 95   .S...^B.1.8X.s..
    02a0 - 08 67 82 3e a3 ab a4 7f-f2 e4 9c 88 29 ea 7f d8   .g.>........)...
    02b0 - a3 81 b2 c3 34 8b 2d 33-5d d3 f3 c1 ea c8 11 fb   ....4.-3].......
    02c0 - 7b 62 43 98 96 74 6a 50-1c 91 1d 3c 04 7a 31 04   {bC..tjP...<.z1.
    02d0 - 2e ee 7e bd fe b8 86 1f-ad a5 0a 01 b2 fd 99 31   ..~............1
    02e0 - cf 12 1a e0 18 34 57 17-6a fc 7e 74 8b 94 12 f0   .....4W.j.~t....
    02f0 - d8 08 89 b3 5d c1 d9 ef-ae 11 08 e7 42 03 9d 64   ....].......B..d
    0300 - 31 b6 0e 7c 5f 03 57 05-77 2c 4c 52 ba 28 7a a0   1..|_.W.w,LR.(z.
    0310 - 06 e0 4e 0c 3a 2c 3b 21-d4 4d 68 d0 19 a4 8e e0   ..N.:,;!.Mh.....
    0320 - 32 f6 73 18 f8 f5 ca fb-eb 76 f6 52 f1 f2 68 bc   2.s......v.R..h.
    0330 - 6a 08 b1 b7 54 5f a4 c5-b7 9c ba 79 e8 63 de 85   j...T_.....y.c..
    0340 - 1f 3a 3b f7 82 51 86 c8-f1 49 db a2 cb f7 77 63   .:;..Q...I....wc
    0350 - bb 97 f4 f7 7d af 7a 4c-d4 6d c6 f5 be d7 6a fd   ....}.zL.m....j.
    0360 - 6d c7 ef a0 f8 5d b8 fb-bb 36 e1 52 67 2c 81 49   m....]...6.Rg,.I
    0370 - 56 ad 4c 0b 1a 50 36 46-a8 c3 01 85 ab ed 40 1a   V.L..P6F......@.
    0380 - dc 85 a9 5b 6a f1 1f 77-35 0e 69 da 46 5f 98 a9   ...[j..w5.i.F_..
    0390 - 54 13 0f f9 99 16 e1 1a-83 dc 23 21 7b 44 e3 75   T.........#!{D.u
    03a0 - 0a 87 89 97 d8 b9 60 61-c1 92 66 c5 68 c0 4b 0e   ......`a..f.h.K.
    03b0 - b5 2d 67 e1 db 8c c2 f7-f4 d9 d5 fc 1c c4 89 43   .-g............C
    03c0 - e1 50 55 d1 c2 8a 04 02-a5 d1 6b 17 3e d5 7c 48   .PU.......k.>.|H
    03d0 - 3a cb ce 9b d2 d1 14 d8-34 02 84 7c e8 bf 85 c0   :.......4..|....
    03e0 - 01 cf 53 33 ea 02 c1 c9-c1 f5 9b 9f 32 01 c6 00   ..S3........2...
    03f0 - 5d 6b 98 f6 1f c4 f0 ad-67 58 e0 da 38 91 57 0f   ]k......gX..8.W.
    0400 - 8d 0b ab 73 70 3e 52 08-a8 17 6a 31 60 82 14 1d   ...sp>R...j1`...
    0410 - 3f 1e 81 fd d3 74 93 af-8d ab 46 b3 77 9d 2c 18   ?....t....F.w.,.
    0420 - 1e f1 65 4b 8a a9 5e ca-22 97 53 8c 6b e1 e2 d6   ..eK..^.".S.k...
    0430 - e0 1f 01 c6 36 79 24 39-90 60 01 5c 88 c8 0e b9   ....6y$9.`.\....
    0440 - 79 d8 9f ed c6 4c e1 51-24 a4 6c 51 2e 2e 37 4b   y....L.Q$.lQ..7K
    0450 - e2 8c 02 d1 bb a1 c6 f8-8f 43 c5 f8 d2 5a 88 dd   .........C...Z..
    0460 - 54 af 8f 42 9d 86 60 0a-da 95 fc 3c ac 00 66 c7   T..B..`....<..f.
    0470 - e9 ff a4 bb c6 76 39 6c-11 7c bc 9b 14 a3 8f 56   .....v9l.|.....V
    0480 - f5 ee 56 36 4a 5c c0 91-2a ab 79 b6 80 d3 75 a7   ..V6J\..*.y...u.
    0490 - 56 3e 7b e5 6a 7d c2 bc-f4 f6 09 eb f0 1c 5c 28   V>{.j}........\(
    04a0 - 57 e3 ef 91 2e f7 59 f4-60 c1 27 85 c2 d8 d9 c4   W.....Y.`.'.....
    04b0 - c4 74 31 f1 67 22 ff                              .t1.g".

    Start Time: 1612996355
    Timeout   : 7200 (sec)
    Verify return code: 18 (self signed certificate)
    Extended master secret: no
    Max Early Data: 0
---
read R BLOCK
<time/>
<date-response>
  <date>2021-02-10 22:32:43.326 UTC</date>
</date-response>

```