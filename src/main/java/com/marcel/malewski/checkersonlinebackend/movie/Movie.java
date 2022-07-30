package com.marcel.malewski.checkersonlinebackend.movie;


import com.marcel.malewski.checkersonlinebackend.actor.Actor;

import java.time.LocalDate;
import java.util.List;

public record Movie(Integer id,
                    String name,
                    List<Actor> actors,
                    LocalDate releaseDate) {

}
