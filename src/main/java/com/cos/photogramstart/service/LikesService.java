package com.cos.photogramstart.service;

import com.cos.photogramstart.domain.likes.LikesRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LikesService {

    private final LikesRepository likesRepository;

    @Transactional
    public void Like(Integer imageId, Integer principalId) {
        likesRepository.mLikes(imageId, principalId);
    }

    @Transactional
    public void UnLike(Integer imageId, Integer principalId) {
        likesRepository.mUnLikes(imageId, principalId);
    }
}
