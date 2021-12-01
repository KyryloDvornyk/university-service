package com.example.university.repository;

import java.time.LocalDateTime;
import java.util.List;
import com.example.university.model.Group;
import com.example.university.model.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TimetableRepository extends JpaRepository<Timetable, Long> {
    @Query("SELECT t FROM Timetable t WHERE t.group = :group " +
            "AND t.startTime >= :startDate AND t.startTime <= :endDate")
    List<Timetable> findAllByGroupAndDate(Group group,
                                          LocalDateTime startDate, LocalDateTime endDate);
}
