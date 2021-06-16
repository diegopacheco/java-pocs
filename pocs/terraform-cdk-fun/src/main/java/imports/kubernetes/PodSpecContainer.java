package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.719Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.PodSpecContainer")
@software.amazon.jsii.Jsii.Proxy(PodSpecContainer.Jsii$Proxy.class)
public interface PodSpecContainer extends software.amazon.jsii.JsiiSerializable {

    /**
     * Name of the container specified as a DNS_LABEL.
     * <p>
     * Each container in a pod must have a unique name (DNS_LABEL). Cannot be updated.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#name Pod#name}
     */
    @org.jetbrains.annotations.NotNull java.lang.String getName();

    /**
     * Arguments to the entrypoint.
     * <p>
     * The docker image's CMD is used if this is not provided. Variable references $(VAR_NAME) are expanded using the container's environment. If a variable cannot be resolved, the reference in the input string will be unchanged. The $(VAR_NAME) syntax can be escaped with a double $$, ie: $$(VAR_NAME). Escaped references will never be expanded, regardless of whether the variable exists or not. Cannot be updated. More info: http://kubernetes.io/docs/user-guide/containers#containers-and-commands
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#args Pod#args}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<java.lang.String> getArgs() {
        return null;
    }

    /**
     * Entrypoint array.
     * <p>
     * Not executed within a shell. The docker image's ENTRYPOINT is used if this is not provided. Variable references $(VAR_NAME) are expanded using the container's environment. If a variable cannot be resolved, the reference in the input string will be unchanged. The $(VAR_NAME) syntax can be escaped with a double $$, ie: $$(VAR_NAME). Escaped references will never be expanded, regardless of whether the variable exists or not. Cannot be updated. More info: http://kubernetes.io/docs/user-guide/containers#containers-and-commands
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#command Pod#command}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<java.lang.String> getCommand() {
        return null;
    }

    /**
     * env block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#env Pod#env}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecContainerEnv> getEnv() {
        return null;
    }

    /**
     * env_from block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#env_from Pod#env_from}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecContainerEnvFrom> getEnvFrom() {
        return null;
    }

    /**
     * Docker image name. More info: http://kubernetes.io/docs/user-guide/images.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#image Pod#image}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getImage() {
        return null;
    }

    /**
     * Image pull policy.
     * <p>
     * One of Always, Never, IfNotPresent. Defaults to Always if :latest tag is specified, or IfNotPresent otherwise. Cannot be updated. More info: http://kubernetes.io/docs/user-guide/images#updating-images
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#image_pull_policy Pod#image_pull_policy}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getImagePullPolicy() {
        return null;
    }

    /**
     * lifecycle block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#lifecycle Pod#lifecycle}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecContainerLifecycle> getLifecycle() {
        return null;
    }

    /**
     * liveness_probe block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#liveness_probe Pod#liveness_probe}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecContainerLivenessProbe> getLivenessProbe() {
        return null;
    }

    /**
     * port block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#port Pod#port}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecContainerPort> getPort() {
        return null;
    }

    /**
     * readiness_probe block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#readiness_probe Pod#readiness_probe}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecContainerReadinessProbe> getReadinessProbe() {
        return null;
    }

    /**
     * resources block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#resources Pod#resources}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecContainerResources> getResources() {
        return null;
    }

    /**
     * security_context block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#security_context Pod#security_context}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecContainerSecurityContext> getSecurityContext() {
        return null;
    }

    /**
     * startup_probe block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#startup_probe Pod#startup_probe}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecContainerStartupProbe> getStartupProbe() {
        return null;
    }

    /**
     * Whether this container should allocate a buffer for stdin in the container runtime.
     * <p>
     * If this is not set, reads from stdin in the container will always result in EOF.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#stdin Pod#stdin}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Boolean getStdin() {
        return null;
    }

    /**
     * Whether the container runtime should close the stdin channel after it has been opened by a single attach.
     * <p>
     * When stdin is true the stdin stream will remain open across multiple attach sessions. If stdinOnce is set to true, stdin is opened on container start, is empty until the first client attaches to stdin, and then remains open and accepts data until the client disconnects, at which time stdin is closed and remains closed until the container is restarted. If this flag is false, a container processes that reads from stdin will never receive an EOF.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#stdin_once Pod#stdin_once}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Boolean getStdinOnce() {
        return null;
    }

    /**
     * Optional: Path at which the file to which the container's termination message will be written is mounted into the container's filesystem.
     * <p>
     * Message written is intended to be brief final status, such as an assertion failure message. Defaults to /dev/termination-log. Cannot be updated.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#termination_message_path Pod#termination_message_path}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getTerminationMessagePath() {
        return null;
    }

    /**
     * Whether this container should allocate a TTY for itself.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#tty Pod#tty}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Boolean getTty() {
        return null;
    }

    /**
     * volume_mount block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#volume_mount Pod#volume_mount}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecContainerVolumeMount> getVolumeMount() {
        return null;
    }

    /**
     * Container's working directory.
     * <p>
     * If not specified, the container runtime's default will be used, which might be configured in the container image. Cannot be updated.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#working_dir Pod#working_dir}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getWorkingDir() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link PodSpecContainer}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link PodSpecContainer}
     */
    public static final class Builder implements software.amazon.jsii.Builder<PodSpecContainer> {
        private java.lang.String name;
        private java.util.List<java.lang.String> args;
        private java.util.List<java.lang.String> command;
        private java.util.List<imports.kubernetes.PodSpecContainerEnv> env;
        private java.util.List<imports.kubernetes.PodSpecContainerEnvFrom> envFrom;
        private java.lang.String image;
        private java.lang.String imagePullPolicy;
        private java.util.List<imports.kubernetes.PodSpecContainerLifecycle> lifecycle;
        private java.util.List<imports.kubernetes.PodSpecContainerLivenessProbe> livenessProbe;
        private java.util.List<imports.kubernetes.PodSpecContainerPort> port;
        private java.util.List<imports.kubernetes.PodSpecContainerReadinessProbe> readinessProbe;
        private java.util.List<imports.kubernetes.PodSpecContainerResources> resources;
        private java.util.List<imports.kubernetes.PodSpecContainerSecurityContext> securityContext;
        private java.util.List<imports.kubernetes.PodSpecContainerStartupProbe> startupProbe;
        private java.lang.Boolean stdin;
        private java.lang.Boolean stdinOnce;
        private java.lang.String terminationMessagePath;
        private java.lang.Boolean tty;
        private java.util.List<imports.kubernetes.PodSpecContainerVolumeMount> volumeMount;
        private java.lang.String workingDir;

        /**
         * Sets the value of {@link PodSpecContainer#getName}
         * @param name Name of the container specified as a DNS_LABEL. This parameter is required.
         *             Each container in a pod must have a unique name (DNS_LABEL). Cannot be updated.
         *             <p>
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#name Pod#name}
         * @return {@code this}
         */
        public Builder name(java.lang.String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecContainer#getArgs}
         * @param args Arguments to the entrypoint.
         *             The docker image's CMD is used if this is not provided. Variable references $(VAR_NAME) are expanded using the container's environment. If a variable cannot be resolved, the reference in the input string will be unchanged. The $(VAR_NAME) syntax can be escaped with a double $$, ie: $$(VAR_NAME). Escaped references will never be expanded, regardless of whether the variable exists or not. Cannot be updated. More info: http://kubernetes.io/docs/user-guide/containers#containers-and-commands
         *             <p>
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#args Pod#args}
         * @return {@code this}
         */
        public Builder args(java.util.List<java.lang.String> args) {
            this.args = args;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecContainer#getCommand}
         * @param command Entrypoint array.
         *                Not executed within a shell. The docker image's ENTRYPOINT is used if this is not provided. Variable references $(VAR_NAME) are expanded using the container's environment. If a variable cannot be resolved, the reference in the input string will be unchanged. The $(VAR_NAME) syntax can be escaped with a double $$, ie: $$(VAR_NAME). Escaped references will never be expanded, regardless of whether the variable exists or not. Cannot be updated. More info: http://kubernetes.io/docs/user-guide/containers#containers-and-commands
         *                <p>
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#command Pod#command}
         * @return {@code this}
         */
        public Builder command(java.util.List<java.lang.String> command) {
            this.command = command;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecContainer#getEnv}
         * @param env env block.
         *            Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#env Pod#env}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder env(java.util.List<? extends imports.kubernetes.PodSpecContainerEnv> env) {
            this.env = (java.util.List<imports.kubernetes.PodSpecContainerEnv>)env;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecContainer#getEnvFrom}
         * @param envFrom env_from block.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#env_from Pod#env_from}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder envFrom(java.util.List<? extends imports.kubernetes.PodSpecContainerEnvFrom> envFrom) {
            this.envFrom = (java.util.List<imports.kubernetes.PodSpecContainerEnvFrom>)envFrom;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecContainer#getImage}
         * @param image Docker image name. More info: http://kubernetes.io/docs/user-guide/images.
         *              Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#image Pod#image}
         * @return {@code this}
         */
        public Builder image(java.lang.String image) {
            this.image = image;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecContainer#getImagePullPolicy}
         * @param imagePullPolicy Image pull policy.
         *                        One of Always, Never, IfNotPresent. Defaults to Always if :latest tag is specified, or IfNotPresent otherwise. Cannot be updated. More info: http://kubernetes.io/docs/user-guide/images#updating-images
         *                        <p>
         *                        Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#image_pull_policy Pod#image_pull_policy}
         * @return {@code this}
         */
        public Builder imagePullPolicy(java.lang.String imagePullPolicy) {
            this.imagePullPolicy = imagePullPolicy;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecContainer#getLifecycle}
         * @param lifecycle lifecycle block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#lifecycle Pod#lifecycle}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder lifecycle(java.util.List<? extends imports.kubernetes.PodSpecContainerLifecycle> lifecycle) {
            this.lifecycle = (java.util.List<imports.kubernetes.PodSpecContainerLifecycle>)lifecycle;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecContainer#getLivenessProbe}
         * @param livenessProbe liveness_probe block.
         *                      Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#liveness_probe Pod#liveness_probe}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder livenessProbe(java.util.List<? extends imports.kubernetes.PodSpecContainerLivenessProbe> livenessProbe) {
            this.livenessProbe = (java.util.List<imports.kubernetes.PodSpecContainerLivenessProbe>)livenessProbe;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecContainer#getPort}
         * @param port port block.
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#port Pod#port}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder port(java.util.List<? extends imports.kubernetes.PodSpecContainerPort> port) {
            this.port = (java.util.List<imports.kubernetes.PodSpecContainerPort>)port;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecContainer#getReadinessProbe}
         * @param readinessProbe readiness_probe block.
         *                       Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#readiness_probe Pod#readiness_probe}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder readinessProbe(java.util.List<? extends imports.kubernetes.PodSpecContainerReadinessProbe> readinessProbe) {
            this.readinessProbe = (java.util.List<imports.kubernetes.PodSpecContainerReadinessProbe>)readinessProbe;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecContainer#getResources}
         * @param resources resources block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#resources Pod#resources}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder resources(java.util.List<? extends imports.kubernetes.PodSpecContainerResources> resources) {
            this.resources = (java.util.List<imports.kubernetes.PodSpecContainerResources>)resources;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecContainer#getSecurityContext}
         * @param securityContext security_context block.
         *                        Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#security_context Pod#security_context}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder securityContext(java.util.List<? extends imports.kubernetes.PodSpecContainerSecurityContext> securityContext) {
            this.securityContext = (java.util.List<imports.kubernetes.PodSpecContainerSecurityContext>)securityContext;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecContainer#getStartupProbe}
         * @param startupProbe startup_probe block.
         *                     Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#startup_probe Pod#startup_probe}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder startupProbe(java.util.List<? extends imports.kubernetes.PodSpecContainerStartupProbe> startupProbe) {
            this.startupProbe = (java.util.List<imports.kubernetes.PodSpecContainerStartupProbe>)startupProbe;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecContainer#getStdin}
         * @param stdin Whether this container should allocate a buffer for stdin in the container runtime.
         *              If this is not set, reads from stdin in the container will always result in EOF.
         *              <p>
         *              Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#stdin Pod#stdin}
         * @return {@code this}
         */
        public Builder stdin(java.lang.Boolean stdin) {
            this.stdin = stdin;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecContainer#getStdinOnce}
         * @param stdinOnce Whether the container runtime should close the stdin channel after it has been opened by a single attach.
         *                  When stdin is true the stdin stream will remain open across multiple attach sessions. If stdinOnce is set to true, stdin is opened on container start, is empty until the first client attaches to stdin, and then remains open and accepts data until the client disconnects, at which time stdin is closed and remains closed until the container is restarted. If this flag is false, a container processes that reads from stdin will never receive an EOF.
         *                  <p>
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#stdin_once Pod#stdin_once}
         * @return {@code this}
         */
        public Builder stdinOnce(java.lang.Boolean stdinOnce) {
            this.stdinOnce = stdinOnce;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecContainer#getTerminationMessagePath}
         * @param terminationMessagePath Optional: Path at which the file to which the container's termination message will be written is mounted into the container's filesystem.
         *                               Message written is intended to be brief final status, such as an assertion failure message. Defaults to /dev/termination-log. Cannot be updated.
         *                               <p>
         *                               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#termination_message_path Pod#termination_message_path}
         * @return {@code this}
         */
        public Builder terminationMessagePath(java.lang.String terminationMessagePath) {
            this.terminationMessagePath = terminationMessagePath;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecContainer#getTty}
         * @param tty Whether this container should allocate a TTY for itself.
         *            Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#tty Pod#tty}
         * @return {@code this}
         */
        public Builder tty(java.lang.Boolean tty) {
            this.tty = tty;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecContainer#getVolumeMount}
         * @param volumeMount volume_mount block.
         *                    Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#volume_mount Pod#volume_mount}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder volumeMount(java.util.List<? extends imports.kubernetes.PodSpecContainerVolumeMount> volumeMount) {
            this.volumeMount = (java.util.List<imports.kubernetes.PodSpecContainerVolumeMount>)volumeMount;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecContainer#getWorkingDir}
         * @param workingDir Container's working directory.
         *                   If not specified, the container runtime's default will be used, which might be configured in the container image. Cannot be updated.
         *                   <p>
         *                   Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#working_dir Pod#working_dir}
         * @return {@code this}
         */
        public Builder workingDir(java.lang.String workingDir) {
            this.workingDir = workingDir;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link PodSpecContainer}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public PodSpecContainer build() {
            return new Jsii$Proxy(name, args, command, env, envFrom, image, imagePullPolicy, lifecycle, livenessProbe, port, readinessProbe, resources, securityContext, startupProbe, stdin, stdinOnce, terminationMessagePath, tty, volumeMount, workingDir);
        }
    }

    /**
     * An implementation for {@link PodSpecContainer}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements PodSpecContainer {
        private final java.lang.String name;
        private final java.util.List<java.lang.String> args;
        private final java.util.List<java.lang.String> command;
        private final java.util.List<imports.kubernetes.PodSpecContainerEnv> env;
        private final java.util.List<imports.kubernetes.PodSpecContainerEnvFrom> envFrom;
        private final java.lang.String image;
        private final java.lang.String imagePullPolicy;
        private final java.util.List<imports.kubernetes.PodSpecContainerLifecycle> lifecycle;
        private final java.util.List<imports.kubernetes.PodSpecContainerLivenessProbe> livenessProbe;
        private final java.util.List<imports.kubernetes.PodSpecContainerPort> port;
        private final java.util.List<imports.kubernetes.PodSpecContainerReadinessProbe> readinessProbe;
        private final java.util.List<imports.kubernetes.PodSpecContainerResources> resources;
        private final java.util.List<imports.kubernetes.PodSpecContainerSecurityContext> securityContext;
        private final java.util.List<imports.kubernetes.PodSpecContainerStartupProbe> startupProbe;
        private final java.lang.Boolean stdin;
        private final java.lang.Boolean stdinOnce;
        private final java.lang.String terminationMessagePath;
        private final java.lang.Boolean tty;
        private final java.util.List<imports.kubernetes.PodSpecContainerVolumeMount> volumeMount;
        private final java.lang.String workingDir;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.name = software.amazon.jsii.Kernel.get(this, "name", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.args = software.amazon.jsii.Kernel.get(this, "args", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.command = software.amazon.jsii.Kernel.get(this, "command", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.env = software.amazon.jsii.Kernel.get(this, "env", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecContainerEnv.class)));
            this.envFrom = software.amazon.jsii.Kernel.get(this, "envFrom", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecContainerEnvFrom.class)));
            this.image = software.amazon.jsii.Kernel.get(this, "image", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.imagePullPolicy = software.amazon.jsii.Kernel.get(this, "imagePullPolicy", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.lifecycle = software.amazon.jsii.Kernel.get(this, "lifecycle", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecContainerLifecycle.class)));
            this.livenessProbe = software.amazon.jsii.Kernel.get(this, "livenessProbe", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecContainerLivenessProbe.class)));
            this.port = software.amazon.jsii.Kernel.get(this, "port", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecContainerPort.class)));
            this.readinessProbe = software.amazon.jsii.Kernel.get(this, "readinessProbe", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecContainerReadinessProbe.class)));
            this.resources = software.amazon.jsii.Kernel.get(this, "resources", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecContainerResources.class)));
            this.securityContext = software.amazon.jsii.Kernel.get(this, "securityContext", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecContainerSecurityContext.class)));
            this.startupProbe = software.amazon.jsii.Kernel.get(this, "startupProbe", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecContainerStartupProbe.class)));
            this.stdin = software.amazon.jsii.Kernel.get(this, "stdin", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
            this.stdinOnce = software.amazon.jsii.Kernel.get(this, "stdinOnce", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
            this.terminationMessagePath = software.amazon.jsii.Kernel.get(this, "terminationMessagePath", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.tty = software.amazon.jsii.Kernel.get(this, "tty", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
            this.volumeMount = software.amazon.jsii.Kernel.get(this, "volumeMount", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecContainerVolumeMount.class)));
            this.workingDir = software.amazon.jsii.Kernel.get(this, "workingDir", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.lang.String name, final java.util.List<java.lang.String> args, final java.util.List<java.lang.String> command, final java.util.List<? extends imports.kubernetes.PodSpecContainerEnv> env, final java.util.List<? extends imports.kubernetes.PodSpecContainerEnvFrom> envFrom, final java.lang.String image, final java.lang.String imagePullPolicy, final java.util.List<? extends imports.kubernetes.PodSpecContainerLifecycle> lifecycle, final java.util.List<? extends imports.kubernetes.PodSpecContainerLivenessProbe> livenessProbe, final java.util.List<? extends imports.kubernetes.PodSpecContainerPort> port, final java.util.List<? extends imports.kubernetes.PodSpecContainerReadinessProbe> readinessProbe, final java.util.List<? extends imports.kubernetes.PodSpecContainerResources> resources, final java.util.List<? extends imports.kubernetes.PodSpecContainerSecurityContext> securityContext, final java.util.List<? extends imports.kubernetes.PodSpecContainerStartupProbe> startupProbe, final java.lang.Boolean stdin, final java.lang.Boolean stdinOnce, final java.lang.String terminationMessagePath, final java.lang.Boolean tty, final java.util.List<? extends imports.kubernetes.PodSpecContainerVolumeMount> volumeMount, final java.lang.String workingDir) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.name = java.util.Objects.requireNonNull(name, "name is required");
            this.args = args;
            this.command = command;
            this.env = (java.util.List<imports.kubernetes.PodSpecContainerEnv>)env;
            this.envFrom = (java.util.List<imports.kubernetes.PodSpecContainerEnvFrom>)envFrom;
            this.image = image;
            this.imagePullPolicy = imagePullPolicy;
            this.lifecycle = (java.util.List<imports.kubernetes.PodSpecContainerLifecycle>)lifecycle;
            this.livenessProbe = (java.util.List<imports.kubernetes.PodSpecContainerLivenessProbe>)livenessProbe;
            this.port = (java.util.List<imports.kubernetes.PodSpecContainerPort>)port;
            this.readinessProbe = (java.util.List<imports.kubernetes.PodSpecContainerReadinessProbe>)readinessProbe;
            this.resources = (java.util.List<imports.kubernetes.PodSpecContainerResources>)resources;
            this.securityContext = (java.util.List<imports.kubernetes.PodSpecContainerSecurityContext>)securityContext;
            this.startupProbe = (java.util.List<imports.kubernetes.PodSpecContainerStartupProbe>)startupProbe;
            this.stdin = stdin;
            this.stdinOnce = stdinOnce;
            this.terminationMessagePath = terminationMessagePath;
            this.tty = tty;
            this.volumeMount = (java.util.List<imports.kubernetes.PodSpecContainerVolumeMount>)volumeMount;
            this.workingDir = workingDir;
        }

        @Override
        public final java.lang.String getName() {
            return this.name;
        }

        @Override
        public final java.util.List<java.lang.String> getArgs() {
            return this.args;
        }

        @Override
        public final java.util.List<java.lang.String> getCommand() {
            return this.command;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecContainerEnv> getEnv() {
            return this.env;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecContainerEnvFrom> getEnvFrom() {
            return this.envFrom;
        }

        @Override
        public final java.lang.String getImage() {
            return this.image;
        }

        @Override
        public final java.lang.String getImagePullPolicy() {
            return this.imagePullPolicy;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecContainerLifecycle> getLifecycle() {
            return this.lifecycle;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecContainerLivenessProbe> getLivenessProbe() {
            return this.livenessProbe;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecContainerPort> getPort() {
            return this.port;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecContainerReadinessProbe> getReadinessProbe() {
            return this.readinessProbe;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecContainerResources> getResources() {
            return this.resources;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecContainerSecurityContext> getSecurityContext() {
            return this.securityContext;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecContainerStartupProbe> getStartupProbe() {
            return this.startupProbe;
        }

        @Override
        public final java.lang.Boolean getStdin() {
            return this.stdin;
        }

        @Override
        public final java.lang.Boolean getStdinOnce() {
            return this.stdinOnce;
        }

        @Override
        public final java.lang.String getTerminationMessagePath() {
            return this.terminationMessagePath;
        }

        @Override
        public final java.lang.Boolean getTty() {
            return this.tty;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecContainerVolumeMount> getVolumeMount() {
            return this.volumeMount;
        }

        @Override
        public final java.lang.String getWorkingDir() {
            return this.workingDir;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("name", om.valueToTree(this.getName()));
            if (this.getArgs() != null) {
                data.set("args", om.valueToTree(this.getArgs()));
            }
            if (this.getCommand() != null) {
                data.set("command", om.valueToTree(this.getCommand()));
            }
            if (this.getEnv() != null) {
                data.set("env", om.valueToTree(this.getEnv()));
            }
            if (this.getEnvFrom() != null) {
                data.set("envFrom", om.valueToTree(this.getEnvFrom()));
            }
            if (this.getImage() != null) {
                data.set("image", om.valueToTree(this.getImage()));
            }
            if (this.getImagePullPolicy() != null) {
                data.set("imagePullPolicy", om.valueToTree(this.getImagePullPolicy()));
            }
            if (this.getLifecycle() != null) {
                data.set("lifecycle", om.valueToTree(this.getLifecycle()));
            }
            if (this.getLivenessProbe() != null) {
                data.set("livenessProbe", om.valueToTree(this.getLivenessProbe()));
            }
            if (this.getPort() != null) {
                data.set("port", om.valueToTree(this.getPort()));
            }
            if (this.getReadinessProbe() != null) {
                data.set("readinessProbe", om.valueToTree(this.getReadinessProbe()));
            }
            if (this.getResources() != null) {
                data.set("resources", om.valueToTree(this.getResources()));
            }
            if (this.getSecurityContext() != null) {
                data.set("securityContext", om.valueToTree(this.getSecurityContext()));
            }
            if (this.getStartupProbe() != null) {
                data.set("startupProbe", om.valueToTree(this.getStartupProbe()));
            }
            if (this.getStdin() != null) {
                data.set("stdin", om.valueToTree(this.getStdin()));
            }
            if (this.getStdinOnce() != null) {
                data.set("stdinOnce", om.valueToTree(this.getStdinOnce()));
            }
            if (this.getTerminationMessagePath() != null) {
                data.set("terminationMessagePath", om.valueToTree(this.getTerminationMessagePath()));
            }
            if (this.getTty() != null) {
                data.set("tty", om.valueToTree(this.getTty()));
            }
            if (this.getVolumeMount() != null) {
                data.set("volumeMount", om.valueToTree(this.getVolumeMount()));
            }
            if (this.getWorkingDir() != null) {
                data.set("workingDir", om.valueToTree(this.getWorkingDir()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.PodSpecContainer"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PodSpecContainer.Jsii$Proxy that = (PodSpecContainer.Jsii$Proxy) o;

            if (!name.equals(that.name)) return false;
            if (this.args != null ? !this.args.equals(that.args) : that.args != null) return false;
            if (this.command != null ? !this.command.equals(that.command) : that.command != null) return false;
            if (this.env != null ? !this.env.equals(that.env) : that.env != null) return false;
            if (this.envFrom != null ? !this.envFrom.equals(that.envFrom) : that.envFrom != null) return false;
            if (this.image != null ? !this.image.equals(that.image) : that.image != null) return false;
            if (this.imagePullPolicy != null ? !this.imagePullPolicy.equals(that.imagePullPolicy) : that.imagePullPolicy != null) return false;
            if (this.lifecycle != null ? !this.lifecycle.equals(that.lifecycle) : that.lifecycle != null) return false;
            if (this.livenessProbe != null ? !this.livenessProbe.equals(that.livenessProbe) : that.livenessProbe != null) return false;
            if (this.port != null ? !this.port.equals(that.port) : that.port != null) return false;
            if (this.readinessProbe != null ? !this.readinessProbe.equals(that.readinessProbe) : that.readinessProbe != null) return false;
            if (this.resources != null ? !this.resources.equals(that.resources) : that.resources != null) return false;
            if (this.securityContext != null ? !this.securityContext.equals(that.securityContext) : that.securityContext != null) return false;
            if (this.startupProbe != null ? !this.startupProbe.equals(that.startupProbe) : that.startupProbe != null) return false;
            if (this.stdin != null ? !this.stdin.equals(that.stdin) : that.stdin != null) return false;
            if (this.stdinOnce != null ? !this.stdinOnce.equals(that.stdinOnce) : that.stdinOnce != null) return false;
            if (this.terminationMessagePath != null ? !this.terminationMessagePath.equals(that.terminationMessagePath) : that.terminationMessagePath != null) return false;
            if (this.tty != null ? !this.tty.equals(that.tty) : that.tty != null) return false;
            if (this.volumeMount != null ? !this.volumeMount.equals(that.volumeMount) : that.volumeMount != null) return false;
            return this.workingDir != null ? this.workingDir.equals(that.workingDir) : that.workingDir == null;
        }

        @Override
        public final int hashCode() {
            int result = this.name.hashCode();
            result = 31 * result + (this.args != null ? this.args.hashCode() : 0);
            result = 31 * result + (this.command != null ? this.command.hashCode() : 0);
            result = 31 * result + (this.env != null ? this.env.hashCode() : 0);
            result = 31 * result + (this.envFrom != null ? this.envFrom.hashCode() : 0);
            result = 31 * result + (this.image != null ? this.image.hashCode() : 0);
            result = 31 * result + (this.imagePullPolicy != null ? this.imagePullPolicy.hashCode() : 0);
            result = 31 * result + (this.lifecycle != null ? this.lifecycle.hashCode() : 0);
            result = 31 * result + (this.livenessProbe != null ? this.livenessProbe.hashCode() : 0);
            result = 31 * result + (this.port != null ? this.port.hashCode() : 0);
            result = 31 * result + (this.readinessProbe != null ? this.readinessProbe.hashCode() : 0);
            result = 31 * result + (this.resources != null ? this.resources.hashCode() : 0);
            result = 31 * result + (this.securityContext != null ? this.securityContext.hashCode() : 0);
            result = 31 * result + (this.startupProbe != null ? this.startupProbe.hashCode() : 0);
            result = 31 * result + (this.stdin != null ? this.stdin.hashCode() : 0);
            result = 31 * result + (this.stdinOnce != null ? this.stdinOnce.hashCode() : 0);
            result = 31 * result + (this.terminationMessagePath != null ? this.terminationMessagePath.hashCode() : 0);
            result = 31 * result + (this.tty != null ? this.tty.hashCode() : 0);
            result = 31 * result + (this.volumeMount != null ? this.volumeMount.hashCode() : 0);
            result = 31 * result + (this.workingDir != null ? this.workingDir.hashCode() : 0);
            return result;
        }
    }
}
