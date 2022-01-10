package ru.wd3.study.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.bind.annotation.*;
import ru.wd3.study.clients.dto.TypeDto;
import ru.wd3.study.clients.enity.Type;
import ru.wd3.study.clients.repository.TypeRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TypeController {
    private final TypeRepository typeRepository;

    public TypeController(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @GetMapping("/api/types")
    @JsonFormat
    public List<TypeDto> getAll() {
        List<Type> types = (List<Type>) this.typeRepository.findAll();
        List<TypeDto> typeDtoList = new ArrayList<>();
        types.forEach((type -> {
            TypeDto typeDto = new TypeDto(type.getTitle());
            typeDtoList.add(typeDto);
        }));

        return typeDtoList;
    }
}
