package com.hospital.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hospital.entity.Login;

@Repository
public interface LoginRepository extends CrudRepository<Login, Integer> {

	@Query(value = "SELECT * FROM user_table WHERE username = :username AND password = :password", nativeQuery = true)
	Optional<Login> findByLoginDetails(@Param("username") String username, @Param("password") String password);

//	Login findByUsernameAndPassword(String username, String password);
}
