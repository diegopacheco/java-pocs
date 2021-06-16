package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.744Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.PodSpecInitContainerStartupProbeExec")
@software.amazon.jsii.Jsii.Proxy(PodSpecInitContainerStartupProbeExec.Jsii$Proxy.class)
public interface PodSpecInitContainerStartupProbeExec extends software.amazon.jsii.JsiiSerializable {

    /**
     * Command is the command line to execute inside the container, the working directory for the command is root ('/') in the container's filesystem.
     * <p>
     * The command is simply exec'd, it is not run inside a shell, so traditional shell instructions. To use a shell, you need to explicitly call out to that shell. Exit status of 0 is treated as live/healthy and non-zero is unhealthy.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#command Pod#command}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<java.lang.String> getCommand() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link PodSpecInitContainerStartupProbeExec}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link PodSpecInitContainerStartupProbeExec}
     */
    public static final class Builder implements software.amazon.jsii.Builder<PodSpecInitContainerStartupProbeExec> {
        private java.util.List<java.lang.String> command;

        /**
         * Sets the value of {@link PodSpecInitContainerStartupProbeExec#getCommand}
         * @param command Command is the command line to execute inside the container, the working directory for the command is root ('/') in the container's filesystem.
         *                The command is simply exec'd, it is not run inside a shell, so traditional shell instructions. To use a shell, you need to explicitly call out to that shell. Exit status of 0 is treated as live/healthy and non-zero is unhealthy.
         *                <p>
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#command Pod#command}
         * @return {@code this}
         */
        public Builder command(java.util.List<java.lang.String> command) {
            this.command = command;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link PodSpecInitContainerStartupProbeExec}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public PodSpecInitContainerStartupProbeExec build() {
            return new Jsii$Proxy(command);
        }
    }

    /**
     * An implementation for {@link PodSpecInitContainerStartupProbeExec}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements PodSpecInitContainerStartupProbeExec {
        private final java.util.List<java.lang.String> command;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.command = software.amazon.jsii.Kernel.get(this, "command", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final java.util.List<java.lang.String> command) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.command = command;
        }

        @Override
        public final java.util.List<java.lang.String> getCommand() {
            return this.command;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getCommand() != null) {
                data.set("command", om.valueToTree(this.getCommand()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.PodSpecInitContainerStartupProbeExec"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PodSpecInitContainerStartupProbeExec.Jsii$Proxy that = (PodSpecInitContainerStartupProbeExec.Jsii$Proxy) o;

            return this.command != null ? this.command.equals(that.command) : that.command == null;
        }

        @Override
        public final int hashCode() {
            int result = this.command != null ? this.command.hashCode() : 0;
            return result;
        }
    }
}
