## Assumptions

ForkLifter is very memory intensive, since will load all data from 2 databases in to memory.
However that will happen 1 DAO at the time in a single thread application. This is like a mini crippled Spark. 
We could save mekory for the case that dataset is too big but them each chunk of data 
we would need todo target cassandra(TO DAO) and do a query there. This would be saving lots of memory but slow donw a lot the overall process.

## Spinakker usage

This is another assumption is that Forklift is short lived. Once 2 dabs are in sync, Dual write will make sure they are in sync.
When we deploy forklit we add more memory wait to forklift finish and redeploy the service again with forklift off and less
memory. This is under the assuptionns we are using spinnaker and we can doi traffic switch without downtime.

## This is a POC

This is not a PRODUCTION READY and FINAL CODE. So it could have bugs. So its better to test local with docker you can
use this solution to help you out: https://github.com/diegopacheco/dualwrite-cass-docker.
