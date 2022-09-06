package com.mb.examples.listeners;

import org.springframework.batch.core.annotation.AfterChunk;
import org.springframework.batch.core.annotation.BeforeChunk;

public class ChunkListener {
    @BeforeChunk
    public void beforeChunk() {
        System.out.println(">> Before the chunk");
    }

    @AfterChunk
    public void afterChunk() {
        System.out.println(">> After the chunk");
    }
}
