package com.dmdk.common.snowflake;

import java.util.concurrent.atomic.AtomicLong;

public class MySnowflake {
    private final long epoch;
    private final long workerIdBits;
    private final long sequenceBits;
    private final long maxWorkerId;
    private final long maxSequence;
    private final long workerIdShift;
    private final long timestampShift;
    private final AtomicLong sequence = new AtomicLong(0L);
    private long lastTimestamp = -1L;

    public MySnowflake(long workerId, long epoch, int workerIdBits, int sequenceBits) {
        this.epoch = epoch;
        this.workerIdBits = workerIdBits;
        this.sequenceBits = sequenceBits;
        this.maxWorkerId = (1L << workerIdBits) - 1;
        this.maxSequence = (1L << sequenceBits) - 1;
        this.workerIdShift = sequenceBits;
        this.timestampShift = sequenceBits + workerIdBits;

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

        return id;
    }

    private long getCurrentTimestamp() {
        // Replace with your own logic to obtain the current timestamp with 30 bits
        return System.currentTimeMillis() % (1L << 30);
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
        return 22;
    }

    public MySnowflake() {
        this(1L, 0L, 10, 12);
    }

    // Example usage
    public static void main(String[] args) {
        MySnowflake idGenerator = new MySnowflake(1L, 0L, 10, 12);
        long id = idGenerator.generateId();
        System.out.println(id);
    }
}
