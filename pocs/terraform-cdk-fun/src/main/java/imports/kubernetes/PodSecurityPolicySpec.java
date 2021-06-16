package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.700Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.PodSecurityPolicySpec")
@software.amazon.jsii.Jsii.Proxy(PodSecurityPolicySpec.Jsii$Proxy.class)
public interface PodSecurityPolicySpec extends software.amazon.jsii.JsiiSerializable {

    /**
     * fs_group block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#fs_group PodSecurityPolicy#fs_group}
     */
    @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.PodSecurityPolicySpecFsGroup> getFsGroup();

    /**
     * run_as_user block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#run_as_user PodSecurityPolicy#run_as_user}
     */
    @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.PodSecurityPolicySpecRunAsUser> getRunAsUser();

    /**
     * supplemental_groups block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#supplemental_groups PodSecurityPolicy#supplemental_groups}
     */
    @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.PodSecurityPolicySpecSupplementalGroups> getSupplementalGroups();

    /**
     * allowedCapabilities is a list of capabilities that can be requested to add to the container.
     * <p>
     * Capabilities in this field may be added at the pod author's discretion. You must not list a capability in both allowedCapabilities and requiredDropCapabilities.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#allowed_capabilities PodSecurityPolicy#allowed_capabilities}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<java.lang.String> getAllowedCapabilities() {
        return null;
    }

    /**
     * allowed_flex_volumes block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#allowed_flex_volumes PodSecurityPolicy#allowed_flex_volumes}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSecurityPolicySpecAllowedFlexVolumes> getAllowedFlexVolumes() {
        return null;
    }

    /**
     * allowed_host_paths block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#allowed_host_paths PodSecurityPolicy#allowed_host_paths}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSecurityPolicySpecAllowedHostPaths> getAllowedHostPaths() {
        return null;
    }

    /**
     * AllowedProcMountTypes is a whitelist of allowed ProcMountTypes.
     * <p>
     * Empty or nil indicates that only the DefaultProcMountType may be used. This requires the ProcMountType feature flag to be enabled.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#allowed_proc_mount_types PodSecurityPolicy#allowed_proc_mount_types}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<java.lang.String> getAllowedProcMountTypes() {
        return null;
    }

    /**
     * allowedUnsafeSysctls is a list of explicitly allowed unsafe sysctls, defaults to none.
     * <p>
     * Each entry is either a plain sysctl name or ends in "*" in which case it is considered as a prefix of allowed sysctls. Single * means all unsafe sysctls are allowed. Kubelet has to whitelist all allowed unsafe sysctls explicitly to avoid rejection.
     * <p>
     * Examples: e.g. "foo/<em>" allows "foo/bar", "foo/baz", etc. e.g. "foo.</em>" allows "foo.bar", "foo.baz", etc.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#allowed_unsafe_sysctls PodSecurityPolicy#allowed_unsafe_sysctls}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<java.lang.String> getAllowedUnsafeSysctls() {
        return null;
    }

    /**
     * allowPrivilegeEscalation determines if a pod can request to allow privilege escalation. If unspecified, defaults to true.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#allow_privilege_escalation PodSecurityPolicy#allow_privilege_escalation}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Boolean getAllowPrivilegeEscalation() {
        return null;
    }

    /**
     * defaultAddCapabilities is the default set of capabilities that will be added to the container unless the pod spec specifically drops the capability.
     * <p>
     * You may not list a capability in both defaultAddCapabilities and requiredDropCapabilities. Capabilities added here are implicitly allowed, and need not be included in the allowedCapabilities list.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#default_add_capabilities PodSecurityPolicy#default_add_capabilities}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<java.lang.String> getDefaultAddCapabilities() {
        return null;
    }

    /**
     * defaultAllowPrivilegeEscalation controls the default setting for whether a process can gain more privileges than its parent process.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#default_allow_privilege_escalation PodSecurityPolicy#default_allow_privilege_escalation}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Boolean getDefaultAllowPrivilegeEscalation() {
        return null;
    }

    /**
     * forbiddenSysctls is a list of explicitly forbidden sysctls, defaults to none.
     * <p>
     * Each entry is either a plain sysctl name or ends in "*" in which case it is considered as a prefix of forbidden sysctls. Single * means all sysctls are forbidden.
     * <p>
     * Examples: e.g. "foo/<em>" forbids "foo/bar", "foo/baz", etc. e.g. "foo.</em>" forbids "foo.bar", "foo.baz", etc.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#forbidden_sysctls PodSecurityPolicy#forbidden_sysctls}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<java.lang.String> getForbiddenSysctls() {
        return null;
    }

    /**
     * hostIPC determines if the policy allows the use of HostIPC in the pod spec.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#host_ipc PodSecurityPolicy#host_ipc}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Boolean getHostIpc() {
        return null;
    }

    /**
     * hostNetwork determines if the policy allows the use of HostNetwork in the pod spec.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#host_network PodSecurityPolicy#host_network}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Boolean getHostNetwork() {
        return null;
    }

    /**
     * hostPID determines if the policy allows the use of HostPID in the pod spec.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#host_pid PodSecurityPolicy#host_pid}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Boolean getHostPid() {
        return null;
    }

    /**
     * host_ports block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#host_ports PodSecurityPolicy#host_ports}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSecurityPolicySpecHostPorts> getHostPorts() {
        return null;
    }

    /**
     * privileged determines if a pod can request to be run as privileged.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#privileged PodSecurityPolicy#privileged}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Boolean getPrivileged() {
        return null;
    }

    /**
     * readOnlyRootFilesystem when set to true will force containers to run with a read only root file system.
     * <p>
     * If the container specifically requests to run with a non-read only root file system the PSP should deny the pod. If set to false the container may run with a read only root file system if it wishes but it will not be forced to.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#read_only_root_filesystem PodSecurityPolicy#read_only_root_filesystem}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Boolean getReadOnlyRootFilesystem() {
        return null;
    }

    /**
     * requiredDropCapabilities are the capabilities that will be dropped from the container.
     * <p>
     * These are required to be dropped and cannot be added.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#required_drop_capabilities PodSecurityPolicy#required_drop_capabilities}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<java.lang.String> getRequiredDropCapabilities() {
        return null;
    }

    /**
     * run_as_group block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#run_as_group PodSecurityPolicy#run_as_group}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSecurityPolicySpecRunAsGroup> getRunAsGroup() {
        return null;
    }

    /**
     * se_linux block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#se_linux PodSecurityPolicy#se_linux}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSecurityPolicySpecSeLinux> getSeLinux() {
        return null;
    }

    /**
     * volumes is a white list of allowed volume plugins.
     * <p>
     * Empty indicates that no volumes may be used. To allow all volumes you may use '*'.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#volumes PodSecurityPolicy#volumes}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<java.lang.String> getVolumes() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link PodSecurityPolicySpec}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link PodSecurityPolicySpec}
     */
    public static final class Builder implements software.amazon.jsii.Builder<PodSecurityPolicySpec> {
        private java.util.List<imports.kubernetes.PodSecurityPolicySpecFsGroup> fsGroup;
        private java.util.List<imports.kubernetes.PodSecurityPolicySpecRunAsUser> runAsUser;
        private java.util.List<imports.kubernetes.PodSecurityPolicySpecSupplementalGroups> supplementalGroups;
        private java.util.List<java.lang.String> allowedCapabilities;
        private java.util.List<imports.kubernetes.PodSecurityPolicySpecAllowedFlexVolumes> allowedFlexVolumes;
        private java.util.List<imports.kubernetes.PodSecurityPolicySpecAllowedHostPaths> allowedHostPaths;
        private java.util.List<java.lang.String> allowedProcMountTypes;
        private java.util.List<java.lang.String> allowedUnsafeSysctls;
        private java.lang.Boolean allowPrivilegeEscalation;
        private java.util.List<java.lang.String> defaultAddCapabilities;
        private java.lang.Boolean defaultAllowPrivilegeEscalation;
        private java.util.List<java.lang.String> forbiddenSysctls;
        private java.lang.Boolean hostIpc;
        private java.lang.Boolean hostNetwork;
        private java.lang.Boolean hostPid;
        private java.util.List<imports.kubernetes.PodSecurityPolicySpecHostPorts> hostPorts;
        private java.lang.Boolean privileged;
        private java.lang.Boolean readOnlyRootFilesystem;
        private java.util.List<java.lang.String> requiredDropCapabilities;
        private java.util.List<imports.kubernetes.PodSecurityPolicySpecRunAsGroup> runAsGroup;
        private java.util.List<imports.kubernetes.PodSecurityPolicySpecSeLinux> seLinux;
        private java.util.List<java.lang.String> volumes;

        /**
         * Sets the value of {@link PodSecurityPolicySpec#getFsGroup}
         * @param fsGroup fs_group block. This parameter is required.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#fs_group PodSecurityPolicy#fs_group}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder fsGroup(java.util.List<? extends imports.kubernetes.PodSecurityPolicySpecFsGroup> fsGroup) {
            this.fsGroup = (java.util.List<imports.kubernetes.PodSecurityPolicySpecFsGroup>)fsGroup;
            return this;
        }

        /**
         * Sets the value of {@link PodSecurityPolicySpec#getRunAsUser}
         * @param runAsUser run_as_user block. This parameter is required.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#run_as_user PodSecurityPolicy#run_as_user}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder runAsUser(java.util.List<? extends imports.kubernetes.PodSecurityPolicySpecRunAsUser> runAsUser) {
            this.runAsUser = (java.util.List<imports.kubernetes.PodSecurityPolicySpecRunAsUser>)runAsUser;
            return this;
        }

        /**
         * Sets the value of {@link PodSecurityPolicySpec#getSupplementalGroups}
         * @param supplementalGroups supplemental_groups block. This parameter is required.
         *                           Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#supplemental_groups PodSecurityPolicy#supplemental_groups}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder supplementalGroups(java.util.List<? extends imports.kubernetes.PodSecurityPolicySpecSupplementalGroups> supplementalGroups) {
            this.supplementalGroups = (java.util.List<imports.kubernetes.PodSecurityPolicySpecSupplementalGroups>)supplementalGroups;
            return this;
        }

        /**
         * Sets the value of {@link PodSecurityPolicySpec#getAllowedCapabilities}
         * @param allowedCapabilities allowedCapabilities is a list of capabilities that can be requested to add to the container.
         *                            Capabilities in this field may be added at the pod author's discretion. You must not list a capability in both allowedCapabilities and requiredDropCapabilities.
         *                            <p>
         *                            Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#allowed_capabilities PodSecurityPolicy#allowed_capabilities}
         * @return {@code this}
         */
        public Builder allowedCapabilities(java.util.List<java.lang.String> allowedCapabilities) {
            this.allowedCapabilities = allowedCapabilities;
            return this;
        }

        /**
         * Sets the value of {@link PodSecurityPolicySpec#getAllowedFlexVolumes}
         * @param allowedFlexVolumes allowed_flex_volumes block.
         *                           Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#allowed_flex_volumes PodSecurityPolicy#allowed_flex_volumes}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder allowedFlexVolumes(java.util.List<? extends imports.kubernetes.PodSecurityPolicySpecAllowedFlexVolumes> allowedFlexVolumes) {
            this.allowedFlexVolumes = (java.util.List<imports.kubernetes.PodSecurityPolicySpecAllowedFlexVolumes>)allowedFlexVolumes;
            return this;
        }

        /**
         * Sets the value of {@link PodSecurityPolicySpec#getAllowedHostPaths}
         * @param allowedHostPaths allowed_host_paths block.
         *                         Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#allowed_host_paths PodSecurityPolicy#allowed_host_paths}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder allowedHostPaths(java.util.List<? extends imports.kubernetes.PodSecurityPolicySpecAllowedHostPaths> allowedHostPaths) {
            this.allowedHostPaths = (java.util.List<imports.kubernetes.PodSecurityPolicySpecAllowedHostPaths>)allowedHostPaths;
            return this;
        }

        /**
         * Sets the value of {@link PodSecurityPolicySpec#getAllowedProcMountTypes}
         * @param allowedProcMountTypes AllowedProcMountTypes is a whitelist of allowed ProcMountTypes.
         *                              Empty or nil indicates that only the DefaultProcMountType may be used. This requires the ProcMountType feature flag to be enabled.
         *                              <p>
         *                              Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#allowed_proc_mount_types PodSecurityPolicy#allowed_proc_mount_types}
         * @return {@code this}
         */
        public Builder allowedProcMountTypes(java.util.List<java.lang.String> allowedProcMountTypes) {
            this.allowedProcMountTypes = allowedProcMountTypes;
            return this;
        }

        /**
         * Sets the value of {@link PodSecurityPolicySpec#getAllowedUnsafeSysctls}
         * @param allowedUnsafeSysctls allowedUnsafeSysctls is a list of explicitly allowed unsafe sysctls, defaults to none.
         *                             Each entry is either a plain sysctl name or ends in "*" in which case it is considered as a prefix of allowed sysctls. Single * means all unsafe sysctls are allowed. Kubelet has to whitelist all allowed unsafe sysctls explicitly to avoid rejection.
         *                             <p>
         *                             Examples: e.g. "foo/<em>" allows "foo/bar", "foo/baz", etc. e.g. "foo.</em>" allows "foo.bar", "foo.baz", etc.
         *                             <p>
         *                             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#allowed_unsafe_sysctls PodSecurityPolicy#allowed_unsafe_sysctls}
         * @return {@code this}
         */
        public Builder allowedUnsafeSysctls(java.util.List<java.lang.String> allowedUnsafeSysctls) {
            this.allowedUnsafeSysctls = allowedUnsafeSysctls;
            return this;
        }

        /**
         * Sets the value of {@link PodSecurityPolicySpec#getAllowPrivilegeEscalation}
         * @param allowPrivilegeEscalation allowPrivilegeEscalation determines if a pod can request to allow privilege escalation. If unspecified, defaults to true.
         *                                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#allow_privilege_escalation PodSecurityPolicy#allow_privilege_escalation}
         * @return {@code this}
         */
        public Builder allowPrivilegeEscalation(java.lang.Boolean allowPrivilegeEscalation) {
            this.allowPrivilegeEscalation = allowPrivilegeEscalation;
            return this;
        }

        /**
         * Sets the value of {@link PodSecurityPolicySpec#getDefaultAddCapabilities}
         * @param defaultAddCapabilities defaultAddCapabilities is the default set of capabilities that will be added to the container unless the pod spec specifically drops the capability.
         *                               You may not list a capability in both defaultAddCapabilities and requiredDropCapabilities. Capabilities added here are implicitly allowed, and need not be included in the allowedCapabilities list.
         *                               <p>
         *                               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#default_add_capabilities PodSecurityPolicy#default_add_capabilities}
         * @return {@code this}
         */
        public Builder defaultAddCapabilities(java.util.List<java.lang.String> defaultAddCapabilities) {
            this.defaultAddCapabilities = defaultAddCapabilities;
            return this;
        }

        /**
         * Sets the value of {@link PodSecurityPolicySpec#getDefaultAllowPrivilegeEscalation}
         * @param defaultAllowPrivilegeEscalation defaultAllowPrivilegeEscalation controls the default setting for whether a process can gain more privileges than its parent process.
         *                                        Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#default_allow_privilege_escalation PodSecurityPolicy#default_allow_privilege_escalation}
         * @return {@code this}
         */
        public Builder defaultAllowPrivilegeEscalation(java.lang.Boolean defaultAllowPrivilegeEscalation) {
            this.defaultAllowPrivilegeEscalation = defaultAllowPrivilegeEscalation;
            return this;
        }

        /**
         * Sets the value of {@link PodSecurityPolicySpec#getForbiddenSysctls}
         * @param forbiddenSysctls forbiddenSysctls is a list of explicitly forbidden sysctls, defaults to none.
         *                         Each entry is either a plain sysctl name or ends in "*" in which case it is considered as a prefix of forbidden sysctls. Single * means all sysctls are forbidden.
         *                         <p>
         *                         Examples: e.g. "foo/<em>" forbids "foo/bar", "foo/baz", etc. e.g. "foo.</em>" forbids "foo.bar", "foo.baz", etc.
         *                         <p>
         *                         Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#forbidden_sysctls PodSecurityPolicy#forbidden_sysctls}
         * @return {@code this}
         */
        public Builder forbiddenSysctls(java.util.List<java.lang.String> forbiddenSysctls) {
            this.forbiddenSysctls = forbiddenSysctls;
            return this;
        }

        /**
         * Sets the value of {@link PodSecurityPolicySpec#getHostIpc}
         * @param hostIpc hostIPC determines if the policy allows the use of HostIPC in the pod spec.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#host_ipc PodSecurityPolicy#host_ipc}
         * @return {@code this}
         */
        public Builder hostIpc(java.lang.Boolean hostIpc) {
            this.hostIpc = hostIpc;
            return this;
        }

        /**
         * Sets the value of {@link PodSecurityPolicySpec#getHostNetwork}
         * @param hostNetwork hostNetwork determines if the policy allows the use of HostNetwork in the pod spec.
         *                    Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#host_network PodSecurityPolicy#host_network}
         * @return {@code this}
         */
        public Builder hostNetwork(java.lang.Boolean hostNetwork) {
            this.hostNetwork = hostNetwork;
            return this;
        }

        /**
         * Sets the value of {@link PodSecurityPolicySpec#getHostPid}
         * @param hostPid hostPID determines if the policy allows the use of HostPID in the pod spec.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#host_pid PodSecurityPolicy#host_pid}
         * @return {@code this}
         */
        public Builder hostPid(java.lang.Boolean hostPid) {
            this.hostPid = hostPid;
            return this;
        }

        /**
         * Sets the value of {@link PodSecurityPolicySpec#getHostPorts}
         * @param hostPorts host_ports block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#host_ports PodSecurityPolicy#host_ports}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder hostPorts(java.util.List<? extends imports.kubernetes.PodSecurityPolicySpecHostPorts> hostPorts) {
            this.hostPorts = (java.util.List<imports.kubernetes.PodSecurityPolicySpecHostPorts>)hostPorts;
            return this;
        }

        /**
         * Sets the value of {@link PodSecurityPolicySpec#getPrivileged}
         * @param privileged privileged determines if a pod can request to be run as privileged.
         *                   Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#privileged PodSecurityPolicy#privileged}
         * @return {@code this}
         */
        public Builder privileged(java.lang.Boolean privileged) {
            this.privileged = privileged;
            return this;
        }

        /**
         * Sets the value of {@link PodSecurityPolicySpec#getReadOnlyRootFilesystem}
         * @param readOnlyRootFilesystem readOnlyRootFilesystem when set to true will force containers to run with a read only root file system.
         *                               If the container specifically requests to run with a non-read only root file system the PSP should deny the pod. If set to false the container may run with a read only root file system if it wishes but it will not be forced to.
         *                               <p>
         *                               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#read_only_root_filesystem PodSecurityPolicy#read_only_root_filesystem}
         * @return {@code this}
         */
        public Builder readOnlyRootFilesystem(java.lang.Boolean readOnlyRootFilesystem) {
            this.readOnlyRootFilesystem = readOnlyRootFilesystem;
            return this;
        }

        /**
         * Sets the value of {@link PodSecurityPolicySpec#getRequiredDropCapabilities}
         * @param requiredDropCapabilities requiredDropCapabilities are the capabilities that will be dropped from the container.
         *                                 These are required to be dropped and cannot be added.
         *                                 <p>
         *                                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#required_drop_capabilities PodSecurityPolicy#required_drop_capabilities}
         * @return {@code this}
         */
        public Builder requiredDropCapabilities(java.util.List<java.lang.String> requiredDropCapabilities) {
            this.requiredDropCapabilities = requiredDropCapabilities;
            return this;
        }

        /**
         * Sets the value of {@link PodSecurityPolicySpec#getRunAsGroup}
         * @param runAsGroup run_as_group block.
         *                   Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#run_as_group PodSecurityPolicy#run_as_group}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder runAsGroup(java.util.List<? extends imports.kubernetes.PodSecurityPolicySpecRunAsGroup> runAsGroup) {
            this.runAsGroup = (java.util.List<imports.kubernetes.PodSecurityPolicySpecRunAsGroup>)runAsGroup;
            return this;
        }

        /**
         * Sets the value of {@link PodSecurityPolicySpec#getSeLinux}
         * @param seLinux se_linux block.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#se_linux PodSecurityPolicy#se_linux}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder seLinux(java.util.List<? extends imports.kubernetes.PodSecurityPolicySpecSeLinux> seLinux) {
            this.seLinux = (java.util.List<imports.kubernetes.PodSecurityPolicySpecSeLinux>)seLinux;
            return this;
        }

        /**
         * Sets the value of {@link PodSecurityPolicySpec#getVolumes}
         * @param volumes volumes is a white list of allowed volume plugins.
         *                Empty indicates that no volumes may be used. To allow all volumes you may use '*'.
         *                <p>
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#volumes PodSecurityPolicy#volumes}
         * @return {@code this}
         */
        public Builder volumes(java.util.List<java.lang.String> volumes) {
            this.volumes = volumes;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link PodSecurityPolicySpec}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public PodSecurityPolicySpec build() {
            return new Jsii$Proxy(fsGroup, runAsUser, supplementalGroups, allowedCapabilities, allowedFlexVolumes, allowedHostPaths, allowedProcMountTypes, allowedUnsafeSysctls, allowPrivilegeEscalation, defaultAddCapabilities, defaultAllowPrivilegeEscalation, forbiddenSysctls, hostIpc, hostNetwork, hostPid, hostPorts, privileged, readOnlyRootFilesystem, requiredDropCapabilities, runAsGroup, seLinux, volumes);
        }
    }

    /**
     * An implementation for {@link PodSecurityPolicySpec}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements PodSecurityPolicySpec {
        private final java.util.List<imports.kubernetes.PodSecurityPolicySpecFsGroup> fsGroup;
        private final java.util.List<imports.kubernetes.PodSecurityPolicySpecRunAsUser> runAsUser;
        private final java.util.List<imports.kubernetes.PodSecurityPolicySpecSupplementalGroups> supplementalGroups;
        private final java.util.List<java.lang.String> allowedCapabilities;
        private final java.util.List<imports.kubernetes.PodSecurityPolicySpecAllowedFlexVolumes> allowedFlexVolumes;
        private final java.util.List<imports.kubernetes.PodSecurityPolicySpecAllowedHostPaths> allowedHostPaths;
        private final java.util.List<java.lang.String> allowedProcMountTypes;
        private final java.util.List<java.lang.String> allowedUnsafeSysctls;
        private final java.lang.Boolean allowPrivilegeEscalation;
        private final java.util.List<java.lang.String> defaultAddCapabilities;
        private final java.lang.Boolean defaultAllowPrivilegeEscalation;
        private final java.util.List<java.lang.String> forbiddenSysctls;
        private final java.lang.Boolean hostIpc;
        private final java.lang.Boolean hostNetwork;
        private final java.lang.Boolean hostPid;
        private final java.util.List<imports.kubernetes.PodSecurityPolicySpecHostPorts> hostPorts;
        private final java.lang.Boolean privileged;
        private final java.lang.Boolean readOnlyRootFilesystem;
        private final java.util.List<java.lang.String> requiredDropCapabilities;
        private final java.util.List<imports.kubernetes.PodSecurityPolicySpecRunAsGroup> runAsGroup;
        private final java.util.List<imports.kubernetes.PodSecurityPolicySpecSeLinux> seLinux;
        private final java.util.List<java.lang.String> volumes;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.fsGroup = software.amazon.jsii.Kernel.get(this, "fsGroup", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSecurityPolicySpecFsGroup.class)));
            this.runAsUser = software.amazon.jsii.Kernel.get(this, "runAsUser", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSecurityPolicySpecRunAsUser.class)));
            this.supplementalGroups = software.amazon.jsii.Kernel.get(this, "supplementalGroups", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSecurityPolicySpecSupplementalGroups.class)));
            this.allowedCapabilities = software.amazon.jsii.Kernel.get(this, "allowedCapabilities", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.allowedFlexVolumes = software.amazon.jsii.Kernel.get(this, "allowedFlexVolumes", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSecurityPolicySpecAllowedFlexVolumes.class)));
            this.allowedHostPaths = software.amazon.jsii.Kernel.get(this, "allowedHostPaths", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSecurityPolicySpecAllowedHostPaths.class)));
            this.allowedProcMountTypes = software.amazon.jsii.Kernel.get(this, "allowedProcMountTypes", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.allowedUnsafeSysctls = software.amazon.jsii.Kernel.get(this, "allowedUnsafeSysctls", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.allowPrivilegeEscalation = software.amazon.jsii.Kernel.get(this, "allowPrivilegeEscalation", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
            this.defaultAddCapabilities = software.amazon.jsii.Kernel.get(this, "defaultAddCapabilities", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.defaultAllowPrivilegeEscalation = software.amazon.jsii.Kernel.get(this, "defaultAllowPrivilegeEscalation", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
            this.forbiddenSysctls = software.amazon.jsii.Kernel.get(this, "forbiddenSysctls", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.hostIpc = software.amazon.jsii.Kernel.get(this, "hostIpc", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
            this.hostNetwork = software.amazon.jsii.Kernel.get(this, "hostNetwork", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
            this.hostPid = software.amazon.jsii.Kernel.get(this, "hostPid", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
            this.hostPorts = software.amazon.jsii.Kernel.get(this, "hostPorts", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSecurityPolicySpecHostPorts.class)));
            this.privileged = software.amazon.jsii.Kernel.get(this, "privileged", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
            this.readOnlyRootFilesystem = software.amazon.jsii.Kernel.get(this, "readOnlyRootFilesystem", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
            this.requiredDropCapabilities = software.amazon.jsii.Kernel.get(this, "requiredDropCapabilities", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.runAsGroup = software.amazon.jsii.Kernel.get(this, "runAsGroup", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSecurityPolicySpecRunAsGroup.class)));
            this.seLinux = software.amazon.jsii.Kernel.get(this, "seLinux", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSecurityPolicySpecSeLinux.class)));
            this.volumes = software.amazon.jsii.Kernel.get(this, "volumes", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.PodSecurityPolicySpecFsGroup> fsGroup, final java.util.List<? extends imports.kubernetes.PodSecurityPolicySpecRunAsUser> runAsUser, final java.util.List<? extends imports.kubernetes.PodSecurityPolicySpecSupplementalGroups> supplementalGroups, final java.util.List<java.lang.String> allowedCapabilities, final java.util.List<? extends imports.kubernetes.PodSecurityPolicySpecAllowedFlexVolumes> allowedFlexVolumes, final java.util.List<? extends imports.kubernetes.PodSecurityPolicySpecAllowedHostPaths> allowedHostPaths, final java.util.List<java.lang.String> allowedProcMountTypes, final java.util.List<java.lang.String> allowedUnsafeSysctls, final java.lang.Boolean allowPrivilegeEscalation, final java.util.List<java.lang.String> defaultAddCapabilities, final java.lang.Boolean defaultAllowPrivilegeEscalation, final java.util.List<java.lang.String> forbiddenSysctls, final java.lang.Boolean hostIpc, final java.lang.Boolean hostNetwork, final java.lang.Boolean hostPid, final java.util.List<? extends imports.kubernetes.PodSecurityPolicySpecHostPorts> hostPorts, final java.lang.Boolean privileged, final java.lang.Boolean readOnlyRootFilesystem, final java.util.List<java.lang.String> requiredDropCapabilities, final java.util.List<? extends imports.kubernetes.PodSecurityPolicySpecRunAsGroup> runAsGroup, final java.util.List<? extends imports.kubernetes.PodSecurityPolicySpecSeLinux> seLinux, final java.util.List<java.lang.String> volumes) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.fsGroup = (java.util.List<imports.kubernetes.PodSecurityPolicySpecFsGroup>)java.util.Objects.requireNonNull(fsGroup, "fsGroup is required");
            this.runAsUser = (java.util.List<imports.kubernetes.PodSecurityPolicySpecRunAsUser>)java.util.Objects.requireNonNull(runAsUser, "runAsUser is required");
            this.supplementalGroups = (java.util.List<imports.kubernetes.PodSecurityPolicySpecSupplementalGroups>)java.util.Objects.requireNonNull(supplementalGroups, "supplementalGroups is required");
            this.allowedCapabilities = allowedCapabilities;
            this.allowedFlexVolumes = (java.util.List<imports.kubernetes.PodSecurityPolicySpecAllowedFlexVolumes>)allowedFlexVolumes;
            this.allowedHostPaths = (java.util.List<imports.kubernetes.PodSecurityPolicySpecAllowedHostPaths>)allowedHostPaths;
            this.allowedProcMountTypes = allowedProcMountTypes;
            this.allowedUnsafeSysctls = allowedUnsafeSysctls;
            this.allowPrivilegeEscalation = allowPrivilegeEscalation;
            this.defaultAddCapabilities = defaultAddCapabilities;
            this.defaultAllowPrivilegeEscalation = defaultAllowPrivilegeEscalation;
            this.forbiddenSysctls = forbiddenSysctls;
            this.hostIpc = hostIpc;
            this.hostNetwork = hostNetwork;
            this.hostPid = hostPid;
            this.hostPorts = (java.util.List<imports.kubernetes.PodSecurityPolicySpecHostPorts>)hostPorts;
            this.privileged = privileged;
            this.readOnlyRootFilesystem = readOnlyRootFilesystem;
            this.requiredDropCapabilities = requiredDropCapabilities;
            this.runAsGroup = (java.util.List<imports.kubernetes.PodSecurityPolicySpecRunAsGroup>)runAsGroup;
            this.seLinux = (java.util.List<imports.kubernetes.PodSecurityPolicySpecSeLinux>)seLinux;
            this.volumes = volumes;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSecurityPolicySpecFsGroup> getFsGroup() {
            return this.fsGroup;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSecurityPolicySpecRunAsUser> getRunAsUser() {
            return this.runAsUser;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSecurityPolicySpecSupplementalGroups> getSupplementalGroups() {
            return this.supplementalGroups;
        }

        @Override
        public final java.util.List<java.lang.String> getAllowedCapabilities() {
            return this.allowedCapabilities;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSecurityPolicySpecAllowedFlexVolumes> getAllowedFlexVolumes() {
            return this.allowedFlexVolumes;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSecurityPolicySpecAllowedHostPaths> getAllowedHostPaths() {
            return this.allowedHostPaths;
        }

        @Override
        public final java.util.List<java.lang.String> getAllowedProcMountTypes() {
            return this.allowedProcMountTypes;
        }

        @Override
        public final java.util.List<java.lang.String> getAllowedUnsafeSysctls() {
            return this.allowedUnsafeSysctls;
        }

        @Override
        public final java.lang.Boolean getAllowPrivilegeEscalation() {
            return this.allowPrivilegeEscalation;
        }

        @Override
        public final java.util.List<java.lang.String> getDefaultAddCapabilities() {
            return this.defaultAddCapabilities;
        }

        @Override
        public final java.lang.Boolean getDefaultAllowPrivilegeEscalation() {
            return this.defaultAllowPrivilegeEscalation;
        }

        @Override
        public final java.util.List<java.lang.String> getForbiddenSysctls() {
            return this.forbiddenSysctls;
        }

        @Override
        public final java.lang.Boolean getHostIpc() {
            return this.hostIpc;
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
        public final java.util.List<imports.kubernetes.PodSecurityPolicySpecHostPorts> getHostPorts() {
            return this.hostPorts;
        }

        @Override
        public final java.lang.Boolean getPrivileged() {
            return this.privileged;
        }

        @Override
        public final java.lang.Boolean getReadOnlyRootFilesystem() {
            return this.readOnlyRootFilesystem;
        }

        @Override
        public final java.util.List<java.lang.String> getRequiredDropCapabilities() {
            return this.requiredDropCapabilities;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSecurityPolicySpecRunAsGroup> getRunAsGroup() {
            return this.runAsGroup;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSecurityPolicySpecSeLinux> getSeLinux() {
            return this.seLinux;
        }

        @Override
        public final java.util.List<java.lang.String> getVolumes() {
            return this.volumes;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("fsGroup", om.valueToTree(this.getFsGroup()));
            data.set("runAsUser", om.valueToTree(this.getRunAsUser()));
            data.set("supplementalGroups", om.valueToTree(this.getSupplementalGroups()));
            if (this.getAllowedCapabilities() != null) {
                data.set("allowedCapabilities", om.valueToTree(this.getAllowedCapabilities()));
            }
            if (this.getAllowedFlexVolumes() != null) {
                data.set("allowedFlexVolumes", om.valueToTree(this.getAllowedFlexVolumes()));
            }
            if (this.getAllowedHostPaths() != null) {
                data.set("allowedHostPaths", om.valueToTree(this.getAllowedHostPaths()));
            }
            if (this.getAllowedProcMountTypes() != null) {
                data.set("allowedProcMountTypes", om.valueToTree(this.getAllowedProcMountTypes()));
            }
            if (this.getAllowedUnsafeSysctls() != null) {
                data.set("allowedUnsafeSysctls", om.valueToTree(this.getAllowedUnsafeSysctls()));
            }
            if (this.getAllowPrivilegeEscalation() != null) {
                data.set("allowPrivilegeEscalation", om.valueToTree(this.getAllowPrivilegeEscalation()));
            }
            if (this.getDefaultAddCapabilities() != null) {
                data.set("defaultAddCapabilities", om.valueToTree(this.getDefaultAddCapabilities()));
            }
            if (this.getDefaultAllowPrivilegeEscalation() != null) {
                data.set("defaultAllowPrivilegeEscalation", om.valueToTree(this.getDefaultAllowPrivilegeEscalation()));
            }
            if (this.getForbiddenSysctls() != null) {
                data.set("forbiddenSysctls", om.valueToTree(this.getForbiddenSysctls()));
            }
            if (this.getHostIpc() != null) {
                data.set("hostIpc", om.valueToTree(this.getHostIpc()));
            }
            if (this.getHostNetwork() != null) {
                data.set("hostNetwork", om.valueToTree(this.getHostNetwork()));
            }
            if (this.getHostPid() != null) {
                data.set("hostPid", om.valueToTree(this.getHostPid()));
            }
            if (this.getHostPorts() != null) {
                data.set("hostPorts", om.valueToTree(this.getHostPorts()));
            }
            if (this.getPrivileged() != null) {
                data.set("privileged", om.valueToTree(this.getPrivileged()));
            }
            if (this.getReadOnlyRootFilesystem() != null) {
                data.set("readOnlyRootFilesystem", om.valueToTree(this.getReadOnlyRootFilesystem()));
            }
            if (this.getRequiredDropCapabilities() != null) {
                data.set("requiredDropCapabilities", om.valueToTree(this.getRequiredDropCapabilities()));
            }
            if (this.getRunAsGroup() != null) {
                data.set("runAsGroup", om.valueToTree(this.getRunAsGroup()));
            }
            if (this.getSeLinux() != null) {
                data.set("seLinux", om.valueToTree(this.getSeLinux()));
            }
            if (this.getVolumes() != null) {
                data.set("volumes", om.valueToTree(this.getVolumes()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.PodSecurityPolicySpec"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PodSecurityPolicySpec.Jsii$Proxy that = (PodSecurityPolicySpec.Jsii$Proxy) o;

            if (!fsGroup.equals(that.fsGroup)) return false;
            if (!runAsUser.equals(that.runAsUser)) return false;
            if (!supplementalGroups.equals(that.supplementalGroups)) return false;
            if (this.allowedCapabilities != null ? !this.allowedCapabilities.equals(that.allowedCapabilities) : that.allowedCapabilities != null) return false;
            if (this.allowedFlexVolumes != null ? !this.allowedFlexVolumes.equals(that.allowedFlexVolumes) : that.allowedFlexVolumes != null) return false;
            if (this.allowedHostPaths != null ? !this.allowedHostPaths.equals(that.allowedHostPaths) : that.allowedHostPaths != null) return false;
            if (this.allowedProcMountTypes != null ? !this.allowedProcMountTypes.equals(that.allowedProcMountTypes) : that.allowedProcMountTypes != null) return false;
            if (this.allowedUnsafeSysctls != null ? !this.allowedUnsafeSysctls.equals(that.allowedUnsafeSysctls) : that.allowedUnsafeSysctls != null) return false;
            if (this.allowPrivilegeEscalation != null ? !this.allowPrivilegeEscalation.equals(that.allowPrivilegeEscalation) : that.allowPrivilegeEscalation != null) return false;
            if (this.defaultAddCapabilities != null ? !this.defaultAddCapabilities.equals(that.defaultAddCapabilities) : that.defaultAddCapabilities != null) return false;
            if (this.defaultAllowPrivilegeEscalation != null ? !this.defaultAllowPrivilegeEscalation.equals(that.defaultAllowPrivilegeEscalation) : that.defaultAllowPrivilegeEscalation != null) return false;
            if (this.forbiddenSysctls != null ? !this.forbiddenSysctls.equals(that.forbiddenSysctls) : that.forbiddenSysctls != null) return false;
            if (this.hostIpc != null ? !this.hostIpc.equals(that.hostIpc) : that.hostIpc != null) return false;
            if (this.hostNetwork != null ? !this.hostNetwork.equals(that.hostNetwork) : that.hostNetwork != null) return false;
            if (this.hostPid != null ? !this.hostPid.equals(that.hostPid) : that.hostPid != null) return false;
            if (this.hostPorts != null ? !this.hostPorts.equals(that.hostPorts) : that.hostPorts != null) return false;
            if (this.privileged != null ? !this.privileged.equals(that.privileged) : that.privileged != null) return false;
            if (this.readOnlyRootFilesystem != null ? !this.readOnlyRootFilesystem.equals(that.readOnlyRootFilesystem) : that.readOnlyRootFilesystem != null) return false;
            if (this.requiredDropCapabilities != null ? !this.requiredDropCapabilities.equals(that.requiredDropCapabilities) : that.requiredDropCapabilities != null) return false;
            if (this.runAsGroup != null ? !this.runAsGroup.equals(that.runAsGroup) : that.runAsGroup != null) return false;
            if (this.seLinux != null ? !this.seLinux.equals(that.seLinux) : that.seLinux != null) return false;
            return this.volumes != null ? this.volumes.equals(that.volumes) : that.volumes == null;
        }

        @Override
        public final int hashCode() {
            int result = this.fsGroup.hashCode();
            result = 31 * result + (this.runAsUser.hashCode());
            result = 31 * result + (this.supplementalGroups.hashCode());
            result = 31 * result + (this.allowedCapabilities != null ? this.allowedCapabilities.hashCode() : 0);
            result = 31 * result + (this.allowedFlexVolumes != null ? this.allowedFlexVolumes.hashCode() : 0);
            result = 31 * result + (this.allowedHostPaths != null ? this.allowedHostPaths.hashCode() : 0);
            result = 31 * result + (this.allowedProcMountTypes != null ? this.allowedProcMountTypes.hashCode() : 0);
            result = 31 * result + (this.allowedUnsafeSysctls != null ? this.allowedUnsafeSysctls.hashCode() : 0);
            result = 31 * result + (this.allowPrivilegeEscalation != null ? this.allowPrivilegeEscalation.hashCode() : 0);
            result = 31 * result + (this.defaultAddCapabilities != null ? this.defaultAddCapabilities.hashCode() : 0);
            result = 31 * result + (this.defaultAllowPrivilegeEscalation != null ? this.defaultAllowPrivilegeEscalation.hashCode() : 0);
            result = 31 * result + (this.forbiddenSysctls != null ? this.forbiddenSysctls.hashCode() : 0);
            result = 31 * result + (this.hostIpc != null ? this.hostIpc.hashCode() : 0);
            result = 31 * result + (this.hostNetwork != null ? this.hostNetwork.hashCode() : 0);
            result = 31 * result + (this.hostPid != null ? this.hostPid.hashCode() : 0);
            result = 31 * result + (this.hostPorts != null ? this.hostPorts.hashCode() : 0);
            result = 31 * result + (this.privileged != null ? this.privileged.hashCode() : 0);
            result = 31 * result + (this.readOnlyRootFilesystem != null ? this.readOnlyRootFilesystem.hashCode() : 0);
            result = 31 * result + (this.requiredDropCapabilities != null ? this.requiredDropCapabilities.hashCode() : 0);
            result = 31 * result + (this.runAsGroup != null ? this.runAsGroup.hashCode() : 0);
            result = 31 * result + (this.seLinux != null ? this.seLinux.hashCode() : 0);
            result = 31 * result + (this.volumes != null ? this.volumes.hashCode() : 0);
            return result;
        }
    }
}
