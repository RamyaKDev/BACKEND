package com.upwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.upwork.model.EXPERIENCE;
import com.upwork.model.FeaturesDto;
import com.upwork.model.JOBTYPE;
import com.upwork.model.JobDto;
import com.upwork.model.MODE;
import com.upwork.model.ROLE;
import com.upwork.service.IJobService;



@SpringBootApplication
public class SpringUpworkAllmappingRestapiApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringUpworkAllmappingRestapiApplication.class, args);
	}
	@Autowired
	private IJobService jobService;
	@Override
	public void run(String... args) throws Exception {
		FeaturesDto featureDto=new FeaturesDto(null,MODE.ONLINE.name(),JOBTYPE.FULLTIME.name(),"This is a developer job",ROLE.CONTRACT.name());		
		JobDto jobDto=new JobDto("Java developer",null,25000,EXPERIENCE.BEGINNER.name(),"Chennai",featureDto);
		jobService.addJob(jobDto);
		
		featureDto=new FeaturesDto(null,MODE.ONLINE.name(),JOBTYPE.FULLTIME.name(),"This is a Tester job",ROLE.PERMANENT.name());
		 jobDto=new JobDto("Automation Tester",null,15000,EXPERIENCE.EXPERT.name(),"Bangalore",featureDto);
		jobService.addJob(jobDto);
		
		featureDto=new FeaturesDto(null,MODE.OFFLINE.name(),JOBTYPE.PARTTIME.name(),"This is a devops job",ROLE.CONTRACT.name());
		 jobDto=new JobDto("Devops",null,20000,EXPERIENCE.INTERMEDIATE.name(),"Hyderabad",featureDto);
		jobService.addJob(jobDto);
		
		System.out.println();
		System.out.println("delete job");
		//jobService.deleteJob(101);
		
		System.out.println();
		System.out.println("Update job");
		JobDto njobDto=jobService.getById(101);
		njobDto.setLocation("Pune");
		jobService.updateJob(njobDto);
		njobDto=jobService.getById(101);
		System.out.println(njobDto);
		
		System.out.println();
		System.out.println("Get all job");
		jobService.getAll().forEach(System.out::println);
		
		System.out.println();
		System.out.println("Get job by JobType");
		jobService.getByJobType(JOBTYPE.PARTTIME.name()).forEach(System.out::println);
		
		System.out.println();
		System.out.println("Get job by Role");
		jobService.getByRole(ROLE.CONTRACT.name()).forEach(System.out::println);
		
		System.out.println();
		System.out.println("Get job by Location");
		jobService.getByLocation("Pune").forEach(System.out::println);
		
		System.out.println();
		System.out.println(" get job By Type and Role");
		jobService.getByTypeandRole(JOBTYPE.FULLTIME.name(),ROLE.CONTRACT.name()).forEach(System.out::println);
		
		System.out.println();
		System.out.println(" get job By Type and Mode");
		jobService.getByTypeandMode(JOBTYPE.PARTTIME.name(),MODE.OFFLINE.name()).forEach(System.out::println);
		
		System.out.println();
		System.out.println(" get job By Location and Type");
		jobService.getByLocationandType("Bangalore",JOBTYPE.FULLTIME.name()).forEach(System.out::println);
		
		System.out.println();
		System.out.println(" get job By Location and Role");
		jobService.getByLocationandRole("Hyderabad",ROLE.CONTRACT.name()).forEach(System.out::println);
	}
}
