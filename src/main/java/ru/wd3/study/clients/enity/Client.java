package ru.wd3.study.clients.enity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "clients", schema = "public", indexes = {
        @Index(name = "idx_client_id", columnList = "id")
})
@Entity(name = "Client")
public class Client {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "client_card",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "card_id")
    )
    private List<Card> cards;

    @OneToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="type_id")
    private Type type;

    private String fio;

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Integer getId() {
        return id;
    }

    public List<Card> getCards() {
        return cards;
    }

    public Type getType() {
        return type;
    }

    public String getFio() {
        return fio;
    }

    public List<String> getCardNumbers() {
        List<String> numbers = new ArrayList<>();
        this.cards.forEach(card -> {
            numbers.add(card.getNumber());
        });
        return numbers;
    }
}
