package com.github.diegopacheco.sandboxspring.mapper;

import com.github.diegopacheco.sandboxspring.model.Person;
import org.apache.ibatis.annotations.*;

import java.util.Collection;

@Mapper
public interface PersonMapper {

    @Options(useGeneratedKeys = true)
    @Insert("insert into person(first_name, last_name) values(#{first_name}, #{last_name})")
    void insert(Person person);

    @Select("select * from person")
    Collection<Person> selectAll();

    @Delete("delete from person where id = #{id}")
    void deleteById(long id);

    @Select("select * from person where id = #{id}")
    Collection<Person> search(@Param("id") Integer id);

}
