package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.404Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolume")
@software.amazon.jsii.Jsii.Proxy(CronJobSpecJobTemplateSpecTemplateSpecVolume.Jsii$Proxy.class)
public interface CronJobSpecJobTemplateSpecTemplateSpecVolume extends software.amazon.jsii.JsiiSerializable {

    /**
     * aws_elastic_block_store block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#aws_elastic_block_store CronJob#aws_elastic_block_store}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeAwsElasticBlockStore> getAwsElasticBlockStore() {
        return null;
    }

    /**
     * azure_disk block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#azure_disk CronJob#azure_disk}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeAzureDisk> getAzureDisk() {
        return null;
    }

    /**
     * azure_file block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#azure_file CronJob#azure_file}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeAzureFile> getAzureFile() {
        return null;
    }

    /**
     * ceph_fs block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#ceph_fs CronJob#ceph_fs}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeCephFs> getCephFs() {
        return null;
    }

    /**
     * cinder block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#cinder CronJob#cinder}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeCinder> getCinder() {
        return null;
    }

    /**
     * config_map block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#config_map CronJob#config_map}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeConfigMap> getConfigMap() {
        return null;
    }

    /**
     * csi block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#csi CronJob#csi}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeCsi> getCsi() {
        return null;
    }

    /**
     * downward_api block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#downward_api CronJob#downward_api}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeDownwardApi> getDownwardApi() {
        return null;
    }

    /**
     * empty_dir block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#empty_dir CronJob#empty_dir}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeEmptyDir> getEmptyDir() {
        return null;
    }

    /**
     * fc block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#fc CronJob#fc}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeFc> getFc() {
        return null;
    }

    /**
     * flex_volume block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#flex_volume CronJob#flex_volume}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeFlexVolume> getFlexVolume() {
        return null;
    }

    /**
     * flocker block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#flocker CronJob#flocker}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeFlocker> getFlocker() {
        return null;
    }

    /**
     * gce_persistent_disk block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#gce_persistent_disk CronJob#gce_persistent_disk}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeGcePersistentDisk> getGcePersistentDisk() {
        return null;
    }

    /**
     * git_repo block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#git_repo CronJob#git_repo}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeGitRepo> getGitRepo() {
        return null;
    }

    /**
     * glusterfs block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#glusterfs CronJob#glusterfs}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeGlusterfs> getGlusterfs() {
        return null;
    }

    /**
     * host_path block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#host_path CronJob#host_path}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeHostPath> getHostPath() {
        return null;
    }

    /**
     * iscsi block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#iscsi CronJob#iscsi}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeIscsi> getIscsi() {
        return null;
    }

    /**
     * local block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#local CronJob#local}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeLocal> getLocal() {
        return null;
    }

    /**
     * Volume's name. Must be a DNS_LABEL and unique within the pod. More info: http://kubernetes.io/docs/user-guide/identifiers#names.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#name CronJob#name}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getName() {
        return null;
    }

    /**
     * nfs block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#nfs CronJob#nfs}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeNfs> getNfs() {
        return null;
    }

    /**
     * persistent_volume_claim block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#persistent_volume_claim CronJob#persistent_volume_claim}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumePersistentVolumeClaim> getPersistentVolumeClaim() {
        return null;
    }

    /**
     * photon_persistent_disk block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#photon_persistent_disk CronJob#photon_persistent_disk}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumePhotonPersistentDisk> getPhotonPersistentDisk() {
        return null;
    }

    /**
     * quobyte block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#quobyte CronJob#quobyte}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeQuobyte> getQuobyte() {
        return null;
    }

    /**
     * rbd block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#rbd CronJob#rbd}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeRbd> getRbd() {
        return null;
    }

    /**
     * secret block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#secret CronJob#secret}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeSecret> getSecret() {
        return null;
    }

    /**
     * vsphere_volume block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#vsphere_volume CronJob#vsphere_volume}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeVsphereVolume> getVsphereVolume() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link CronJobSpecJobTemplateSpecTemplateSpecVolume}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link CronJobSpecJobTemplateSpecTemplateSpecVolume}
     */
    public static final class Builder implements software.amazon.jsii.Builder<CronJobSpecJobTemplateSpecTemplateSpecVolume> {
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeAwsElasticBlockStore> awsElasticBlockStore;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeAzureDisk> azureDisk;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeAzureFile> azureFile;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeCephFs> cephFs;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeCinder> cinder;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeConfigMap> configMap;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeCsi> csi;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeDownwardApi> downwardApi;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeEmptyDir> emptyDir;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeFc> fc;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeFlexVolume> flexVolume;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeFlocker> flocker;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeGcePersistentDisk> gcePersistentDisk;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeGitRepo> gitRepo;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeGlusterfs> glusterfs;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeHostPath> hostPath;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeIscsi> iscsi;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeLocal> local;
        private java.lang.String name;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeNfs> nfs;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumePersistentVolumeClaim> persistentVolumeClaim;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumePhotonPersistentDisk> photonPersistentDisk;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeQuobyte> quobyte;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeRbd> rbd;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeSecret> secret;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeVsphereVolume> vsphereVolume;

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpecVolume#getAwsElasticBlockStore}
         * @param awsElasticBlockStore aws_elastic_block_store block.
         *                             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#aws_elastic_block_store CronJob#aws_elastic_block_store}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder awsElasticBlockStore(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeAwsElasticBlockStore> awsElasticBlockStore) {
            this.awsElasticBlockStore = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeAwsElasticBlockStore>)awsElasticBlockStore;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpecVolume#getAzureDisk}
         * @param azureDisk azure_disk block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#azure_disk CronJob#azure_disk}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder azureDisk(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeAzureDisk> azureDisk) {
            this.azureDisk = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeAzureDisk>)azureDisk;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpecVolume#getAzureFile}
         * @param azureFile azure_file block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#azure_file CronJob#azure_file}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder azureFile(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeAzureFile> azureFile) {
            this.azureFile = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeAzureFile>)azureFile;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpecVolume#getCephFs}
         * @param cephFs ceph_fs block.
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#ceph_fs CronJob#ceph_fs}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder cephFs(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeCephFs> cephFs) {
            this.cephFs = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeCephFs>)cephFs;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpecVolume#getCinder}
         * @param cinder cinder block.
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#cinder CronJob#cinder}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder cinder(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeCinder> cinder) {
            this.cinder = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeCinder>)cinder;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpecVolume#getConfigMap}
         * @param configMap config_map block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#config_map CronJob#config_map}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder configMap(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeConfigMap> configMap) {
            this.configMap = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeConfigMap>)configMap;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpecVolume#getCsi}
         * @param csi csi block.
         *            Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#csi CronJob#csi}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder csi(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeCsi> csi) {
            this.csi = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeCsi>)csi;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpecVolume#getDownwardApi}
         * @param downwardApi downward_api block.
         *                    Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#downward_api CronJob#downward_api}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder downwardApi(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeDownwardApi> downwardApi) {
            this.downwardApi = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeDownwardApi>)downwardApi;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpecVolume#getEmptyDir}
         * @param emptyDir empty_dir block.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#empty_dir CronJob#empty_dir}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder emptyDir(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeEmptyDir> emptyDir) {
            this.emptyDir = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeEmptyDir>)emptyDir;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpecVolume#getFc}
         * @param fc fc block.
         *           Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#fc CronJob#fc}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder fc(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeFc> fc) {
            this.fc = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeFc>)fc;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpecVolume#getFlexVolume}
         * @param flexVolume flex_volume block.
         *                   Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#flex_volume CronJob#flex_volume}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder flexVolume(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeFlexVolume> flexVolume) {
            this.flexVolume = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeFlexVolume>)flexVolume;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpecVolume#getFlocker}
         * @param flocker flocker block.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#flocker CronJob#flocker}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder flocker(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeFlocker> flocker) {
            this.flocker = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeFlocker>)flocker;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpecVolume#getGcePersistentDisk}
         * @param gcePersistentDisk gce_persistent_disk block.
         *                          Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#gce_persistent_disk CronJob#gce_persistent_disk}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder gcePersistentDisk(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeGcePersistentDisk> gcePersistentDisk) {
            this.gcePersistentDisk = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeGcePersistentDisk>)gcePersistentDisk;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpecVolume#getGitRepo}
         * @param gitRepo git_repo block.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#git_repo CronJob#git_repo}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder gitRepo(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeGitRepo> gitRepo) {
            this.gitRepo = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeGitRepo>)gitRepo;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpecVolume#getGlusterfs}
         * @param glusterfs glusterfs block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#glusterfs CronJob#glusterfs}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder glusterfs(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeGlusterfs> glusterfs) {
            this.glusterfs = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeGlusterfs>)glusterfs;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpecVolume#getHostPath}
         * @param hostPath host_path block.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#host_path CronJob#host_path}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder hostPath(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeHostPath> hostPath) {
            this.hostPath = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeHostPath>)hostPath;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpecVolume#getIscsi}
         * @param iscsi iscsi block.
         *              Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#iscsi CronJob#iscsi}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder iscsi(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeIscsi> iscsi) {
            this.iscsi = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeIscsi>)iscsi;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpecVolume#getLocal}
         * @param local local block.
         *              Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#local CronJob#local}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder local(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeLocal> local) {
            this.local = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeLocal>)local;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpecVolume#getName}
         * @param name Volume's name. Must be a DNS_LABEL and unique within the pod. More info: http://kubernetes.io/docs/user-guide/identifiers#names.
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#name CronJob#name}
         * @return {@code this}
         */
        public Builder name(java.lang.String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpecVolume#getNfs}
         * @param nfs nfs block.
         *            Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#nfs CronJob#nfs}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder nfs(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeNfs> nfs) {
            this.nfs = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeNfs>)nfs;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpecVolume#getPersistentVolumeClaim}
         * @param persistentVolumeClaim persistent_volume_claim block.
         *                              Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#persistent_volume_claim CronJob#persistent_volume_claim}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder persistentVolumeClaim(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumePersistentVolumeClaim> persistentVolumeClaim) {
            this.persistentVolumeClaim = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumePersistentVolumeClaim>)persistentVolumeClaim;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpecVolume#getPhotonPersistentDisk}
         * @param photonPersistentDisk photon_persistent_disk block.
         *                             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#photon_persistent_disk CronJob#photon_persistent_disk}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder photonPersistentDisk(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumePhotonPersistentDisk> photonPersistentDisk) {
            this.photonPersistentDisk = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumePhotonPersistentDisk>)photonPersistentDisk;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpecVolume#getQuobyte}
         * @param quobyte quobyte block.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#quobyte CronJob#quobyte}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder quobyte(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeQuobyte> quobyte) {
            this.quobyte = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeQuobyte>)quobyte;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpecVolume#getRbd}
         * @param rbd rbd block.
         *            Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#rbd CronJob#rbd}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder rbd(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeRbd> rbd) {
            this.rbd = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeRbd>)rbd;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpecVolume#getSecret}
         * @param secret secret block.
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#secret CronJob#secret}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder secret(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeSecret> secret) {
            this.secret = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeSecret>)secret;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpecVolume#getVsphereVolume}
         * @param vsphereVolume vsphere_volume block.
         *                      Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#vsphere_volume CronJob#vsphere_volume}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder vsphereVolume(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeVsphereVolume> vsphereVolume) {
            this.vsphereVolume = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeVsphereVolume>)vsphereVolume;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link CronJobSpecJobTemplateSpecTemplateSpecVolume}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public CronJobSpecJobTemplateSpecTemplateSpecVolume build() {
            return new Jsii$Proxy(awsElasticBlockStore, azureDisk, azureFile, cephFs, cinder, configMap, csi, downwardApi, emptyDir, fc, flexVolume, flocker, gcePersistentDisk, gitRepo, glusterfs, hostPath, iscsi, local, name, nfs, persistentVolumeClaim, photonPersistentDisk, quobyte, rbd, secret, vsphereVolume);
        }
    }

    /**
     * An implementation for {@link CronJobSpecJobTemplateSpecTemplateSpecVolume}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements CronJobSpecJobTemplateSpecTemplateSpecVolume {
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeAwsElasticBlockStore> awsElasticBlockStore;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeAzureDisk> azureDisk;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeAzureFile> azureFile;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeCephFs> cephFs;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeCinder> cinder;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeConfigMap> configMap;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeCsi> csi;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeDownwardApi> downwardApi;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeEmptyDir> emptyDir;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeFc> fc;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeFlexVolume> flexVolume;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeFlocker> flocker;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeGcePersistentDisk> gcePersistentDisk;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeGitRepo> gitRepo;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeGlusterfs> glusterfs;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeHostPath> hostPath;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeIscsi> iscsi;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeLocal> local;
        private final java.lang.String name;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeNfs> nfs;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumePersistentVolumeClaim> persistentVolumeClaim;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumePhotonPersistentDisk> photonPersistentDisk;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeQuobyte> quobyte;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeRbd> rbd;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeSecret> secret;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeVsphereVolume> vsphereVolume;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.awsElasticBlockStore = software.amazon.jsii.Kernel.get(this, "awsElasticBlockStore", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeAwsElasticBlockStore.class)));
            this.azureDisk = software.amazon.jsii.Kernel.get(this, "azureDisk", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeAzureDisk.class)));
            this.azureFile = software.amazon.jsii.Kernel.get(this, "azureFile", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeAzureFile.class)));
            this.cephFs = software.amazon.jsii.Kernel.get(this, "cephFs", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeCephFs.class)));
            this.cinder = software.amazon.jsii.Kernel.get(this, "cinder", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeCinder.class)));
            this.configMap = software.amazon.jsii.Kernel.get(this, "configMap", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeConfigMap.class)));
            this.csi = software.amazon.jsii.Kernel.get(this, "csi", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeCsi.class)));
            this.downwardApi = software.amazon.jsii.Kernel.get(this, "downwardApi", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeDownwardApi.class)));
            this.emptyDir = software.amazon.jsii.Kernel.get(this, "emptyDir", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeEmptyDir.class)));
            this.fc = software.amazon.jsii.Kernel.get(this, "fc", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeFc.class)));
            this.flexVolume = software.amazon.jsii.Kernel.get(this, "flexVolume", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeFlexVolume.class)));
            this.flocker = software.amazon.jsii.Kernel.get(this, "flocker", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeFlocker.class)));
            this.gcePersistentDisk = software.amazon.jsii.Kernel.get(this, "gcePersistentDisk", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeGcePersistentDisk.class)));
            this.gitRepo = software.amazon.jsii.Kernel.get(this, "gitRepo", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeGitRepo.class)));
            this.glusterfs = software.amazon.jsii.Kernel.get(this, "glusterfs", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeGlusterfs.class)));
            this.hostPath = software.amazon.jsii.Kernel.get(this, "hostPath", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeHostPath.class)));
            this.iscsi = software.amazon.jsii.Kernel.get(this, "iscsi", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeIscsi.class)));
            this.local = software.amazon.jsii.Kernel.get(this, "local", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeLocal.class)));
            this.name = software.amazon.jsii.Kernel.get(this, "name", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.nfs = software.amazon.jsii.Kernel.get(this, "nfs", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeNfs.class)));
            this.persistentVolumeClaim = software.amazon.jsii.Kernel.get(this, "persistentVolumeClaim", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumePersistentVolumeClaim.class)));
            this.photonPersistentDisk = software.amazon.jsii.Kernel.get(this, "photonPersistentDisk", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumePhotonPersistentDisk.class)));
            this.quobyte = software.amazon.jsii.Kernel.get(this, "quobyte", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeQuobyte.class)));
            this.rbd = software.amazon.jsii.Kernel.get(this, "rbd", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeRbd.class)));
            this.secret = software.amazon.jsii.Kernel.get(this, "secret", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeSecret.class)));
            this.vsphereVolume = software.amazon.jsii.Kernel.get(this, "vsphereVolume", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeVsphereVolume.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeAwsElasticBlockStore> awsElasticBlockStore, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeAzureDisk> azureDisk, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeAzureFile> azureFile, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeCephFs> cephFs, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeCinder> cinder, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeConfigMap> configMap, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeCsi> csi, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeDownwardApi> downwardApi, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeEmptyDir> emptyDir, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeFc> fc, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeFlexVolume> flexVolume, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeFlocker> flocker, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeGcePersistentDisk> gcePersistentDisk, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeGitRepo> gitRepo, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeGlusterfs> glusterfs, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeHostPath> hostPath, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeIscsi> iscsi, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeLocal> local, final java.lang.String name, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeNfs> nfs, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumePersistentVolumeClaim> persistentVolumeClaim, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumePhotonPersistentDisk> photonPersistentDisk, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeQuobyte> quobyte, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeRbd> rbd, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeSecret> secret, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeVsphereVolume> vsphereVolume) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.awsElasticBlockStore = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeAwsElasticBlockStore>)awsElasticBlockStore;
            this.azureDisk = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeAzureDisk>)azureDisk;
            this.azureFile = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeAzureFile>)azureFile;
            this.cephFs = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeCephFs>)cephFs;
            this.cinder = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeCinder>)cinder;
            this.configMap = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeConfigMap>)configMap;
            this.csi = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeCsi>)csi;
            this.downwardApi = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeDownwardApi>)downwardApi;
            this.emptyDir = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeEmptyDir>)emptyDir;
            this.fc = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeFc>)fc;
            this.flexVolume = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeFlexVolume>)flexVolume;
            this.flocker = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeFlocker>)flocker;
            this.gcePersistentDisk = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeGcePersistentDisk>)gcePersistentDisk;
            this.gitRepo = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeGitRepo>)gitRepo;
            this.glusterfs = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeGlusterfs>)glusterfs;
            this.hostPath = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeHostPath>)hostPath;
            this.iscsi = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeIscsi>)iscsi;
            this.local = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeLocal>)local;
            this.name = name;
            this.nfs = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeNfs>)nfs;
            this.persistentVolumeClaim = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumePersistentVolumeClaim>)persistentVolumeClaim;
            this.photonPersistentDisk = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumePhotonPersistentDisk>)photonPersistentDisk;
            this.quobyte = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeQuobyte>)quobyte;
            this.rbd = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeRbd>)rbd;
            this.secret = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeSecret>)secret;
            this.vsphereVolume = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeVsphereVolume>)vsphereVolume;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeAwsElasticBlockStore> getAwsElasticBlockStore() {
            return this.awsElasticBlockStore;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeAzureDisk> getAzureDisk() {
            return this.azureDisk;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeAzureFile> getAzureFile() {
            return this.azureFile;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeCephFs> getCephFs() {
            return this.cephFs;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeCinder> getCinder() {
            return this.cinder;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeConfigMap> getConfigMap() {
            return this.configMap;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeCsi> getCsi() {
            return this.csi;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeDownwardApi> getDownwardApi() {
            return this.downwardApi;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeEmptyDir> getEmptyDir() {
            return this.emptyDir;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeFc> getFc() {
            return this.fc;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeFlexVolume> getFlexVolume() {
            return this.flexVolume;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeFlocker> getFlocker() {
            return this.flocker;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeGcePersistentDisk> getGcePersistentDisk() {
            return this.gcePersistentDisk;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeGitRepo> getGitRepo() {
            return this.gitRepo;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeGlusterfs> getGlusterfs() {
            return this.glusterfs;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeHostPath> getHostPath() {
            return this.hostPath;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeIscsi> getIscsi() {
            return this.iscsi;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeLocal> getLocal() {
            return this.local;
        }

        @Override
        public final java.lang.String getName() {
            return this.name;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeNfs> getNfs() {
            return this.nfs;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumePersistentVolumeClaim> getPersistentVolumeClaim() {
            return this.persistentVolumeClaim;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumePhotonPersistentDisk> getPhotonPersistentDisk() {
            return this.photonPersistentDisk;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeQuobyte> getQuobyte() {
            return this.quobyte;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeRbd> getRbd() {
            return this.rbd;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeSecret> getSecret() {
            return this.secret;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeVsphereVolume> getVsphereVolume() {
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
            struct.set("fqn", om.valueToTree("kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolume"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CronJobSpecJobTemplateSpecTemplateSpecVolume.Jsii$Proxy that = (CronJobSpecJobTemplateSpecTemplateSpecVolume.Jsii$Proxy) o;

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
