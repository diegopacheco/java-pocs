package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.759Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.PodSpecVolumeGlusterfs")
@software.amazon.jsii.Jsii.Proxy(PodSpecVolumeGlusterfs.Jsii$Proxy.class)
public interface PodSpecVolumeGlusterfs extends software.amazon.jsii.JsiiSerializable {

    /**
     * The endpoint name that details Glusterfs topology. More info: http://releases.k8s.io/HEAD/examples/volumes/glusterfs/README.md#create-a-pod.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#endpoints_name Pod#endpoints_name}
     */
    @org.jetbrains.annotations.NotNull java.lang.String getEndpointsName();

    /**
     * The Glusterfs volume path. More info: http://releases.k8s.io/HEAD/examples/volumes/glusterfs/README.md#create-a-pod.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#path Pod#path}
     */
    @org.jetbrains.annotations.NotNull java.lang.String getPath();

    /**
     * Whether to force the Glusterfs volume to be mounted with read-only permissions. Defaults to false. More info: http://releases.k8s.io/HEAD/examples/volumes/glusterfs/README.md#create-a-pod.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#read_only Pod#read_only}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Boolean getReadOnly() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link PodSpecVolumeGlusterfs}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link PodSpecVolumeGlusterfs}
     */
    public static final class Builder implements software.amazon.jsii.Builder<PodSpecVolumeGlusterfs> {
        private java.lang.String endpointsName;
        private java.lang.String path;
        private java.lang.Boolean readOnly;

        /**
         * Sets the value of {@link PodSpecVolumeGlusterfs#getEndpointsName}
         * @param endpointsName The endpoint name that details Glusterfs topology. More info: http://releases.k8s.io/HEAD/examples/volumes/glusterfs/README.md#create-a-pod. This parameter is required.
         *                      Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#endpoints_name Pod#endpoints_name}
         * @return {@code this}
         */
        public Builder endpointsName(java.lang.String endpointsName) {
            this.endpointsName = endpointsName;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolumeGlusterfs#getPath}
         * @param path The Glusterfs volume path. More info: http://releases.k8s.io/HEAD/examples/volumes/glusterfs/README.md#create-a-pod. This parameter is required.
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#path Pod#path}
         * @return {@code this}
         */
        public Builder path(java.lang.String path) {
            this.path = path;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolumeGlusterfs#getReadOnly}
         * @param readOnly Whether to force the Glusterfs volume to be mounted with read-only permissions. Defaults to false. More info: http://releases.k8s.io/HEAD/examples/volumes/glusterfs/README.md#create-a-pod.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#read_only Pod#read_only}
         * @return {@code this}
         */
        public Builder readOnly(java.lang.Boolean readOnly) {
            this.readOnly = readOnly;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link PodSpecVolumeGlusterfs}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public PodSpecVolumeGlusterfs build() {
            return new Jsii$Proxy(endpointsName, path, readOnly);
        }
    }

    /**
     * An implementation for {@link PodSpecVolumeGlusterfs}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements PodSpecVolumeGlusterfs {
        private final java.lang.String endpointsName;
        private final java.lang.String path;
        private final java.lang.Boolean readOnly;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.endpointsName = software.amazon.jsii.Kernel.get(this, "endpointsName", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.path = software.amazon.jsii.Kernel.get(this, "path", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.readOnly = software.amazon.jsii.Kernel.get(this, "readOnly", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final java.lang.String endpointsName, final java.lang.String path, final java.lang.Boolean readOnly) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.endpointsName = java.util.Objects.requireNonNull(endpointsName, "endpointsName is required");
            this.path = java.util.Objects.requireNonNull(path, "path is required");
            this.readOnly = readOnly;
        }

        @Override
        public final java.lang.String getEndpointsName() {
            return this.endpointsName;
        }

        @Override
        public final java.lang.String getPath() {
            return this.path;
        }

        @Override
        public final java.lang.Boolean getReadOnly() {
            return this.readOnly;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("endpointsName", om.valueToTree(this.getEndpointsName()));
            data.set("path", om.valueToTree(this.getPath()));
            if (this.getReadOnly() != null) {
                data.set("readOnly", om.valueToTree(this.getReadOnly()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.PodSpecVolumeGlusterfs"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PodSpecVolumeGlusterfs.Jsii$Proxy that = (PodSpecVolumeGlusterfs.Jsii$Proxy) o;

            if (!endpointsName.equals(that.endpointsName)) return false;
            if (!path.equals(that.path)) return false;
            return this.readOnly != null ? this.readOnly.equals(that.readOnly) : that.readOnly == null;
        }

        @Override
        public final int hashCode() {
            int result = this.endpointsName.hashCode();
            result = 31 * result + (this.path.hashCode());
            result = 31 * result + (this.readOnly != null ? this.readOnly.hashCode() : 0);
            return result;
        }
    }
}
