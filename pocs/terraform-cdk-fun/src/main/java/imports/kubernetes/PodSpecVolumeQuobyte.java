package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.760Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.PodSpecVolumeQuobyte")
@software.amazon.jsii.Jsii.Proxy(PodSpecVolumeQuobyte.Jsii$Proxy.class)
public interface PodSpecVolumeQuobyte extends software.amazon.jsii.JsiiSerializable {

    /**
     * Registry represents a single or multiple Quobyte Registry services specified as a string as host:port pair (multiple entries are separated with commas) which acts as the central registry for volumes.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#registry Pod#registry}
     */
    @org.jetbrains.annotations.NotNull java.lang.String getRegistry();

    /**
     * Volume is a string that references an already created Quobyte volume by name.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#volume Pod#volume}
     */
    @org.jetbrains.annotations.NotNull java.lang.String getVolume();

    /**
     * Group to map volume access to Default is no group.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#group Pod#group}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getGroup() {
        return null;
    }

    /**
     * Whether to force the Quobyte volume to be mounted with read-only permissions. Defaults to false.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#read_only Pod#read_only}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Boolean getReadOnly() {
        return null;
    }

    /**
     * User to map volume access to Defaults to serivceaccount user.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#user Pod#user}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getUser() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link PodSpecVolumeQuobyte}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link PodSpecVolumeQuobyte}
     */
    public static final class Builder implements software.amazon.jsii.Builder<PodSpecVolumeQuobyte> {
        private java.lang.String registry;
        private java.lang.String volume;
        private java.lang.String group;
        private java.lang.Boolean readOnly;
        private java.lang.String user;

        /**
         * Sets the value of {@link PodSpecVolumeQuobyte#getRegistry}
         * @param registry Registry represents a single or multiple Quobyte Registry services specified as a string as host:port pair (multiple entries are separated with commas) which acts as the central registry for volumes. This parameter is required.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#registry Pod#registry}
         * @return {@code this}
         */
        public Builder registry(java.lang.String registry) {
            this.registry = registry;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolumeQuobyte#getVolume}
         * @param volume Volume is a string that references an already created Quobyte volume by name. This parameter is required.
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#volume Pod#volume}
         * @return {@code this}
         */
        public Builder volume(java.lang.String volume) {
            this.volume = volume;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolumeQuobyte#getGroup}
         * @param group Group to map volume access to Default is no group.
         *              Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#group Pod#group}
         * @return {@code this}
         */
        public Builder group(java.lang.String group) {
            this.group = group;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolumeQuobyte#getReadOnly}
         * @param readOnly Whether to force the Quobyte volume to be mounted with read-only permissions. Defaults to false.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#read_only Pod#read_only}
         * @return {@code this}
         */
        public Builder readOnly(java.lang.Boolean readOnly) {
            this.readOnly = readOnly;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolumeQuobyte#getUser}
         * @param user User to map volume access to Defaults to serivceaccount user.
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#user Pod#user}
         * @return {@code this}
         */
        public Builder user(java.lang.String user) {
            this.user = user;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link PodSpecVolumeQuobyte}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public PodSpecVolumeQuobyte build() {
            return new Jsii$Proxy(registry, volume, group, readOnly, user);
        }
    }

    /**
     * An implementation for {@link PodSpecVolumeQuobyte}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements PodSpecVolumeQuobyte {
        private final java.lang.String registry;
        private final java.lang.String volume;
        private final java.lang.String group;
        private final java.lang.Boolean readOnly;
        private final java.lang.String user;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.registry = software.amazon.jsii.Kernel.get(this, "registry", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.volume = software.amazon.jsii.Kernel.get(this, "volume", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.group = software.amazon.jsii.Kernel.get(this, "group", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.readOnly = software.amazon.jsii.Kernel.get(this, "readOnly", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
            this.user = software.amazon.jsii.Kernel.get(this, "user", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final java.lang.String registry, final java.lang.String volume, final java.lang.String group, final java.lang.Boolean readOnly, final java.lang.String user) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.registry = java.util.Objects.requireNonNull(registry, "registry is required");
            this.volume = java.util.Objects.requireNonNull(volume, "volume is required");
            this.group = group;
            this.readOnly = readOnly;
            this.user = user;
        }

        @Override
        public final java.lang.String getRegistry() {
            return this.registry;
        }

        @Override
        public final java.lang.String getVolume() {
            return this.volume;
        }

        @Override
        public final java.lang.String getGroup() {
            return this.group;
        }

        @Override
        public final java.lang.Boolean getReadOnly() {
            return this.readOnly;
        }

        @Override
        public final java.lang.String getUser() {
            return this.user;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("registry", om.valueToTree(this.getRegistry()));
            data.set("volume", om.valueToTree(this.getVolume()));
            if (this.getGroup() != null) {
                data.set("group", om.valueToTree(this.getGroup()));
            }
            if (this.getReadOnly() != null) {
                data.set("readOnly", om.valueToTree(this.getReadOnly()));
            }
            if (this.getUser() != null) {
                data.set("user", om.valueToTree(this.getUser()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.PodSpecVolumeQuobyte"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PodSpecVolumeQuobyte.Jsii$Proxy that = (PodSpecVolumeQuobyte.Jsii$Proxy) o;

            if (!registry.equals(that.registry)) return false;
            if (!volume.equals(that.volume)) return false;
            if (this.group != null ? !this.group.equals(that.group) : that.group != null) return false;
            if (this.readOnly != null ? !this.readOnly.equals(that.readOnly) : that.readOnly != null) return false;
            return this.user != null ? this.user.equals(that.user) : that.user == null;
        }

        @Override
        public final int hashCode() {
            int result = this.registry.hashCode();
            result = 31 * result + (this.volume.hashCode());
            result = 31 * result + (this.group != null ? this.group.hashCode() : 0);
            result = 31 * result + (this.readOnly != null ? this.readOnly.hashCode() : 0);
            result = 31 * result + (this.user != null ? this.user.hashCode() : 0);
            return result;
        }
    }
}
