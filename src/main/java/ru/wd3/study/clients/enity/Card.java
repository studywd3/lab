package ru.wd3.study.clients.enity;

import javax.persistence.*;
import java.util.List;

@Table(name = "cards", schema = "public", indexes = {
        @Index(name = "idx_card_id", columnList = "id")
})
@Entity(name = "Card")
public class Card {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String number;

    @ManyToMany
    @JoinTable(name="client_card",
            joinColumns=@JoinColumn(name="card_id"),
            inverseJoinColumns=@JoinColumn(name="client_id"))
    private List<Client> clients;

    public void setNumber(String number) {
        this.number = number;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Integer getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public List<Client> getClients() {
        return clients;
    }
}
