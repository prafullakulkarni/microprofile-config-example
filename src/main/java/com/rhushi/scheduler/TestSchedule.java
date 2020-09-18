package com.rhushi.scheduler;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

@Stateless
public class TestSchedule {

    @Schedule(second = "*/30", minute = "*", hour = "*") // Thirty second intervals
    public void processFiles() {
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        jobOperator.start("BatchTest", null);
    }
}
