package com.github.diegopacheco.sandboxspring.tasks;

import org.springframework.cloud.task.listener.annotation.AfterTask;
import org.springframework.cloud.task.listener.annotation.BeforeTask;
import org.springframework.cloud.task.listener.annotation.FailedTask;
import org.springframework.cloud.task.repository.TaskExecution;

public class TaskObservability {

    @BeforeTask
    public void beforeTask(TaskExecution taskExecution) {
        System.out.println("[TaskObservability] Before Task: " + taskExecution);
    }

    @AfterTask
    public void afterTask(TaskExecution taskExecution) {
        System.out.println("[TaskObservability] After Task: " + taskExecution);
    }

    @FailedTask
    public void failedTask(TaskExecution taskExecution, Throwable throwable) {
        System.out.println("[TaskObservability] Failure Task: " + taskExecution + " ex: " + throwable);
    }

}
