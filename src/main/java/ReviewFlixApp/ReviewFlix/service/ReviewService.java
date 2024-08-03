package ReviewFlixApp.ReviewFlix.service;

import ReviewFlixApp.ReviewFlix.domain.Movie;
import ReviewFlixApp.ReviewFlix.domain.Review;
import ReviewFlixApp.ReviewFlix.repository.MovieRepository;
import ReviewFlixApp.ReviewFlix.repository.ReviewRepository;
import ReviewFlixApp.ReviewFlix.service.response.ReviewResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

//    public void addReview(Review review) {
//        Movie movie = movieRepository.findById(review.getMovie().getId()).orElse(null);
//        reviewRepository.save(review);
//        //need to optimized
//        //exception handling.
//        if (movie != null) {
//            Double average = reviewRepository.getReviewAverage(movie.getId());
//            movie.setRating(average);
//            movieRepository.save(movie);
//        }
//
//    }

    public String  addReview(Review review) {
//        try {
//            Movie movie = movieRepository.findById(review.getMovie().getId()).orElse(null);
//
//            if (movie == null) {
//                throw new EntityNotFoundException("Movie not found with ID: " + review.getMovie().getId());
//            }
//
//            reviewRepository.save(review);
//
//            // Get the new average rating
//            Double average = reviewRepository.getReviewAverage(movie.getId());
//            movie.setRating(average);
//            movieRepository.save(movie);
//
//        } catch (EntityNotFoundException e) {
//            // Handle case where movie is not found
//            System.err.println("Error: " + e.getMessage());
//            // You can also log this exception or take further actions if needed
//        } catch (DataAccessException e) {
//            // Handle any database related exceptions
//            System.err.println("Database error occurred: " + e.getMessage());
//            // Log the exception and/or perform other error recovery actions
//        } catch (Exception e) {
//            // Handle any other exceptions that might occur
//            System.err.println("An unexpected error occurred: " + e.getMessage());
//            // Log the exception and/or take further actions as needed
//        }

        try {
            Movie movie = movieRepository.findById(review.getMovie().getId()).orElse(null);

            if (movie == null) {
                throw new EntityNotFoundException("Movie not found with ID: " + review.getMovie().getId());
            }

            reviewRepository.save(review);

            // Get the new average rating
            Double average = reviewRepository.getReviewAverage(movie.getId());
            movie.setRating(average);
            movieRepository.save(movie);

            return "Review added successfully.";

        } catch (EntityNotFoundException e) {
            // Handle case where movie is not found
            System.err.println("Error: " + e.getMessage());
            return "Error: " + e.getMessage();
        } catch (DataAccessException e) {
            // Handle any database related exceptions
            System.err.println("Database error occurred: " + e.getMessage());
            return "Database error occurred: " + e.getMessage();
        } catch (Exception e) {
            // Handle any other exceptions that might occur
            System.err.println("An unexpected error occurred: " + e.getMessage());
            return "An unexpected error occurred: " + e.getMessage();
        }


    }


    public ReviewResponse getReviewById(Long reviewId) {

        Optional<Review> review = reviewRepository.findById(reviewId);
        return review.map(Review::toReviewResponse).orElse(null);

    }
}