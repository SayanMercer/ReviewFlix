package ReviewFlixApp.ReviewFlix.service;

import ReviewFlixApp.ReviewFlix.domain.Movie;
import ReviewFlixApp.ReviewFlix.repository.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private MovieRepository movieRepository;

    //constructor injection
    public AdminService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie addMovie(Movie movie){
        return movieRepository.save(movie);
    }
}