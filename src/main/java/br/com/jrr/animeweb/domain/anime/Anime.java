package br.com.jrr.animeweb.domain.anime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "animes")
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer duration;
    private Integer year;
    private String genre;


    public Anime(AnimeRegistrationData data){
        this.name = data.name();
        this.duration = data.duration();
        this.year = data.year();
        this.genre = data.genre();

    }

    public Anime(){}

    @Override
    public String toString() {
        return "Anime{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                '}';
    }

    public void editData(AnimeEditData data) {
        this.name = data.name();
        this.duration = data.duration();
        this.year = data.year();
        this.genre = data.genre();
    }
}
