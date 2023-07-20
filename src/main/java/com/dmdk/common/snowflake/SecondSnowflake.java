package com.dmdk.common.snowflake;

import java.util.concurrent.atomic.AtomicLong;

public class SecondSnowflake {
    private final long epoch = 1630848000000L; // 自定义的起始时间戳，此处为 2021-09-06 00:00:00
    private final long workerIdBits = 4;
    private final long sequenceBits = 8;
    private final long maxWorkerId = (1L << workerIdBits) - 1;
    private final long maxSequence = (1L << sequenceBits) - 1;
    private final long workerIdShift = sequenceBits;
    private final long timestampShift = sequenceBits + workerIdBits;
    private final AtomicLong sequence = new AtomicLong(0L);
    private long lastTimestamp = -1L;

    public SecondSnowflake(long workerId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException("Worker ID exceeds the maximum allowed value");
        }
    }

    public synchronized long generateId() {
        long timestamp = getCurrentTimestamp();

        if (timestamp < lastTimestamp) {
            throw new IllegalStateException("Clock moved backwards");
        }

        if (timestamp == lastTimestamp) {
            long currentSequence = sequence.incrementAndGet();

            if (currentSequence > maxSequence) {
                timestamp = waitNextMillis(lastTimestamp);
                sequence.set(0);
            }
        } else {
            sequence.set(0);
        }

        lastTimestamp = timestamp;

        long id = (timestamp - epoch) << timestampShift;
        id |= (getWorkerId() << workerIdShift);
        id |= sequence.get();

        return id % 900_000_000_000_000L; // 限制长度为 16
    }

    private long getCurrentTimestamp() {
        return System.currentTimeMillis();
    }

    private long waitNextMillis(long lastTimestamp) {
        long timestamp = getCurrentTimestamp();

        while (timestamp <= lastTimestamp) {
            timestamp = getCurrentTimestamp();
        }

        return timestamp;
    }

    private long getWorkerId() {
        // Replace with your own logic to obtain the worker ID
        return 0L;
    }

    public SecondSnowflake() {
        this(0L);
    }

    // Example usage
    public static void main(String[] args) {
        SecondSnowflake idGenerator = new SecondSnowflake(0L);
        long id = idGenerator.generateId();
        System.out.println("Generated ID: " + id);
    }
}
