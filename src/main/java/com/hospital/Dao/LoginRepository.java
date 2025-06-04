package com.hospital.Dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hospital.entity.Login;

@Repository
public interface LoginRepository extends CrudRepository<Login, Integer> {

	@Query(value = "SELECT * FROM user_table WHERE userName = :userName AND password = :password", nativeQuery = true)
	Login findByLoginDetails(@Param("userName") String userName, @Param("password") String password);

}
