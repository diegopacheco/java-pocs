package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.856Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.ReplicationControllerSpecTemplateSpecVolumeEmptyDir")
@software.amazon.jsii.Jsii.Proxy(ReplicationControllerSpecTemplateSpecVolumeEmptyDir.Jsii$Proxy.class)
public interface ReplicationControllerSpecTemplateSpecVolumeEmptyDir extends software.amazon.jsii.JsiiSerializable {

    /**
     * What type of storage medium should back this directory.
     * <p>
     * The default is "" which means to use the node's default medium. Must be an empty string (default) or Memory. More info: http://kubernetes.io/docs/user-guide/volumes#emptydir
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#medium ReplicationController#medium}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getMedium() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link ReplicationControllerSpecTemplateSpecVolumeEmptyDir}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link ReplicationControllerSpecTemplateSpecVolumeEmptyDir}
     */
    public static final class Builder implements software.amazon.jsii.Builder<ReplicationControllerSpecTemplateSpecVolumeEmptyDir> {
        private java.lang.String medium;

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateSpecVolumeEmptyDir#getMedium}
         * @param medium What type of storage medium should back this directory.
         *               The default is "" which means to use the node's default medium. Must be an empty string (default) or Memory. More info: http://kubernetes.io/docs/user-guide/volumes#emptydir
         *               <p>
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#medium ReplicationController#medium}
         * @return {@code this}
         */
        public Builder medium(java.lang.String medium) {
            this.medium = medium;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link ReplicationControllerSpecTemplateSpecVolumeEmptyDir}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public ReplicationControllerSpecTemplateSpecVolumeEmptyDir build() {
            return new Jsii$Proxy(medium);
        }
    }

    /**
     * An implementation for {@link ReplicationControllerSpecTemplateSpecVolumeEmptyDir}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements ReplicationControllerSpecTemplateSpecVolumeEmptyDir {
        private final java.lang.String medium;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.medium = software.amazon.jsii.Kernel.get(this, "medium", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final java.lang.String medium) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.medium = medium;
        }

        @Override
        public final java.lang.String getMedium() {
            return this.medium;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getMedium() != null) {
                data.set("medium", om.valueToTree(this.getMedium()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.ReplicationControllerSpecTemplateSpecVolumeEmptyDir"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ReplicationControllerSpecTemplateSpecVolumeEmptyDir.Jsii$Proxy that = (ReplicationControllerSpecTemplateSpecVolumeEmptyDir.Jsii$Proxy) o;

            return this.medium != null ? this.medium.equals(that.medium) : that.medium == null;
        }

        @Override
        public final int hashCode() {
            int result = this.medium != null ? this.medium.hashCode() : 0;
            return result;
        }
    }
}
