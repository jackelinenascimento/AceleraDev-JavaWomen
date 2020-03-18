package com.challenge.service.interfaces.Implements;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import com.challenge.repository.CandidateRepository;
import com.challenge.service.interfaces.CandidateServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CandidateService implements CandidateServiceInterface {

    @Autowired
    CandidateRepository candidateRepository;

    public Optional<Candidate> findById(CandidateId id) {
        return candidateRepository.findByUserIdCompanyIdAccelerationId(id.getUser().getId(), id.getCompany().getId(), id.getAcceleration().getId());
    }

    @Override
    public Optional<Candidate> findById( Long userId, Long companyId, Long accelerationId ) {
        return candidateRepository.findByUserIdCompanyIdAccelerationId(userId, companyId, accelerationId);
    }

    @Override
    public List<Candidate> findByCompanyId( Long companyId ) {
        return candidateRepository.findByIdCompany(companyId);
    }

    @Override
    public List<Candidate> findByAccelerationId( Long accelerationId ) {
        return candidateRepository.findByIdAcceleration(accelerationId);
    }

    @Override
    public Candidate save( Candidate candidate ) {
        return candidateRepository.save(candidate);
    }
}
