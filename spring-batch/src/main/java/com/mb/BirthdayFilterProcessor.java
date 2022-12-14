package com.mb;

import java.util.Calendar;
import java.util.GregorianCalendar;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class BirthdayFilterProcessor implements ItemProcessor<Customer, Customer> {
    @Override
    public Customer process(final Customer item) throws Exception {
        if (new GregorianCalendar().get(Calendar.MONTH) == item.getBirthday().get(Calendar.MONTH)) {
            // log.info("Customer {} matched the birthday filter", item);
            System.out.println("Customer {} matched the birthday filter"+ item);
            return item;
        }
        return null;
    }
}
