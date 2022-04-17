package me.yunan.javatest;

import lombok.extern.slf4j.Slf4j;
import me.yunan.javatest.domain.Study;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@Slf4j
public class EnvAssumeTest {

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

    @Test
    @EnabledOnOs({OS.MAC, OS.LINUX})
    void assumeTestMac() {
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

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void assumeTestWindow() {
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

    @Test
    @EnabledOnJre({JRE.JAVA_8, JRE.JAVA_11})
    void assumeTestJREVersion() {
        String test_env = System.getenv("TEST_ENV");
        System.out.println(test_env);
        assumeTrue("LOCAL".equalsIgnoreCase(test_env));

        //로컬일때
//        assumingThat("LOCAL".equalsIgnoreCase(test_env), () -> {
//            Study actual = new Study(10);
//            log.info("Local limit : {}", actual.getLimit());
//            assertThat(actual.getLimit()).isGreaterThanOrEqualTo(10);
//        });

        //dev일때
//        assumingThat("DEV".equalsIgnoreCase(test_env), () -> {
//            Study actual = new Study(100);
//            log.info("Dev limit : {}", actual.getLimit());
//            assertThat(actual.getLimit()).isGreaterThanOrEqualTo(100);
//        });
    }

    /**
     * 변수가 LOCAL아니면 실행안됨 (정규식 가능)
     */
    @Test
    @EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "NOT_LOCAL")
    void assumeTestEnvironmentVariable() {
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
}
