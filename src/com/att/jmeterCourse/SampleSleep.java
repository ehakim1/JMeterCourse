package com.att.jmeterCourse;

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
	private long sleepTime;
	
	@Override
	public void setupTest(JavaSamplerContext ctx){
		
		userPrefix = "User";
		userNumber = ctx.getParameter("myThreadId");  //get the Thread ID from the Java Request context
		userName =  userPrefix + userNumber;
		timeToWait = 5;
	}
	
	
	@Override
	public SampleResult runTest(JavaSamplerContext ctx) {
		// TODO Auto-generated method stub
		
		iterationNumber = ctx.getParameter("myIteration"); //get the Iteration number from the Java Request context
		
		SampleResult sample = new SampleResult();
		
		System.out.println("Username - " + userName + ", Iteration - " + iterationNumber);
		
		Random r = new Random(System.currentTimeMillis());
		
		try {		
			sample.setSampleLabel("SampleSleep");
			sample.sampleStart();
			sleepTime = r.nextInt(timeToWait);
			System.out.println("Sleeping - " + sleepTime);
			TimeUnit.SECONDS.sleep(sleepTime);
			sample.sampleEnd();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sample;
	}

	
	@Override
    public Arguments getDefaultParameters() {
        Arguments defaultParameters = new Arguments();
        defaultParameters.addArgument("myThreadId", "${__threadNum}");  //Set thread number param in the Java request context
        defaultParameters.addArgument("myIteration", "${__counter(TRUE,)}"); //Set thread number param in the Java request context
        return defaultParameters;
    }
    
	
}
