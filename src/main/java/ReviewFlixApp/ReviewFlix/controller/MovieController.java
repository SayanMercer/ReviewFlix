package ReviewFlixApp.ReviewFlix.controller;

import ReviewFlixApp.ReviewFlix.service.MovieService;
import ReviewFlixApp.ReviewFlix.service.response.MovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/title")
    public MovieResponse findMovie(@RequestParam String title){
        return movieService.findMovie(title);

        //hello who are you
        //hey baby
    }

}
