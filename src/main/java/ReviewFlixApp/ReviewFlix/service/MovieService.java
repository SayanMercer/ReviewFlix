package ReviewFlixApp.ReviewFlix.service;

import ReviewFlixApp.ReviewFlix.domain.Movie;
import ReviewFlixApp.ReviewFlix.repository.MovieRepository;
import ReviewFlixApp.ReviewFlix.service.response.MovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;
    public MovieResponse findMovie(String title) {
        //write fetch from repo.
        // handle not exist scenarios
        //caching logic
        //exception handling
        Movie movie = movieRepository.findByTitle(title);
        if (Objects.nonNull(movie))
            return movie.toMovieResponse();
        return null;
    }
}
