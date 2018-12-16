package com.att.jmeterCourse.exercise1;

import java.io.IOException;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;

public class JmeterTester {

	public static void main(String[] args)  throws IOException, InterruptedException {
		
		SampleSleep sample = new SampleSleep();
		
		Arguments defaultParameters = sample.getDefaultParameters();

        JavaSamplerContext context = new JavaSamplerContext(defaultParameters);

		
		
		sample.setupTest(context);
		sample.runTest(context);
		
	}
}
