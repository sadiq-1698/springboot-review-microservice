package com.sadiq1698.reviewsappmicroservice.review;

import com.sadiq1698.reviewsappmicroservice.review.Review;
import com.sadiq1698.reviewsappmicroservice.review.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Review>> getAllReviews(@RequestParam Long companyId) {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addAReview(@RequestParam Long companyId, @RequestBody Review review) {
        boolean reviewAdded = reviewService.createReview(companyId, review);
        if(!reviewAdded)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>("Review added successfully", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getAReview(@PathVariable Long id) {
        return new ResponseEntity<>(reviewService.getAReview(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAReview(@PathVariable Long id, @RequestBody Review review) {
        boolean isUpdated = reviewService.updateAReview(id, review);
        if(isUpdated)
            return new ResponseEntity<>("Review updated successfully", HttpStatus.OK);
        return new ResponseEntity<>("Failed updating review", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAReview(@PathVariable Long id) {
        boolean isDeleted = reviewService.deleteAReview(id);
        if(isDeleted)
            return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
        return new ResponseEntity<>("Failed deleting review", HttpStatus.NOT_FOUND);
    }

}
