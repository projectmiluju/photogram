package com.cos.photogramstart.service;

import com.cos.photogramstart.domain.subscribe.SubscribeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class SubscribeService {

    private final SubscribeRepository subscribeRepository;

    @Transactional
    public void 구독하기(Integer fromUserId, Integer toUserId) {

        subscribeRepository.mSubScribe(fromUserId, toUserId);

    }

    @Transactional
    public void 구독취소하기(Integer fromUserId, Integer toUserId) {

        subscribeRepository.mUnSubscribe(fromUserId, toUserId);

    }
}
