package ontech.event.emitter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
//@EnableAsync
public class EventEmitterConfiguration {

    @Bean
    public EventEmitter getEventEmitter(){
        return new EventEmitter("Service Name");
    }

//    @Bean("taskExecutor")
//    public TaskExecutor getAsyncExecutor() {
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(4);
//        executor.setMaxPoolSize(10);
//        executor.setWaitForTasksToCompleteOnShutdown(true);
//        executor.setThreadNamePrefix("EventEmitter-");
//        return executor;
//    }
}
