package ReviewFlixApp.ReviewFlix.controller;

import ReviewFlixApp.ReviewFlix.service.ReviewService;
import ReviewFlixApp.ReviewFlix.service.request.ReviewRequest;
import ReviewFlixApp.ReviewFlix.service.response.ReviewResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping("/add")
    public void addReview(@RequestBody ReviewRequest reviewRequest) {
        reviewService.addReview(reviewRequest.toReview());
    }

    @GetMapping("/find")
    public ReviewResponse getReview(@RequestParam Long reviewId) {
        return reviewService.getReviewById(reviewId);
    }
}
