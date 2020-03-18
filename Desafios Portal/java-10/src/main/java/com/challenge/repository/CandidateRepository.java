package com.challenge.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, CandidateId> {

    @Query(value = "SELECT * " +
            " FROM CANDIDATE c " +
            " WHERE c.company_id = :companyId", nativeQuery = true)
    List<Candidate> findByIdCompany( @Param("companyId") Long companyId);

    @Query(value = "SELECT * " +
            " FROM  CANDIDATE c " +
            " WHERE c.acceleration_id = :accelerationId", nativeQuery = true)
    List<Candidate> findByIdAcceleration(@Param("accelerationId") Long accelerationId);

    @Query(value = "SELECT * " +
            " FROM CANDIDATE c " +
            " WHERE c.user_id = :userId " +
            " AND c.company_id = :companyId " +
            " AND c.acceleration_id = :accelerationId", nativeQuery = true)
    Optional<Candidate> findByUserIdCompanyIdAccelerationId( @Param("userId") Long userId, @Param("companyId") Long companyId,  @Param("accelerationId") Long accelerationId);
}
