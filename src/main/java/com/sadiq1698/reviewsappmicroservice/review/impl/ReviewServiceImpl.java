package com.sadiq1698.reviewsappmicroservice.review.impl;

import com.sadiq1698.reviewsappmicroservice.review.Review;
import com.sadiq1698.reviewsappmicroservice.review.ReviewRepository;
import com.sadiq1698.reviewsappmicroservice.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews =  reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean createReview(Long companyId, Review review) {
        if(companyId != null && review  != null) {
            review.setCompanyId(companyId);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getAReview(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updateAReview(Long id, Review review) {
        Review _review = reviewRepository.findById(id).orElse(null);
        if(_review != null) {
            review.setDescription(review.getDescription());
            review.setTitle(review.getTitle());
            review.setRating(review.getRating());
            review.setCompanyId(review.getCompanyId());
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAReview(Long id) {
        Review review = reviewRepository.findById(id).orElse(null);
        if(review == null) return false;

        reviewRepository.deleteById(id);
        return true;
    }
}
