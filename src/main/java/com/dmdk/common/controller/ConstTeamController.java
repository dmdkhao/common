package com.dmdk.common.controller;

import com.dmdk.common.domain.ConstTeamEntity;
import com.dmdk.common.repository.ConstNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/constTeam")
public class ConstTeamController {

    private final ConstNameRepository constNameRepository;

    @Autowired
    public ConstTeamController(ConstNameRepository constNameRepository) {
        this.constNameRepository = constNameRepository;
    }

    @GetMapping("/all")
    public List<ConstTeamEntity> getAll() {
        return constNameRepository.findAll();
    }
}
