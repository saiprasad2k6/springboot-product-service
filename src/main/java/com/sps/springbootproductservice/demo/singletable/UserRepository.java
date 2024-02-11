package com.sps.springbootproductservice.demo.singletable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    <U extends User> U save(U entity);
}
