### Build
```bash
./mvnw clean install
```

### Result

Test Script
```
❯ ./test.sh
calling [http://127.0.0.1:8080/save/0/john/doe/0] should be insert! OK.
HTTP/1.1 200 
Content-Type: application/json
Content-Length: 13
Date: Thu, 27 Jun 2024 14:58:25 GMT

Person saved!calling [http://127.0.0.1:8080/save/6/john/doe/1] should be update! OK.
HTTP/1.1 200 
Content-Type: application/json
Content-Length: 13
Date: Thu, 27 Jun 2024 14:58:25 GMT

Person saved!calling [http://127.0.0.1:8080/save/6/john/doe/1] should be update! BAM! Does not work!
HTTP/1.1 500 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Thu, 27 Jun 2024 14:58:25 GMT
Connection: close

{"timestamp":"2024-06-27T14:58:25.836+00:00","status":500,"error":"Internal Server Error","path":"/save/6/john/doe/1"}%
```

State at MySQL
```
mysql> select * from person;
+----+------------+-----------+---------+---------------------+
| id | first_name | last_name | version | created_at          |
+----+------------+-----------+---------+---------------------+
|  1 | Victor     | Hugo      |       0 | 2024-06-27 14:57:12 |
|  2 | Dante      | Alighieri |       0 | 2024-06-27 14:57:12 |
|  3 | Stefan     | Zweig     |       0 | 2024-06-27 14:57:12 |
|  4 | Oscar      | Wilde     |       0 | 2024-06-27 14:57:12 |
|  5 | Diego      | Pacheco   |       1 | 2024-06-27 14:57:12 |
|  6 | john       | doe       |       2 | 2024-06-27 14:58:25 |
+----+------------+-----------+---------+---------------------+
6 rows in set (0,00 sec)

mysql>
```

Application Error
```
org.springframework.dao.OptimisticLockingFailureException: Optimistic lock exception on saving entity of type com.github.diegopacheco.sandboxspring.model.Person
	at org.springframework.data.jdbc.core.convert.DefaultDataAccessStrategy.updateWithVersion(DefaultDataAccessStrategy.java:153) ~[spring-data-jdbc-3.3.0.jar:3.3.0]
	at org.springframework.data.jdbc.core.JdbcAggregateChangeExecutionContext.updateWithVersion(JdbcAggregateChangeExecutionContext.java:348) ~[spring-data-jdbc-3.3.0.jar:3.3.0]
	at org.springframework.data.jdbc.core.JdbcAggregateChangeExecutionContext.executeUpdateRoot(JdbcAggregateChangeExecutionContext.java:127) ~[spring-data-jdbc-3.3.0.jar:3.3.0]
	at org.springframework.data.jdbc.core.AggregateChangeExecutor.execute(AggregateChangeExecutor.java:93) ~[spring-data-jdbc-3.3.0.jar:3.3.0]
	at org.springframework.data.jdbc.core.AggregateChangeExecutor.lambda$executeSave$0(AggregateChangeExecutor.java:61) ~[spring-data-jdbc-3.3.0.jar:3.3.0]
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596) ~[na:na]
	at org.springframework.data.relational.core.conversion.SaveBatchingAggregateChange.forEachAction(SaveBatchingAggregateChange.java:70) ~[spring-data-relational-3.3.0.jar:3.3.0]
	at org.springframework.data.jdbc.core.AggregateChangeExecutor.executeSave(AggregateChangeExecutor.java:61) ~[spring-data-jdbc-3.3.0.jar:3.3.0]
	at org.springframework.data.jdbc.core.JdbcAggregateTemplate.performSave(JdbcAggregateTemplate.java:491) ~[spring-data-jdbc-3.3.0.jar:3.3.0]
	at org.springframework.data.jdbc.core.JdbcAggregateTemplate.save(JdbcAggregateTemplate.java:168) ~[spring-data-jdbc-3.3.0.jar:3.3.0]
	at org.springframework.data.jdbc.repository.support.SimpleJdbcRepository.save(SimpleJdbcRepository.java:68) ~[spring-data-jdbc-3.3.0.jar:3.3.0]
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:580) ~[na:na]
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:354) ~[spring-aop-6.1.8.jar:6.1.8]
	at org.springframework.data.repository.core.support.RepositoryMethodInvoker$RepositoryFragmentMethodInvoker.lambda$new$0(RepositoryMethodInvoker.java:277) ~[spring-data-commons-3.3.0.jar:3.3.0]
	at org.springframework.data.repository.core.support.RepositoryMethodInvoker.doInvoke(RepositoryMethodInvoker.java:170) ~[spring-data-commons-3.3.0.jar:3.3.0]
	at org.springframework.data.repository.core.support.RepositoryMethodInvoker.invoke(RepositoryMethodInvoker.java:158) ~[spring-data-commons-3.3.0.jar:3.3.0]
	at org.springframework.data.repository.core.support.RepositoryComposition$RepositoryFragments.invoke(RepositoryComposition.java:516) ~[spring-data-commons-3.3.0.jar:3.3.0]
	at org.springframework.data.repository.core.support.RepositoryComposition.invoke(RepositoryComposition.java:285) ~[spring-data-commons-3.3.0.jar:3.3.0]
	at org.springframework.data.repository.core.support.RepositoryFactorySupport$ImplementationMethodExecutionInterceptor.invoke(RepositoryFactorySupport.java:628) ~[spring-data-commons-3.3.0.jar:3.3.0]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184) ~[spring-aop-6.1.8.jar:6.1.8]
	at org.springframework.data.repository.core.support.QueryExecutorMethodInterceptor.doInvoke(QueryExecutorMethodInterceptor.java:168) ~[spring-data-commons-3.3.0.jar:3.3.0]
	at org.springframework.data.repository.core.support.QueryExecutorMethodInterceptor.invoke(QueryExecutorMethodInterceptor.java:143) ~[spring-data-commons-3.3.0.jar:3.3.0]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184) ~[spring-aop-6.1.8.jar:6.1.8]
	at org.springframework.transaction.interceptor.TransactionInterceptor$1.proceedWithInvocation(TransactionInterceptor.java:123) ~[spring-tx-6.1.8.jar:6.1.8]
	at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:392) ~[spring-tx-6.1.8.jar:6.1.8]
	at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:119) ~[spring-tx-6.1.8.jar:6.1.8]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184) ~[spring-aop-6.1.8.jar:6.1.8]
	at org.springframework.dao.support.PersistenceExceptionTranslationInterceptor.invoke(PersistenceExceptionTranslationInterceptor.java:137) ~[spring-tx-6.1.8.jar:6.1.8]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184) ~[spring-aop-6.1.8.jar:6.1.8]
	at org.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:97) ~[spring-aop-6.1.8.jar:6.1.8]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184) ~[spring-aop-6.1.8.jar:6.1.8]
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:223) ~[spring-aop-6.1.8.jar:6.1.8]
	at jdk.proxy2/jdk.proxy2.$Proxy94.save(Unknown Source) ~[na:na]
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:580) ~[na:na]
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:354) ~[spring-aop-6.1.8.jar:6.1.8]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:196) ~[spring-aop-6.1.8.jar:6.1.8]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163) ~[spring-aop-6.1.8.jar:6.1.8]
	at org.springframework.dao.support.PersistenceExceptionTranslationInterceptor.invoke(PersistenceExceptionTranslationInterceptor.java:137) ~[spring-tx-6.1.8.jar:6.1.8]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184) ~[spring-aop-6.1.8.jar:6.1.8]
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:223) ~[spring-aop-6.1.8.jar:6.1.8]
	at jdk.proxy2/jdk.proxy2.$Proxy94.save(Unknown Source) ~[na:na]
	at com.github.diegopacheco.sandboxspring.service.PersonService.save(PersonService.java:26) ~[classes/:na]
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:580) ~[na:na]
```