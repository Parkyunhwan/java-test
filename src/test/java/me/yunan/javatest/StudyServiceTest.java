package me.yunan.javatest;

import me.yunan.javatest.domain.Member;
import me.yunan.javatest.domain.Study;
import me.yunan.javatest.member.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudyServiceTest {

    @Mock
    MemberService memberService;

    @Mock
    StudyRepository studyRepository;

    @Test
    void createStudyService() {
        MemberService memberService = mock(MemberService.class);
        StudyRepository studyRepository = mock(StudyRepository.class);
        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);
    }

    @Test
    void createStudyServiceAnnotation() {
        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);
    }

    @Test
    void createStudyServiceAnnotationParameter(@Mock MemberService memberService,
                                               @Mock StudyRepository studyRepository) {
        StudyService studyService = new StudyService(memberService, studyRepository);
        // 리턴 원하는 객체
        Member member = new Member();
        member.setId(10L);
        member.setEmail("yunan@email.com");

        // stubbing
        when(memberService.findById(any())).thenReturn(Optional.of(member));

        assertEquals("yunan@email.com", memberService.findById(1L).get().getEmail());
        Study study = new Study(10, "java");
        studyService.createNewStudy(1L, study);

        // 예외 상황도 스터빙 가능
        when(memberService.findById(1L)).thenThrow(new RuntimeException());
        doThrow(new IllegalArgumentException()).when(memberService).validate(1L);
        assertThrows(IllegalArgumentException.class, () -> {
            memberService.validate(1L);
        });
        assertThrows(RuntimeException.class, () -> {
            memberService.findById(1L);
        });
    }

    @Test
    void moreTest(@Mock MemberService memberService,
                                               @Mock StudyRepository studyRepository) {
        StudyService studyService = new StudyService(memberService, studyRepository);
        // 리턴 원하는 객체
        Member member = new Member();
        member.setId(10L);
        member.setEmail("yunan@email.com");

        // stubbing
        when(memberService.findById(any())).thenReturn(Optional.of(member));


        Study study = new Study(10, "java");
        studyService.createNewStudy(1L, study);

        // 예외 상황도 스터빙 가능
        when(memberService.findById(1L))
                .thenReturn(Optional.of(member))
                .thenThrow(new RuntimeException())
                .thenReturn(Optional.empty());

        assertEquals("yunan@email.com", memberService.findById(1L).get().getEmail());
        assertThrows(RuntimeException.class, () -> {
            memberService.findById(1L);
        });
        assertTrue(memberService.findById(1L).isEmpty());
    }

    @Test
    void MockStubbingTest() {
        Study study = new Study(10, "테스트");
        Member member = new Member();
        member.setEmail("yunan@gmail.com");
        member.setId(10L);

        when(memberService.findById(1L)).thenReturn(Optional.of(member));
        when(studyRepository.save(study)).thenReturn(study);
    }
}