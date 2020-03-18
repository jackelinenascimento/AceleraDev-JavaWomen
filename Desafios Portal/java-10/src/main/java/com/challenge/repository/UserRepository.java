package com.challenge.repository;

import com.challenge.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query( value = "SELECT us.id, us.created_at, us.email," +
            " us.full_name, us.nickname, us.password" +
            " FROM  USERS us " +
            " INNER JOIN CANDIDATE c " +
            " ON c.user_id = us.id " +
            " INNER JOIN ACCELERATION acc " +
            " ON acc.id = c.acceleration_id " +
            " WHERE acc.name = :name ", nativeQuery = true )
    List<User> findUserByAccelerationName( @Param("name") String name );


    @Query(value = "SELECT us.id, us.created_at, us.email," +
            " us.full_name, us.nickname, us.password" +
            " FROM  USERS us " +
            " INNER JOIN CANDIDATE c " +
            " ON c.user_id = us.id " +
            " INNER JOIN COMPANY comp " +
            " ON comp.id = c.company_id " +
            " WHERE comp.id = :companyId ", nativeQuery = true )
    List<User> findByCompanyId( @Param("companyId") Long companyId );

}