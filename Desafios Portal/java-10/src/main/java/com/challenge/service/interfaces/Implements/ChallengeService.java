package com.challenge.service.interfaces.Implements;

import com.challenge.entity.Challenge;
import com.challenge.repository.ChallengeRepository;
import com.challenge.service.interfaces.ChallengeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ChallengeService implements ChallengeServiceInterface {

    @Autowired
    ChallengeRepository challengeRepository;

    @Override
    public List<Challenge> findByAccelerationIdAndUserId( Long accelerationId, Long userId ) {

        return challengeRepository.findByAccelerationIdAndUserId(accelerationId, userId);
    }

    @Override
    public Challenge save( Challenge challenge) {
        return challengeRepository.save(challenge);
    }
}
