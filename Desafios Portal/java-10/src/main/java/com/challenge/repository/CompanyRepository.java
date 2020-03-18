package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query( value = "SELECT DISTINCT comp.*" +
            " FROM COMPANY comp" +
            " INNER JOIN CANDIDATE c" +
            " ON comp.id = c.company_id" +
            " INNER JOIN USERS us" +
            " ON us.id = c.user_id" +
            " WHERE c.acceleration_id = :accelerationId" , nativeQuery = true)
    List<Company> findByAccelerationId( @Param("accelerationId") Long accelerationId);


    @Query( value = "SELECT comp.id, comp.created_at, comp.name, comp.slug" +
            " FROM COMPANY comp" +
            " INNER JOIN CANDIDATE c" +
            " ON comp.id = c.company_id" +
            " INNER JOIN USERS us" +
            " ON us.id = c.user_id" +
            " WHERE c.user_id = :userId" , nativeQuery = true)
    List<Company> findByUserId( @Param("userId") Long userId);
}
