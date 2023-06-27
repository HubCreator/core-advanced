package hello.advanced.trace;

import java.util.UUID;

public class TraceId {

    private final String id;
    private final int level;

    public TraceId() {
        this.id = createId();
        this.level = 0;
    }

    public TraceId(String id, int level) {
        this.id = id;
        this.level = level;
    }

    private String createId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    // 이전 로그에 뎁스만 하나 더 추가한다.
    public TraceId createNextId() {
        return new TraceId(id, level + 1);
    }

    // 이전 로그에 뎁스만 하나 더 줄인다.
    public TraceId createPreviousId() {
        return new TraceId(id, level - 1);
    }

    public boolean isFirstLevel() {
        return level == 0;
    }

    public String getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }
}
