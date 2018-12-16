package com.att.jmeterCourse.exercise1;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.threads.JMeterContextService;
import org.apache.jmeter.threads.JMeterVariables;

public class SampleSleep extends AbstractJavaSamplerClient {

	private String userName;
	private String userPrefix;
	private String userNumber;
	private int timeToWait;
	private String iterationNumber;
	
	@Override
	public void setupTest(JavaSamplerContext ctx){
		
		userPrefix = "User";
		userNumber = ctx.getParameter("myThreadId");
		
		//if running from eclipse
		userNumber = "1";
		userName =  userPrefix + userNumber;
		timeToWait = 5;
	}
	
	
	@Override
	public SampleResult runTest(JavaSamplerContext ctx) {
		// TODO Auto-generated method stub
		
		iterationNumber = ctx.getParameter("myIteration");

		//if running from eclipse
		iterationNumber = "1";
		
		SampleResult sample = new SampleResult();
		
		System.out.println("Username - " + userName + ", Iteration - " + iterationNumber);
		
		Random r = new Random(System.currentTimeMillis());
		try {		
			sample.setSampleLabel("SampleSleep");
			sample.sampleStart();
			TimeUnit.SECONDS.sleep(r.nextLong() + timeToWait);
			sample.sampleEnd();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	
	@Override
    public Arguments getDefaultParameters() {
        Arguments defaultParameters = new Arguments();
        defaultParameters.addArgument("myThreadId", "${__threadNum}");
        defaultParameters.addArgument("myIteration", "${__counter(TRUE,)}");
        return defaultParameters;
    }
    
	
}
