package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.343Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.CronJobSpecJobTemplateSpecTemplateSpec")
@software.amazon.jsii.Jsii.Proxy(CronJobSpecJobTemplateSpecTemplateSpec.Jsii$Proxy.class)
public interface CronJobSpecJobTemplateSpecTemplateSpec extends software.amazon.jsii.JsiiSerializable {

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
     * affinity block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#affinity CronJob#affinity}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecAffinity> getAffinity() {
        return null;
    }

    /**
     * AutomountServiceAccountToken indicates whether a service account token should be automatically mounted.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#automount_service_account_token CronJob#automount_service_account_token}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Boolean getAutomountServiceAccountToken() {
        return null;
    }

    /**
     * container block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#container CronJob#container}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainer> getContainer() {
        return null;
    }

    /**
     * dns_config block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#dns_config CronJob#dns_config}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecDnsConfig> getDnsConfig() {
        return null;
    }

    /**
     * Set DNS policy for containers within the pod.
     * <p>
     * Valid values are 'ClusterFirstWithHostNet', 'ClusterFirst', 'Default' or 'None'. DNS parameters given in DNSConfig will be merged with the policy selected with DNSPolicy. To have DNS options set along with hostNetwork, you have to specify DNS policy explicitly to 'ClusterFirstWithHostNet'. Optional: Defaults to 'ClusterFirst', see <a href="https://kubernetes.io/docs/concepts/services-networking/dns-pod-service/#pod-s-dns-policy">Kubernetes reference</a>.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#dns_policy CronJob#dns_policy}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getDnsPolicy() {
        return null;
    }

    /**
     * host_aliases block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#host_aliases CronJob#host_aliases}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecHostAliases> getHostAliases() {
        return null;
    }

    /**
     * Use the host's ipc namespace. Optional: Defaults to false.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#host_ipc CronJob#host_ipc}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Boolean getHostIpc() {
        return null;
    }

    /**
     * Specifies the hostname of the Pod If not specified, the pod's hostname will be set to a system-defined value.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#hostname CronJob#hostname}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getHostname() {
        return null;
    }

    /**
     * Host networking requested for this pod.
     * <p>
     * Use the host's network namespace. If this option is set, the ports that will be used must be specified.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#host_network CronJob#host_network}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Boolean getHostNetwork() {
        return null;
    }

    /**
     * Use the host's pid namespace.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#host_pid CronJob#host_pid}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Boolean getHostPid() {
        return null;
    }

    /**
     * image_pull_secrets block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#image_pull_secrets CronJob#image_pull_secrets}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecImagePullSecrets> getImagePullSecrets() {
        return null;
    }

    /**
     * init_container block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#init_container CronJob#init_container}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecInitContainer> getInitContainer() {
        return null;
    }

    /**
     * NodeName is a request to schedule this pod onto a specific node.
     * <p>
     * If it is non-empty, the scheduler simply schedules this pod onto that node, assuming that it fits resource requirements.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#node_name CronJob#node_name}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getNodeName() {
        return null;
    }

    /**
     * NodeSelector is a selector which must be true for the pod to fit on a node.
     * <p>
     * Selector which must match a node's labels for the pod to be scheduled on that node. More info: http://kubernetes.io/docs/user-guide/node-selection.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#node_selector CronJob#node_selector}
     */
    default @org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, java.lang.String> getNodeSelector() {
        return null;
    }

    /**
     * If specified, indicates the pod's priority.
     * <p>
     * "system-node-critical" and "system-cluster-critical" are two special keywords which indicate the highest priorities with the former being the highest priority. Any other name must be defined by creating a PriorityClass object with that name. If not specified, the pod priority will be default or zero if there is no default.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#priority_class_name CronJob#priority_class_name}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getPriorityClassName() {
        return null;
    }

    /**
     * Restart policy for all containers within the pod. One of Always, OnFailure, Never. More info: http://kubernetes.io/docs/user-guide/pod-states#restartpolicy.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#restart_policy CronJob#restart_policy}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getRestartPolicy() {
        return null;
    }

    /**
     * security_context block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#security_context CronJob#security_context}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecSecurityContext> getSecurityContext() {
        return null;
    }

    /**
     * ServiceAccountName is the name of the ServiceAccount to use to run this pod. More info: http://releases.k8s.io/HEAD/docs/design/service_accounts.md.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#service_account_name CronJob#service_account_name}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getServiceAccountName() {
        return null;
    }

    /**
     * Share a single process namespace between all of the containers in a pod.
     * <p>
     * When this is set containers will be able to view and signal processes from other containers in the same pod, and the first process in each container will not be assigned PID 1. HostPID and ShareProcessNamespace cannot both be set. Optional: Defaults to false.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#share_process_namespace CronJob#share_process_namespace}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Boolean getShareProcessNamespace() {
        return null;
    }

    /**
     * If specified, the fully qualified Pod hostname will be "...svc.". If not specified, the pod will not have a domainname at all..
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#subdomain CronJob#subdomain}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getSubdomain() {
        return null;
    }

    /**
     * Optional duration in seconds the pod needs to terminate gracefully.
     * <p>
     * May be decreased in delete request. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period will be used instead. The grace period is the duration in seconds after the processes running in the pod are sent a termination signal and the time when the processes are forcibly halted with a kill signal. Set this value longer than the expected cleanup time for your process.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#termination_grace_period_seconds CronJob#termination_grace_period_seconds}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getTerminationGracePeriodSeconds() {
        return null;
    }

    /**
     * toleration block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#toleration CronJob#toleration}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecToleration> getToleration() {
        return null;
    }

    /**
     * volume block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#volume CronJob#volume}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolume> getVolume() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link CronJobSpecJobTemplateSpecTemplateSpec}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link CronJobSpecJobTemplateSpecTemplateSpec}
     */
    public static final class Builder implements software.amazon.jsii.Builder<CronJobSpecJobTemplateSpecTemplateSpec> {
        private java.lang.Number activeDeadlineSeconds;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecAffinity> affinity;
        private java.lang.Boolean automountServiceAccountToken;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainer> container;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecDnsConfig> dnsConfig;
        private java.lang.String dnsPolicy;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecHostAliases> hostAliases;
        private java.lang.Boolean hostIpc;
        private java.lang.String hostname;
        private java.lang.Boolean hostNetwork;
        private java.lang.Boolean hostPid;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecImagePullSecrets> imagePullSecrets;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecInitContainer> initContainer;
        private java.lang.String nodeName;
        private java.util.Map<java.lang.String, java.lang.String> nodeSelector;
        private java.lang.String priorityClassName;
        private java.lang.String restartPolicy;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecSecurityContext> securityContext;
        private java.lang.String serviceAccountName;
        private java.lang.Boolean shareProcessNamespace;
        private java.lang.String subdomain;
        private java.lang.Number terminationGracePeriodSeconds;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecToleration> toleration;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolume> volume;

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpec#getActiveDeadlineSeconds}
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
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpec#getAffinity}
         * @param affinity affinity block.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#affinity CronJob#affinity}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder affinity(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecAffinity> affinity) {
            this.affinity = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecAffinity>)affinity;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpec#getAutomountServiceAccountToken}
         * @param automountServiceAccountToken AutomountServiceAccountToken indicates whether a service account token should be automatically mounted.
         *                                     Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#automount_service_account_token CronJob#automount_service_account_token}
         * @return {@code this}
         */
        public Builder automountServiceAccountToken(java.lang.Boolean automountServiceAccountToken) {
            this.automountServiceAccountToken = automountServiceAccountToken;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpec#getContainer}
         * @param container container block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#container CronJob#container}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder container(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainer> container) {
            this.container = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainer>)container;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpec#getDnsConfig}
         * @param dnsConfig dns_config block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#dns_config CronJob#dns_config}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder dnsConfig(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecDnsConfig> dnsConfig) {
            this.dnsConfig = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecDnsConfig>)dnsConfig;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpec#getDnsPolicy}
         * @param dnsPolicy Set DNS policy for containers within the pod.
         *                  Valid values are 'ClusterFirstWithHostNet', 'ClusterFirst', 'Default' or 'None'. DNS parameters given in DNSConfig will be merged with the policy selected with DNSPolicy. To have DNS options set along with hostNetwork, you have to specify DNS policy explicitly to 'ClusterFirstWithHostNet'. Optional: Defaults to 'ClusterFirst', see <a href="https://kubernetes.io/docs/concepts/services-networking/dns-pod-service/#pod-s-dns-policy">Kubernetes reference</a>.
         *                  <p>
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#dns_policy CronJob#dns_policy}
         * @return {@code this}
         */
        public Builder dnsPolicy(java.lang.String dnsPolicy) {
            this.dnsPolicy = dnsPolicy;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpec#getHostAliases}
         * @param hostAliases host_aliases block.
         *                    Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#host_aliases CronJob#host_aliases}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder hostAliases(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecHostAliases> hostAliases) {
            this.hostAliases = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecHostAliases>)hostAliases;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpec#getHostIpc}
         * @param hostIpc Use the host's ipc namespace. Optional: Defaults to false.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#host_ipc CronJob#host_ipc}
         * @return {@code this}
         */
        public Builder hostIpc(java.lang.Boolean hostIpc) {
            this.hostIpc = hostIpc;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpec#getHostname}
         * @param hostname Specifies the hostname of the Pod If not specified, the pod's hostname will be set to a system-defined value.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#hostname CronJob#hostname}
         * @return {@code this}
         */
        public Builder hostname(java.lang.String hostname) {
            this.hostname = hostname;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpec#getHostNetwork}
         * @param hostNetwork Host networking requested for this pod.
         *                    Use the host's network namespace. If this option is set, the ports that will be used must be specified.
         *                    <p>
         *                    Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#host_network CronJob#host_network}
         * @return {@code this}
         */
        public Builder hostNetwork(java.lang.Boolean hostNetwork) {
            this.hostNetwork = hostNetwork;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpec#getHostPid}
         * @param hostPid Use the host's pid namespace.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#host_pid CronJob#host_pid}
         * @return {@code this}
         */
        public Builder hostPid(java.lang.Boolean hostPid) {
            this.hostPid = hostPid;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpec#getImagePullSecrets}
         * @param imagePullSecrets image_pull_secrets block.
         *                         Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#image_pull_secrets CronJob#image_pull_secrets}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder imagePullSecrets(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecImagePullSecrets> imagePullSecrets) {
            this.imagePullSecrets = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecImagePullSecrets>)imagePullSecrets;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpec#getInitContainer}
         * @param initContainer init_container block.
         *                      Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#init_container CronJob#init_container}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder initContainer(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecInitContainer> initContainer) {
            this.initContainer = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecInitContainer>)initContainer;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpec#getNodeName}
         * @param nodeName NodeName is a request to schedule this pod onto a specific node.
         *                 If it is non-empty, the scheduler simply schedules this pod onto that node, assuming that it fits resource requirements.
         *                 <p>
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#node_name CronJob#node_name}
         * @return {@code this}
         */
        public Builder nodeName(java.lang.String nodeName) {
            this.nodeName = nodeName;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpec#getNodeSelector}
         * @param nodeSelector NodeSelector is a selector which must be true for the pod to fit on a node.
         *                     Selector which must match a node's labels for the pod to be scheduled on that node. More info: http://kubernetes.io/docs/user-guide/node-selection.
         *                     <p>
         *                     Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#node_selector CronJob#node_selector}
         * @return {@code this}
         */
        public Builder nodeSelector(java.util.Map<java.lang.String, java.lang.String> nodeSelector) {
            this.nodeSelector = nodeSelector;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpec#getPriorityClassName}
         * @param priorityClassName If specified, indicates the pod's priority.
         *                          "system-node-critical" and "system-cluster-critical" are two special keywords which indicate the highest priorities with the former being the highest priority. Any other name must be defined by creating a PriorityClass object with that name. If not specified, the pod priority will be default or zero if there is no default.
         *                          <p>
         *                          Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#priority_class_name CronJob#priority_class_name}
         * @return {@code this}
         */
        public Builder priorityClassName(java.lang.String priorityClassName) {
            this.priorityClassName = priorityClassName;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpec#getRestartPolicy}
         * @param restartPolicy Restart policy for all containers within the pod. One of Always, OnFailure, Never. More info: http://kubernetes.io/docs/user-guide/pod-states#restartpolicy.
         *                      Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#restart_policy CronJob#restart_policy}
         * @return {@code this}
         */
        public Builder restartPolicy(java.lang.String restartPolicy) {
            this.restartPolicy = restartPolicy;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpec#getSecurityContext}
         * @param securityContext security_context block.
         *                        Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#security_context CronJob#security_context}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder securityContext(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecSecurityContext> securityContext) {
            this.securityContext = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecSecurityContext>)securityContext;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpec#getServiceAccountName}
         * @param serviceAccountName ServiceAccountName is the name of the ServiceAccount to use to run this pod. More info: http://releases.k8s.io/HEAD/docs/design/service_accounts.md.
         *                           Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#service_account_name CronJob#service_account_name}
         * @return {@code this}
         */
        public Builder serviceAccountName(java.lang.String serviceAccountName) {
            this.serviceAccountName = serviceAccountName;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpec#getShareProcessNamespace}
         * @param shareProcessNamespace Share a single process namespace between all of the containers in a pod.
         *                              When this is set containers will be able to view and signal processes from other containers in the same pod, and the first process in each container will not be assigned PID 1. HostPID and ShareProcessNamespace cannot both be set. Optional: Defaults to false.
         *                              <p>
         *                              Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#share_process_namespace CronJob#share_process_namespace}
         * @return {@code this}
         */
        public Builder shareProcessNamespace(java.lang.Boolean shareProcessNamespace) {
            this.shareProcessNamespace = shareProcessNamespace;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpec#getSubdomain}
         * @param subdomain If specified, the fully qualified Pod hostname will be "...svc.". If not specified, the pod will not have a domainname at all..
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#subdomain CronJob#subdomain}
         * @return {@code this}
         */
        public Builder subdomain(java.lang.String subdomain) {
            this.subdomain = subdomain;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpec#getTerminationGracePeriodSeconds}
         * @param terminationGracePeriodSeconds Optional duration in seconds the pod needs to terminate gracefully.
         *                                      May be decreased in delete request. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period will be used instead. The grace period is the duration in seconds after the processes running in the pod are sent a termination signal and the time when the processes are forcibly halted with a kill signal. Set this value longer than the expected cleanup time for your process.
         *                                      <p>
         *                                      Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#termination_grace_period_seconds CronJob#termination_grace_period_seconds}
         * @return {@code this}
         */
        public Builder terminationGracePeriodSeconds(java.lang.Number terminationGracePeriodSeconds) {
            this.terminationGracePeriodSeconds = terminationGracePeriodSeconds;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpec#getToleration}
         * @param toleration toleration block.
         *                   Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#toleration CronJob#toleration}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder toleration(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecToleration> toleration) {
            this.toleration = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecToleration>)toleration;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpec#getVolume}
         * @param volume volume block.
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#volume CronJob#volume}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder volume(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolume> volume) {
            this.volume = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolume>)volume;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link CronJobSpecJobTemplateSpecTemplateSpec}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public CronJobSpecJobTemplateSpecTemplateSpec build() {
            return new Jsii$Proxy(activeDeadlineSeconds, affinity, automountServiceAccountToken, container, dnsConfig, dnsPolicy, hostAliases, hostIpc, hostname, hostNetwork, hostPid, imagePullSecrets, initContainer, nodeName, nodeSelector, priorityClassName, restartPolicy, securityContext, serviceAccountName, shareProcessNamespace, subdomain, terminationGracePeriodSeconds, toleration, volume);
        }
    }

    /**
     * An implementation for {@link CronJobSpecJobTemplateSpecTemplateSpec}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements CronJobSpecJobTemplateSpecTemplateSpec {
        private final java.lang.Number activeDeadlineSeconds;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecAffinity> affinity;
        private final java.lang.Boolean automountServiceAccountToken;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainer> container;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecDnsConfig> dnsConfig;
        private final java.lang.String dnsPolicy;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecHostAliases> hostAliases;
        private final java.lang.Boolean hostIpc;
        private final java.lang.String hostname;
        private final java.lang.Boolean hostNetwork;
        private final java.lang.Boolean hostPid;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecImagePullSecrets> imagePullSecrets;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecInitContainer> initContainer;
        private final java.lang.String nodeName;
        private final java.util.Map<java.lang.String, java.lang.String> nodeSelector;
        private final java.lang.String priorityClassName;
        private final java.lang.String restartPolicy;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecSecurityContext> securityContext;
        private final java.lang.String serviceAccountName;
        private final java.lang.Boolean shareProcessNamespace;
        private final java.lang.String subdomain;
        private final java.lang.Number terminationGracePeriodSeconds;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecToleration> toleration;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolume> volume;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.activeDeadlineSeconds = software.amazon.jsii.Kernel.get(this, "activeDeadlineSeconds", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.affinity = software.amazon.jsii.Kernel.get(this, "affinity", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecAffinity.class)));
            this.automountServiceAccountToken = software.amazon.jsii.Kernel.get(this, "automountServiceAccountToken", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
            this.container = software.amazon.jsii.Kernel.get(this, "container", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainer.class)));
            this.dnsConfig = software.amazon.jsii.Kernel.get(this, "dnsConfig", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecDnsConfig.class)));
            this.dnsPolicy = software.amazon.jsii.Kernel.get(this, "dnsPolicy", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.hostAliases = software.amazon.jsii.Kernel.get(this, "hostAliases", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecHostAliases.class)));
            this.hostIpc = software.amazon.jsii.Kernel.get(this, "hostIpc", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
            this.hostname = software.amazon.jsii.Kernel.get(this, "hostname", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.hostNetwork = software.amazon.jsii.Kernel.get(this, "hostNetwork", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
            this.hostPid = software.amazon.jsii.Kernel.get(this, "hostPid", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
            this.imagePullSecrets = software.amazon.jsii.Kernel.get(this, "imagePullSecrets", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecImagePullSecrets.class)));
            this.initContainer = software.amazon.jsii.Kernel.get(this, "initContainer", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecInitContainer.class)));
            this.nodeName = software.amazon.jsii.Kernel.get(this, "nodeName", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.nodeSelector = software.amazon.jsii.Kernel.get(this, "nodeSelector", software.amazon.jsii.NativeType.mapOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.priorityClassName = software.amazon.jsii.Kernel.get(this, "priorityClassName", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.restartPolicy = software.amazon.jsii.Kernel.get(this, "restartPolicy", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.securityContext = software.amazon.jsii.Kernel.get(this, "securityContext", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecSecurityContext.class)));
            this.serviceAccountName = software.amazon.jsii.Kernel.get(this, "serviceAccountName", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.shareProcessNamespace = software.amazon.jsii.Kernel.get(this, "shareProcessNamespace", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
            this.subdomain = software.amazon.jsii.Kernel.get(this, "subdomain", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.terminationGracePeriodSeconds = software.amazon.jsii.Kernel.get(this, "terminationGracePeriodSeconds", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.toleration = software.amazon.jsii.Kernel.get(this, "toleration", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecToleration.class)));
            this.volume = software.amazon.jsii.Kernel.get(this, "volume", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolume.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.lang.Number activeDeadlineSeconds, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecAffinity> affinity, final java.lang.Boolean automountServiceAccountToken, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainer> container, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecDnsConfig> dnsConfig, final java.lang.String dnsPolicy, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecHostAliases> hostAliases, final java.lang.Boolean hostIpc, final java.lang.String hostname, final java.lang.Boolean hostNetwork, final java.lang.Boolean hostPid, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecImagePullSecrets> imagePullSecrets, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecInitContainer> initContainer, final java.lang.String nodeName, final java.util.Map<java.lang.String, java.lang.String> nodeSelector, final java.lang.String priorityClassName, final java.lang.String restartPolicy, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecSecurityContext> securityContext, final java.lang.String serviceAccountName, final java.lang.Boolean shareProcessNamespace, final java.lang.String subdomain, final java.lang.Number terminationGracePeriodSeconds, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecToleration> toleration, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolume> volume) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.activeDeadlineSeconds = activeDeadlineSeconds;
            this.affinity = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecAffinity>)affinity;
            this.automountServiceAccountToken = automountServiceAccountToken;
            this.container = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainer>)container;
            this.dnsConfig = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecDnsConfig>)dnsConfig;
            this.dnsPolicy = dnsPolicy;
            this.hostAliases = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecHostAliases>)hostAliases;
            this.hostIpc = hostIpc;
            this.hostname = hostname;
            this.hostNetwork = hostNetwork;
            this.hostPid = hostPid;
            this.imagePullSecrets = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecImagePullSecrets>)imagePullSecrets;
            this.initContainer = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecInitContainer>)initContainer;
            this.nodeName = nodeName;
            this.nodeSelector = nodeSelector;
            this.priorityClassName = priorityClassName;
            this.restartPolicy = restartPolicy;
            this.securityContext = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecSecurityContext>)securityContext;
            this.serviceAccountName = serviceAccountName;
            this.shareProcessNamespace = shareProcessNamespace;
            this.subdomain = subdomain;
            this.terminationGracePeriodSeconds = terminationGracePeriodSeconds;
            this.toleration = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecToleration>)toleration;
            this.volume = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolume>)volume;
        }

        @Override
        public final java.lang.Number getActiveDeadlineSeconds() {
            return this.activeDeadlineSeconds;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecAffinity> getAffinity() {
            return this.affinity;
        }

        @Override
        public final java.lang.Boolean getAutomountServiceAccountToken() {
            return this.automountServiceAccountToken;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainer> getContainer() {
            return this.container;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecDnsConfig> getDnsConfig() {
            return this.dnsConfig;
        }

        @Override
        public final java.lang.String getDnsPolicy() {
            return this.dnsPolicy;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecHostAliases> getHostAliases() {
            return this.hostAliases;
        }

        @Override
        public final java.lang.Boolean getHostIpc() {
            return this.hostIpc;
        }

        @Override
        public final java.lang.String getHostname() {
            return this.hostname;
        }

        @Override
        public final java.lang.Boolean getHostNetwork() {
            return this.hostNetwork;
        }

        @Override
        public final java.lang.Boolean getHostPid() {
            return this.hostPid;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecImagePullSecrets> getImagePullSecrets() {
            return this.imagePullSecrets;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecInitContainer> getInitContainer() {
            return this.initContainer;
        }

        @Override
        public final java.lang.String getNodeName() {
            return this.nodeName;
        }

        @Override
        public final java.util.Map<java.lang.String, java.lang.String> getNodeSelector() {
            return this.nodeSelector;
        }

        @Override
        public final java.lang.String getPriorityClassName() {
            return this.priorityClassName;
        }

        @Override
        public final java.lang.String getRestartPolicy() {
            return this.restartPolicy;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecSecurityContext> getSecurityContext() {
            return this.securityContext;
        }

        @Override
        public final java.lang.String getServiceAccountName() {
            return this.serviceAccountName;
        }

        @Override
        public final java.lang.Boolean getShareProcessNamespace() {
            return this.shareProcessNamespace;
        }

        @Override
        public final java.lang.String getSubdomain() {
            return this.subdomain;
        }

        @Override
        public final java.lang.Number getTerminationGracePeriodSeconds() {
            return this.terminationGracePeriodSeconds;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecToleration> getToleration() {
            return this.toleration;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolume> getVolume() {
            return this.volume;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getActiveDeadlineSeconds() != null) {
                data.set("activeDeadlineSeconds", om.valueToTree(this.getActiveDeadlineSeconds()));
            }
            if (this.getAffinity() != null) {
                data.set("affinity", om.valueToTree(this.getAffinity()));
            }
            if (this.getAutomountServiceAccountToken() != null) {
                data.set("automountServiceAccountToken", om.valueToTree(this.getAutomountServiceAccountToken()));
            }
            if (this.getContainer() != null) {
                data.set("container", om.valueToTree(this.getContainer()));
            }
            if (this.getDnsConfig() != null) {
                data.set("dnsConfig", om.valueToTree(this.getDnsConfig()));
            }
            if (this.getDnsPolicy() != null) {
                data.set("dnsPolicy", om.valueToTree(this.getDnsPolicy()));
            }
            if (this.getHostAliases() != null) {
                data.set("hostAliases", om.valueToTree(this.getHostAliases()));
            }
            if (this.getHostIpc() != null) {
                data.set("hostIpc", om.valueToTree(this.getHostIpc()));
            }
            if (this.getHostname() != null) {
                data.set("hostname", om.valueToTree(this.getHostname()));
            }
            if (this.getHostNetwork() != null) {
                data.set("hostNetwork", om.valueToTree(this.getHostNetwork()));
            }
            if (this.getHostPid() != null) {
                data.set("hostPid", om.valueToTree(this.getHostPid()));
            }
            if (this.getImagePullSecrets() != null) {
                data.set("imagePullSecrets", om.valueToTree(this.getImagePullSecrets()));
            }
            if (this.getInitContainer() != null) {
                data.set("initContainer", om.valueToTree(this.getInitContainer()));
            }
            if (this.getNodeName() != null) {
                data.set("nodeName", om.valueToTree(this.getNodeName()));
            }
            if (this.getNodeSelector() != null) {
                data.set("nodeSelector", om.valueToTree(this.getNodeSelector()));
            }
            if (this.getPriorityClassName() != null) {
                data.set("priorityClassName", om.valueToTree(this.getPriorityClassName()));
            }
            if (this.getRestartPolicy() != null) {
                data.set("restartPolicy", om.valueToTree(this.getRestartPolicy()));
            }
            if (this.getSecurityContext() != null) {
                data.set("securityContext", om.valueToTree(this.getSecurityContext()));
            }
            if (this.getServiceAccountName() != null) {
                data.set("serviceAccountName", om.valueToTree(this.getServiceAccountName()));
            }
            if (this.getShareProcessNamespace() != null) {
                data.set("shareProcessNamespace", om.valueToTree(this.getShareProcessNamespace()));
            }
            if (this.getSubdomain() != null) {
                data.set("subdomain", om.valueToTree(this.getSubdomain()));
            }
            if (this.getTerminationGracePeriodSeconds() != null) {
                data.set("terminationGracePeriodSeconds", om.valueToTree(this.getTerminationGracePeriodSeconds()));
            }
            if (this.getToleration() != null) {
                data.set("toleration", om.valueToTree(this.getToleration()));
            }
            if (this.getVolume() != null) {
                data.set("volume", om.valueToTree(this.getVolume()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.CronJobSpecJobTemplateSpecTemplateSpec"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CronJobSpecJobTemplateSpecTemplateSpec.Jsii$Proxy that = (CronJobSpecJobTemplateSpecTemplateSpec.Jsii$Proxy) o;

            if (this.activeDeadlineSeconds != null ? !this.activeDeadlineSeconds.equals(that.activeDeadlineSeconds) : that.activeDeadlineSeconds != null) return false;
            if (this.affinity != null ? !this.affinity.equals(that.affinity) : that.affinity != null) return false;
            if (this.automountServiceAccountToken != null ? !this.automountServiceAccountToken.equals(that.automountServiceAccountToken) : that.automountServiceAccountToken != null) return false;
            if (this.container != null ? !this.container.equals(that.container) : that.container != null) return false;
            if (this.dnsConfig != null ? !this.dnsConfig.equals(that.dnsConfig) : that.dnsConfig != null) return false;
            if (this.dnsPolicy != null ? !this.dnsPolicy.equals(that.dnsPolicy) : that.dnsPolicy != null) return false;
            if (this.hostAliases != null ? !this.hostAliases.equals(that.hostAliases) : that.hostAliases != null) return false;
            if (this.hostIpc != null ? !this.hostIpc.equals(that.hostIpc) : that.hostIpc != null) return false;
            if (this.hostname != null ? !this.hostname.equals(that.hostname) : that.hostname != null) return false;
            if (this.hostNetwork != null ? !this.hostNetwork.equals(that.hostNetwork) : that.hostNetwork != null) return false;
            if (this.hostPid != null ? !this.hostPid.equals(that.hostPid) : that.hostPid != null) return false;
            if (this.imagePullSecrets != null ? !this.imagePullSecrets.equals(that.imagePullSecrets) : that.imagePullSecrets != null) return false;
            if (this.initContainer != null ? !this.initContainer.equals(that.initContainer) : that.initContainer != null) return false;
            if (this.nodeName != null ? !this.nodeName.equals(that.nodeName) : that.nodeName != null) return false;
            if (this.nodeSelector != null ? !this.nodeSelector.equals(that.nodeSelector) : that.nodeSelector != null) return false;
            if (this.priorityClassName != null ? !this.priorityClassName.equals(that.priorityClassName) : that.priorityClassName != null) return false;
            if (this.restartPolicy != null ? !this.restartPolicy.equals(that.restartPolicy) : that.restartPolicy != null) return false;
            if (this.securityContext != null ? !this.securityContext.equals(that.securityContext) : that.securityContext != null) return false;
            if (this.serviceAccountName != null ? !this.serviceAccountName.equals(that.serviceAccountName) : that.serviceAccountName != null) return false;
            if (this.shareProcessNamespace != null ? !this.shareProcessNamespace.equals(that.shareProcessNamespace) : that.shareProcessNamespace != null) return false;
            if (this.subdomain != null ? !this.subdomain.equals(that.subdomain) : that.subdomain != null) return false;
            if (this.terminationGracePeriodSeconds != null ? !this.terminationGracePeriodSeconds.equals(that.terminationGracePeriodSeconds) : that.terminationGracePeriodSeconds != null) return false;
            if (this.toleration != null ? !this.toleration.equals(that.toleration) : that.toleration != null) return false;
            return this.volume != null ? this.volume.equals(that.volume) : that.volume == null;
        }

        @Override
        public final int hashCode() {
            int result = this.activeDeadlineSeconds != null ? this.activeDeadlineSeconds.hashCode() : 0;
            result = 31 * result + (this.affinity != null ? this.affinity.hashCode() : 0);
            result = 31 * result + (this.automountServiceAccountToken != null ? this.automountServiceAccountToken.hashCode() : 0);
            result = 31 * result + (this.container != null ? this.container.hashCode() : 0);
            result = 31 * result + (this.dnsConfig != null ? this.dnsConfig.hashCode() : 0);
            result = 31 * result + (this.dnsPolicy != null ? this.dnsPolicy.hashCode() : 0);
            result = 31 * result + (this.hostAliases != null ? this.hostAliases.hashCode() : 0);
            result = 31 * result + (this.hostIpc != null ? this.hostIpc.hashCode() : 0);
            result = 31 * result + (this.hostname != null ? this.hostname.hashCode() : 0);
            result = 31 * result + (this.hostNetwork != null ? this.hostNetwork.hashCode() : 0);
            result = 31 * result + (this.hostPid != null ? this.hostPid.hashCode() : 0);
            result = 31 * result + (this.imagePullSecrets != null ? this.imagePullSecrets.hashCode() : 0);
            result = 31 * result + (this.initContainer != null ? this.initContainer.hashCode() : 0);
            result = 31 * result + (this.nodeName != null ? this.nodeName.hashCode() : 0);
            result = 31 * result + (this.nodeSelector != null ? this.nodeSelector.hashCode() : 0);
            result = 31 * result + (this.priorityClassName != null ? this.priorityClassName.hashCode() : 0);
            result = 31 * result + (this.restartPolicy != null ? this.restartPolicy.hashCode() : 0);
            result = 31 * result + (this.securityContext != null ? this.securityContext.hashCode() : 0);
            result = 31 * result + (this.serviceAccountName != null ? this.serviceAccountName.hashCode() : 0);
            result = 31 * result + (this.shareProcessNamespace != null ? this.shareProcessNamespace.hashCode() : 0);
            result = 31 * result + (this.subdomain != null ? this.subdomain.hashCode() : 0);
            result = 31 * result + (this.terminationGracePeriodSeconds != null ? this.terminationGracePeriodSeconds.hashCode() : 0);
            result = 31 * result + (this.toleration != null ? this.toleration.hashCode() : 0);
            result = 31 * result + (this.volume != null ? this.volume.hashCode() : 0);
            return result;
        }
    }
}
