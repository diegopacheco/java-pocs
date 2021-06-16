package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.341Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.CronJobSpecJobTemplateSpec")
@software.amazon.jsii.Jsii.Proxy(CronJobSpecJobTemplateSpec.Jsii$Proxy.class)
public interface CronJobSpecJobTemplateSpec extends software.amazon.jsii.JsiiSerializable {

    /**
     * template block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#template CronJob#template}
     */
    @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplate> getTemplate();

    /**
     * Optional duration in seconds the pod may be active on the node relative to StartTime before the system will actively try to mark it failed and kill associated containers.
     * <p>
     * Value must be a positive integer.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#active_deadline_seconds CronJob#active_deadline_seconds}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getActiveDeadlineSeconds() {
        return null;
    }

    /**
     * Specifies the number of retries before marking this job failed. Defaults to 6.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#backoff_limit CronJob#backoff_limit}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getBackoffLimit() {
        return null;
    }

    /**
     * Specifies the desired number of successfully finished pods the job should be run with.
     * <p>
     * Setting to nil means that the success of any pod signals the success of all pods, and allows parallelism to have any positive value. Setting to 1 means that parallelism is limited to 1 and the success of that pod signals the success of the job. More info: https://kubernetes.io/docs/concepts/workloads/controllers/jobs-run-to-completion/
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#completions CronJob#completions}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getCompletions() {
        return null;
    }

    /**
     * Controls generation of pod labels and pod selectors.
     * <p>
     * Leave unset unless you are certain what you are doing. When false or unset, the system pick labels unique to this job and appends those labels to the pod template. When true, the user is responsyble for picking unique labels and specifying the selector. Failure to pick a unique label may cause this and other jobs to not function correctly. More info: https://git.k8s.io/community/contributors/design-proposals/selector-generation.md
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#manual_selector CronJob#manual_selector}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Boolean getManualSelector() {
        return null;
    }

    /**
     * Specifies the maximum desired number of pods the job should run at any given time.
     * <p>
     * The actual number of pods running in steady state will be less than this number when ((.spec.completions - .status.successful) &lt; .spec.parallelism), i.e. when the work left to do is less than max parallelism. More info: https://kubernetes.io/docs/concepts/workloads/controllers/jobs-run-to-completion/
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#parallelism CronJob#parallelism}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getParallelism() {
        return null;
    }

    /**
     * selector block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#selector CronJob#selector}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecSelector> getSelector() {
        return null;
    }

    /**
     * ttlSecondsAfterFinished limits the lifetime of a Job that has finished execution (either Complete or Failed).
     * <p>
     * If this field is set, ttlSecondsAfterFinished after the Job finishes, it is eligible to be automatically deleted. When the Job is being deleted, its lifecycle guarantees (e.g. finalizers) will be honored. If this field is unset, the Job won't be automatically deleted. If this field is set to zero, the Job becomes eligible to be deleted immediately after it finishes.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#ttl_seconds_after_finished CronJob#ttl_seconds_after_finished}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getTtlSecondsAfterFinished() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link CronJobSpecJobTemplateSpec}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link CronJobSpecJobTemplateSpec}
     */
    public static final class Builder implements software.amazon.jsii.Builder<CronJobSpecJobTemplateSpec> {
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplate> template;
        private java.lang.Number activeDeadlineSeconds;
        private java.lang.Number backoffLimit;
        private java.lang.Number completions;
        private java.lang.Boolean manualSelector;
        private java.lang.Number parallelism;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecSelector> selector;
        private java.lang.Number ttlSecondsAfterFinished;

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpec#getTemplate}
         * @param template template block. This parameter is required.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#template CronJob#template}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder template(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplate> template) {
            this.template = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplate>)template;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpec#getActiveDeadlineSeconds}
         * @param activeDeadlineSeconds Optional duration in seconds the pod may be active on the node relative to StartTime before the system will actively try to mark it failed and kill associated containers.
         *                              Value must be a positive integer.
         *                              <p>
         *                              Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#active_deadline_seconds CronJob#active_deadline_seconds}
         * @return {@code this}
         */
        public Builder activeDeadlineSeconds(java.lang.Number activeDeadlineSeconds) {
            this.activeDeadlineSeconds = activeDeadlineSeconds;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpec#getBackoffLimit}
         * @param backoffLimit Specifies the number of retries before marking this job failed. Defaults to 6.
         *                     Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#backoff_limit CronJob#backoff_limit}
         * @return {@code this}
         */
        public Builder backoffLimit(java.lang.Number backoffLimit) {
            this.backoffLimit = backoffLimit;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpec#getCompletions}
         * @param completions Specifies the desired number of successfully finished pods the job should be run with.
         *                    Setting to nil means that the success of any pod signals the success of all pods, and allows parallelism to have any positive value. Setting to 1 means that parallelism is limited to 1 and the success of that pod signals the success of the job. More info: https://kubernetes.io/docs/concepts/workloads/controllers/jobs-run-to-completion/
         *                    <p>
         *                    Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#completions CronJob#completions}
         * @return {@code this}
         */
        public Builder completions(java.lang.Number completions) {
            this.completions = completions;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpec#getManualSelector}
         * @param manualSelector Controls generation of pod labels and pod selectors.
         *                       Leave unset unless you are certain what you are doing. When false or unset, the system pick labels unique to this job and appends those labels to the pod template. When true, the user is responsyble for picking unique labels and specifying the selector. Failure to pick a unique label may cause this and other jobs to not function correctly. More info: https://git.k8s.io/community/contributors/design-proposals/selector-generation.md
         *                       <p>
         *                       Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#manual_selector CronJob#manual_selector}
         * @return {@code this}
         */
        public Builder manualSelector(java.lang.Boolean manualSelector) {
            this.manualSelector = manualSelector;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpec#getParallelism}
         * @param parallelism Specifies the maximum desired number of pods the job should run at any given time.
         *                    The actual number of pods running in steady state will be less than this number when ((.spec.completions - .status.successful) &lt; .spec.parallelism), i.e. when the work left to do is less than max parallelism. More info: https://kubernetes.io/docs/concepts/workloads/controllers/jobs-run-to-completion/
         *                    <p>
         *                    Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#parallelism CronJob#parallelism}
         * @return {@code this}
         */
        public Builder parallelism(java.lang.Number parallelism) {
            this.parallelism = parallelism;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpec#getSelector}
         * @param selector selector block.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#selector CronJob#selector}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder selector(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecSelector> selector) {
            this.selector = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecSelector>)selector;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpec#getTtlSecondsAfterFinished}
         * @param ttlSecondsAfterFinished ttlSecondsAfterFinished limits the lifetime of a Job that has finished execution (either Complete or Failed).
         *                                If this field is set, ttlSecondsAfterFinished after the Job finishes, it is eligible to be automatically deleted. When the Job is being deleted, its lifecycle guarantees (e.g. finalizers) will be honored. If this field is unset, the Job won't be automatically deleted. If this field is set to zero, the Job becomes eligible to be deleted immediately after it finishes.
         *                                <p>
         *                                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#ttl_seconds_after_finished CronJob#ttl_seconds_after_finished}
         * @return {@code this}
         */
        public Builder ttlSecondsAfterFinished(java.lang.Number ttlSecondsAfterFinished) {
            this.ttlSecondsAfterFinished = ttlSecondsAfterFinished;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link CronJobSpecJobTemplateSpec}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public CronJobSpecJobTemplateSpec build() {
            return new Jsii$Proxy(template, activeDeadlineSeconds, backoffLimit, completions, manualSelector, parallelism, selector, ttlSecondsAfterFinished);
        }
    }

    /**
     * An implementation for {@link CronJobSpecJobTemplateSpec}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements CronJobSpecJobTemplateSpec {
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplate> template;
        private final java.lang.Number activeDeadlineSeconds;
        private final java.lang.Number backoffLimit;
        private final java.lang.Number completions;
        private final java.lang.Boolean manualSelector;
        private final java.lang.Number parallelism;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecSelector> selector;
        private final java.lang.Number ttlSecondsAfterFinished;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.template = software.amazon.jsii.Kernel.get(this, "template", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplate.class)));
            this.activeDeadlineSeconds = software.amazon.jsii.Kernel.get(this, "activeDeadlineSeconds", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.backoffLimit = software.amazon.jsii.Kernel.get(this, "backoffLimit", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.completions = software.amazon.jsii.Kernel.get(this, "completions", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.manualSelector = software.amazon.jsii.Kernel.get(this, "manualSelector", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
            this.parallelism = software.amazon.jsii.Kernel.get(this, "parallelism", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.selector = software.amazon.jsii.Kernel.get(this, "selector", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecSelector.class)));
            this.ttlSecondsAfterFinished = software.amazon.jsii.Kernel.get(this, "ttlSecondsAfterFinished", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplate> template, final java.lang.Number activeDeadlineSeconds, final java.lang.Number backoffLimit, final java.lang.Number completions, final java.lang.Boolean manualSelector, final java.lang.Number parallelism, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecSelector> selector, final java.lang.Number ttlSecondsAfterFinished) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.template = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplate>)java.util.Objects.requireNonNull(template, "template is required");
            this.activeDeadlineSeconds = activeDeadlineSeconds;
            this.backoffLimit = backoffLimit;
            this.completions = completions;
            this.manualSelector = manualSelector;
            this.parallelism = parallelism;
            this.selector = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecSelector>)selector;
            this.ttlSecondsAfterFinished = ttlSecondsAfterFinished;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplate> getTemplate() {
            return this.template;
        }

        @Override
        public final java.lang.Number getActiveDeadlineSeconds() {
            return this.activeDeadlineSeconds;
        }

        @Override
        public final java.lang.Number getBackoffLimit() {
            return this.backoffLimit;
        }

        @Override
        public final java.lang.Number getCompletions() {
            return this.completions;
        }

        @Override
        public final java.lang.Boolean getManualSelector() {
            return this.manualSelector;
        }

        @Override
        public final java.lang.Number getParallelism() {
            return this.parallelism;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecSelector> getSelector() {
            return this.selector;
        }

        @Override
        public final java.lang.Number getTtlSecondsAfterFinished() {
            return this.ttlSecondsAfterFinished;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("template", om.valueToTree(this.getTemplate()));
            if (this.getActiveDeadlineSeconds() != null) {
                data.set("activeDeadlineSeconds", om.valueToTree(this.getActiveDeadlineSeconds()));
            }
            if (this.getBackoffLimit() != null) {
                data.set("backoffLimit", om.valueToTree(this.getBackoffLimit()));
            }
            if (this.getCompletions() != null) {
                data.set("completions", om.valueToTree(this.getCompletions()));
            }
            if (this.getManualSelector() != null) {
                data.set("manualSelector", om.valueToTree(this.getManualSelector()));
            }
            if (this.getParallelism() != null) {
                data.set("parallelism", om.valueToTree(this.getParallelism()));
            }
            if (this.getSelector() != null) {
                data.set("selector", om.valueToTree(this.getSelector()));
            }
            if (this.getTtlSecondsAfterFinished() != null) {
                data.set("ttlSecondsAfterFinished", om.valueToTree(this.getTtlSecondsAfterFinished()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.CronJobSpecJobTemplateSpec"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CronJobSpecJobTemplateSpec.Jsii$Proxy that = (CronJobSpecJobTemplateSpec.Jsii$Proxy) o;

            if (!template.equals(that.template)) return false;
            if (this.activeDeadlineSeconds != null ? !this.activeDeadlineSeconds.equals(that.activeDeadlineSeconds) : that.activeDeadlineSeconds != null) return false;
            if (this.backoffLimit != null ? !this.backoffLimit.equals(that.backoffLimit) : that.backoffLimit != null) return false;
            if (this.completions != null ? !this.completions.equals(that.completions) : that.completions != null) return false;
            if (this.manualSelector != null ? !this.manualSelector.equals(that.manualSelector) : that.manualSelector != null) return false;
            if (this.parallelism != null ? !this.parallelism.equals(that.parallelism) : that.parallelism != null) return false;
            if (this.selector != null ? !this.selector.equals(that.selector) : that.selector != null) return false;
            return this.ttlSecondsAfterFinished != null ? this.ttlSecondsAfterFinished.equals(that.ttlSecondsAfterFinished) : that.ttlSecondsAfterFinished == null;
        }

        @Override
        public final int hashCode() {
            int result = this.template.hashCode();
            result = 31 * result + (this.activeDeadlineSeconds != null ? this.activeDeadlineSeconds.hashCode() : 0);
            result = 31 * result + (this.backoffLimit != null ? this.backoffLimit.hashCode() : 0);
            result = 31 * result + (this.completions != null ? this.completions.hashCode() : 0);
            result = 31 * result + (this.manualSelector != null ? this.manualSelector.hashCode() : 0);
            result = 31 * result + (this.parallelism != null ? this.parallelism.hashCode() : 0);
            result = 31 * result + (this.selector != null ? this.selector.hashCode() : 0);
            result = 31 * result + (this.ttlSecondsAfterFinished != null ? this.ttlSecondsAfterFinished.hashCode() : 0);
            return result;
        }
    }
}
