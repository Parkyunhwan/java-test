package me.yunan.javatest;

import me.yunan.javatest.domain.Study;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class RepeatTest {


    @DisplayName("반복 실행 테스트")
    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    void repeatTen(RepetitionInfo repetitionInfo) {
        System.out.println("test " + repetitionInfo.getCurrentRepetition());
    }

    /**
     * 파라미터를 하나씩 받아와서 테스트 가능
     * @param message
     */
    @ParameterizedTest(name = "{index} : {displayName}, 0 : {0}")
    @ValueSource(strings = {"a", "b", "c", "d"})
    @NullAndEmptySource // null과 엠티를 파라미터로 넘겨줌
    void parameterTest(String message) {
        System.out.println(message);
    }

    @DisplayName("여러 파라미터 테스트")
    @ParameterizedTest(name = "{index} - {0}, {1}")
    @CsvSource({"10, '자바 스터디'", "20, 스프링"})
    void parameterTest(Integer limit, String name) {
//        Study study = new Study(name, limit);
//        System.out.println(study.toString());
    }


    @DisplayName("여러 파라미터 테스트")
    @ParameterizedTest(name = "{index} - {0}, {1}")
    @CsvSource({"10, '자바 스터디'", "20, 스프링"})
    void parameterArgumentAccessorTest(ArgumentsAccessor argumentsAccessor) {
//        Study study = new Study(argumentsAccessor.getString(1), argumentsAccessor.getInteger(0));
//        System.out.println(study.toString());
    }


//    @DisplayName("여러 파라미터 테스트-Aggregator이용")
//    @ParameterizedTest(name = "{index} - {0}, {1}")
//    @CsvSource({"10, '자바 스터디'", "20, 스프링"})
//    void parameterArgumentAccessorTest(@AggregateWith(StudyAggregator.class) Study study) {
//        System.out.println(study);
//    }
//
//    static class StudyAggregator implements ArgumentsAggregator {
//
//        @Override
//        public Object aggregateArguments(ArgumentsAccessor argumentsAccessor, ParameterContext parameterContext) throws ArgumentsAggregationException {
//            return new Study(argumentsAccessor.getString(1), argumentsAccessor.getInteger(0));
//        }
//    }
}
