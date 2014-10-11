package frank.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyJob2 implements Job{

	private static final Logger log = LoggerFactory.getLogger(MyJob2.class);
	
	@Override
	public void execute(JobExecutionContext arg0)
			throws JobExecutionException {
		log.info("------------- job2 begin -----------------");
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("------------- job2 end -------------------");
	}
	
}