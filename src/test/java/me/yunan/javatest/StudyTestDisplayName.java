package me.yunan.javatest;

import lombok.extern.slf4j.Slf4j;
import me.yunan.javatest.domain.Study;
import me.yunan.javatest.domain.StudyStatus;
import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@Slf4j
class StudyTestDisplayName {

    @FastTest
    @DisplayName("스터디 만들기 ! @ @ !")
    void create_new_study() {
        Study study = new Study(10);
        System.out.println("Create");
        assertNotNull(study);

//        assertAll(
//                () -> assertNotNull(study),
//                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(),
//                        () -> "스터디를 처음 만들면 상태값이 DRAFT여야 한다."),
//                () -> assertTrue(study.getLimit() > 0)
//        );


//        assertEquals(StudyStatus.DRAFT, study.getStatus(),
//                () -> "스터디를 처음 만들면 상태값이 DRAFT여야 한다.");
        // (기대하는 값, 실제 값, 메시지)
        // 람다식으로 실패시에만 메서드연산을 실행한다.
    }


    @SlowTest
    @Tag("slow")
    void creat_study_throw_exception() {
        Study study = new Study();
        System.out.println("Exception");
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> new Study(-10));
        assertEquals("limit는 0보다 커야한다.", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("시간안에 테스트 성공하는 지")
    @Tag("fast")
    void in_time_test() {
        // 메서드 종료시까지 해보고 종료
        assertTimeout(Duration.ofMillis(100), () -> {
            new Study(10);
            Thread.sleep(30);
        });

        // 100ms 가 지나면 바로 종료
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            new Study(10);
            Thread.sleep(30);
        });
    }

    @Test
    void create_disabled() {
        Study study = new Study();
        System.out.println("Create");
        assertNotNull(study);
    }

    @Test
    void assumeTest() {
        String test_env = System.getenv("TEST_ENV");
        System.out.println(test_env);
        assumeTrue("LOCAL".equalsIgnoreCase(test_env));

//        //로컬일때
//        assumingThat("LOCAL".equalsIgnoreCase(test_env), () -> {
//            Study actual = new Study(10);
//            log.info("Local limit : {}", actual.getLimit());
//            assertThat(actual.getLimit()).isGreaterThanOrEqualTo(10);
//        });
//
//        //dev일때
//        assumingThat("DEV".equalsIgnoreCase(test_env), () -> {
//            Study actual = new Study(100);
//            log.info("Dev limit : {}", actual.getLimit());
//            assertThat(actual.getLimit()).isGreaterThanOrEqualTo(100);
//        });
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("before Each");
    }

    @AfterEach
    void afterEach() {
        System.out.println("after Each");
    }

}