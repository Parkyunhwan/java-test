package me.yunan.javatest;

public class Study {
    private StudyStatus status = StudyStatus.DRAFT;

    public Study(String name, int limit) {
        this.name = name;
        this.limit = limit;
    }

    private String name;

    public Study() {
    }

    @Override
    public String toString() {
        return "Study{" +
                "status=" + status +
                ", name='" + name + '\'' +
                ", limit=" + limit +
                '}';
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

    public Study(StudyStatus status, int limit) {
        this.status = status;
        this.limit = limit;
    }

    public StudyStatus getStatus() {
        return status;
    }
}
