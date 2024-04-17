package com.lazyvic.web.api;

import com.lazyvic.Taco;
import com.lazyvic.data.TacoRepository;
import com.lazyvic.messaging.TestMessageService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/api/tacos", produces="application/json")
@CrossOrigin(origins="http://localhost:8080")
public class TacoController {
    private TacoRepository tacoRepo;
    private TestMessageService testMessageService;

    public TacoController(TacoRepository tacoRepo, TestMessageService testMessageService) {
        this.tacoRepo = tacoRepo;
        this.testMessageService = testMessageService;
    }

    @GetMapping(params="recent")
    public Iterable<Taco> recentTacos() {
        testMessageService.sendMessage("Hello Jms");
        PageRequest page = PageRequest.of(0, 12, Sort.by("createdAt").descending());
        return tacoRepo.findAll(page).getContent();
    }

    @GetMapping(params="test")
    public String test() {
        PageRequest page = PageRequest.of(0, 12, Sort.by("createdAt").descending());
        return "This is test api";
    }

}
