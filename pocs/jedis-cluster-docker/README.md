### Build 
```bash
./mvnw clean install 
```

### This is the cluster desired state (100% working)
```bash
❯ redis-cluster-check.sh
```
```
Warning: Using a password with '-a' or '-u' option on the command line interface may not be safe.
cluster_state:ok
cluster_slots_assigned:16384
cluster_slots_ok:16384
cluster_slots_pfail:0
cluster_slots_fail:0
cluster_known_nodes:6
cluster_size:3
cluster_current_epoch:6
cluster_my_epoch:1
cluster_stats_messages_ping_sent:49
cluster_stats_messages_pong_sent:53
cluster_stats_messages_sent:102
cluster_stats_messages_ping_received:48
cluster_stats_messages_pong_received:49
cluster_stats_messages_meet_received:5
cluster_stats_messages_received:102
total_cluster_links_buffer_limit_exceeded:0
```
On docker-compose log, should see something like:
```
redis-node-6_1  | 117:S 13 Sep 2023 08:02:04.570 * Trying a partial resynchronization (request 131e8d04c1e821794e30df8a604bcffe605992af:1).
redis-node-6_1  | 
redis-node-6_1  | >>> Performing Cluster Check (using node 192.168.32.4:6379)
redis-node-6_1  | M: 7b9b925de951b584dcda251f29b7b9a303100b24 192.168.32.4:6379
redis-node-6_1  |    slots:[0-5460] (5461 slots) master
redis-node-6_1  |    1 additional replica(s)
redis-node-6_1  | S: 4dfab59e6eb86a75a4439b67f3f380e2c1d6af05 192.168.32.3:6379
redis-node-6_1  |    slots: (0 slots) slave
redis-node-6_1  |    replicates 7b9b925de951b584dcda251f29b7b9a303100b24
redis-node-6_1  | S: 931fc5150f427e88329dedce0fb487ab076bd02b 192.168.32.5:6379
redis-node-6_1  |    slots: (0 slots) slave
redis-node-6_1  |    replicates 31fc946d54609c7ca1ad55d07303b0ea39ed09cc
redis-node-6_1  | M: 488855039fc86bb1e0ff4a1f36a1cb5a94754aa7 192.168.32.2:6379
redis-node-6_1  |    slots:[5461-10922] (5462 slots) master
redis-node-6_1  |    1 additional replica(s)
redis-node-6_1  | M: 31fc946d54609c7ca1ad55d07303b0ea39ed09cc 192.168.32.6:6379
redis-node-6_1  |    slots:[10923-16383] (5461 slots) master
redis-node-6_1  |    1 additional replica(s)
redis-node-6_1  | S: ca58cb034c5859f2f56f4fee1c4277ef3e63777e 192.168.32.7:6379
redis-node-6_1  |    slots: (0 slots) slave
redis-node-6_1  |    replicates 488855039fc86bb1e0ff4a1f36a1cb5a94754aa7
redis-node-6_1  | [OK] All nodes agree about slots configuration.
redis-node-6_1  | >>> Check for open slots...
redis-node-6_1  | >>> Check slots coverage...
redis-node-6_1  | [OK] All 16384 slots covered.
```


### After some chaos engineering (chaos 1)
```
*** Stats 
key : 192.168.32.2:6379 - key 192.168.32.2:6379 has issues
key : 192.168.32.3:6379 - key 192.168.32.3:6379 has issues
key : 192.168.32.4:6379 - key 192.168.32.4:6379 has issues
key : 192.168.32.5:6379 - key 192.168.32.5:6379 has issues
key : 192.168.32.6:6379 - key 192.168.32.6:6379 has issues
key : 192.168.32.7:6379 - key 192.168.32.7:6379 has issues
***
generateSetLoad - Error : redis.clients.jedis.exceptions.JedisClusterOperationException: No reachable node in cluster.
generateScanHeavyLoad - Error : redis.clients.jedis.exceptions.JedisClusterOperationException: No reachable node in cluster.
generateScanHeavyLoad - Error : redis.clients.jedis.exceptions.JedisClusterOperationException: No reachable node in cluster.
generateScanHeavyLoad - Error : redis.clients.jedis.exceptions.JedisClusterOperationException: No reachable node in cluster.
generateScanHeavyLoad - Error : redis.clients.jedis.exceptions.JedisClusterOperationException: No reachable node in cluster.
generateScanHeavyLoad - Error : redis.clients.jedis.exceptions.JedisClusterOperationException: No reachable node in cluster.
```

### How the chaos was done 
```
1. docker ps 
2. docker stop $ID
3. ./redis-cluster-check.sh
4. wait
5. repeat with another node
```

### Chaos round 2 (chaos 2)
```
❯ docker ps
CONTAINER ID        IMAGE                       COMMAND                  CREATED             STATUS              PORTS                    NAMES
b4d47174a8c7        bitnami/redis-cluster:7.2   "/opt/bitnami/script…"   4 minutes ago       Up 4 minutes        0.0.0.0:6376->6379/tcp   redis-cluster_redis-node-6_1
fb25308487ac        bitnami/redis-cluster:7.2   "/opt/bitnami/script…"   4 minutes ago       Up 4 minutes        0.0.0.0:6372->6379/tcp   redis-cluster_redis-node-2_1
87d9d7080d39        bitnami/redis-cluster:7.2   "/opt/bitnami/script…"   4 minutes ago       Up 4 minutes        0.0.0.0:6373->6379/tcp   redis-cluster_redis-node-3_1
c8dfd604e740        bitnami/redis-cluster:7.2   "/opt/bitnami/script…"   4 minutes ago       Up 4 minutes        0.0.0.0:6374->6379/tcp   redis-cluster_redis-node-4_1
1c595ea56ac6        bitnami/redis-cluster:7.2   "/opt/bitnami/script…"   4 minutes ago       Up 4 minutes        0.0.0.0:6371->6379/tcp   redis-cluster_redis-node-1_1
40614aaae158        bitnami/redis-cluster:7.2   "/opt/bitnami/script…"   4 minutes ago       Up 4 minutes        0.0.0.0:6375->6379/tcp   redis-cluster_redis-node-5_1
❯ docker stop fb25308487ac
fb25308487ac
❯ docker rm fb25308487ac
fb25308487ac
❯ docker stop b4d47174a8c7
docker rm b4d47174a8c7
b4d47174a8c7
❯ docker rm b4d47174a8c7
b4d47174a8c7
```

### Java application logs
```bash
*** Stats 
key : 192.168.32.2:6379 -  max-total : 8 active : 0 waiters : 0 borrow : 337707 mean-active-ms : 0 mean-borrow-wait-ms : 0
key : 192.168.32.3:6379 -  max-total : 8 active : 0 waiters : 0 borrow : 0 mean-active-ms : 0 mean-borrow-wait-ms : 0
key : 192.168.32.4:6379 -  max-total : 8 active : 1 waiters : 0 borrow : 1636681 mean-active-ms : 0 mean-borrow-wait-ms : 0
key : 192.168.32.5:6379 -  max-total : 8 active : 0 waiters : 0 borrow : 0 mean-active-ms : 0 mean-borrow-wait-ms : 0
key : 192.168.32.6:6379 - key 192.168.32.6:6379 has issues
key : 192.168.32.7:6379 -  max-total : 8 active : 0 waiters : 0 borrow : 107651 mean-active-ms : 0 mean-borrow-wait-ms : 0
***
generateBrokenLoad - Error : java.lang.IllegalArgumentException: Cluster mode only supports KEYS command with pattern containing hash-tag ( curly-brackets enclosed string )
generateBrokenLoad - Error : java.lang.IllegalArgumentException: Cluster mode only supports KEYS command with pattern containing hash-tag ( curly-brackets enclosed string )
generateBrokenLoad - Error : java.lang.IllegalArgumentException: Cluster mode only supports KEYS command with pattern containing hash-tag ( curly-brackets enclosed string )
generateSetLoad - Error : redis.clients.jedis.exceptions.JedisClusterOperationException: Cluster retry deadline exceeded.
generateSetLoad - Error : redis.clients.jedis.exceptions.JedisClusterException: CLUSTERDOWN The cluster is down
generateSetLoad - Error : redis.clients.jedis.exceptions.JedisClusterException: CLUSTERDOWN The cluster is down
generateBrokenLoad - Error : java.lang.IllegalArgumentException: Cluster mode only supports KEYS command with pattern containing hash-tag ( curly-brackets enclosed string )
generateBrokenLoad - Error : java.lang.IllegalArgumentException: Cluster mode only supports KEYS command with pattern containing hash-tag ( curly-brackets enclosed string )
```

### Cluster might be broken
```bash
redis-cluster-check.sh
```
```
Warning: Using a password with '-a' or '-u' option on the command line interface may not be safe.
cluster_state:fail
cluster_slots_assigned:0
cluster_slots_ok:0
cluster_slots_pfail:0
cluster_slots_fail:0
cluster_known_nodes:1
cluster_size:0
cluster_current_epoch:0
cluster_my_epoch:0
cluster_stats_messages_pong_sent:1
cluster_stats_messages_sent:1
cluster_stats_messages_ping_received:1
cluster_stats_messages_received:1
total_cluster_links_buffer_limit_exceeded:0
```
To fix it - I have to nuke the docker volumes, some volues was attached to docker images, so I had to nuke the images first, doing:
```
0 - docker volume ls
1 - docker volume rm $volume_name
2 - docker rm $docker_image
3 - docker volume rm $volume_name
4 - docker volume ls
5 - repeat
```

### Useful Links
* https://github.com/bitnami/containers/tree/main/bitnami/redis-cluster
* https://severalnines.com/blog/hash-slot-vs-consistent-hashing-redis/