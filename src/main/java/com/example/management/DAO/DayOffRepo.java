package com.example.management.DAO;

import com.example.management.DTO.AskDayOff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayOffRepo extends JpaRepository<AskDayOff, Long> {
}
