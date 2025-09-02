### Build 

```bash
./mvnw clean install 
```

### Result

```bash
❯ ./docker-run.sh
Starting GlusterFS and Java 21 application...
WARN[0000] The "file" variable is not set. Defaulting to a blank string. 
WARN[0000] The "file" variable is not set. Defaulting to a blank string. 
[+] Running 3/3
 ✔ Container gluster-server          Running                                                                                                                     0.0s 
 ✔ Container java21-glusterfs-app    Started                                                                                                                     0.0s 
 ✔ Container java21-glusterfs-app-2  Started                                                                                                                     0.0s 
Waiting for services to start...
=== Container Status ===
WARN[0000] The "file" variable is not set. Defaulting to a blank string. 
WARN[0000] The "file" variable is not set. Defaulting to a blank string. 
NAME             IMAGE                           COMMAND                  SERVICE          CREATED         STATUS         PORTS
gluster-server   gluster/gluster-centos:latest   "/usr/local/bin/upda…"   gluster-server   3 minutes ago   Up 3 minutes   111/tcp, 245/tcp, 443/tcp, 2049/tcp, 2222/tcp, 6010-6012/tcp, 8080/tcp, 24007/tcp, 38465-38466/tcp, 38468-38469/tcp, 49152-49154/tcp, 49156-49162/tcp
=== GlusterFS Volume Info ===
 
Volume Name: gv0
Type: Distribute
Volume ID: f4500352-9abe-4ffc-9cb1-67b653611255
Status: Started
Snapshot Count: 0
Number of Bricks: 1
Transport-type: tcp
Bricks:
Brick1: gluster-server:/export/brick1/gv0
Options Reconfigured:
transport.address-family: inet
storage.fips-mode-rchecksum: on
nfs.disable: on
=== Java App Logs ===
Java App: Waiting for GlusterFS server to be ready...
Java App: Installing ping utility...
debconf: delaying package configuration, since apt-utils is not installed
(Reading database ... 8581 files and directories currently installed.)
Preparing to unpack .../libcap2_1%3a2.66-4+deb12u1_amd64.deb ...
Unpacking libcap2:amd64 (1:2.66-4+deb12u1) over (1:2.66-4) ...
Setting up libcap2:amd64 (1:2.66-4+deb12u1) ...
Selecting previously unselected package libcap2-bin.
(Reading database ... 8581 files and directories currently installed.)
Preparing to unpack .../libcap2-bin_1%3a2.66-4+deb12u1_amd64.deb ...
Unpacking libcap2-bin (1:2.66-4+deb12u1) ...
Selecting previously unselected package iputils-ping.
Preparing to unpack .../iputils-ping_3%3a20221126-1+deb12u1_amd64.deb ...
Unpacking iputils-ping (3:20221126-1+deb12u1) ...
Selecting previously unselected package libpam-cap:amd64.
Preparing to unpack .../libpam-cap_1%3a2.66-4+deb12u1_amd64.deb ...
Unpacking libpam-cap:amd64 (1:2.66-4+deb12u1) ...
Setting up libcap2-bin (1:2.66-4+deb12u1) ...
Setting up libpam-cap:amd64 (1:2.66-4+deb12u1) ...
debconf: unable to initialize frontend: Dialog
debconf: (TERM is not set, so the dialog frontend is not usable.)
debconf: falling back to frontend: Readline
debconf: unable to initialize frontend: Readline
debconf: (Can't locate Term/ReadLine.pm in @INC (you may need to install the Term::ReadLine module) (@INC contains: /etc/perl /usr/local/lib/x86_64-linux-gnu/perl/5.36.0 /usr/local/share/perl/5.36.0 /usr/lib/x86_64-linux-gnu/perl5/5.36 /usr/share/perl5 /usr/lib/x86_64-linux-gnu/perl-base /usr/lib/x86_64-linux-gnu/perl/5.36 /usr/share/perl/5.36 /usr/local/lib/site_perl) at /usr/share/perl5/Debconf/FrontEnd/Readline.pm line 7.)
debconf: falling back to frontend: Teletype
Setting up iputils-ping (3:20221126-1+deb12u1) ...
Processing triggers for libc-bin (2.36-9+deb12u1) ...
Java App: Testing GlusterFS server connectivity...
PING gluster-server (172.30.0.10) 56(84) bytes of data.
64 bytes from gluster-server.java-21-glusterfs_gluster-net (172.30.0.10): icmp_seq=1 ttl=64 time=0.103 ms
64 bytes from gluster-server.java-21-glusterfs_gluster-net (172.30.0.10): icmp_seq=2 ttl=64 time=0.074 ms

--- gluster-server ping statistics ---
2 packets transmitted, 2 received, 0% packet loss, time 1033ms
rtt min/avg/max/mdev = 0.074/0.088/0.103/0.014 ms
Java App: Creating mount point...
Java App: Mounting GlusterFS volume...
Java App: Verifying GlusterFS mount...
Filesystem           Size  Used Avail Use% Mounted on
gluster-server:/gv0  457G  350G   89G  80% /mnt/gluster
total 8
drwxr-xr-x 3 root root 4096 Aug 28 07:39 .
drwxr-xr-x 1 root root 4096 Aug 28 07:19 ..
*** SUCCESS: Real GlusterFS is mounted and working! ***
Java App: Starting Java 21 application with GlusterFS...
[INFO] Scanning for projects...
[INFO] 
[INFO] ---------< com.github.diegopacheco.javapocs:java-21-glusterfs >---------
[INFO] Building java-21-glusterfs 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- exec:3.1.0:java (default-cli) @ java-21-glusterfs ---
Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/3.4.2/plexus-utils-3.4.2.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/3.4.2/plexus-utils-3.4.2.pom (8.2 kB at 12 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus/8/plexus-8.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus/8/plexus-8.pom (25 kB at 344 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-exec/1.3/commons-exec-1.3.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-exec/1.3/commons-exec-1.3.pom (11 kB at 262 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-parent/35/commons-parent-35.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-parent/35/commons-parent-35.pom (58 kB at 1.0 MB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/3.4.2/plexus-utils-3.4.2.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/3.4.2/plexus-utils-3.4.2.jar (267 kB at 4.1 MB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-component-annotations/2.1.1/plexus-component-annotations-2.1.1.jar
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-exec/1.3/commons-exec-1.3.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-component-annotations/2.1.1/plexus-component-annotations-2.1.1.jar (4.1 kB at 108 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-exec/1.3/commons-exec-1.3.jar (54 kB at 672 kB/s)
=== Java 21 GlusterFS Integration Demo ===
✓ GlusterFS mount point is accessible and writable
✓ Created test directory: /mnt/gluster/java-app-test

--- File Operations Test ---
✓ Written file: test-file-2025-08-28_07-40-24.txt
✓ Read file content (5 lines):
  GlusterFS Test File
  Created at: 2025-08-28T07:40:24.224088562
  Java Version: 21
  Container ID: cdfcb9ef8e97
  This file is stored in a distributed GlusterFS volume!
✓ File size: 161 bytes

--- GlusterFS Contents ---
Root directory contents:
  [DIR] java-app-test (0 bytes)

Test directory contents:
  [FILE] test-file-2025-08-28_07-40-24.txt (161 bytes)

--- Concurrent Operations Test ---
✓ Thread 1 completed file operations
✓ Thread 4 completed file operations
✓ Thread 2 completed file operations
✓ Thread 3 completed file operations
✓ Thread 0 completed file operations
✓ All concurrent operations completed

=== GlusterFS App Completed Successfully! ===
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.568 s
[INFO] Finished at: 2025-08-28T07:40:24Z
[INFO] ------------------------------------------------------------------------
Java App: Waiting for GlusterFS server to be ready...
Java App: Installing ping utility...
Java App: Testing GlusterFS server connectivity...
PING gluster-server (172.30.0.10) 56(84) bytes of data.
64 bytes from gluster-server.java-21-glusterfs_gluster-net (172.30.0.10): icmp_seq=1 ttl=64 time=0.071 ms
64 bytes from gluster-server.java-21-glusterfs_gluster-net (172.30.0.10): icmp_seq=2 ttl=64 time=0.090 ms

--- gluster-server ping statistics ---
2 packets transmitted, 2 received, 0% packet loss, time 1006ms
rtt min/avg/max/mdev = 0.071/0.080/0.090/0.009 ms
Java App: Creating mount point...
Java App: Mounting GlusterFS volume...
Java App: Verifying GlusterFS mount...
Filesystem           Size  Used Avail Use% Mounted on
gluster-server:/gv0  457G  350G   89G  80% /mnt/gluster
total 12
drwxr-xr-x 4 root root 4096 Aug 28 07:40 .
drwxr-xr-x 1 root root 4096 Aug 28 07:19 ..
drwxr-xr-x 2 root root 4096 Aug 28 07:40 java-app-test
*** SUCCESS: Real GlusterFS is mounted and working! ***
Java App: Starting Java 21 application with GlusterFS...
[INFO] Scanning for projects...
[INFO] 
[INFO] ---------< com.github.diegopacheco.javapocs:java-21-glusterfs >---------
[INFO] Building java-21-glusterfs 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- exec:3.1.0:java (default-cli) @ java-21-glusterfs ---
=== Java 21 GlusterFS Integration Demo ===
✓ GlusterFS mount point is accessible and writable
✓ Created test directory: /mnt/gluster/java-app-test

--- File Operations Test ---
✓ Written file: test-file-2025-08-28_07-42-43.txt
✓ Read file content (5 lines):
  GlusterFS Test File
  Created at: 2025-08-28T07:42:43.903973143
  Java Version: 21
  Container ID: cdfcb9ef8e97
  This file is stored in a distributed GlusterFS volume!
✓ File size: 161 bytes

--- GlusterFS Contents ---
Root directory contents:
  [DIR] java-app-test (0 bytes)

Test directory contents:
  [FILE] test-file-2025-08-28_07-42-43.txt (161 bytes)
  [FILE] concurrent-test-thread-4.txt (87 bytes)
  [FILE] concurrent-test-thread-0.txt (85 bytes)
  [FILE] concurrent-test-thread-1.txt (86 bytes)
  [FILE] concurrent-test-thread-2.txt (87 bytes)
  [FILE] concurrent-test-thread-3.txt (86 bytes)
  [FILE] test-file-2025-08-28_07-40-24.txt (161 bytes)

--- Concurrent Operations Test ---
✓ Thread 1 completed file operations
✓ Thread 2 completed file operations
✓ Thread 3 completed file operations
✓ Thread 0 completed file operations
✓ Thread 4 completed file operations
✓ All concurrent operations completed

=== GlusterFS App Completed Successfully! ===
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.841 s
[INFO] Finished at: 2025-08-28T07:42:43Z
[INFO] ------------------------------------------------------------------------
=== To follow Java app logs in real-time ===
docker logs -f java21-glusterfs-app
=== To connect to the Java app container ===
docker exec -it java21-glusterfs-app /bin/bash
=== To check GlusterFS mount inside Java app ===
docker exec java21-glusterfs-app ls -la /mnt/gluster
```
