package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.742Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.PodSpecInitContainerSecurityContext")
@software.amazon.jsii.Jsii.Proxy(PodSpecInitContainerSecurityContext.Jsii$Proxy.class)
public interface PodSpecInitContainerSecurityContext extends software.amazon.jsii.JsiiSerializable {

    /**
     * AllowPrivilegeEscalation controls whether a process can gain more privileges than its parent process.
     * <p>
     * This bool directly controls if the no_new_privs flag will be set on the container process. AllowPrivilegeEscalation is true always when the container is: 1) run as Privileged 2) has CAP_SYS_ADMIN
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#allow_privilege_escalation Pod#allow_privilege_escalation}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Boolean getAllowPrivilegeEscalation() {
        return null;
    }

    /**
     * capabilities block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#capabilities Pod#capabilities}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecInitContainerSecurityContextCapabilities> getCapabilities() {
        return null;
    }

    /**
     * Run container in privileged mode.
     * <p>
     * Processes in privileged containers are essentially equivalent to root on the host. Defaults to false.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#privileged Pod#privileged}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Boolean getPrivileged() {
        return null;
    }

    /**
     * Whether this container has a read-only root filesystem. Default is false.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#read_only_root_filesystem Pod#read_only_root_filesystem}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Boolean getReadOnlyRootFilesystem() {
        return null;
    }

    /**
     * The GID to run the entrypoint of the container process.
     * <p>
     * Uses runtime default if unset. May also be set in PodSecurityContext. If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#run_as_group Pod#run_as_group}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getRunAsGroup() {
        return null;
    }

    /**
     * Indicates that the container must run as a non-root user.
     * <p>
     * If true, the Kubelet will validate the image at runtime to ensure that it does not run as UID 0 (root) and fail to start the container if it does. If unset or false, no such validation will be performed. May also be set in PodSecurityContext. If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#run_as_non_root Pod#run_as_non_root}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Boolean getRunAsNonRoot() {
        return null;
    }

    /**
     * The UID to run the entrypoint of the container process.
     * <p>
     * Defaults to user specified in image metadata if unspecified. May also be set in PodSecurityContext. If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#run_as_user Pod#run_as_user}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getRunAsUser() {
        return null;
    }

    /**
     * se_linux_options block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#se_linux_options Pod#se_linux_options}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecInitContainerSecurityContextSeLinuxOptions> getSeLinuxOptions() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link PodSpecInitContainerSecurityContext}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link PodSpecInitContainerSecurityContext}
     */
    public static final class Builder implements software.amazon.jsii.Builder<PodSpecInitContainerSecurityContext> {
        private java.lang.Boolean allowPrivilegeEscalation;
        private java.util.List<imports.kubernetes.PodSpecInitContainerSecurityContextCapabilities> capabilities;
        private java.lang.Boolean privileged;
        private java.lang.Boolean readOnlyRootFilesystem;
        private java.lang.Number runAsGroup;
        private java.lang.Boolean runAsNonRoot;
        private java.lang.Number runAsUser;
        private java.util.List<imports.kubernetes.PodSpecInitContainerSecurityContextSeLinuxOptions> seLinuxOptions;

        /**
         * Sets the value of {@link PodSpecInitContainerSecurityContext#getAllowPrivilegeEscalation}
         * @param allowPrivilegeEscalation AllowPrivilegeEscalation controls whether a process can gain more privileges than its parent process.
         *                                 This bool directly controls if the no_new_privs flag will be set on the container process. AllowPrivilegeEscalation is true always when the container is: 1) run as Privileged 2) has CAP_SYS_ADMIN
         *                                 <p>
         *                                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#allow_privilege_escalation Pod#allow_privilege_escalation}
         * @return {@code this}
         */
        public Builder allowPrivilegeEscalation(java.lang.Boolean allowPrivilegeEscalation) {
            this.allowPrivilegeEscalation = allowPrivilegeEscalation;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecInitContainerSecurityContext#getCapabilities}
         * @param capabilities capabilities block.
         *                     Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#capabilities Pod#capabilities}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder capabilities(java.util.List<? extends imports.kubernetes.PodSpecInitContainerSecurityContextCapabilities> capabilities) {
            this.capabilities = (java.util.List<imports.kubernetes.PodSpecInitContainerSecurityContextCapabilities>)capabilities;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecInitContainerSecurityContext#getPrivileged}
         * @param privileged Run container in privileged mode.
         *                   Processes in privileged containers are essentially equivalent to root on the host. Defaults to false.
         *                   <p>
         *                   Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#privileged Pod#privileged}
         * @return {@code this}
         */
        public Builder privileged(java.lang.Boolean privileged) {
            this.privileged = privileged;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecInitContainerSecurityContext#getReadOnlyRootFilesystem}
         * @param readOnlyRootFilesystem Whether this container has a read-only root filesystem. Default is false.
         *                               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#read_only_root_filesystem Pod#read_only_root_filesystem}
         * @return {@code this}
         */
        public Builder readOnlyRootFilesystem(java.lang.Boolean readOnlyRootFilesystem) {
            this.readOnlyRootFilesystem = readOnlyRootFilesystem;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecInitContainerSecurityContext#getRunAsGroup}
         * @param runAsGroup The GID to run the entrypoint of the container process.
         *                   Uses runtime default if unset. May also be set in PodSecurityContext. If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence.
         *                   <p>
         *                   Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#run_as_group Pod#run_as_group}
         * @return {@code this}
         */
        public Builder runAsGroup(java.lang.Number runAsGroup) {
            this.runAsGroup = runAsGroup;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecInitContainerSecurityContext#getRunAsNonRoot}
         * @param runAsNonRoot Indicates that the container must run as a non-root user.
         *                     If true, the Kubelet will validate the image at runtime to ensure that it does not run as UID 0 (root) and fail to start the container if it does. If unset or false, no such validation will be performed. May also be set in PodSecurityContext. If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence.
         *                     <p>
         *                     Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#run_as_non_root Pod#run_as_non_root}
         * @return {@code this}
         */
        public Builder runAsNonRoot(java.lang.Boolean runAsNonRoot) {
            this.runAsNonRoot = runAsNonRoot;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecInitContainerSecurityContext#getRunAsUser}
         * @param runAsUser The UID to run the entrypoint of the container process.
         *                  Defaults to user specified in image metadata if unspecified. May also be set in PodSecurityContext. If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence.
         *                  <p>
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#run_as_user Pod#run_as_user}
         * @return {@code this}
         */
        public Builder runAsUser(java.lang.Number runAsUser) {
            this.runAsUser = runAsUser;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecInitContainerSecurityContext#getSeLinuxOptions}
         * @param seLinuxOptions se_linux_options block.
         *                       Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#se_linux_options Pod#se_linux_options}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder seLinuxOptions(java.util.List<? extends imports.kubernetes.PodSpecInitContainerSecurityContextSeLinuxOptions> seLinuxOptions) {
            this.seLinuxOptions = (java.util.List<imports.kubernetes.PodSpecInitContainerSecurityContextSeLinuxOptions>)seLinuxOptions;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link PodSpecInitContainerSecurityContext}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public PodSpecInitContainerSecurityContext build() {
            return new Jsii$Proxy(allowPrivilegeEscalation, capabilities, privileged, readOnlyRootFilesystem, runAsGroup, runAsNonRoot, runAsUser, seLinuxOptions);
        }
    }

    /**
     * An implementation for {@link PodSpecInitContainerSecurityContext}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements PodSpecInitContainerSecurityContext {
        private final java.lang.Boolean allowPrivilegeEscalation;
        private final java.util.List<imports.kubernetes.PodSpecInitContainerSecurityContextCapabilities> capabilities;
        private final java.lang.Boolean privileged;
        private final java.lang.Boolean readOnlyRootFilesystem;
        private final java.lang.Number runAsGroup;
        private final java.lang.Boolean runAsNonRoot;
        private final java.lang.Number runAsUser;
        private final java.util.List<imports.kubernetes.PodSpecInitContainerSecurityContextSeLinuxOptions> seLinuxOptions;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.allowPrivilegeEscalation = software.amazon.jsii.Kernel.get(this, "allowPrivilegeEscalation", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
            this.capabilities = software.amazon.jsii.Kernel.get(this, "capabilities", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecInitContainerSecurityContextCapabilities.class)));
            this.privileged = software.amazon.jsii.Kernel.get(this, "privileged", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
            this.readOnlyRootFilesystem = software.amazon.jsii.Kernel.get(this, "readOnlyRootFilesystem", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
            this.runAsGroup = software.amazon.jsii.Kernel.get(this, "runAsGroup", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.runAsNonRoot = software.amazon.jsii.Kernel.get(this, "runAsNonRoot", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
            this.runAsUser = software.amazon.jsii.Kernel.get(this, "runAsUser", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.seLinuxOptions = software.amazon.jsii.Kernel.get(this, "seLinuxOptions", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecInitContainerSecurityContextSeLinuxOptions.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.lang.Boolean allowPrivilegeEscalation, final java.util.List<? extends imports.kubernetes.PodSpecInitContainerSecurityContextCapabilities> capabilities, final java.lang.Boolean privileged, final java.lang.Boolean readOnlyRootFilesystem, final java.lang.Number runAsGroup, final java.lang.Boolean runAsNonRoot, final java.lang.Number runAsUser, final java.util.List<? extends imports.kubernetes.PodSpecInitContainerSecurityContextSeLinuxOptions> seLinuxOptions) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.allowPrivilegeEscalation = allowPrivilegeEscalation;
            this.capabilities = (java.util.List<imports.kubernetes.PodSpecInitContainerSecurityContextCapabilities>)capabilities;
            this.privileged = privileged;
            this.readOnlyRootFilesystem = readOnlyRootFilesystem;
            this.runAsGroup = runAsGroup;
            this.runAsNonRoot = runAsNonRoot;
            this.runAsUser = runAsUser;
            this.seLinuxOptions = (java.util.List<imports.kubernetes.PodSpecInitContainerSecurityContextSeLinuxOptions>)seLinuxOptions;
        }

        @Override
        public final java.lang.Boolean getAllowPrivilegeEscalation() {
            return this.allowPrivilegeEscalation;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecInitContainerSecurityContextCapabilities> getCapabilities() {
            return this.capabilities;
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
        public final java.lang.Number getRunAsGroup() {
            return this.runAsGroup;
        }

        @Override
        public final java.lang.Boolean getRunAsNonRoot() {
            return this.runAsNonRoot;
        }

        @Override
        public final java.lang.Number getRunAsUser() {
            return this.runAsUser;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecInitContainerSecurityContextSeLinuxOptions> getSeLinuxOptions() {
            return this.seLinuxOptions;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getAllowPrivilegeEscalation() != null) {
                data.set("allowPrivilegeEscalation", om.valueToTree(this.getAllowPrivilegeEscalation()));
            }
            if (this.getCapabilities() != null) {
                data.set("capabilities", om.valueToTree(this.getCapabilities()));
            }
            if (this.getPrivileged() != null) {
                data.set("privileged", om.valueToTree(this.getPrivileged()));
            }
            if (this.getReadOnlyRootFilesystem() != null) {
                data.set("readOnlyRootFilesystem", om.valueToTree(this.getReadOnlyRootFilesystem()));
            }
            if (this.getRunAsGroup() != null) {
                data.set("runAsGroup", om.valueToTree(this.getRunAsGroup()));
            }
            if (this.getRunAsNonRoot() != null) {
                data.set("runAsNonRoot", om.valueToTree(this.getRunAsNonRoot()));
            }
            if (this.getRunAsUser() != null) {
                data.set("runAsUser", om.valueToTree(this.getRunAsUser()));
            }
            if (this.getSeLinuxOptions() != null) {
                data.set("seLinuxOptions", om.valueToTree(this.getSeLinuxOptions()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.PodSpecInitContainerSecurityContext"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PodSpecInitContainerSecurityContext.Jsii$Proxy that = (PodSpecInitContainerSecurityContext.Jsii$Proxy) o;

            if (this.allowPrivilegeEscalation != null ? !this.allowPrivilegeEscalation.equals(that.allowPrivilegeEscalation) : that.allowPrivilegeEscalation != null) return false;
            if (this.capabilities != null ? !this.capabilities.equals(that.capabilities) : that.capabilities != null) return false;
            if (this.privileged != null ? !this.privileged.equals(that.privileged) : that.privileged != null) return false;
            if (this.readOnlyRootFilesystem != null ? !this.readOnlyRootFilesystem.equals(that.readOnlyRootFilesystem) : that.readOnlyRootFilesystem != null) return false;
            if (this.runAsGroup != null ? !this.runAsGroup.equals(that.runAsGroup) : that.runAsGroup != null) return false;
            if (this.runAsNonRoot != null ? !this.runAsNonRoot.equals(that.runAsNonRoot) : that.runAsNonRoot != null) return false;
            if (this.runAsUser != null ? !this.runAsUser.equals(that.runAsUser) : that.runAsUser != null) return false;
            return this.seLinuxOptions != null ? this.seLinuxOptions.equals(that.seLinuxOptions) : that.seLinuxOptions == null;
        }

        @Override
        public final int hashCode() {
            int result = this.allowPrivilegeEscalation != null ? this.allowPrivilegeEscalation.hashCode() : 0;
            result = 31 * result + (this.capabilities != null ? this.capabilities.hashCode() : 0);
            result = 31 * result + (this.privileged != null ? this.privileged.hashCode() : 0);
            result = 31 * result + (this.readOnlyRootFilesystem != null ? this.readOnlyRootFilesystem.hashCode() : 0);
            result = 31 * result + (this.runAsGroup != null ? this.runAsGroup.hashCode() : 0);
            result = 31 * result + (this.runAsNonRoot != null ? this.runAsNonRoot.hashCode() : 0);
            result = 31 * result + (this.runAsUser != null ? this.runAsUser.hashCode() : 0);
            result = 31 * result + (this.seLinuxOptions != null ? this.seLinuxOptions.hashCode() : 0);
            return result;
        }
    }
}
