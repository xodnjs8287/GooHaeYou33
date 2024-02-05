package com.ll.gooHaeYu.domain.jobPost.jobPost.repository;

import com.ll.gooHaeYu.domain.jobPost.jobPost.entity.JobPost;
import org.springframework.data.jpa.domain.Specification;

public class JobPostSpecifications {

    public static Specification<JobPost> titleContains(String title) {
        return (root, query, criteriaBuilder) -> {
            if (title == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(root.get("title"), "%" + title + "%");
        };
    }

    public static Specification<JobPost> bodyContains(String body) {
        return (root, query, criteriaBuilder) -> {
            if (body == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(root.join("jobPostDetail").get("body"), "%" + body + "%");
        };
    }

    public static Specification<JobPost> titleOrBodyContains(String title, String body) {
        return Specification.where(titleContains(title)).or(bodyContains(body));
    }
}
