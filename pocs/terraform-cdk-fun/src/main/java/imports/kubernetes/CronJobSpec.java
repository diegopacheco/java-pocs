package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.339Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.CronJobSpec")
@software.amazon.jsii.Jsii.Proxy(CronJobSpec.Jsii$Proxy.class)
public interface CronJobSpec extends software.amazon.jsii.JsiiSerializable {

    /**
     * job_template block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#job_template CronJob#job_template}
     */
    @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.CronJobSpecJobTemplate> getJobTemplate();

    /**
     * Cron format string, e.g. 0 * * * * or @hourly, as schedule time of its jobs to be created and executed.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#schedule CronJob#schedule}
     */
    @org.jetbrains.annotations.NotNull java.lang.String getSchedule();

    /**
     * Specifies how to treat concurrent executions of a Job. Defaults to Allow.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#concurrency_policy CronJob#concurrency_policy}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getConcurrencyPolicy() {
        return null;
    }

    /**
     * The number of failed finished jobs to retain.
     * <p>
     * This is a pointer to distinguish between explicit zero and not specified. Defaults to 1.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#failed_jobs_history_limit CronJob#failed_jobs_history_limit}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getFailedJobsHistoryLimit() {
        return null;
    }

    /**
     * Optional deadline in seconds for starting the job if it misses scheduled time for any reason.
     * <p>
     * Missed jobs executions will be counted as failed ones.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#starting_deadline_seconds CronJob#starting_deadline_seconds}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getStartingDeadlineSeconds() {
        return null;
    }

    /**
     * The number of successful finished jobs to retain. Defaults to 3.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#successful_jobs_history_limit CronJob#successful_jobs_history_limit}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getSuccessfulJobsHistoryLimit() {
        return null;
    }

    /**
     * This flag tells the controller to suspend subsequent executions, it does not apply to already started executions.
     * <p>
     * Defaults to false.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#suspend CronJob#suspend}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Boolean getSuspend() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link CronJobSpec}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link CronJobSpec}
     */
    public static final class Builder implements software.amazon.jsii.Builder<CronJobSpec> {
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplate> jobTemplate;
        private java.lang.String schedule;
        private java.lang.String concurrencyPolicy;
        private java.lang.Number failedJobsHistoryLimit;
        private java.lang.Number startingDeadlineSeconds;
        private java.lang.Number successfulJobsHistoryLimit;
        private java.lang.Boolean suspend;

        /**
         * Sets the value of {@link CronJobSpec#getJobTemplate}
         * @param jobTemplate job_template block. This parameter is required.
         *                    Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#job_template CronJob#job_template}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder jobTemplate(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplate> jobTemplate) {
            this.jobTemplate = (java.util.List<imports.kubernetes.CronJobSpecJobTemplate>)jobTemplate;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpec#getSchedule}
         * @param schedule Cron format string, e.g. 0 * * * * or @hourly, as schedule time of its jobs to be created and executed. This parameter is required.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#schedule CronJob#schedule}
         * @return {@code this}
         */
        public Builder schedule(java.lang.String schedule) {
            this.schedule = schedule;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpec#getConcurrencyPolicy}
         * @param concurrencyPolicy Specifies how to treat concurrent executions of a Job. Defaults to Allow.
         *                          Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#concurrency_policy CronJob#concurrency_policy}
         * @return {@code this}
         */
        public Builder concurrencyPolicy(java.lang.String concurrencyPolicy) {
            this.concurrencyPolicy = concurrencyPolicy;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpec#getFailedJobsHistoryLimit}
         * @param failedJobsHistoryLimit The number of failed finished jobs to retain.
         *                               This is a pointer to distinguish between explicit zero and not specified. Defaults to 1.
         *                               <p>
         *                               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#failed_jobs_history_limit CronJob#failed_jobs_history_limit}
         * @return {@code this}
         */
        public Builder failedJobsHistoryLimit(java.lang.Number failedJobsHistoryLimit) {
            this.failedJobsHistoryLimit = failedJobsHistoryLimit;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpec#getStartingDeadlineSeconds}
         * @param startingDeadlineSeconds Optional deadline in seconds for starting the job if it misses scheduled time for any reason.
         *                                Missed jobs executions will be counted as failed ones.
         *                                <p>
         *                                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#starting_deadline_seconds CronJob#starting_deadline_seconds}
         * @return {@code this}
         */
        public Builder startingDeadlineSeconds(java.lang.Number startingDeadlineSeconds) {
            this.startingDeadlineSeconds = startingDeadlineSeconds;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpec#getSuccessfulJobsHistoryLimit}
         * @param successfulJobsHistoryLimit The number of successful finished jobs to retain. Defaults to 3.
         *                                   Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#successful_jobs_history_limit CronJob#successful_jobs_history_limit}
         * @return {@code this}
         */
        public Builder successfulJobsHistoryLimit(java.lang.Number successfulJobsHistoryLimit) {
            this.successfulJobsHistoryLimit = successfulJobsHistoryLimit;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpec#getSuspend}
         * @param suspend This flag tells the controller to suspend subsequent executions, it does not apply to already started executions.
         *                Defaults to false.
         *                <p>
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#suspend CronJob#suspend}
         * @return {@code this}
         */
        public Builder suspend(java.lang.Boolean suspend) {
            this.suspend = suspend;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link CronJobSpec}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public CronJobSpec build() {
            return new Jsii$Proxy(jobTemplate, schedule, concurrencyPolicy, failedJobsHistoryLimit, startingDeadlineSeconds, successfulJobsHistoryLimit, suspend);
        }
    }

    /**
     * An implementation for {@link CronJobSpec}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements CronJobSpec {
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplate> jobTemplate;
        private final java.lang.String schedule;
        private final java.lang.String concurrencyPolicy;
        private final java.lang.Number failedJobsHistoryLimit;
        private final java.lang.Number startingDeadlineSeconds;
        private final java.lang.Number successfulJobsHistoryLimit;
        private final java.lang.Boolean suspend;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.jobTemplate = software.amazon.jsii.Kernel.get(this, "jobTemplate", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplate.class)));
            this.schedule = software.amazon.jsii.Kernel.get(this, "schedule", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.concurrencyPolicy = software.amazon.jsii.Kernel.get(this, "concurrencyPolicy", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.failedJobsHistoryLimit = software.amazon.jsii.Kernel.get(this, "failedJobsHistoryLimit", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.startingDeadlineSeconds = software.amazon.jsii.Kernel.get(this, "startingDeadlineSeconds", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.successfulJobsHistoryLimit = software.amazon.jsii.Kernel.get(this, "successfulJobsHistoryLimit", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.suspend = software.amazon.jsii.Kernel.get(this, "suspend", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplate> jobTemplate, final java.lang.String schedule, final java.lang.String concurrencyPolicy, final java.lang.Number failedJobsHistoryLimit, final java.lang.Number startingDeadlineSeconds, final java.lang.Number successfulJobsHistoryLimit, final java.lang.Boolean suspend) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.jobTemplate = (java.util.List<imports.kubernetes.CronJobSpecJobTemplate>)java.util.Objects.requireNonNull(jobTemplate, "jobTemplate is required");
            this.schedule = java.util.Objects.requireNonNull(schedule, "schedule is required");
            this.concurrencyPolicy = concurrencyPolicy;
            this.failedJobsHistoryLimit = failedJobsHistoryLimit;
            this.startingDeadlineSeconds = startingDeadlineSeconds;
            this.successfulJobsHistoryLimit = successfulJobsHistoryLimit;
            this.suspend = suspend;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplate> getJobTemplate() {
            return this.jobTemplate;
        }

        @Override
        public final java.lang.String getSchedule() {
            return this.schedule;
        }

        @Override
        public final java.lang.String getConcurrencyPolicy() {
            return this.concurrencyPolicy;
        }

        @Override
        public final java.lang.Number getFailedJobsHistoryLimit() {
            return this.failedJobsHistoryLimit;
        }

        @Override
        public final java.lang.Number getStartingDeadlineSeconds() {
            return this.startingDeadlineSeconds;
        }

        @Override
        public final java.lang.Number getSuccessfulJobsHistoryLimit() {
            return this.successfulJobsHistoryLimit;
        }

        @Override
        public final java.lang.Boolean getSuspend() {
            return this.suspend;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("jobTemplate", om.valueToTree(this.getJobTemplate()));
            data.set("schedule", om.valueToTree(this.getSchedule()));
            if (this.getConcurrencyPolicy() != null) {
                data.set("concurrencyPolicy", om.valueToTree(this.getConcurrencyPolicy()));
            }
            if (this.getFailedJobsHistoryLimit() != null) {
                data.set("failedJobsHistoryLimit", om.valueToTree(this.getFailedJobsHistoryLimit()));
            }
            if (this.getStartingDeadlineSeconds() != null) {
                data.set("startingDeadlineSeconds", om.valueToTree(this.getStartingDeadlineSeconds()));
            }
            if (this.getSuccessfulJobsHistoryLimit() != null) {
                data.set("successfulJobsHistoryLimit", om.valueToTree(this.getSuccessfulJobsHistoryLimit()));
            }
            if (this.getSuspend() != null) {
                data.set("suspend", om.valueToTree(this.getSuspend()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.CronJobSpec"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CronJobSpec.Jsii$Proxy that = (CronJobSpec.Jsii$Proxy) o;

            if (!jobTemplate.equals(that.jobTemplate)) return false;
            if (!schedule.equals(that.schedule)) return false;
            if (this.concurrencyPolicy != null ? !this.concurrencyPolicy.equals(that.concurrencyPolicy) : that.concurrencyPolicy != null) return false;
            if (this.failedJobsHistoryLimit != null ? !this.failedJobsHistoryLimit.equals(that.failedJobsHistoryLimit) : that.failedJobsHistoryLimit != null) return false;
            if (this.startingDeadlineSeconds != null ? !this.startingDeadlineSeconds.equals(that.startingDeadlineSeconds) : that.startingDeadlineSeconds != null) return false;
            if (this.successfulJobsHistoryLimit != null ? !this.successfulJobsHistoryLimit.equals(that.successfulJobsHistoryLimit) : that.successfulJobsHistoryLimit != null) return false;
            return this.suspend != null ? this.suspend.equals(that.suspend) : that.suspend == null;
        }

        @Override
        public final int hashCode() {
            int result = this.jobTemplate.hashCode();
            result = 31 * result + (this.schedule.hashCode());
            result = 31 * result + (this.concurrencyPolicy != null ? this.concurrencyPolicy.hashCode() : 0);
            result = 31 * result + (this.failedJobsHistoryLimit != null ? this.failedJobsHistoryLimit.hashCode() : 0);
            result = 31 * result + (this.startingDeadlineSeconds != null ? this.startingDeadlineSeconds.hashCode() : 0);
            result = 31 * result + (this.successfulJobsHistoryLimit != null ? this.successfulJobsHistoryLimit.hashCode() : 0);
            result = 31 * result + (this.suspend != null ? this.suspend.hashCode() : 0);
            return result;
        }
    }
}
