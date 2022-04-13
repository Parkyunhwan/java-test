package me.yunan.javatest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(FindSlowTestExtension.class)
class StudyTest {
    int value = 0;

    @Test
    void create() throws InterruptedException {
        Thread.sleep(1001L);
        Study study = new Study();
        System.out.println("Create");
        System.out.println(++value);
        assertNotNull(study);
    }

    @Test
    @Disabled
    void create_disabled() {
        Study study = new Study();
        System.out.println("Create");
        System.out.println(++value);
        assertNotNull(study);
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