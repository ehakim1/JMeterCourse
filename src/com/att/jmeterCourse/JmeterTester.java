package com.att.jmeterCourse;

import java.io.IOException;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;

public class JmeterTester {

	public static void main(String[] args)  throws IOException, InterruptedException {
		
		SampleSleep sample = new SampleSleep();
		
		Arguments defaultParameters = sample.getDefaultParameters();

		defaultParameters.removeArgument("myThreadId");
		defaultParameters.addArgument("myThreadId", "1");
		
		JavaSamplerContext context = new JavaSamplerContext(defaultParameters);
        
        		
		sample.setupTest(context);
		
		for (int i=0; i<5;i++){
			defaultParameters = sample.getDefaultParameters();
			defaultParameters.removeArgument("myIteration");
			defaultParameters.addArgument("myIteration", "" + i);
			//context = new JavaSamplerContext(defaultParameters);
			sample.runTest(context);
		}
		defaultParameters.removeArgument("myThreadId");
		defaultParameters.addArgument("myThreadId", "1");		
		//context = new JavaSamplerContext(defaultParameters);
		sample.teardownTest(context);
	}
}
