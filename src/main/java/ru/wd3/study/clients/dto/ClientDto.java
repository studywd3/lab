package ru.wd3.study.clients.dto;

import java.util.List;

public class ClientDto {
    String fio;
    String type;
    List<String> cards;

    public ClientDto(String fio, String type, List<String> cards) {
        this.fio = fio;
        this.type = type;
        this.cards = cards;
    }

    public String getFio() {
        return fio;
    }

    public String getType() {
        return type;
    }

    public List<String> getCards() {
        return cards;
    }
}
