package ru.wd3.study.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.bind.annotation.*;
import ru.wd3.study.clients.dto.ClientDto;
import ru.wd3.study.clients.services.ClientService;
import java.util.List;

@RestController

public class ClientController {
    public final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/api/clients")
    @JsonFormat
    public List<ClientDto> getAll() {
        return this.clientService.getAll();
    }

    @GetMapping("/api/clients/{id}")
    @JsonFormat
    public @ResponseBody
    ClientDto getById(@PathVariable Integer id) throws Exception {
        return this.clientService.getById(id);
    }

    @PostMapping("/api/clients")
    @JsonFormat
    public @ResponseBody
    ClientDto create(@RequestBody ClientDto clientDto) {
        this.clientService.create(clientDto);
        return clientDto;
    }

    @PutMapping("/api/clients/{id}")
    @JsonFormat
    public @ResponseBody
    ClientDto updateById(@RequestBody ClientDto clientDto, @PathVariable Integer id) throws Exception {
        this.clientService.update(clientDto, id);
        return this.clientService.getById(id);
    }

    @DeleteMapping("/api/clients/{id}")
    void delete(@PathVariable Integer id) {
        this.clientService.delete(id);
    }


}
