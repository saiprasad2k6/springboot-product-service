package com.sps.springbootproductservice.demo.joinedtable;

import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("jtMentorRepository")
public interface MentorRepository extends JpaRepository<Mentor, Long> {
    @Override
    <M extends Mentor> M save(M Entity);
}
