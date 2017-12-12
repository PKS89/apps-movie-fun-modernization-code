package org.superbiz.moviefun.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    @Autowired
    MoviesRepository repository;

    @PostMapping
    public void addMovie(@RequestBody Movie movie){
        repository.addMovie(movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id){
        repository.deleteMovieId(id);
    }


    @GetMapping("/count")
    public int count(@RequestParam(name = "field", required = false) String field,
                     @RequestParam(name = "key", required = false) String key ){
        if (field != null && key != null) {
            return repository.count(field, key);
        } else {
            return repository.countAll();
        }
    }


    @GetMapping
    public List<Movie> find(
            @RequestParam(name = "field", required = false) String field,
            @RequestParam(name = "key", required = false) String key,
            @RequestParam(name = "start", required = false) Integer start,
            @RequestParam(name = "pageSize", required = false) Integer pageSize
    ) {
        if (field != null && key != null) {
            return repository.findRange(field, key, start, pageSize);
        } else if (start != null && pageSize != null) {
            return repository.findAll(start, pageSize);
        } else {
            return repository.getMovies();
        }
    }


}
