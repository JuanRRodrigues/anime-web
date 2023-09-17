package br.com.jrr.animeweb.controller;

import br.com.jrr.animeweb.domain.anime.Anime;
import br.com.jrr.animeweb.domain.anime.AnimeEditData;
import br.com.jrr.animeweb.domain.anime.AnimeRegistrationData;
import br.com.jrr.animeweb.domain.anime.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/animes")
public class AnimeController {

    @Autowired
    private AnimeRepository repository;

    @GetMapping("/form")
    public String loadingPageForm(Long id, Model model) {
        if(id != null){
            var anime = repository.getReferenceById(id);
            model.addAttribute("anime", anime);
        }
        return "animes/form";
    }

    @GetMapping
    public String loadingPageListing(Model model){
        model.addAttribute("list", repository.findAll());
        return "animes/listing";
    }

    @PostMapping
    @Transactional
    public String registerAnime(AnimeRegistrationData data){
        var anime = new Anime(data);

        repository.save(anime);
        return "redirect:/animes";
    }

    @PutMapping
    @Transactional
    public String editAnime(AnimeEditData data){
        var anime = repository.getReferenceById(data.id());
        anime.editData(data);

        return "redirect:/animes";
    }

    @DeleteMapping
    @Transactional
    public String deleteAnime(Long id){
        repository.deleteById(id);

        return "redirect:/animes";
    }
}
