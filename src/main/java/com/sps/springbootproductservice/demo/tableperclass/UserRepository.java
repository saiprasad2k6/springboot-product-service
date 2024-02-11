package com.sps.springbootproductservice.demo.tableperclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("tbcUserRepository")
public interface UserRepository extends JpaRepository<User, Long> {

    <U extends User> U save(U entity);
}
