package ru.wd3.study.clients.repository;

import org.springframework.data.repository.CrudRepository;
import ru.wd3.study.clients.enity.Card;

import java.util.Collection;
import java.util.List;

public interface CardRepository extends CrudRepository<Card, Integer> {
    List<Card> findByNumberIn(Collection<String> numbers);
}
