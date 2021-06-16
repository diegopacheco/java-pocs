package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.365Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStop")
@software.amazon.jsii.Jsii.Proxy(CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStop.Jsii$Proxy.class)
public interface CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStop extends software.amazon.jsii.JsiiSerializable {

    /**
     * exec block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#exec CronJob#exec}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStopExec> getExec() {
        return null;
    }

    /**
     * http_get block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#http_get CronJob#http_get}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStopHttpGet> getHttpGet() {
        return null;
    }

    /**
     * tcp_socket block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#tcp_socket CronJob#tcp_socket}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStopTcpSocket> getTcpSocket() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStop}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStop}
     */
    public static final class Builder implements software.amazon.jsii.Builder<CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStop> {
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStopExec> exec;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStopHttpGet> httpGet;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStopTcpSocket> tcpSocket;

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStop#getExec}
         * @param exec exec block.
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#exec CronJob#exec}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder exec(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStopExec> exec) {
            this.exec = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStopExec>)exec;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStop#getHttpGet}
         * @param httpGet http_get block.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#http_get CronJob#http_get}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder httpGet(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStopHttpGet> httpGet) {
            this.httpGet = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStopHttpGet>)httpGet;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStop#getTcpSocket}
         * @param tcpSocket tcp_socket block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#tcp_socket CronJob#tcp_socket}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder tcpSocket(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStopTcpSocket> tcpSocket) {
            this.tcpSocket = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStopTcpSocket>)tcpSocket;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStop}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStop build() {
            return new Jsii$Proxy(exec, httpGet, tcpSocket);
        }
    }

    /**
     * An implementation for {@link CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStop}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStop {
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStopExec> exec;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStopHttpGet> httpGet;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStopTcpSocket> tcpSocket;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.exec = software.amazon.jsii.Kernel.get(this, "exec", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStopExec.class)));
            this.httpGet = software.amazon.jsii.Kernel.get(this, "httpGet", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStopHttpGet.class)));
            this.tcpSocket = software.amazon.jsii.Kernel.get(this, "tcpSocket", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStopTcpSocket.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStopExec> exec, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStopHttpGet> httpGet, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStopTcpSocket> tcpSocket) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.exec = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStopExec>)exec;
            this.httpGet = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStopHttpGet>)httpGet;
            this.tcpSocket = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStopTcpSocket>)tcpSocket;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStopExec> getExec() {
            return this.exec;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStopHttpGet> getHttpGet() {
            return this.httpGet;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStopTcpSocket> getTcpSocket() {
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
            struct.set("fqn", om.valueToTree("kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStop"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStop.Jsii$Proxy that = (CronJobSpecJobTemplateSpecTemplateSpecContainerLifecyclePreStop.Jsii$Proxy) o;

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
