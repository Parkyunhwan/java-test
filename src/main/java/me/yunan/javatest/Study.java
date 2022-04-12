package me.yunan.javatest;

public class Study {
    private StudyStatus status = StudyStatus.DRAFT;

    public Study() {
    }

    public Study(int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("limit는 0보다 커야한다.");
        }
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

    private int limit;

    public StudyStatus getStatus() {
        return status;
    }
}
