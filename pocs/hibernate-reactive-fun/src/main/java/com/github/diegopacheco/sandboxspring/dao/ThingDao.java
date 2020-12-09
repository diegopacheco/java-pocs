package com.github.diegopacheco.sandboxspring.dao;

import com.github.diegopacheco.sandboxspring.model.Thing;
import org.hibernate.SessionFactory;
import org.hibernate.reactive.mutiny.Mutiny;
import org.hibernate.reactive.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import java.util.concurrent.ExecutionException;

@Repository
public class ThingDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void createThing(String name) {
        Thing t = new Thing();
        t.setName(name);
        t.setId(1L);

        sessionFactory.getCurrentSession().save(t);
        sessionFactory.getCurrentSession().flush();
        System.out.println("Record Successfully Inserted In The Database");
    }

    public Thing getThing(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ThingPU");
        //Stage.SessionFactory sessionFactory = emf.unwrap(Stage.SessionFactory.class);
        Mutiny.SessionFactory sessionFactory = emf.unwrap(Mutiny.SessionFactory.class);
        Mutiny.Session session = sessionFactory.openSession();

        session.find(Thing.class, id).invoke( thing -> {
            if (null!=thing)
                System.out.println(thing.getName() + " is a nice person!");
        }).await().indefinitely();

        session.createQuery("select id, name from Thing order by name desc")
                .getResultList()
                .invoke( list -> list.forEach(System.out::println) )
                .await().indefinitely();

        return session.find(Thing.class, id).await().indefinitely();
    }

    public Mono<Thing> getMonoThing(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ThingPU");
        Mutiny.SessionFactory sessionFactory = emf.unwrap(Mutiny.SessionFactory.class);
        Mutiny.Session session = sessionFactory.openSession();

        try {
            return Mono.fromFuture(session.find(Thing.class, id).subscribe().asCompletionStage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
