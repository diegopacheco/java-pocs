package com.github.diegopacheco.jooq.repository;

import com.github.diegopacheco.jooq.generated.tables.records.UsersRecord;
import static com.github.diegopacheco.jooq.generated.tables.Users.USERS;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.github.diegopacheco.jooq.model.UserDTO;

@Repository
public class UserRepository {

    private final DSLContext dsl;

    public UserRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    public List<UserDTO> findAll() {
        return dsl.selectFrom(USERS)
                .fetchInto(UserDTO.class);
    }

    public UserDTO findById(Integer id) {
        return dsl.selectFrom(USERS)
                .where(USERS.ID.eq(id))
                .fetchOneInto(UserDTO.class);
    }

    public UserDTO create(String name) {
        // Insert record
        UsersRecord record = dsl.insertInto(USERS)
                .set(USERS.NAME, name)
                .returning(USERS.ID, USERS.NAME)
                .fetchOne();
        return new UserDTO(record.getId(), record.getName());
    }

    public UserDTO update(Integer id, String name) {
        dsl.update(USERS)
                .set(USERS.NAME, name)
                .where(USERS.ID.eq(id))
                .execute();
        return findById(id);
    }

    public void delete(Integer id) {
        dsl.deleteFrom(USERS)
                .where(USERS.ID.eq(id))
                .execute();
    }
}