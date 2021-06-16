package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.705Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.PodSecurityPolicySpecSeLinuxSeLinuxOptions")
@software.amazon.jsii.Jsii.Proxy(PodSecurityPolicySpecSeLinuxSeLinuxOptions.Jsii$Proxy.class)
public interface PodSecurityPolicySpecSeLinuxSeLinuxOptions extends software.amazon.jsii.JsiiSerializable {

    /**
     * Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#level PodSecurityPolicy#level}.
     */
    @org.jetbrains.annotations.NotNull java.lang.String getLevel();

    /**
     * Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#role PodSecurityPolicy#role}.
     */
    @org.jetbrains.annotations.NotNull java.lang.String getRole();

    /**
     * Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#type PodSecurityPolicy#type}.
     */
    @org.jetbrains.annotations.NotNull java.lang.String getType();

    /**
     * Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#user PodSecurityPolicy#user}.
     */
    @org.jetbrains.annotations.NotNull java.lang.String getUser();

    /**
     * @return a {@link Builder} of {@link PodSecurityPolicySpecSeLinuxSeLinuxOptions}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link PodSecurityPolicySpecSeLinuxSeLinuxOptions}
     */
    public static final class Builder implements software.amazon.jsii.Builder<PodSecurityPolicySpecSeLinuxSeLinuxOptions> {
        private java.lang.String level;
        private java.lang.String role;
        private java.lang.String type;
        private java.lang.String user;

        /**
         * Sets the value of {@link PodSecurityPolicySpecSeLinuxSeLinuxOptions#getLevel}
         * @param level Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#level PodSecurityPolicy#level}. This parameter is required.
         * @return {@code this}
         */
        public Builder level(java.lang.String level) {
            this.level = level;
            return this;
        }

        /**
         * Sets the value of {@link PodSecurityPolicySpecSeLinuxSeLinuxOptions#getRole}
         * @param role Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#role PodSecurityPolicy#role}. This parameter is required.
         * @return {@code this}
         */
        public Builder role(java.lang.String role) {
            this.role = role;
            return this;
        }

        /**
         * Sets the value of {@link PodSecurityPolicySpecSeLinuxSeLinuxOptions#getType}
         * @param type Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#type PodSecurityPolicy#type}. This parameter is required.
         * @return {@code this}
         */
        public Builder type(java.lang.String type) {
            this.type = type;
            return this;
        }

        /**
         * Sets the value of {@link PodSecurityPolicySpecSeLinuxSeLinuxOptions#getUser}
         * @param user Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#user PodSecurityPolicy#user}. This parameter is required.
         * @return {@code this}
         */
        public Builder user(java.lang.String user) {
            this.user = user;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link PodSecurityPolicySpecSeLinuxSeLinuxOptions}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public PodSecurityPolicySpecSeLinuxSeLinuxOptions build() {
            return new Jsii$Proxy(level, role, type, user);
        }
    }

    /**
     * An implementation for {@link PodSecurityPolicySpecSeLinuxSeLinuxOptions}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements PodSecurityPolicySpecSeLinuxSeLinuxOptions {
        private final java.lang.String level;
        private final java.lang.String role;
        private final java.lang.String type;
        private final java.lang.String user;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.level = software.amazon.jsii.Kernel.get(this, "level", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.role = software.amazon.jsii.Kernel.get(this, "role", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.type = software.amazon.jsii.Kernel.get(this, "type", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.user = software.amazon.jsii.Kernel.get(this, "user", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final java.lang.String level, final java.lang.String role, final java.lang.String type, final java.lang.String user) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.level = java.util.Objects.requireNonNull(level, "level is required");
            this.role = java.util.Objects.requireNonNull(role, "role is required");
            this.type = java.util.Objects.requireNonNull(type, "type is required");
            this.user = java.util.Objects.requireNonNull(user, "user is required");
        }

        @Override
        public final java.lang.String getLevel() {
            return this.level;
        }

        @Override
        public final java.lang.String getRole() {
            return this.role;
        }

        @Override
        public final java.lang.String getType() {
            return this.type;
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

            data.set("level", om.valueToTree(this.getLevel()));
            data.set("role", om.valueToTree(this.getRole()));
            data.set("type", om.valueToTree(this.getType()));
            data.set("user", om.valueToTree(this.getUser()));

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.PodSecurityPolicySpecSeLinuxSeLinuxOptions"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PodSecurityPolicySpecSeLinuxSeLinuxOptions.Jsii$Proxy that = (PodSecurityPolicySpecSeLinuxSeLinuxOptions.Jsii$Proxy) o;

            if (!level.equals(that.level)) return false;
            if (!role.equals(that.role)) return false;
            if (!type.equals(that.type)) return false;
            return this.user.equals(that.user);
        }

        @Override
        public final int hashCode() {
            int result = this.level.hashCode();
            result = 31 * result + (this.role.hashCode());
            result = 31 * result + (this.type.hashCode());
            result = 31 * result + (this.user.hashCode());
            return result;
        }
    }
}
