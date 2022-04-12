package me.yunan.javatest;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 메타 에너테이션 (테스트의 에너테이션을 조합해 커스텀함)
 * 런타임까지 정보가 유지되면 메서드에 사용되는 fast 태그를 가진 테스트 에너테이션
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME) //런타임까지 정보유지
@Test
@Tag("fast")
public @interface FastTest {
}
