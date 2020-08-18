package com.example.management.repository;

import com.example.management.dto.AskDayOff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DayOffRepo extends JpaRepository<AskDayOff, Long> {
    List<AskDayOff> findByEmployeeManager_id(long managerId);
    List<AskDayOff> findByEmployee_Id(long id);
}
