## What the code does?

Basically there is a simple REST service using CASS 2.x as source of truth. Cassandra cluster is running in Docker.
Its possible to DUAL WRITE to a CASS 3.x CLUSTER and ALSO FORKLIFT from CASS 2.x and 3.x. Forklit is memory intensive and will
take several rounds to get data in sync. DualWrite is very lightweight. Basicaly just double write in Cass 3.x. The whole
code is using toggles so you can ask questions and switch things on the fly. There is a docker utility project to check whats going on the database here: https://github.com/diegopacheco/dualwrite-cass-docker.

There are some "generic" infrastructure code and some especific business code which can give you an idea how to integrate with your own DAOS to the project. 

## Assumptions

ForkLifter is very memory intensive, since will load all data from 2 databases in to memory.
However that will happen 1 DAO at the time in a single thread application. This is like a mini crippled Spark. 
We could save memory for the case that dataset is too big but them each chunk of data 
we would need todo target cassandra(TO DAO) and do a query there. This would be saving lots of memory but slow donw a lot the overall process however todo that you would need to change forklift code and the contract with the DAOs but is possible and not that hard - but this is not default - memory is the default.

## Spinnaker usage

This is another assumption is that Forklift is short lived. Once 2 dabs are in sync, Dual write will make sure they are in sync.
When we deploy forklit we add more memory wait to forklift finish and redeploy the service again with forklift off and less
memory. This is under the assuptionns we are using spinnaker and we can doi traffic switch without downtime.

## This is a POC

This is not a PRODUCTION READY and FINAL CODE. So it could have bugs. So its better to test local with docker you can
use this solution to help you out: https://github.com/diegopacheco/dualwrite-cass-docker.
