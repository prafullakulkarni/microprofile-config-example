package com.rhushi.job;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.batch.api.Batchlet;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("TestBatchlet")
public class TestBatchlet implements Batchlet {

    @Inject
    private JobContext jobCtx;

    @Override
    public String process() throws Exception {
        String filename = "/home/rhushi/out.txt";//jobCtx.getProperties().getProperty("outfile");
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        BufferedWriter output = new BufferedWriter(new FileWriter(filename, true));
        output.append(timestamp);
        output.newLine();
        output.close();
        return "COMPLETED";
    }

    @Override
    public void stop() throws Exception {
    }
}
