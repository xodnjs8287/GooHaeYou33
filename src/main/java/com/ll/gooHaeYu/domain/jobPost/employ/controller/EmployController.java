package com.ll.gooHaeYu.domain.jobPost.employ.controller;

import com.ll.gooHaeYu.domain.application.application.dto.ApplicationDto;
import com.ll.gooHaeYu.domain.jobPost.employ.service.EmployService;
import com.ll.gooHaeYu.global.rsData.RsData;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Employ", description = "구인 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employ/{postId}")
public class EmployController {
    private final EmployService employService;

    @GetMapping
    public RsData<List<ApplicationDto>> getList(Authentication authentication,
                                                @PathVariable Long postId) {
        return RsData.of(employService.getList(authentication.getName(), postId));
    }

    @PostMapping("/{applicationIds}")
    public ResponseEntity<Void> approve(Authentication authentication,
                        @PathVariable Long postId,
                        @PathVariable List<Long> applicationIds) {
        employService.approve(authentication.getName(), postId, applicationIds);

        return ResponseEntity.noContent().build();
    }
}
