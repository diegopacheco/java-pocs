package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.457Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.DaemonsetSpecTemplateSpecContainerLifecyclePostStart")
@software.amazon.jsii.Jsii.Proxy(DaemonsetSpecTemplateSpecContainerLifecyclePostStart.Jsii$Proxy.class)
public interface DaemonsetSpecTemplateSpecContainerLifecyclePostStart extends software.amazon.jsii.JsiiSerializable {

    /**
     * exec block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/daemonset.html#exec Daemonset#exec}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.DaemonsetSpecTemplateSpecContainerLifecyclePostStartExec> getExec() {
        return null;
    }

    /**
     * http_get block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/daemonset.html#http_get Daemonset#http_get}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.DaemonsetSpecTemplateSpecContainerLifecyclePostStartHttpGet> getHttpGet() {
        return null;
    }

    /**
     * tcp_socket block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/daemonset.html#tcp_socket Daemonset#tcp_socket}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.DaemonsetSpecTemplateSpecContainerLifecyclePostStartTcpSocket> getTcpSocket() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link DaemonsetSpecTemplateSpecContainerLifecyclePostStart}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link DaemonsetSpecTemplateSpecContainerLifecyclePostStart}
     */
    public static final class Builder implements software.amazon.jsii.Builder<DaemonsetSpecTemplateSpecContainerLifecyclePostStart> {
        private java.util.List<imports.kubernetes.DaemonsetSpecTemplateSpecContainerLifecyclePostStartExec> exec;
        private java.util.List<imports.kubernetes.DaemonsetSpecTemplateSpecContainerLifecyclePostStartHttpGet> httpGet;
        private java.util.List<imports.kubernetes.DaemonsetSpecTemplateSpecContainerLifecyclePostStartTcpSocket> tcpSocket;

        /**
         * Sets the value of {@link DaemonsetSpecTemplateSpecContainerLifecyclePostStart#getExec}
         * @param exec exec block.
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/daemonset.html#exec Daemonset#exec}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder exec(java.util.List<? extends imports.kubernetes.DaemonsetSpecTemplateSpecContainerLifecyclePostStartExec> exec) {
            this.exec = (java.util.List<imports.kubernetes.DaemonsetSpecTemplateSpecContainerLifecyclePostStartExec>)exec;
            return this;
        }

        /**
         * Sets the value of {@link DaemonsetSpecTemplateSpecContainerLifecyclePostStart#getHttpGet}
         * @param httpGet http_get block.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/daemonset.html#http_get Daemonset#http_get}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder httpGet(java.util.List<? extends imports.kubernetes.DaemonsetSpecTemplateSpecContainerLifecyclePostStartHttpGet> httpGet) {
            this.httpGet = (java.util.List<imports.kubernetes.DaemonsetSpecTemplateSpecContainerLifecyclePostStartHttpGet>)httpGet;
            return this;
        }

        /**
         * Sets the value of {@link DaemonsetSpecTemplateSpecContainerLifecyclePostStart#getTcpSocket}
         * @param tcpSocket tcp_socket block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/daemonset.html#tcp_socket Daemonset#tcp_socket}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder tcpSocket(java.util.List<? extends imports.kubernetes.DaemonsetSpecTemplateSpecContainerLifecyclePostStartTcpSocket> tcpSocket) {
            this.tcpSocket = (java.util.List<imports.kubernetes.DaemonsetSpecTemplateSpecContainerLifecyclePostStartTcpSocket>)tcpSocket;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link DaemonsetSpecTemplateSpecContainerLifecyclePostStart}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public DaemonsetSpecTemplateSpecContainerLifecyclePostStart build() {
            return new Jsii$Proxy(exec, httpGet, tcpSocket);
        }
    }

    /**
     * An implementation for {@link DaemonsetSpecTemplateSpecContainerLifecyclePostStart}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements DaemonsetSpecTemplateSpecContainerLifecyclePostStart {
        private final java.util.List<imports.kubernetes.DaemonsetSpecTemplateSpecContainerLifecyclePostStartExec> exec;
        private final java.util.List<imports.kubernetes.DaemonsetSpecTemplateSpecContainerLifecyclePostStartHttpGet> httpGet;
        private final java.util.List<imports.kubernetes.DaemonsetSpecTemplateSpecContainerLifecyclePostStartTcpSocket> tcpSocket;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.exec = software.amazon.jsii.Kernel.get(this, "exec", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DaemonsetSpecTemplateSpecContainerLifecyclePostStartExec.class)));
            this.httpGet = software.amazon.jsii.Kernel.get(this, "httpGet", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DaemonsetSpecTemplateSpecContainerLifecyclePostStartHttpGet.class)));
            this.tcpSocket = software.amazon.jsii.Kernel.get(this, "tcpSocket", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DaemonsetSpecTemplateSpecContainerLifecyclePostStartTcpSocket.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.DaemonsetSpecTemplateSpecContainerLifecyclePostStartExec> exec, final java.util.List<? extends imports.kubernetes.DaemonsetSpecTemplateSpecContainerLifecyclePostStartHttpGet> httpGet, final java.util.List<? extends imports.kubernetes.DaemonsetSpecTemplateSpecContainerLifecyclePostStartTcpSocket> tcpSocket) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.exec = (java.util.List<imports.kubernetes.DaemonsetSpecTemplateSpecContainerLifecyclePostStartExec>)exec;
            this.httpGet = (java.util.List<imports.kubernetes.DaemonsetSpecTemplateSpecContainerLifecyclePostStartHttpGet>)httpGet;
            this.tcpSocket = (java.util.List<imports.kubernetes.DaemonsetSpecTemplateSpecContainerLifecyclePostStartTcpSocket>)tcpSocket;
        }

        @Override
        public final java.util.List<imports.kubernetes.DaemonsetSpecTemplateSpecContainerLifecyclePostStartExec> getExec() {
            return this.exec;
        }

        @Override
        public final java.util.List<imports.kubernetes.DaemonsetSpecTemplateSpecContainerLifecyclePostStartHttpGet> getHttpGet() {
            return this.httpGet;
        }

        @Override
        public final java.util.List<imports.kubernetes.DaemonsetSpecTemplateSpecContainerLifecyclePostStartTcpSocket> getTcpSocket() {
            return this.tcpSocket;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getExec() != null) {
                data.set("exec", om.valueToTree(this.getExec()));
            }
            if (this.getHttpGet() != null) {
                data.set("httpGet", om.valueToTree(this.getHttpGet()));
            }
            if (this.getTcpSocket() != null) {
                data.set("tcpSocket", om.valueToTree(this.getTcpSocket()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.DaemonsetSpecTemplateSpecContainerLifecyclePostStart"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DaemonsetSpecTemplateSpecContainerLifecyclePostStart.Jsii$Proxy that = (DaemonsetSpecTemplateSpecContainerLifecyclePostStart.Jsii$Proxy) o;

            if (this.exec != null ? !this.exec.equals(that.exec) : that.exec != null) return false;
            if (this.httpGet != null ? !this.httpGet.equals(that.httpGet) : that.httpGet != null) return false;
            return this.tcpSocket != null ? this.tcpSocket.equals(that.tcpSocket) : that.tcpSocket == null;
        }

        @Override
        public final int hashCode() {
            int result = this.exec != null ? this.exec.hashCode() : 0;
            result = 31 * result + (this.httpGet != null ? this.httpGet.hashCode() : 0);
            result = 31 * result + (this.tcpSocket != null ? this.tcpSocket.hashCode() : 0);
            return result;
        }
    }
}
