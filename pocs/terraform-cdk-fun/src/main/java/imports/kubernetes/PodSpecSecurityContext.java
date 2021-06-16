package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.744Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.PodSpecSecurityContext")
@software.amazon.jsii.Jsii.Proxy(PodSpecSecurityContext.Jsii$Proxy.class)
public interface PodSpecSecurityContext extends software.amazon.jsii.JsiiSerializable {

    /**
     * A special supplemental group that applies to all containers in a pod.
     * <p>
     * Some volume types allow the Kubelet to change the ownership of that volume to be owned by the pod: 1. The owning GID will be the FSGroup 2. The setgid bit is set (new files created in the volume will be owned by FSGroup) 3. The permission bits are OR'd with rw-rw---- If unset, the Kubelet will not modify the ownership and permissions of any volume.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#fs_group Pod#fs_group}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getFsGroup() {
        return null;
    }

    /**
     * The GID to run the entrypoint of the container process.
     * <p>
     * Uses runtime default if unset. May also be set in SecurityContext. If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence for that container.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#run_as_group Pod#run_as_group}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getRunAsGroup() {
        return null;
    }

    /**
     * Indicates that the container must run as a non-root user.
     * <p>
     * If true, the Kubelet will validate the image at runtime to ensure that it does not run as UID 0 (root) and fail to start the container if it does. If unset or false, no such validation will be performed. May also be set in SecurityContext. If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#run_as_non_root Pod#run_as_non_root}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Boolean getRunAsNonRoot() {
        return null;
    }

    /**
     * The UID to run the entrypoint of the container process.
     * <p>
     * Defaults to user specified in image metadata if unspecified. May also be set in SecurityContext. If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence for that container.
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
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecSecurityContextSeLinuxOptions> getSeLinuxOptions() {
        return null;
    }

    /**
     * A list of groups applied to the first process run in each container, in addition to the container's primary GID.
     * <p>
     * If unspecified, no groups will be added to any container.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#supplemental_groups Pod#supplemental_groups}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<java.lang.Number> getSupplementalGroups() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link PodSpecSecurityContext}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link PodSpecSecurityContext}
     */
    public static final class Builder implements software.amazon.jsii.Builder<PodSpecSecurityContext> {
        private java.lang.Number fsGroup;
        private java.lang.Number runAsGroup;
        private java.lang.Boolean runAsNonRoot;
        private java.lang.Number runAsUser;
        private java.util.List<imports.kubernetes.PodSpecSecurityContextSeLinuxOptions> seLinuxOptions;
        private java.util.List<java.lang.Number> supplementalGroups;

        /**
         * Sets the value of {@link PodSpecSecurityContext#getFsGroup}
         * @param fsGroup A special supplemental group that applies to all containers in a pod.
         *                Some volume types allow the Kubelet to change the ownership of that volume to be owned by the pod: 1. The owning GID will be the FSGroup 2. The setgid bit is set (new files created in the volume will be owned by FSGroup) 3. The permission bits are OR'd with rw-rw---- If unset, the Kubelet will not modify the ownership and permissions of any volume.
         *                <p>
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#fs_group Pod#fs_group}
         * @return {@code this}
         */
        public Builder fsGroup(java.lang.Number fsGroup) {
            this.fsGroup = fsGroup;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecSecurityContext#getRunAsGroup}
         * @param runAsGroup The GID to run the entrypoint of the container process.
         *                   Uses runtime default if unset. May also be set in SecurityContext. If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence for that container.
         *                   <p>
         *                   Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#run_as_group Pod#run_as_group}
         * @return {@code this}
         */
        public Builder runAsGroup(java.lang.Number runAsGroup) {
            this.runAsGroup = runAsGroup;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecSecurityContext#getRunAsNonRoot}
         * @param runAsNonRoot Indicates that the container must run as a non-root user.
         *                     If true, the Kubelet will validate the image at runtime to ensure that it does not run as UID 0 (root) and fail to start the container if it does. If unset or false, no such validation will be performed. May also be set in SecurityContext. If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence.
         *                     <p>
         *                     Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#run_as_non_root Pod#run_as_non_root}
         * @return {@code this}
         */
        public Builder runAsNonRoot(java.lang.Boolean runAsNonRoot) {
            this.runAsNonRoot = runAsNonRoot;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecSecurityContext#getRunAsUser}
         * @param runAsUser The UID to run the entrypoint of the container process.
         *                  Defaults to user specified in image metadata if unspecified. May also be set in SecurityContext. If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence for that container.
         *                  <p>
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#run_as_user Pod#run_as_user}
         * @return {@code this}
         */
        public Builder runAsUser(java.lang.Number runAsUser) {
            this.runAsUser = runAsUser;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecSecurityContext#getSeLinuxOptions}
         * @param seLinuxOptions se_linux_options block.
         *                       Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#se_linux_options Pod#se_linux_options}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder seLinuxOptions(java.util.List<? extends imports.kubernetes.PodSpecSecurityContextSeLinuxOptions> seLinuxOptions) {
            this.seLinuxOptions = (java.util.List<imports.kubernetes.PodSpecSecurityContextSeLinuxOptions>)seLinuxOptions;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecSecurityContext#getSupplementalGroups}
         * @param supplementalGroups A list of groups applied to the first process run in each container, in addition to the container's primary GID.
         *                           If unspecified, no groups will be added to any container.
         *                           <p>
         *                           Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#supplemental_groups Pod#supplemental_groups}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder supplementalGroups(java.util.List<? extends java.lang.Number> supplementalGroups) {
            this.supplementalGroups = (java.util.List<java.lang.Number>)supplementalGroups;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link PodSpecSecurityContext}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public PodSpecSecurityContext build() {
            return new Jsii$Proxy(fsGroup, runAsGroup, runAsNonRoot, runAsUser, seLinuxOptions, supplementalGroups);
        }
    }

    /**
     * An implementation for {@link PodSpecSecurityContext}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements PodSpecSecurityContext {
        private final java.lang.Number fsGroup;
        private final java.lang.Number runAsGroup;
        private final java.lang.Boolean runAsNonRoot;
        private final java.lang.Number runAsUser;
        private final java.util.List<imports.kubernetes.PodSpecSecurityContextSeLinuxOptions> seLinuxOptions;
        private final java.util.List<java.lang.Number> supplementalGroups;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.fsGroup = software.amazon.jsii.Kernel.get(this, "fsGroup", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.runAsGroup = software.amazon.jsii.Kernel.get(this, "runAsGroup", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.runAsNonRoot = software.amazon.jsii.Kernel.get(this, "runAsNonRoot", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
            this.runAsUser = software.amazon.jsii.Kernel.get(this, "runAsUser", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.seLinuxOptions = software.amazon.jsii.Kernel.get(this, "seLinuxOptions", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecSecurityContextSeLinuxOptions.class)));
            this.supplementalGroups = software.amazon.jsii.Kernel.get(this, "supplementalGroups", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.Number.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.lang.Number fsGroup, final java.lang.Number runAsGroup, final java.lang.Boolean runAsNonRoot, final java.lang.Number runAsUser, final java.util.List<? extends imports.kubernetes.PodSpecSecurityContextSeLinuxOptions> seLinuxOptions, final java.util.List<? extends java.lang.Number> supplementalGroups) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.fsGroup = fsGroup;
            this.runAsGroup = runAsGroup;
            this.runAsNonRoot = runAsNonRoot;
            this.runAsUser = runAsUser;
            this.seLinuxOptions = (java.util.List<imports.kubernetes.PodSpecSecurityContextSeLinuxOptions>)seLinuxOptions;
            this.supplementalGroups = (java.util.List<java.lang.Number>)supplementalGroups;
        }

        @Override
        public final java.lang.Number getFsGroup() {
            return this.fsGroup;
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
        public final java.util.List<imports.kubernetes.PodSpecSecurityContextSeLinuxOptions> getSeLinuxOptions() {
            return this.seLinuxOptions;
        }

        @Override
        public final java.util.List<java.lang.Number> getSupplementalGroups() {
            return this.supplementalGroups;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getFsGroup() != null) {
                data.set("fsGroup", om.valueToTree(this.getFsGroup()));
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
            if (this.getSupplementalGroups() != null) {
                data.set("supplementalGroups", om.valueToTree(this.getSupplementalGroups()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.PodSpecSecurityContext"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PodSpecSecurityContext.Jsii$Proxy that = (PodSpecSecurityContext.Jsii$Proxy) o;

            if (this.fsGroup != null ? !this.fsGroup.equals(that.fsGroup) : that.fsGroup != null) return false;
            if (this.runAsGroup != null ? !this.runAsGroup.equals(that.runAsGroup) : that.runAsGroup != null) return false;
            if (this.runAsNonRoot != null ? !this.runAsNonRoot.equals(that.runAsNonRoot) : that.runAsNonRoot != null) return false;
            if (this.runAsUser != null ? !this.runAsUser.equals(that.runAsUser) : that.runAsUser != null) return false;
            if (this.seLinuxOptions != null ? !this.seLinuxOptions.equals(that.seLinuxOptions) : that.seLinuxOptions != null) return false;
            return this.supplementalGroups != null ? this.supplementalGroups.equals(that.supplementalGroups) : that.supplementalGroups == null;
        }

        @Override
        public final int hashCode() {
            int result = this.fsGroup != null ? this.fsGroup.hashCode() : 0;
            result = 31 * result + (this.runAsGroup != null ? this.runAsGroup.hashCode() : 0);
            result = 31 * result + (this.runAsNonRoot != null ? this.runAsNonRoot.hashCode() : 0);
            result = 31 * result + (this.runAsUser != null ? this.runAsUser.hashCode() : 0);
            result = 31 * result + (this.seLinuxOptions != null ? this.seLinuxOptions.hashCode() : 0);
            result = 31 * result + (this.supplementalGroups != null ? this.supplementalGroups.hashCode() : 0);
            return result;
        }
    }
}
