package com.gml.cursomc.dto;

import java.util.Objects;

public class bucketDTO {

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

    public bucketDTO() {
    }

    public bucketDTO(String name, String bucket, String generation, String metageneration, String contentType, String timeCreated, String updated, String storageClass, String size, String md5Hash, String contentEncoding, String contentDisposition, String crc32c, String etag, String downloadTokens) {
        this.name = name;
        this.bucket = bucket;
        this.generation = generation;
        this.metageneration = metageneration;
        this.contentType = contentType;
        this.timeCreated = timeCreated;
        this.updated = updated;
        this.storageClass = storageClass;
        this.size = size;
        this.md5Hash = md5Hash;
        this.contentEncoding = contentEncoding;
        this.contentDisposition = contentDisposition;
        this.crc32c = crc32c;
        this.etag = etag;
        this.downloadTokens = downloadTokens;
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

    public String getDownloadTokens() {
        return downloadTokens;
    }

    public void setDownloadTokens(String downloadTokens) {
        this.downloadTokens = downloadTokens;
    }

}