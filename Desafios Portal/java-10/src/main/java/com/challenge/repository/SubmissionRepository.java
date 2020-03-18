package com.challenge.repository;

import com.challenge.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long> {

    @Query(value = "SELECT COALESCE(MAX(sub.score), 0)" +
            " FROM SUBMISSION sub" +
            " INNER JOIN CHALLENGE ch" +
            " ON sub.challenge_id = ch.id" +
            " WHERE ch.id = :challengeId", nativeQuery = true)
    BigDecimal findHigherScoreByChallengeId( @Param("challengeId") Long challengeId );

    @Query(value = "SELECT sub.challenge_id, sub.score, sub.user_id, sub.created_at" +
            " FROM submission sub " +
            " INNER JOIN challenge ch " +
            " ON sub.challenge_id = ch.id " +
            " INNER JOIN acceleration acc " +
            " ON acc.challenge_id = ch.id " +
            " WHERE ch.id = :challengeId " +
            " AND acc.id = :accelerationId", nativeQuery = true)
    List<Submission> findByChallengeIdAndAccelerationId( @Param("challengeId") Long challengeId, @Param("accelerationId") Long accelerationId);
}
