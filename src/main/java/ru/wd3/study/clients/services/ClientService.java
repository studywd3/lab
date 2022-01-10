package ru.wd3.study.clients.services;

import org.springframework.stereotype.Service;
import ru.wd3.study.clients.dto.ClientDto;
import ru.wd3.study.clients.repository.CardRepository;
import ru.wd3.study.clients.repository.ClientRepository;

import ru.wd3.study.clients.enity.Client;
import ru.wd3.study.clients.enity.Card;
import ru.wd3.study.clients.enity.Type;
import ru.wd3.study.clients.repository.TypeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final CardRepository cardRepository;
    private final TypeRepository typeRepository;

    public ClientService(ClientRepository clientRepository, CardRepository cardRepository, TypeRepository typeRepository) {
        this.clientRepository = clientRepository;
        this.cardRepository = cardRepository;
        this.typeRepository = typeRepository;
    }

    public List<ClientDto> getAll() {
        List<Client> clients = (List<Client>) this.clientRepository.findAll();
        List<ClientDto> clientDtoList = new ArrayList<>();

        clients.forEach((client -> {
            ClientDto clientDto = new ClientDto(client.getFio(), client.getType().getTitle(), client.getCardNumbers());
            clientDtoList.add(clientDto);
        }));

        return clientDtoList;
    }

    public ClientDto getById(Integer id) throws Exception {
        Optional<Client> clientOpt = Optional.ofNullable(
                this.clientRepository.findById(id).orElseThrow(() -> new Exception("Client not found"))
        );
        Client client = clientOpt.get();
        return new ClientDto(client.getFio(), client.getType().getTitle(), client.getCardNumbers());
    }

    public void create(ClientDto dto) {
        Client client = new Client();
        List<Card> cards = this.cardRepository.findByNumberIn(dto.getCards());
        Type type = (Type) this.typeRepository.findByTitle(dto.getType());
        client.setCards(cards);
        client.setFio(dto.getFio());
        client.setType(type);
        this.clientRepository.save(client);
    }

    public void update(ClientDto dto, Integer id) {
        List<Card> cards = this.cardRepository.findByNumberIn(dto.getCards());
        Type type = (Type) this.typeRepository.findByTitle(dto.getType());
        this.clientRepository.findById(id).map(client -> {
            client.setCards(cards);
            client.setFio(dto.getFio());
            client.setType(type);
            return this.clientRepository.save(client);
        });
    }

    public void delete(Integer id) {
        this.clientRepository.deleteById(id);
    }
}
