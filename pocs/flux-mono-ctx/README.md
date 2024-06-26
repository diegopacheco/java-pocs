### Spring Boot WebFlux POC

<BR/>
Let's say you have a global message id called(MID). You want to do 2 scenarios: <BR/>
* (A) The client has a MID and it need to be chained down to all downstream calls  <BR/>
* (B) The client DOES NOT have a MID, so you need to create and return to the client. <BR/>
* (C) Same as A but using a ThreadLocal  <BR/>

For this POC I have (A), (B) and (C) working but the result is far from ideal.

### Important Callouts
<BR/>
* It's ONE WAY. You cannot think Flux/Mono are request respose, it's a chain that only goes down. <BR/>
* IF you want send data down the chain need to user `contextWrite(Context.of(Mid.ID,ref.get()))` <BR/>
* IF you need to read data from the upstream chain you need `Mono.deferContextual` which is a WRAPPER and 
you will be CALLED BACK by the upstream, when the upstream call you - you will recive Upstream context IF present, 
if you recived a Context0 means there is nothing on the context and a get will throw `NoSuchElementException`.

#### Unit Tests and Approaches

Take a look on the class: FluxMonoCtxApplicationTests.
* testCreateMidClientPropagation (A)
* testNoMidPropagationFromClientButThereIsFromServer (B)

(A) Is the client calling the downstream and passing the context. IF the call comes from a controller or another,
rest client you will need to get from the headers or from whatever mechanism and pass it down. This would be almost ok if
was not for 2 reasons: (1) Not always your client will send that to you. (2) It's fragile, what if you forget to do something? 
the answer will be create a library - well but that bring us a lot of problems. How many libs you will need? how many things you will need to integrate with?

(B) We are cheating a little bit, because there is a reference callback that can receive the MID generated by the provider, 
however this is not good because the code gets coupled with the AtomicReference callback. But it works but is ugly.

#### Unit Test vs Controller

On the Unit Test ThreadLocal works on the Controller it does not work, it cannot get the same values.

#### Useful links

* https://spring.io/blog/2023/03/28/context-propagation-with-project-reactor-1-the-basics
* https://www.altia.es/en/about-altia/newsroom/news/spring-webflux#:~:text=As%20requests%20are%20handled%20by,uses%20a%20feature%20called%20Context.