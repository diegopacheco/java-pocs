### Build 
```bash
./mvnw clean install 
```

### After some chaos engineering
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