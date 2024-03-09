package GalapagosookYonan.GalapagosookYonan;

import GalapagosookYonan.GalapagosookYonan.entity.FarmEntity;
import GalapagosookYonan.GalapagosookYonan.farm.CsvFarmWriter;
import GalapagosookYonan.GalapagosookYonan.farm.FarmDto;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
@EnableBatchProcessing
public class FileReaderJobConfig {
    private final int CHUNK_SIZE = 5;

    private final CsvReader csvReader;
    private final CsvFarmWriter csvFarmWriter;
    private static final int chunkSize = 1000; //데이터 처리할 row size


    @Bean
    public Job job(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new JobBuilder("job", jobRepository)
                .start(step(jobRepository, transactionManager))
                .build();
    }

    @Bean
    public Step step(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("step", jobRepository)
                .tasklet(((contribution, chunkContext) -> {
                    return RepeatStatus.FINISHED;
                }), transactionManager).build();
    }
    @Bean
    // reader 와 processor, writer 는 딱히 바뀐 게 없음
    public Step testStep3(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("testStep3", jobRepository)
                .<FarmEntity, FarmEntity>chunk(CHUNK_SIZE, transactionManager)
                .build();
    }




}