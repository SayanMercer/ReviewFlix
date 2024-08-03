package ReviewFlixApp.ReviewFlix.service.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class ReviewResponse {
    private String review;
    private Double rating;
}
