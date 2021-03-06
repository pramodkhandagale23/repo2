/*
 * Copyright 2015 EMBL - European Bioinformatics Institute
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package embl.ebi.variation.examples.dynamicworkflow;

import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;

public class StepFiveDecider implements JobExecutionDecider {
	private static final Log log = LogFactory.getLog(StepFiveDecider.class);

	@Override
	public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
		/*
		 * if
		 * (Boolean.valueOf(jobExecution.getJobParameters().getString("doStep4",
		 * "true"))) { System.out.println("++ Will run step 4"); return new
		 * FlowExecutionStatus("DO_STEP_4"); }
		 * 
		 * System.out.println("++ Skip step 4"); return new
		 * FlowExecutionStatus("SKIP_STEP_4"); }
		 */
		Random generator = new Random();
		int randomInt = generator.nextInt();

		log.info("Executing Decision with randomInt = " + randomInt);

		log.info("Executing Decision with randomInt = " + randomInt);
		if (randomInt % 2 == 0) {
			log.info("------------------------------------------");
			log.info("Completed -> step 5");
			log.info("------------------------------------------");
			return FlowExecutionStatus.COMPLETED;
		}
		log.info("------------------------------------------");
		log.info("Failed -> step 5");
		log.info("------------------------------------------");
		return FlowExecutionStatus.FAILED;
	}
}
