package ru.wd3.study.clients.repository;

import org.springframework.data.repository.CrudRepository;
import ru.wd3.study.clients.enity.Client;

public interface ClientRepository extends CrudRepository<Client, Integer> {
}
