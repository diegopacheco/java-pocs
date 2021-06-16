package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.578Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.DeploymentSpecTemplateSpecVolume")
@software.amazon.jsii.Jsii.Proxy(DeploymentSpecTemplateSpecVolume.Jsii$Proxy.class)
public interface DeploymentSpecTemplateSpecVolume extends software.amazon.jsii.JsiiSerializable {

    /**
     * aws_elastic_block_store block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#aws_elastic_block_store Deployment#aws_elastic_block_store}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeAwsElasticBlockStore> getAwsElasticBlockStore() {
        return null;
    }

    /**
     * azure_disk block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#azure_disk Deployment#azure_disk}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeAzureDisk> getAzureDisk() {
        return null;
    }

    /**
     * azure_file block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#azure_file Deployment#azure_file}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeAzureFile> getAzureFile() {
        return null;
    }

    /**
     * ceph_fs block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#ceph_fs Deployment#ceph_fs}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeCephFs> getCephFs() {
        return null;
    }

    /**
     * cinder block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#cinder Deployment#cinder}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeCinder> getCinder() {
        return null;
    }

    /**
     * config_map block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#config_map Deployment#config_map}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeConfigMap> getConfigMap() {
        return null;
    }

    /**
     * csi block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#csi Deployment#csi}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeCsi> getCsi() {
        return null;
    }

    /**
     * downward_api block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#downward_api Deployment#downward_api}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeDownwardApi> getDownwardApi() {
        return null;
    }

    /**
     * empty_dir block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#empty_dir Deployment#empty_dir}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeEmptyDir> getEmptyDir() {
        return null;
    }

    /**
     * fc block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#fc Deployment#fc}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeFc> getFc() {
        return null;
    }

    /**
     * flex_volume block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#flex_volume Deployment#flex_volume}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeFlexVolume> getFlexVolume() {
        return null;
    }

    /**
     * flocker block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#flocker Deployment#flocker}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeFlocker> getFlocker() {
        return null;
    }

    /**
     * gce_persistent_disk block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#gce_persistent_disk Deployment#gce_persistent_disk}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeGcePersistentDisk> getGcePersistentDisk() {
        return null;
    }

    /**
     * git_repo block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#git_repo Deployment#git_repo}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeGitRepo> getGitRepo() {
        return null;
    }

    /**
     * glusterfs block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#glusterfs Deployment#glusterfs}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeGlusterfs> getGlusterfs() {
        return null;
    }

    /**
     * host_path block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#host_path Deployment#host_path}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeHostPath> getHostPath() {
        return null;
    }

    /**
     * iscsi block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#iscsi Deployment#iscsi}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeIscsi> getIscsi() {
        return null;
    }

    /**
     * local block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#local Deployment#local}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeLocal> getLocal() {
        return null;
    }

    /**
     * Volume's name. Must be a DNS_LABEL and unique within the pod. More info: http://kubernetes.io/docs/user-guide/identifiers#names.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#name Deployment#name}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getName() {
        return null;
    }

    /**
     * nfs block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#nfs Deployment#nfs}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeNfs> getNfs() {
        return null;
    }

    /**
     * persistent_volume_claim block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#persistent_volume_claim Deployment#persistent_volume_claim}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumePersistentVolumeClaim> getPersistentVolumeClaim() {
        return null;
    }

    /**
     * photon_persistent_disk block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#photon_persistent_disk Deployment#photon_persistent_disk}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumePhotonPersistentDisk> getPhotonPersistentDisk() {
        return null;
    }

    /**
     * quobyte block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#quobyte Deployment#quobyte}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeQuobyte> getQuobyte() {
        return null;
    }

    /**
     * rbd block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#rbd Deployment#rbd}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeRbd> getRbd() {
        return null;
    }

    /**
     * secret block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#secret Deployment#secret}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeSecret> getSecret() {
        return null;
    }

    /**
     * vsphere_volume block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#vsphere_volume Deployment#vsphere_volume}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeVsphereVolume> getVsphereVolume() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link DeploymentSpecTemplateSpecVolume}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link DeploymentSpecTemplateSpecVolume}
     */
    public static final class Builder implements software.amazon.jsii.Builder<DeploymentSpecTemplateSpecVolume> {
        private java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeAwsElasticBlockStore> awsElasticBlockStore;
        private java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeAzureDisk> azureDisk;
        private java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeAzureFile> azureFile;
        private java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeCephFs> cephFs;
        private java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeCinder> cinder;
        private java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeConfigMap> configMap;
        private java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeCsi> csi;
        private java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeDownwardApi> downwardApi;
        private java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeEmptyDir> emptyDir;
        private java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeFc> fc;
        private java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeFlexVolume> flexVolume;
        private java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeFlocker> flocker;
        private java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeGcePersistentDisk> gcePersistentDisk;
        private java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeGitRepo> gitRepo;
        private java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeGlusterfs> glusterfs;
        private java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeHostPath> hostPath;
        private java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeIscsi> iscsi;
        private java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeLocal> local;
        private java.lang.String name;
        private java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeNfs> nfs;
        private java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumePersistentVolumeClaim> persistentVolumeClaim;
        private java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumePhotonPersistentDisk> photonPersistentDisk;
        private java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeQuobyte> quobyte;
        private java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeRbd> rbd;
        private java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeSecret> secret;
        private java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeVsphereVolume> vsphereVolume;

        /**
         * Sets the value of {@link DeploymentSpecTemplateSpecVolume#getAwsElasticBlockStore}
         * @param awsElasticBlockStore aws_elastic_block_store block.
         *                             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#aws_elastic_block_store Deployment#aws_elastic_block_store}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder awsElasticBlockStore(java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeAwsElasticBlockStore> awsElasticBlockStore) {
            this.awsElasticBlockStore = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeAwsElasticBlockStore>)awsElasticBlockStore;
            return this;
        }

        /**
         * Sets the value of {@link DeploymentSpecTemplateSpecVolume#getAzureDisk}
         * @param azureDisk azure_disk block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#azure_disk Deployment#azure_disk}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder azureDisk(java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeAzureDisk> azureDisk) {
            this.azureDisk = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeAzureDisk>)azureDisk;
            return this;
        }

        /**
         * Sets the value of {@link DeploymentSpecTemplateSpecVolume#getAzureFile}
         * @param azureFile azure_file block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#azure_file Deployment#azure_file}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder azureFile(java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeAzureFile> azureFile) {
            this.azureFile = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeAzureFile>)azureFile;
            return this;
        }

        /**
         * Sets the value of {@link DeploymentSpecTemplateSpecVolume#getCephFs}
         * @param cephFs ceph_fs block.
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#ceph_fs Deployment#ceph_fs}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder cephFs(java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeCephFs> cephFs) {
            this.cephFs = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeCephFs>)cephFs;
            return this;
        }

        /**
         * Sets the value of {@link DeploymentSpecTemplateSpecVolume#getCinder}
         * @param cinder cinder block.
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#cinder Deployment#cinder}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder cinder(java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeCinder> cinder) {
            this.cinder = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeCinder>)cinder;
            return this;
        }

        /**
         * Sets the value of {@link DeploymentSpecTemplateSpecVolume#getConfigMap}
         * @param configMap config_map block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#config_map Deployment#config_map}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder configMap(java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeConfigMap> configMap) {
            this.configMap = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeConfigMap>)configMap;
            return this;
        }

        /**
         * Sets the value of {@link DeploymentSpecTemplateSpecVolume#getCsi}
         * @param csi csi block.
         *            Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#csi Deployment#csi}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder csi(java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeCsi> csi) {
            this.csi = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeCsi>)csi;
            return this;
        }

        /**
         * Sets the value of {@link DeploymentSpecTemplateSpecVolume#getDownwardApi}
         * @param downwardApi downward_api block.
         *                    Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#downward_api Deployment#downward_api}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder downwardApi(java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeDownwardApi> downwardApi) {
            this.downwardApi = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeDownwardApi>)downwardApi;
            return this;
        }

        /**
         * Sets the value of {@link DeploymentSpecTemplateSpecVolume#getEmptyDir}
         * @param emptyDir empty_dir block.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#empty_dir Deployment#empty_dir}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder emptyDir(java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeEmptyDir> emptyDir) {
            this.emptyDir = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeEmptyDir>)emptyDir;
            return this;
        }

        /**
         * Sets the value of {@link DeploymentSpecTemplateSpecVolume#getFc}
         * @param fc fc block.
         *           Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#fc Deployment#fc}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder fc(java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeFc> fc) {
            this.fc = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeFc>)fc;
            return this;
        }

        /**
         * Sets the value of {@link DeploymentSpecTemplateSpecVolume#getFlexVolume}
         * @param flexVolume flex_volume block.
         *                   Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#flex_volume Deployment#flex_volume}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder flexVolume(java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeFlexVolume> flexVolume) {
            this.flexVolume = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeFlexVolume>)flexVolume;
            return this;
        }

        /**
         * Sets the value of {@link DeploymentSpecTemplateSpecVolume#getFlocker}
         * @param flocker flocker block.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#flocker Deployment#flocker}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder flocker(java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeFlocker> flocker) {
            this.flocker = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeFlocker>)flocker;
            return this;
        }

        /**
         * Sets the value of {@link DeploymentSpecTemplateSpecVolume#getGcePersistentDisk}
         * @param gcePersistentDisk gce_persistent_disk block.
         *                          Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#gce_persistent_disk Deployment#gce_persistent_disk}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder gcePersistentDisk(java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeGcePersistentDisk> gcePersistentDisk) {
            this.gcePersistentDisk = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeGcePersistentDisk>)gcePersistentDisk;
            return this;
        }

        /**
         * Sets the value of {@link DeploymentSpecTemplateSpecVolume#getGitRepo}
         * @param gitRepo git_repo block.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#git_repo Deployment#git_repo}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder gitRepo(java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeGitRepo> gitRepo) {
            this.gitRepo = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeGitRepo>)gitRepo;
            return this;
        }

        /**
         * Sets the value of {@link DeploymentSpecTemplateSpecVolume#getGlusterfs}
         * @param glusterfs glusterfs block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#glusterfs Deployment#glusterfs}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder glusterfs(java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeGlusterfs> glusterfs) {
            this.glusterfs = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeGlusterfs>)glusterfs;
            return this;
        }

        /**
         * Sets the value of {@link DeploymentSpecTemplateSpecVolume#getHostPath}
         * @param hostPath host_path block.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#host_path Deployment#host_path}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder hostPath(java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeHostPath> hostPath) {
            this.hostPath = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeHostPath>)hostPath;
            return this;
        }

        /**
         * Sets the value of {@link DeploymentSpecTemplateSpecVolume#getIscsi}
         * @param iscsi iscsi block.
         *              Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#iscsi Deployment#iscsi}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder iscsi(java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeIscsi> iscsi) {
            this.iscsi = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeIscsi>)iscsi;
            return this;
        }

        /**
         * Sets the value of {@link DeploymentSpecTemplateSpecVolume#getLocal}
         * @param local local block.
         *              Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#local Deployment#local}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder local(java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeLocal> local) {
            this.local = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeLocal>)local;
            return this;
        }

        /**
         * Sets the value of {@link DeploymentSpecTemplateSpecVolume#getName}
         * @param name Volume's name. Must be a DNS_LABEL and unique within the pod. More info: http://kubernetes.io/docs/user-guide/identifiers#names.
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#name Deployment#name}
         * @return {@code this}
         */
        public Builder name(java.lang.String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets the value of {@link DeploymentSpecTemplateSpecVolume#getNfs}
         * @param nfs nfs block.
         *            Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#nfs Deployment#nfs}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder nfs(java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeNfs> nfs) {
            this.nfs = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeNfs>)nfs;
            return this;
        }

        /**
         * Sets the value of {@link DeploymentSpecTemplateSpecVolume#getPersistentVolumeClaim}
         * @param persistentVolumeClaim persistent_volume_claim block.
         *                              Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#persistent_volume_claim Deployment#persistent_volume_claim}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder persistentVolumeClaim(java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumePersistentVolumeClaim> persistentVolumeClaim) {
            this.persistentVolumeClaim = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumePersistentVolumeClaim>)persistentVolumeClaim;
            return this;
        }

        /**
         * Sets the value of {@link DeploymentSpecTemplateSpecVolume#getPhotonPersistentDisk}
         * @param photonPersistentDisk photon_persistent_disk block.
         *                             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#photon_persistent_disk Deployment#photon_persistent_disk}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder photonPersistentDisk(java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumePhotonPersistentDisk> photonPersistentDisk) {
            this.photonPersistentDisk = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumePhotonPersistentDisk>)photonPersistentDisk;
            return this;
        }

        /**
         * Sets the value of {@link DeploymentSpecTemplateSpecVolume#getQuobyte}
         * @param quobyte quobyte block.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#quobyte Deployment#quobyte}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder quobyte(java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeQuobyte> quobyte) {
            this.quobyte = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeQuobyte>)quobyte;
            return this;
        }

        /**
         * Sets the value of {@link DeploymentSpecTemplateSpecVolume#getRbd}
         * @param rbd rbd block.
         *            Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#rbd Deployment#rbd}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder rbd(java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeRbd> rbd) {
            this.rbd = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeRbd>)rbd;
            return this;
        }

        /**
         * Sets the value of {@link DeploymentSpecTemplateSpecVolume#getSecret}
         * @param secret secret block.
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#secret Deployment#secret}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder secret(java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeSecret> secret) {
            this.secret = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeSecret>)secret;
            return this;
        }

        /**
         * Sets the value of {@link DeploymentSpecTemplateSpecVolume#getVsphereVolume}
         * @param vsphereVolume vsphere_volume block.
         *                      Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#vsphere_volume Deployment#vsphere_volume}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder vsphereVolume(java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeVsphereVolume> vsphereVolume) {
            this.vsphereVolume = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeVsphereVolume>)vsphereVolume;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link DeploymentSpecTemplateSpecVolume}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public DeploymentSpecTemplateSpecVolume build() {
            return new Jsii$Proxy(awsElasticBlockStore, azureDisk, azureFile, cephFs, cinder, configMap, csi, downwardApi, emptyDir, fc, flexVolume, flocker, gcePersistentDisk, gitRepo, glusterfs, hostPath, iscsi, local, name, nfs, persistentVolumeClaim, photonPersistentDisk, quobyte, rbd, secret, vsphereVolume);
        }
    }

    /**
     * An implementation for {@link DeploymentSpecTemplateSpecVolume}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements DeploymentSpecTemplateSpecVolume {
        private final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeAwsElasticBlockStore> awsElasticBlockStore;
        private final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeAzureDisk> azureDisk;
        private final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeAzureFile> azureFile;
        private final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeCephFs> cephFs;
        private final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeCinder> cinder;
        private final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeConfigMap> configMap;
        private final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeCsi> csi;
        private final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeDownwardApi> downwardApi;
        private final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeEmptyDir> emptyDir;
        private final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeFc> fc;
        private final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeFlexVolume> flexVolume;
        private final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeFlocker> flocker;
        private final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeGcePersistentDisk> gcePersistentDisk;
        private final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeGitRepo> gitRepo;
        private final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeGlusterfs> glusterfs;
        private final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeHostPath> hostPath;
        private final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeIscsi> iscsi;
        private final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeLocal> local;
        private final java.lang.String name;
        private final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeNfs> nfs;
        private final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumePersistentVolumeClaim> persistentVolumeClaim;
        private final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumePhotonPersistentDisk> photonPersistentDisk;
        private final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeQuobyte> quobyte;
        private final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeRbd> rbd;
        private final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeSecret> secret;
        private final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeVsphereVolume> vsphereVolume;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.awsElasticBlockStore = software.amazon.jsii.Kernel.get(this, "awsElasticBlockStore", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DeploymentSpecTemplateSpecVolumeAwsElasticBlockStore.class)));
            this.azureDisk = software.amazon.jsii.Kernel.get(this, "azureDisk", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DeploymentSpecTemplateSpecVolumeAzureDisk.class)));
            this.azureFile = software.amazon.jsii.Kernel.get(this, "azureFile", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DeploymentSpecTemplateSpecVolumeAzureFile.class)));
            this.cephFs = software.amazon.jsii.Kernel.get(this, "cephFs", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DeploymentSpecTemplateSpecVolumeCephFs.class)));
            this.cinder = software.amazon.jsii.Kernel.get(this, "cinder", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DeploymentSpecTemplateSpecVolumeCinder.class)));
            this.configMap = software.amazon.jsii.Kernel.get(this, "configMap", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DeploymentSpecTemplateSpecVolumeConfigMap.class)));
            this.csi = software.amazon.jsii.Kernel.get(this, "csi", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DeploymentSpecTemplateSpecVolumeCsi.class)));
            this.downwardApi = software.amazon.jsii.Kernel.get(this, "downwardApi", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DeploymentSpecTemplateSpecVolumeDownwardApi.class)));
            this.emptyDir = software.amazon.jsii.Kernel.get(this, "emptyDir", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DeploymentSpecTemplateSpecVolumeEmptyDir.class)));
            this.fc = software.amazon.jsii.Kernel.get(this, "fc", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DeploymentSpecTemplateSpecVolumeFc.class)));
            this.flexVolume = software.amazon.jsii.Kernel.get(this, "flexVolume", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DeploymentSpecTemplateSpecVolumeFlexVolume.class)));
            this.flocker = software.amazon.jsii.Kernel.get(this, "flocker", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DeploymentSpecTemplateSpecVolumeFlocker.class)));
            this.gcePersistentDisk = software.amazon.jsii.Kernel.get(this, "gcePersistentDisk", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DeploymentSpecTemplateSpecVolumeGcePersistentDisk.class)));
            this.gitRepo = software.amazon.jsii.Kernel.get(this, "gitRepo", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DeploymentSpecTemplateSpecVolumeGitRepo.class)));
            this.glusterfs = software.amazon.jsii.Kernel.get(this, "glusterfs", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DeploymentSpecTemplateSpecVolumeGlusterfs.class)));
            this.hostPath = software.amazon.jsii.Kernel.get(this, "hostPath", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DeploymentSpecTemplateSpecVolumeHostPath.class)));
            this.iscsi = software.amazon.jsii.Kernel.get(this, "iscsi", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DeploymentSpecTemplateSpecVolumeIscsi.class)));
            this.local = software.amazon.jsii.Kernel.get(this, "local", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DeploymentSpecTemplateSpecVolumeLocal.class)));
            this.name = software.amazon.jsii.Kernel.get(this, "name", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.nfs = software.amazon.jsii.Kernel.get(this, "nfs", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DeploymentSpecTemplateSpecVolumeNfs.class)));
            this.persistentVolumeClaim = software.amazon.jsii.Kernel.get(this, "persistentVolumeClaim", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DeploymentSpecTemplateSpecVolumePersistentVolumeClaim.class)));
            this.photonPersistentDisk = software.amazon.jsii.Kernel.get(this, "photonPersistentDisk", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DeploymentSpecTemplateSpecVolumePhotonPersistentDisk.class)));
            this.quobyte = software.amazon.jsii.Kernel.get(this, "quobyte", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DeploymentSpecTemplateSpecVolumeQuobyte.class)));
            this.rbd = software.amazon.jsii.Kernel.get(this, "rbd", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DeploymentSpecTemplateSpecVolumeRbd.class)));
            this.secret = software.amazon.jsii.Kernel.get(this, "secret", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DeploymentSpecTemplateSpecVolumeSecret.class)));
            this.vsphereVolume = software.amazon.jsii.Kernel.get(this, "vsphereVolume", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DeploymentSpecTemplateSpecVolumeVsphereVolume.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeAwsElasticBlockStore> awsElasticBlockStore, final java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeAzureDisk> azureDisk, final java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeAzureFile> azureFile, final java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeCephFs> cephFs, final java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeCinder> cinder, final java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeConfigMap> configMap, final java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeCsi> csi, final java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeDownwardApi> downwardApi, final java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeEmptyDir> emptyDir, final java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeFc> fc, final java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeFlexVolume> flexVolume, final java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeFlocker> flocker, final java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeGcePersistentDisk> gcePersistentDisk, final java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeGitRepo> gitRepo, final java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeGlusterfs> glusterfs, final java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeHostPath> hostPath, final java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeIscsi> iscsi, final java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeLocal> local, final java.lang.String name, final java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeNfs> nfs, final java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumePersistentVolumeClaim> persistentVolumeClaim, final java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumePhotonPersistentDisk> photonPersistentDisk, final java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeQuobyte> quobyte, final java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeRbd> rbd, final java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeSecret> secret, final java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecVolumeVsphereVolume> vsphereVolume) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.awsElasticBlockStore = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeAwsElasticBlockStore>)awsElasticBlockStore;
            this.azureDisk = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeAzureDisk>)azureDisk;
            this.azureFile = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeAzureFile>)azureFile;
            this.cephFs = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeCephFs>)cephFs;
            this.cinder = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeCinder>)cinder;
            this.configMap = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeConfigMap>)configMap;
            this.csi = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeCsi>)csi;
            this.downwardApi = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeDownwardApi>)downwardApi;
            this.emptyDir = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeEmptyDir>)emptyDir;
            this.fc = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeFc>)fc;
            this.flexVolume = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeFlexVolume>)flexVolume;
            this.flocker = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeFlocker>)flocker;
            this.gcePersistentDisk = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeGcePersistentDisk>)gcePersistentDisk;
            this.gitRepo = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeGitRepo>)gitRepo;
            this.glusterfs = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeGlusterfs>)glusterfs;
            this.hostPath = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeHostPath>)hostPath;
            this.iscsi = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeIscsi>)iscsi;
            this.local = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeLocal>)local;
            this.name = name;
            this.nfs = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeNfs>)nfs;
            this.persistentVolumeClaim = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumePersistentVolumeClaim>)persistentVolumeClaim;
            this.photonPersistentDisk = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumePhotonPersistentDisk>)photonPersistentDisk;
            this.quobyte = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeQuobyte>)quobyte;
            this.rbd = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeRbd>)rbd;
            this.secret = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeSecret>)secret;
            this.vsphereVolume = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeVsphereVolume>)vsphereVolume;
        }

        @Override
        public final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeAwsElasticBlockStore> getAwsElasticBlockStore() {
            return this.awsElasticBlockStore;
        }

        @Override
        public final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeAzureDisk> getAzureDisk() {
            return this.azureDisk;
        }

        @Override
        public final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeAzureFile> getAzureFile() {
            return this.azureFile;
        }

        @Override
        public final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeCephFs> getCephFs() {
            return this.cephFs;
        }

        @Override
        public final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeCinder> getCinder() {
            return this.cinder;
        }

        @Override
        public final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeConfigMap> getConfigMap() {
            return this.configMap;
        }

        @Override
        public final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeCsi> getCsi() {
            return this.csi;
        }

        @Override
        public final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeDownwardApi> getDownwardApi() {
            return this.downwardApi;
        }

        @Override
        public final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeEmptyDir> getEmptyDir() {
            return this.emptyDir;
        }

        @Override
        public final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeFc> getFc() {
            return this.fc;
        }

        @Override
        public final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeFlexVolume> getFlexVolume() {
            return this.flexVolume;
        }

        @Override
        public final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeFlocker> getFlocker() {
            return this.flocker;
        }

        @Override
        public final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeGcePersistentDisk> getGcePersistentDisk() {
            return this.gcePersistentDisk;
        }

        @Override
        public final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeGitRepo> getGitRepo() {
            return this.gitRepo;
        }

        @Override
        public final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeGlusterfs> getGlusterfs() {
            return this.glusterfs;
        }

        @Override
        public final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeHostPath> getHostPath() {
            return this.hostPath;
        }

        @Override
        public final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeIscsi> getIscsi() {
            return this.iscsi;
        }

        @Override
        public final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeLocal> getLocal() {
            return this.local;
        }

        @Override
        public final java.lang.String getName() {
            return this.name;
        }

        @Override
        public final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeNfs> getNfs() {
            return this.nfs;
        }

        @Override
        public final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumePersistentVolumeClaim> getPersistentVolumeClaim() {
            return this.persistentVolumeClaim;
        }

        @Override
        public final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumePhotonPersistentDisk> getPhotonPersistentDisk() {
            return this.photonPersistentDisk;
        }

        @Override
        public final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeQuobyte> getQuobyte() {
            return this.quobyte;
        }

        @Override
        public final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeRbd> getRbd() {
            return this.rbd;
        }

        @Override
        public final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeSecret> getSecret() {
            return this.secret;
        }

        @Override
        public final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecVolumeVsphereVolume> getVsphereVolume() {
            return this.vsphereVolume;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getAwsElasticBlockStore() != null) {
                data.set("awsElasticBlockStore", om.valueToTree(this.getAwsElasticBlockStore()));
            }
            if (this.getAzureDisk() != null) {
                data.set("azureDisk", om.valueToTree(this.getAzureDisk()));
            }
            if (this.getAzureFile() != null) {
                data.set("azureFile", om.valueToTree(this.getAzureFile()));
            }
            if (this.getCephFs() != null) {
                data.set("cephFs", om.valueToTree(this.getCephFs()));
            }
            if (this.getCinder() != null) {
                data.set("cinder", om.valueToTree(this.getCinder()));
            }
            if (this.getConfigMap() != null) {
                data.set("configMap", om.valueToTree(this.getConfigMap()));
            }
            if (this.getCsi() != null) {
                data.set("csi", om.valueToTree(this.getCsi()));
            }
            if (this.getDownwardApi() != null) {
                data.set("downwardApi", om.valueToTree(this.getDownwardApi()));
            }
            if (this.getEmptyDir() != null) {
                data.set("emptyDir", om.valueToTree(this.getEmptyDir()));
            }
            if (this.getFc() != null) {
                data.set("fc", om.valueToTree(this.getFc()));
            }
            if (this.getFlexVolume() != null) {
                data.set("flexVolume", om.valueToTree(this.getFlexVolume()));
            }
            if (this.getFlocker() != null) {
                data.set("flocker", om.valueToTree(this.getFlocker()));
            }
            if (this.getGcePersistentDisk() != null) {
                data.set("gcePersistentDisk", om.valueToTree(this.getGcePersistentDisk()));
            }
            if (this.getGitRepo() != null) {
                data.set("gitRepo", om.valueToTree(this.getGitRepo()));
            }
            if (this.getGlusterfs() != null) {
                data.set("glusterfs", om.valueToTree(this.getGlusterfs()));
            }
            if (this.getHostPath() != null) {
                data.set("hostPath", om.valueToTree(this.getHostPath()));
            }
            if (this.getIscsi() != null) {
                data.set("iscsi", om.valueToTree(this.getIscsi()));
            }
            if (this.getLocal() != null) {
                data.set("local", om.valueToTree(this.getLocal()));
            }
            if (this.getName() != null) {
                data.set("name", om.valueToTree(this.getName()));
            }
            if (this.getNfs() != null) {
                data.set("nfs", om.valueToTree(this.getNfs()));
            }
            if (this.getPersistentVolumeClaim() != null) {
                data.set("persistentVolumeClaim", om.valueToTree(this.getPersistentVolumeClaim()));
            }
            if (this.getPhotonPersistentDisk() != null) {
                data.set("photonPersistentDisk", om.valueToTree(this.getPhotonPersistentDisk()));
            }
            if (this.getQuobyte() != null) {
                data.set("quobyte", om.valueToTree(this.getQuobyte()));
            }
            if (this.getRbd() != null) {
                data.set("rbd", om.valueToTree(this.getRbd()));
            }
            if (this.getSecret() != null) {
                data.set("secret", om.valueToTree(this.getSecret()));
            }
            if (this.getVsphereVolume() != null) {
                data.set("vsphereVolume", om.valueToTree(this.getVsphereVolume()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.DeploymentSpecTemplateSpecVolume"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DeploymentSpecTemplateSpecVolume.Jsii$Proxy that = (DeploymentSpecTemplateSpecVolume.Jsii$Proxy) o;

            if (this.awsElasticBlockStore != null ? !this.awsElasticBlockStore.equals(that.awsElasticBlockStore) : that.awsElasticBlockStore != null) return false;
            if (this.azureDisk != null ? !this.azureDisk.equals(that.azureDisk) : that.azureDisk != null) return false;
            if (this.azureFile != null ? !this.azureFile.equals(that.azureFile) : that.azureFile != null) return false;
            if (this.cephFs != null ? !this.cephFs.equals(that.cephFs) : that.cephFs != null) return false;
            if (this.cinder != null ? !this.cinder.equals(that.cinder) : that.cinder != null) return false;
            if (this.configMap != null ? !this.configMap.equals(that.configMap) : that.configMap != null) return false;
            if (this.csi != null ? !this.csi.equals(that.csi) : that.csi != null) return false;
            if (this.downwardApi != null ? !this.downwardApi.equals(that.downwardApi) : that.downwardApi != null) return false;
            if (this.emptyDir != null ? !this.emptyDir.equals(that.emptyDir) : that.emptyDir != null) return false;
            if (this.fc != null ? !this.fc.equals(that.fc) : that.fc != null) return false;
            if (this.flexVolume != null ? !this.flexVolume.equals(that.flexVolume) : that.flexVolume != null) return false;
            if (this.flocker != null ? !this.flocker.equals(that.flocker) : that.flocker != null) return false;
            if (this.gcePersistentDisk != null ? !this.gcePersistentDisk.equals(that.gcePersistentDisk) : that.gcePersistentDisk != null) return false;
            if (this.gitRepo != null ? !this.gitRepo.equals(that.gitRepo) : that.gitRepo != null) return false;
            if (this.glusterfs != null ? !this.glusterfs.equals(that.glusterfs) : that.glusterfs != null) return false;
            if (this.hostPath != null ? !this.hostPath.equals(that.hostPath) : that.hostPath != null) return false;
            if (this.iscsi != null ? !this.iscsi.equals(that.iscsi) : that.iscsi != null) return false;
            if (this.local != null ? !this.local.equals(that.local) : that.local != null) return false;
            if (this.name != null ? !this.name.equals(that.name) : that.name != null) return false;
            if (this.nfs != null ? !this.nfs.equals(that.nfs) : that.nfs != null) return false;
            if (this.persistentVolumeClaim != null ? !this.persistentVolumeClaim.equals(that.persistentVolumeClaim) : that.persistentVolumeClaim != null) return false;
            if (this.photonPersistentDisk != null ? !this.photonPersistentDisk.equals(that.photonPersistentDisk) : that.photonPersistentDisk != null) return false;
            if (this.quobyte != null ? !this.quobyte.equals(that.quobyte) : that.quobyte != null) return false;
            if (this.rbd != null ? !this.rbd.equals(that.rbd) : that.rbd != null) return false;
            if (this.secret != null ? !this.secret.equals(that.secret) : that.secret != null) return false;
            return this.vsphereVolume != null ? this.vsphereVolume.equals(that.vsphereVolume) : that.vsphereVolume == null;
        }

        @Override
        public final int hashCode() {
            int result = this.awsElasticBlockStore != null ? this.awsElasticBlockStore.hashCode() : 0;
            result = 31 * result + (this.azureDisk != null ? this.azureDisk.hashCode() : 0);
            result = 31 * result + (this.azureFile != null ? this.azureFile.hashCode() : 0);
            result = 31 * result + (this.cephFs != null ? this.cephFs.hashCode() : 0);
            result = 31 * result + (this.cinder != null ? this.cinder.hashCode() : 0);
            result = 31 * result + (this.configMap != null ? this.configMap.hashCode() : 0);
            result = 31 * result + (this.csi != null ? this.csi.hashCode() : 0);
            result = 31 * result + (this.downwardApi != null ? this.downwardApi.hashCode() : 0);
            result = 31 * result + (this.emptyDir != null ? this.emptyDir.hashCode() : 0);
            result = 31 * result + (this.fc != null ? this.fc.hashCode() : 0);
            result = 31 * result + (this.flexVolume != null ? this.flexVolume.hashCode() : 0);
            result = 31 * result + (this.flocker != null ? this.flocker.hashCode() : 0);
            result = 31 * result + (this.gcePersistentDisk != null ? this.gcePersistentDisk.hashCode() : 0);
            result = 31 * result + (this.gitRepo != null ? this.gitRepo.hashCode() : 0);
            result = 31 * result + (this.glusterfs != null ? this.glusterfs.hashCode() : 0);
            result = 31 * result + (this.hostPath != null ? this.hostPath.hashCode() : 0);
            result = 31 * result + (this.iscsi != null ? this.iscsi.hashCode() : 0);
            result = 31 * result + (this.local != null ? this.local.hashCode() : 0);
            result = 31 * result + (this.name != null ? this.name.hashCode() : 0);
            result = 31 * result + (this.nfs != null ? this.nfs.hashCode() : 0);
            result = 31 * result + (this.persistentVolumeClaim != null ? this.persistentVolumeClaim.hashCode() : 0);
            result = 31 * result + (this.photonPersistentDisk != null ? this.photonPersistentDisk.hashCode() : 0);
            result = 31 * result + (this.quobyte != null ? this.quobyte.hashCode() : 0);
            result = 31 * result + (this.rbd != null ? this.rbd.hashCode() : 0);
            result = 31 * result + (this.secret != null ? this.secret.hashCode() : 0);
            result = 31 * result + (this.vsphereVolume != null ? this.vsphereVolume.hashCode() : 0);
            return result;
        }
    }
}
