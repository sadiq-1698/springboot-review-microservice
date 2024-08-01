package com.sadiq1698.reviewsappmicroservice.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    boolean createReview(Long companyId, Review review);
    Review getAReview(Long id);
    boolean updateAReview(Long id, Review review);
    boolean deleteAReview(Long id);
}
