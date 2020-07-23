package com.swann.repository;

import com.swann.entity.UserRegistration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends CrudRepository<UserRegistration, Long> {
}
