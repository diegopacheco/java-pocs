### Build

```bash
./mvnw clean install
```

### Run

```bash
./start.sh
./run.sh
```

### Endpoints

```
/generate/{count}/{id} -> Generate x purchases for user id
/duplicate/{count}/{id} -> Generate duplicated x purchases for user id
/total/{id} -> Get total purchases for user id
```