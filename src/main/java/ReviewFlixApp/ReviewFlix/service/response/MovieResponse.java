package ReviewFlixApp.ReviewFlix.service.response;

import ReviewFlixApp.ReviewFlix.domain.Genre;
import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class MovieResponse {
    private String title;
    private Genre genre;
    private Double rating;
    private List<ReviewResponse> reviews;
}
