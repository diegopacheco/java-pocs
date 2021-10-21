### Setup and Run Prometheus
prometheus.yml
```yaml
global:
    scrape_interval: 5s # How frequently to scrape targets by default
scrape_configs:
    - job_name: 'spring_micrometer'         # The job name is assigned to scraped metrics by default.
      metrics_path: '/actuator/prometheus'  # The HTTP resource path on which to fetch metrics from targets.
      scrape_interval: 5s                   # How frequently to scrape targets from this job.
      static_configs:                       # A static_config allows specifying a list of targets and a common label set for them
        - targets: ['192.168.176.1:8080']   # my localhost ip from ifconfig
```
run prometheus with docker
```bash
docker run \
  --network=host \
  --rm \
  --name=prometheus \
  -v $(pwd)/prometheus.yml:/etc/prometheus/prometheus.yml \
  -p 9090:9090 \
  prom/prometheus
```
### Build and run micrometer app
```bash
gradle build
```
Run main app now
### Test 
```bash
curl "http://localhost:8080/actuator/health"
```
```bash
curl -s http://localhost:8080/actuator/prometheus 
```
```bash
curl -s "http://localhost:8080/actuator/prometheus" | grep custom
```
### Test on Prometrheus Web
goto
```bash
http://localhost:9090/graph
```
ctrl+space to see lots of jvm metrics or use spesific like this ones:
```bash
jvm_memory_used_bytes
custom_counter_total
```