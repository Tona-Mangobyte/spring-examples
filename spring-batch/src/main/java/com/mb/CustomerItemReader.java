package com.mb;

import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.support.IteratorItemReader;

@Slf4j
public class CustomerItemReader implements ItemReader<Customer> {
    private final String filename;

    private ItemReader<Customer> delegate;

    public CustomerItemReader(final String filename) {
        this.filename = filename;
    }

    @Override
    public Customer read() throws Exception {
        if (delegate == null) {
            // log.info("Creating iterator item reader");
            delegate = new IteratorItemReader<>(customers());
        }
        // log.info("Reading next customer");
        return delegate.read();
    }

    private List<Customer> customers() throws FileNotFoundException {
        try (XMLDecoder decoder = new XMLDecoder(new FileInputStream(filename))) {
            return (List<Customer>) decoder.readObject();
        }
    }
}
