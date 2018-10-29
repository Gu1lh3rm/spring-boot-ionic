package com.gml.cursomc.dto;

import com.gml.cursomc.dto.common.BucketDTO;

import java.io.Serializable;
import java.util.List;


public class ProdutoFileNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer produtoId;

    private List<FileNewDTO> files;


    public Integer getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
    }

    public List<FileNewDTO> getFiles() {
        return files;
    }

    public void setFiles(List<FileNewDTO> files) {
        this.files = files;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProdutoFileNewDTO{");
        sb.append("produtoId=").append(produtoId).append(',').append('\'');
        sb.append("files : [");
        getFiles().forEach( objFile -> {
            sb.append("{ ").append(objFile.getName()).append('\'');
            sb.append(", bucket='").append(objFile.getBucket()).append('\'');
            sb.append(", generation='").append(objFile.getGeneration()).append('\'');
            sb.append(", metageneration='").append(objFile.getMetageneration()).append('\'');
            sb.append(", contentType='").append(objFile.getContentType()).append('\'');
            sb.append(", timeCreated='").append(objFile.getTimeCreated()).append('\'');
            sb.append(", updated='").append(objFile.getUpdated()).append('\'');
            sb.append(", storageClass='").append(objFile.getStorageClass()).append('\'');
            sb.append(", size='").append(objFile.getSize()).append('\'');
            sb.append(", md5Hash='").append(objFile.getMd5Hash()).append('\'');
            sb.append(", contentEncoding='").append(objFile.getContentEncoding()).append('\'');
            sb.append(", contentDisposition='").append(objFile.getContentDisposition()).append('\'');
            sb.append(", crc32c='").append(objFile.getCrc32c()).append('\'');
            sb.append(", etag='").append(objFile.getEtag()).append('\'');
            sb.append(", downloadTokens='").append(objFile.getDownloadTokens()).append('\'');
            sb.append(", hash='").append(objFile.getHash()).append('\'');
            sb.append(", path='").append(objFile.getPath()).append('\'');
            sb.append(", downloadUrl='").append(objFile.getDownloadTokens()).append('\'');
            sb.append("} ").append(objFile.getName()).append('\'');
        });

        sb.append("] ").append('\'');
        sb.append('}');
        return sb.toString();
    }
}
