package com.example.university.util;

import java.time.LocalDateTime;
import com.example.university.model.Group;
import com.example.university.model.Lecture;
import com.example.university.model.Student;
import com.example.university.model.Timetable;
import com.example.university.repository.GroupRepository;
import com.example.university.repository.LectureRepository;
import com.example.university.repository.StudentRepository;
import com.example.university.repository.TimetableRepository;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class DataInitializer {
    private final LectureRepository lectureRepository;
    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;
    private final TimetableRepository timetableRepository;

    public DataInitializer(LectureRepository lectureRepository, GroupRepository groupRepository,
                           StudentRepository studentRepository, TimetableRepository timetableRepository) {
        this.lectureRepository = lectureRepository;
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
        this.timetableRepository = timetableRepository;
    }

    @PostConstruct
    public void testData() {
        Lecture history = new Lecture();
        history.setSubject("History");
        lectureRepository.save(history);
        Lecture science = new Lecture();
        science.setSubject("Science");
        lectureRepository.save(science);
        Lecture biology = new Lecture();
        biology.setSubject("Biology");
        lectureRepository.save(biology);

        Group group1 = new Group();
        group1.setName("A-1");
        groupRepository.save(group1);
        Group group2 = new Group();
        group2.setName("A-2");
        groupRepository.save(group2);

        Student bob = new Student();
        bob.setGroup(group1);
        bob.setName("Bob");
        studentRepository.save(bob);
        Student jack = new Student();
        jack.setGroup(group1);
        jack.setName("Jack");
        studentRepository.save(jack);
        Student alice = new Student();
        alice.setGroup(group2);
        alice.setName("Alice");
        studentRepository.save(alice);

        Timetable timetableHistoryGroup1 = new Timetable();
        timetableHistoryGroup1.setStartTime(LocalDateTime.of(2021, 12, 10, 12, 30));
        timetableHistoryGroup1.setGroup(group1);
        timetableHistoryGroup1.setLecture(history);
        timetableRepository.save(timetableHistoryGroup1);
        Timetable timetableScienceGroup1 = new Timetable();
        timetableScienceGroup1.setStartTime(LocalDateTime.of(2021, 12, 10, 14, 0));
        timetableScienceGroup1.setGroup(group1);
        timetableScienceGroup1.setLecture(science);
        timetableRepository.save(timetableScienceGroup1);
        Timetable timetableHistoryGroup2 = new Timetable();
        timetableHistoryGroup2.setStartTime(LocalDateTime.of(2021, 12, 10, 10, 0));
        timetableHistoryGroup2.setGroup(group2);
        timetableHistoryGroup2.setLecture(history);
        timetableRepository.save(timetableHistoryGroup2);
        Timetable timetableBiologyGroup2 = new Timetable();
        timetableBiologyGroup2.setStartTime(LocalDateTime.of(2021, 12, 11, 12, 30));
        timetableBiologyGroup2.setGroup(group2);
        timetableBiologyGroup2.setLecture(biology);
        timetableRepository.save(timetableBiologyGroup2);
    }
}
