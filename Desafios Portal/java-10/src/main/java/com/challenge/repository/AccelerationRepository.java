package com.challenge.repository;

import com.challenge.entity.Acceleration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AccelerationRepository extends JpaRepository<Acceleration, Long> {

    @Query(value = "SELECT acc.id, acc.created_at, acc.name," +
            " acc.slug, acc.challenge_id " +
            " FROM  ACCELERATION acc " +
            " INNER JOIN CANDIDATE c " +
            " ON c.acceleration_id = acc.id " +
            " INNER JOIN COMPANY comp " +
            " ON comp.id = c.company_id " +
            " WHERE comp.id = :companyId ", nativeQuery = true )
    List<Acceleration> findByCompanyId( @Param("companyId") Long companyId );
}
