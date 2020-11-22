### Build
```bash
./mvnw clean install
```
### GraphQl Console
```bash
xdg-open "http://localhost:8080/graphiql"
```
### Query
```
{
     bookById(id:"book-1"){
    	name,
    	pageCount,
        author {
          id,
          firstName,
          lastName
        }
    }
}
```
