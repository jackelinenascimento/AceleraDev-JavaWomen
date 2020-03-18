package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {

    @Query(value = "SELECT ch.id, ch.created_at, ch.name, ch.slug" +
            " FROM CHALLENGE ch" +
            " INNER JOIN ACCELERATION acc" +
            " ON acc.challenge_id = ch.id" +
            " INNER JOIN CANDIDATE c" +
            " ON c.acceleration_id = acc.id" +
            " INNER JOIN USERS us" +
            " ON us.id = c.user_id" +
            " WHERE c.user_id = :userId" +
            " AND c.acceleration_id = :accelerationId", nativeQuery = true)
    List<Challenge> findByAccelerationIdAndUserId( @Param("accelerationId") Long accelerationId, @Param("userId") Long userId);
}
