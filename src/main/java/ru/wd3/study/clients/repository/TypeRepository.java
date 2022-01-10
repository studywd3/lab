package ru.wd3.study.clients.repository;

import org.springframework.data.repository.CrudRepository;
import ru.wd3.study.clients.enity.Type;
import java.util.Collection;
import java.util.List;

public interface TypeRepository extends CrudRepository<Type, Integer> {
    List<Type> findByTitle(String title);
}
