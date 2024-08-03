package ReviewFlixApp.ReviewFlix.domain;

import ReviewFlixApp.ReviewFlix.service.response.ReviewResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;


import java.sql.Date;
import java.util.ArrayList;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name="review_table")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class Review {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String movieReview;

    private double rating;  // rating dedicated to each review.

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    @JsonIgnore
//    private Movie movie; // it will add foregion key in mysql table with <TABLE_NAME>_<ID_NAME> --> // movie_movie_id

//    @Getter
//    public Movie getMovie() {
//        return movie;
//    }

    private Movie movie;
    // other fields and methods


    @CreationTimestamp
    private Date createdon;

    @UpdateTimestamp
    private Date updatedon;

    public static ReviewResponse toReviewResponse(Review review){
        return ReviewResponse.builder().review(review.movieReview).rating(review.rating).build();
    }

    public static List<ReviewResponse> toReviewResponse(List<Review> reviewList){
        if(Objects.isNull(reviewList))
            return new ArrayList<>();
        else
            return reviewList.stream().map(Review::toReviewResponse).collect(Collectors.toList());
    }

}



