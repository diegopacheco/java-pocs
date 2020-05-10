package com.github.diegopacheco.sandboxspring.repo;

import com.github.diegopacheco.sandboxspring.meta.UpperCase;
import com.github.diegopacheco.sandboxspring.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Optional;

@Repository
public class RedisPersonRepository<T> {

    @Autowired
    private CrudRepository<T, String> repo;

    public T save(T entity) {
        try{
            for(Field f : entity.getClass().getDeclaredFields()){
                if (f.isAnnotationPresent(UpperCase.class)){
                    Method getter = entity.getClass().getMethod("get" + toCamelCase(f.getName()));
                    Method setter = entity.getClass().getMethod("set" + toCamelCase(f.getName()), f.getType() );

                    Object value = getter.invoke(entity);
                    if (null!=value)
                        setter.invoke(entity,value.toString().toUpperCase());
                }
            }

            return repo.save(entity);

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    private String toCamelCase(String name){
        return (name.charAt(0) + "").toUpperCase() + name.substring(1);
    }

    public Iterable<T> saveAll(Iterable<T> entities) {
        return repo.saveAll(entities);
    }

    public Optional<T> findById(String s) {
        return repo.findById(s);
    }

    public boolean existsById(String s) {
        return repo.existsById(s);
    }

    public Iterable<T> findAll() {
        return repo.findAll();
    }

    public Iterable<T> findAllById(Iterable<String> strings) {
        return repo.findAllById(strings);
    }

    public long count() {
        return repo.count();
    }

    public void deleteById(String s) {
        repo.deleteById(s);
    }

    public void delete(T entity) {
        repo.delete(entity);
    }

    public void deleteAll(Iterable<? extends T> entities) {
        repo.deleteAll(entities);
    }

    public void deleteAll() {
        repo.deleteAll();
    }

}
