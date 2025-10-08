package com.github.diegopacheco.javapocs.debezium;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataEventRepository extends JpaRepository<DataEvent, Long> {
}
