package ru.wd3.study.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.bind.annotation.*;
import ru.wd3.study.clients.dto.CardDto;
import ru.wd3.study.clients.enity.Card;
import ru.wd3.study.clients.repository.CardRepository;
import java.util.ArrayList;
import java.util.List;

@RestController

public class CardController {

    private final CardRepository cardRepository;

    public CardController(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @GetMapping("/api/cards")
    @JsonFormat
    public List<CardDto> getAll() {
        List<Card> cards = (List<Card>) this.cardRepository.findAll();
        List<CardDto> cardDtoList = new ArrayList<>();
        cards.forEach((card -> {
            CardDto cardDto = new CardDto(card.getNumber());
            cardDtoList.add(cardDto);
        }));

        return cardDtoList;
    }
}
