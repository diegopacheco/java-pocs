package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.683Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.PersistentVolumeSpecPersistentVolumeSource")
@software.amazon.jsii.Jsii.Proxy(PersistentVolumeSpecPersistentVolumeSource.Jsii$Proxy.class)
public interface PersistentVolumeSpecPersistentVolumeSource extends software.amazon.jsii.JsiiSerializable {

    /**
     * aws_elastic_block_store block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#aws_elastic_block_store PersistentVolume#aws_elastic_block_store}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceAwsElasticBlockStore> getAwsElasticBlockStore() {
        return null;
    }

    /**
     * azure_disk block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#azure_disk PersistentVolume#azure_disk}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceAzureDisk> getAzureDisk() {
        return null;
    }

    /**
     * azure_file block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#azure_file PersistentVolume#azure_file}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceAzureFile> getAzureFile() {
        return null;
    }

    /**
     * ceph_fs block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#ceph_fs PersistentVolume#ceph_fs}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceCephFs> getCephFs() {
        return null;
    }

    /**
     * cinder block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#cinder PersistentVolume#cinder}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceCinder> getCinder() {
        return null;
    }

    /**
     * csi block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#csi PersistentVolume#csi}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceCsi> getCsi() {
        return null;
    }

    /**
     * fc block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#fc PersistentVolume#fc}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceFc> getFc() {
        return null;
    }

    /**
     * flex_volume block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#flex_volume PersistentVolume#flex_volume}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceFlexVolume> getFlexVolume() {
        return null;
    }

    /**
     * flocker block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#flocker PersistentVolume#flocker}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceFlocker> getFlocker() {
        return null;
    }

    /**
     * gce_persistent_disk block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#gce_persistent_disk PersistentVolume#gce_persistent_disk}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceGcePersistentDisk> getGcePersistentDisk() {
        return null;
    }

    /**
     * glusterfs block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#glusterfs PersistentVolume#glusterfs}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceGlusterfs> getGlusterfs() {
        return null;
    }

    /**
     * host_path block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#host_path PersistentVolume#host_path}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceHostPath> getHostPath() {
        return null;
    }

    /**
     * iscsi block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#iscsi PersistentVolume#iscsi}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceIscsi> getIscsi() {
        return null;
    }

    /**
     * local block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#local PersistentVolume#local}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceLocal> getLocal() {
        return null;
    }

    /**
     * nfs block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#nfs PersistentVolume#nfs}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceNfs> getNfs() {
        return null;
    }

    /**
     * photon_persistent_disk block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#photon_persistent_disk PersistentVolume#photon_persistent_disk}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourcePhotonPersistentDisk> getPhotonPersistentDisk() {
        return null;
    }

    /**
     * quobyte block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#quobyte PersistentVolume#quobyte}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceQuobyte> getQuobyte() {
        return null;
    }

    /**
     * rbd block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#rbd PersistentVolume#rbd}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceRbd> getRbd() {
        return null;
    }

    /**
     * vsphere_volume block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#vsphere_volume PersistentVolume#vsphere_volume}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceVsphereVolume> getVsphereVolume() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link PersistentVolumeSpecPersistentVolumeSource}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link PersistentVolumeSpecPersistentVolumeSource}
     */
    public static final class Builder implements software.amazon.jsii.Builder<PersistentVolumeSpecPersistentVolumeSource> {
        private java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceAwsElasticBlockStore> awsElasticBlockStore;
        private java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceAzureDisk> azureDisk;
        private java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceAzureFile> azureFile;
        private java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceCephFs> cephFs;
        private java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceCinder> cinder;
        private java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceCsi> csi;
        private java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceFc> fc;
        private java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceFlexVolume> flexVolume;
        private java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceFlocker> flocker;
        private java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceGcePersistentDisk> gcePersistentDisk;
        private java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceGlusterfs> glusterfs;
        private java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceHostPath> hostPath;
        private java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceIscsi> iscsi;
        private java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceLocal> local;
        private java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceNfs> nfs;
        private java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourcePhotonPersistentDisk> photonPersistentDisk;
        private java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceQuobyte> quobyte;
        private java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceRbd> rbd;
        private java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceVsphereVolume> vsphereVolume;

        /**
         * Sets the value of {@link PersistentVolumeSpecPersistentVolumeSource#getAwsElasticBlockStore}
         * @param awsElasticBlockStore aws_elastic_block_store block.
         *                             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#aws_elastic_block_store PersistentVolume#aws_elastic_block_store}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder awsElasticBlockStore(java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceAwsElasticBlockStore> awsElasticBlockStore) {
            this.awsElasticBlockStore = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceAwsElasticBlockStore>)awsElasticBlockStore;
            return this;
        }

        /**
         * Sets the value of {@link PersistentVolumeSpecPersistentVolumeSource#getAzureDisk}
         * @param azureDisk azure_disk block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#azure_disk PersistentVolume#azure_disk}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder azureDisk(java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceAzureDisk> azureDisk) {
            this.azureDisk = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceAzureDisk>)azureDisk;
            return this;
        }

        /**
         * Sets the value of {@link PersistentVolumeSpecPersistentVolumeSource#getAzureFile}
         * @param azureFile azure_file block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#azure_file PersistentVolume#azure_file}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder azureFile(java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceAzureFile> azureFile) {
            this.azureFile = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceAzureFile>)azureFile;
            return this;
        }

        /**
         * Sets the value of {@link PersistentVolumeSpecPersistentVolumeSource#getCephFs}
         * @param cephFs ceph_fs block.
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#ceph_fs PersistentVolume#ceph_fs}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder cephFs(java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceCephFs> cephFs) {
            this.cephFs = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceCephFs>)cephFs;
            return this;
        }

        /**
         * Sets the value of {@link PersistentVolumeSpecPersistentVolumeSource#getCinder}
         * @param cinder cinder block.
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#cinder PersistentVolume#cinder}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder cinder(java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceCinder> cinder) {
            this.cinder = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceCinder>)cinder;
            return this;
        }

        /**
         * Sets the value of {@link PersistentVolumeSpecPersistentVolumeSource#getCsi}
         * @param csi csi block.
         *            Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#csi PersistentVolume#csi}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder csi(java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceCsi> csi) {
            this.csi = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceCsi>)csi;
            return this;
        }

        /**
         * Sets the value of {@link PersistentVolumeSpecPersistentVolumeSource#getFc}
         * @param fc fc block.
         *           Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#fc PersistentVolume#fc}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder fc(java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceFc> fc) {
            this.fc = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceFc>)fc;
            return this;
        }

        /**
         * Sets the value of {@link PersistentVolumeSpecPersistentVolumeSource#getFlexVolume}
         * @param flexVolume flex_volume block.
         *                   Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#flex_volume PersistentVolume#flex_volume}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder flexVolume(java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceFlexVolume> flexVolume) {
            this.flexVolume = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceFlexVolume>)flexVolume;
            return this;
        }

        /**
         * Sets the value of {@link PersistentVolumeSpecPersistentVolumeSource#getFlocker}
         * @param flocker flocker block.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#flocker PersistentVolume#flocker}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder flocker(java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceFlocker> flocker) {
            this.flocker = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceFlocker>)flocker;
            return this;
        }

        /**
         * Sets the value of {@link PersistentVolumeSpecPersistentVolumeSource#getGcePersistentDisk}
         * @param gcePersistentDisk gce_persistent_disk block.
         *                          Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#gce_persistent_disk PersistentVolume#gce_persistent_disk}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder gcePersistentDisk(java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceGcePersistentDisk> gcePersistentDisk) {
            this.gcePersistentDisk = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceGcePersistentDisk>)gcePersistentDisk;
            return this;
        }

        /**
         * Sets the value of {@link PersistentVolumeSpecPersistentVolumeSource#getGlusterfs}
         * @param glusterfs glusterfs block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#glusterfs PersistentVolume#glusterfs}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder glusterfs(java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceGlusterfs> glusterfs) {
            this.glusterfs = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceGlusterfs>)glusterfs;
            return this;
        }

        /**
         * Sets the value of {@link PersistentVolumeSpecPersistentVolumeSource#getHostPath}
         * @param hostPath host_path block.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#host_path PersistentVolume#host_path}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder hostPath(java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceHostPath> hostPath) {
            this.hostPath = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceHostPath>)hostPath;
            return this;
        }

        /**
         * Sets the value of {@link PersistentVolumeSpecPersistentVolumeSource#getIscsi}
         * @param iscsi iscsi block.
         *              Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#iscsi PersistentVolume#iscsi}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder iscsi(java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceIscsi> iscsi) {
            this.iscsi = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceIscsi>)iscsi;
            return this;
        }

        /**
         * Sets the value of {@link PersistentVolumeSpecPersistentVolumeSource#getLocal}
         * @param local local block.
         *              Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#local PersistentVolume#local}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder local(java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceLocal> local) {
            this.local = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceLocal>)local;
            return this;
        }

        /**
         * Sets the value of {@link PersistentVolumeSpecPersistentVolumeSource#getNfs}
         * @param nfs nfs block.
         *            Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#nfs PersistentVolume#nfs}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder nfs(java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceNfs> nfs) {
            this.nfs = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceNfs>)nfs;
            return this;
        }

        /**
         * Sets the value of {@link PersistentVolumeSpecPersistentVolumeSource#getPhotonPersistentDisk}
         * @param photonPersistentDisk photon_persistent_disk block.
         *                             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#photon_persistent_disk PersistentVolume#photon_persistent_disk}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder photonPersistentDisk(java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourcePhotonPersistentDisk> photonPersistentDisk) {
            this.photonPersistentDisk = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourcePhotonPersistentDisk>)photonPersistentDisk;
            return this;
        }

        /**
         * Sets the value of {@link PersistentVolumeSpecPersistentVolumeSource#getQuobyte}
         * @param quobyte quobyte block.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#quobyte PersistentVolume#quobyte}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder quobyte(java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceQuobyte> quobyte) {
            this.quobyte = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceQuobyte>)quobyte;
            return this;
        }

        /**
         * Sets the value of {@link PersistentVolumeSpecPersistentVolumeSource#getRbd}
         * @param rbd rbd block.
         *            Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#rbd PersistentVolume#rbd}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder rbd(java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceRbd> rbd) {
            this.rbd = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceRbd>)rbd;
            return this;
        }

        /**
         * Sets the value of {@link PersistentVolumeSpecPersistentVolumeSource#getVsphereVolume}
         * @param vsphereVolume vsphere_volume block.
         *                      Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#vsphere_volume PersistentVolume#vsphere_volume}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder vsphereVolume(java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceVsphereVolume> vsphereVolume) {
            this.vsphereVolume = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceVsphereVolume>)vsphereVolume;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link PersistentVolumeSpecPersistentVolumeSource}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public PersistentVolumeSpecPersistentVolumeSource build() {
            return new Jsii$Proxy(awsElasticBlockStore, azureDisk, azureFile, cephFs, cinder, csi, fc, flexVolume, flocker, gcePersistentDisk, glusterfs, hostPath, iscsi, local, nfs, photonPersistentDisk, quobyte, rbd, vsphereVolume);
        }
    }

    /**
     * An implementation for {@link PersistentVolumeSpecPersistentVolumeSource}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements PersistentVolumeSpecPersistentVolumeSource {
        private final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceAwsElasticBlockStore> awsElasticBlockStore;
        private final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceAzureDisk> azureDisk;
        private final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceAzureFile> azureFile;
        private final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceCephFs> cephFs;
        private final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceCinder> cinder;
        private final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceCsi> csi;
        private final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceFc> fc;
        private final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceFlexVolume> flexVolume;
        private final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceFlocker> flocker;
        private final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceGcePersistentDisk> gcePersistentDisk;
        private final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceGlusterfs> glusterfs;
        private final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceHostPath> hostPath;
        private final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceIscsi> iscsi;
        private final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceLocal> local;
        private final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceNfs> nfs;
        private final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourcePhotonPersistentDisk> photonPersistentDisk;
        private final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceQuobyte> quobyte;
        private final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceRbd> rbd;
        private final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceVsphereVolume> vsphereVolume;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.awsElasticBlockStore = software.amazon.jsii.Kernel.get(this, "awsElasticBlockStore", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceAwsElasticBlockStore.class)));
            this.azureDisk = software.amazon.jsii.Kernel.get(this, "azureDisk", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceAzureDisk.class)));
            this.azureFile = software.amazon.jsii.Kernel.get(this, "azureFile", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceAzureFile.class)));
            this.cephFs = software.amazon.jsii.Kernel.get(this, "cephFs", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceCephFs.class)));
            this.cinder = software.amazon.jsii.Kernel.get(this, "cinder", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceCinder.class)));
            this.csi = software.amazon.jsii.Kernel.get(this, "csi", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceCsi.class)));
            this.fc = software.amazon.jsii.Kernel.get(this, "fc", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceFc.class)));
            this.flexVolume = software.amazon.jsii.Kernel.get(this, "flexVolume", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceFlexVolume.class)));
            this.flocker = software.amazon.jsii.Kernel.get(this, "flocker", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceFlocker.class)));
            this.gcePersistentDisk = software.amazon.jsii.Kernel.get(this, "gcePersistentDisk", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceGcePersistentDisk.class)));
            this.glusterfs = software.amazon.jsii.Kernel.get(this, "glusterfs", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceGlusterfs.class)));
            this.hostPath = software.amazon.jsii.Kernel.get(this, "hostPath", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceHostPath.class)));
            this.iscsi = software.amazon.jsii.Kernel.get(this, "iscsi", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceIscsi.class)));
            this.local = software.amazon.jsii.Kernel.get(this, "local", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceLocal.class)));
            this.nfs = software.amazon.jsii.Kernel.get(this, "nfs", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceNfs.class)));
            this.photonPersistentDisk = software.amazon.jsii.Kernel.get(this, "photonPersistentDisk", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourcePhotonPersistentDisk.class)));
            this.quobyte = software.amazon.jsii.Kernel.get(this, "quobyte", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceQuobyte.class)));
            this.rbd = software.amazon.jsii.Kernel.get(this, "rbd", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceRbd.class)));
            this.vsphereVolume = software.amazon.jsii.Kernel.get(this, "vsphereVolume", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceVsphereVolume.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceAwsElasticBlockStore> awsElasticBlockStore, final java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceAzureDisk> azureDisk, final java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceAzureFile> azureFile, final java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceCephFs> cephFs, final java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceCinder> cinder, final java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceCsi> csi, final java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceFc> fc, final java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceFlexVolume> flexVolume, final java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceFlocker> flocker, final java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceGcePersistentDisk> gcePersistentDisk, final java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceGlusterfs> glusterfs, final java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceHostPath> hostPath, final java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceIscsi> iscsi, final java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceLocal> local, final java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceNfs> nfs, final java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourcePhotonPersistentDisk> photonPersistentDisk, final java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceQuobyte> quobyte, final java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceRbd> rbd, final java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceVsphereVolume> vsphereVolume) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.awsElasticBlockStore = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceAwsElasticBlockStore>)awsElasticBlockStore;
            this.azureDisk = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceAzureDisk>)azureDisk;
            this.azureFile = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceAzureFile>)azureFile;
            this.cephFs = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceCephFs>)cephFs;
            this.cinder = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceCinder>)cinder;
            this.csi = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceCsi>)csi;
            this.fc = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceFc>)fc;
            this.flexVolume = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceFlexVolume>)flexVolume;
            this.flocker = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceFlocker>)flocker;
            this.gcePersistentDisk = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceGcePersistentDisk>)gcePersistentDisk;
            this.glusterfs = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceGlusterfs>)glusterfs;
            this.hostPath = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceHostPath>)hostPath;
            this.iscsi = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceIscsi>)iscsi;
            this.local = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceLocal>)local;
            this.nfs = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceNfs>)nfs;
            this.photonPersistentDisk = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourcePhotonPersistentDisk>)photonPersistentDisk;
            this.quobyte = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceQuobyte>)quobyte;
            this.rbd = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceRbd>)rbd;
            this.vsphereVolume = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceVsphereVolume>)vsphereVolume;
        }

        @Override
        public final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceAwsElasticBlockStore> getAwsElasticBlockStore() {
            return this.awsElasticBlockStore;
        }

        @Override
        public final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceAzureDisk> getAzureDisk() {
            return this.azureDisk;
        }

        @Override
        public final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceAzureFile> getAzureFile() {
            return this.azureFile;
        }

        @Override
        public final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceCephFs> getCephFs() {
            return this.cephFs;
        }

        @Override
        public final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceCinder> getCinder() {
            return this.cinder;
        }

        @Override
        public final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceCsi> getCsi() {
            return this.csi;
        }

        @Override
        public final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceFc> getFc() {
            return this.fc;
        }

        @Override
        public final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceFlexVolume> getFlexVolume() {
            return this.flexVolume;
        }

        @Override
        public final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceFlocker> getFlocker() {
            return this.flocker;
        }

        @Override
        public final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceGcePersistentDisk> getGcePersistentDisk() {
            return this.gcePersistentDisk;
        }

        @Override
        public final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceGlusterfs> getGlusterfs() {
            return this.glusterfs;
        }

        @Override
        public final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceHostPath> getHostPath() {
            return this.hostPath;
        }

        @Override
        public final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceIscsi> getIscsi() {
            return this.iscsi;
        }

        @Override
        public final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceLocal> getLocal() {
            return this.local;
        }

        @Override
        public final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceNfs> getNfs() {
            return this.nfs;
        }

        @Override
        public final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourcePhotonPersistentDisk> getPhotonPersistentDisk() {
            return this.photonPersistentDisk;
        }

        @Override
        public final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceQuobyte> getQuobyte() {
            return this.quobyte;
        }

        @Override
        public final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceRbd> getRbd() {
            return this.rbd;
        }

        @Override
        public final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSourceVsphereVolume> getVsphereVolume() {
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
            if (this.getCsi() != null) {
                data.set("csi", om.valueToTree(this.getCsi()));
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
            if (this.getNfs() != null) {
                data.set("nfs", om.valueToTree(this.getNfs()));
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
            if (this.getVsphereVolume() != null) {
                data.set("vsphereVolume", om.valueToTree(this.getVsphereVolume()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.PersistentVolumeSpecPersistentVolumeSource"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PersistentVolumeSpecPersistentVolumeSource.Jsii$Proxy that = (PersistentVolumeSpecPersistentVolumeSource.Jsii$Proxy) o;

            if (this.awsElasticBlockStore != null ? !this.awsElasticBlockStore.equals(that.awsElasticBlockStore) : that.awsElasticBlockStore != null) return false;
            if (this.azureDisk != null ? !this.azureDisk.equals(that.azureDisk) : that.azureDisk != null) return false;
            if (this.azureFile != null ? !this.azureFile.equals(that.azureFile) : that.azureFile != null) return false;
            if (this.cephFs != null ? !this.cephFs.equals(that.cephFs) : that.cephFs != null) return false;
            if (this.cinder != null ? !this.cinder.equals(that.cinder) : that.cinder != null) return false;
            if (this.csi != null ? !this.csi.equals(that.csi) : that.csi != null) return false;
            if (this.fc != null ? !this.fc.equals(that.fc) : that.fc != null) return false;
            if (this.flexVolume != null ? !this.flexVolume.equals(that.flexVolume) : that.flexVolume != null) return false;
            if (this.flocker != null ? !this.flocker.equals(that.flocker) : that.flocker != null) return false;
            if (this.gcePersistentDisk != null ? !this.gcePersistentDisk.equals(that.gcePersistentDisk) : that.gcePersistentDisk != null) return false;
            if (this.glusterfs != null ? !this.glusterfs.equals(that.glusterfs) : that.glusterfs != null) return false;
            if (this.hostPath != null ? !this.hostPath.equals(that.hostPath) : that.hostPath != null) return false;
            if (this.iscsi != null ? !this.iscsi.equals(that.iscsi) : that.iscsi != null) return false;
            if (this.local != null ? !this.local.equals(that.local) : that.local != null) return false;
            if (this.nfs != null ? !this.nfs.equals(that.nfs) : that.nfs != null) return false;
            if (this.photonPersistentDisk != null ? !this.photonPersistentDisk.equals(that.photonPersistentDisk) : that.photonPersistentDisk != null) return false;
            if (this.quobyte != null ? !this.quobyte.equals(that.quobyte) : that.quobyte != null) return false;
            if (this.rbd != null ? !this.rbd.equals(that.rbd) : that.rbd != null) return false;
            return this.vsphereVolume != null ? this.vsphereVolume.equals(that.vsphereVolume) : that.vsphereVolume == null;
        }

        @Override
        public final int hashCode() {
            int result = this.awsElasticBlockStore != null ? this.awsElasticBlockStore.hashCode() : 0;
            result = 31 * result + (this.azureDisk != null ? this.azureDisk.hashCode() : 0);
            result = 31 * result + (this.azureFile != null ? this.azureFile.hashCode() : 0);
            result = 31 * result + (this.cephFs != null ? this.cephFs.hashCode() : 0);
            result = 31 * result + (this.cinder != null ? this.cinder.hashCode() : 0);
            result = 31 * result + (this.csi != null ? this.csi.hashCode() : 0);
            result = 31 * result + (this.fc != null ? this.fc.hashCode() : 0);
            result = 31 * result + (this.flexVolume != null ? this.flexVolume.hashCode() : 0);
            result = 31 * result + (this.flocker != null ? this.flocker.hashCode() : 0);
            result = 31 * result + (this.gcePersistentDisk != null ? this.gcePersistentDisk.hashCode() : 0);
            result = 31 * result + (this.glusterfs != null ? this.glusterfs.hashCode() : 0);
            result = 31 * result + (this.hostPath != null ? this.hostPath.hashCode() : 0);
            result = 31 * result + (this.iscsi != null ? this.iscsi.hashCode() : 0);
            result = 31 * result + (this.local != null ? this.local.hashCode() : 0);
            result = 31 * result + (this.nfs != null ? this.nfs.hashCode() : 0);
            result = 31 * result + (this.photonPersistentDisk != null ? this.photonPersistentDisk.hashCode() : 0);
            result = 31 * result + (this.quobyte != null ? this.quobyte.hashCode() : 0);
            result = 31 * result + (this.rbd != null ? this.rbd.hashCode() : 0);
            result = 31 * result + (this.vsphereVolume != null ? this.vsphereVolume.hashCode() : 0);
            return result;
        }
    }
}
