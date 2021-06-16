package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.703Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.PodSecurityPolicySpecAllowedFlexVolumes")
@software.amazon.jsii.Jsii.Proxy(PodSecurityPolicySpecAllowedFlexVolumes.Jsii$Proxy.class)
public interface PodSecurityPolicySpecAllowedFlexVolumes extends software.amazon.jsii.JsiiSerializable {

    /**
     * driver is the name of the Flexvolume driver.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#driver PodSecurityPolicy#driver}
     */
    @org.jetbrains.annotations.NotNull java.lang.String getDriver();

    /**
     * @return a {@link Builder} of {@link PodSecurityPolicySpecAllowedFlexVolumes}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link PodSecurityPolicySpecAllowedFlexVolumes}
     */
    public static final class Builder implements software.amazon.jsii.Builder<PodSecurityPolicySpecAllowedFlexVolumes> {
        private java.lang.String driver;

        /**
         * Sets the value of {@link PodSecurityPolicySpecAllowedFlexVolumes#getDriver}
         * @param driver driver is the name of the Flexvolume driver. This parameter is required.
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#driver PodSecurityPolicy#driver}
         * @return {@code this}
         */
        public Builder driver(java.lang.String driver) {
            this.driver = driver;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link PodSecurityPolicySpecAllowedFlexVolumes}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public PodSecurityPolicySpecAllowedFlexVolumes build() {
            return new Jsii$Proxy(driver);
        }
    }

    /**
     * An implementation for {@link PodSecurityPolicySpecAllowedFlexVolumes}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements PodSecurityPolicySpecAllowedFlexVolumes {
        private final java.lang.String driver;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.driver = software.amazon.jsii.Kernel.get(this, "driver", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final java.lang.String driver) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.driver = java.util.Objects.requireNonNull(driver, "driver is required");
        }

        @Override
        public final java.lang.String getDriver() {
            return this.driver;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("driver", om.valueToTree(this.getDriver()));

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.PodSecurityPolicySpecAllowedFlexVolumes"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PodSecurityPolicySpecAllowedFlexVolumes.Jsii$Proxy that = (PodSecurityPolicySpecAllowedFlexVolumes.Jsii$Proxy) o;

            return this.driver.equals(that.driver);
        }

        @Override
        public final int hashCode() {
            int result = this.driver.hashCode();
            return result;
        }
    }
}
