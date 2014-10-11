package frank.quartz;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyQuartzServer {	
	
	public static void main(String[] args) {
		new MyQuartzServer().run();
	}

	private static final Logger log = LoggerFactory.getLogger(MyQuartzServer.class);
	
	public void run(){		
		try {

			log.info("------------- scheduler begin -----------------");
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			
			JobDetail job = JobBuilder.newJob(MyJob.class).withIdentity("myjob","G1").build();
			Trigger tigger = TriggerBuilder.newTrigger().withIdentity("mytri","G1").startNow()
					.withSchedule(
							SimpleScheduleBuilder.simpleSchedule()
								.withIntervalInSeconds(1)
								.withRepeatCount(5)
							).build();
			
			scheduler.scheduleJob(job, tigger);
			
			JobDetail job2 = JobBuilder.newJob(MyJob2.class).withIdentity("myjob2","G1").build();
			Trigger tigger2 = TriggerBuilder.newTrigger().withIdentity("mytri2","G1").startNow()
					.withSchedule(
							SimpleScheduleBuilder.simpleSchedule()
								.withIntervalInSeconds(1)
								.withRepeatCount(5)
							).build();
			scheduler.scheduleJob(job2, tigger2);
			scheduler.start();

			log.info("------------- scheduler begin -----------------");
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
		
}
