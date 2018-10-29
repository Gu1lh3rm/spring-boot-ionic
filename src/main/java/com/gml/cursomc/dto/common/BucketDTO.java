package com.gml.cursomc.dto.common;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class BucketDTO implements Serializable {
    private static final long serialVersionUID =1L;

    private String name;
    private String bucket;
    private String generation;
    private String metageneration;
    private String contentType;
    private String timeCreated;
    private String updated;
    private String storageClass;
    private String size;
    private String md5Hash;
    private String contentEncoding;
    private String contentDisposition;
    private String crc32c;
    private String etag;
    private String downloadTokens;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 10, message = "O tamanho da hash deve ser maior que 10 caracteres")
    private String hash;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, message = "O tamanho do path deve ser maior que 5 caracteres")
    private String path;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 10, message = "O tamanho da downloadUrl deve ser maior que 10 caracteres")
    private String downloadUrl;


    public BucketDTO() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public String getMetageneration() {
        return metageneration;
    }

    public void setMetageneration(String metageneration) {
        this.metageneration = metageneration;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getStorageClass() {
        return storageClass;
    }

    public void setStorageClass(String storageClass) {
        this.storageClass = storageClass;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMd5Hash() {
        return md5Hash;
    }

    public void setMd5Hash(String md5Hash) {
        this.md5Hash = md5Hash;
    }

    public String getContentEncoding() {
        return contentEncoding;
    }

    public void setContentEncoding(String contentEncoding) {
        this.contentEncoding = contentEncoding;
    }

    public String getContentDisposition() {
        return contentDisposition;
    }

    public void setContentDisposition(String contentDisposition) {
        this.contentDisposition = contentDisposition;
    }

    public String getCrc32c() {
        return crc32c;
    }

    public void setCrc32c(String crc32c) {
        this.crc32c = crc32c;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getDownloadTokens() {
        return downloadTokens;
    }

    public void setDownloadTokens(String downloadTokens) {
        this.downloadTokens = downloadTokens;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BucketDTO{");
        sb.append("name='").append(name).append('\'');
        sb.append(", bucket='").append(bucket).append('\'');
        sb.append(", generation='").append(generation).append('\'');
        sb.append(", metageneration='").append(metageneration).append('\'');
        sb.append(", contentType='").append(contentType).append('\'');
        sb.append(", timeCreated='").append(timeCreated).append('\'');
        sb.append(", updated='").append(updated).append('\'');
        sb.append(", storageClass='").append(storageClass).append('\'');
        sb.append(", size='").append(size).append('\'');
        sb.append(", md5Hash='").append(md5Hash).append('\'');
        sb.append(", contentEncoding='").append(contentEncoding).append('\'');
        sb.append(", contentDisposition='").append(contentDisposition).append('\'');
        sb.append(", crc32c='").append(crc32c).append('\'');
        sb.append(", etag='").append(etag).append('\'');
        sb.append(", downloadTokens='").append(downloadTokens).append('\'');
        sb.append(", hash='").append(hash).append('\'');
        sb.append(", path='").append(path).append('\'');
        sb.append(", downloadUrl='").append(downloadUrl).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
