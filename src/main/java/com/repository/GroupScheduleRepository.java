package com.repository;

import com.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupScheduleRepository extends JpaRepository<GroupSchedule, Long>
{ }
