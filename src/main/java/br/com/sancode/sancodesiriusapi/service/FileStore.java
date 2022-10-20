package br.com.sancode.sancodesiriusapi.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Optional;

@Service
public class FileStore {
    private final AmazonS3 s3;

    @Autowired
    public FileStore(AmazonS3 s3) {
        this.s3 = s3;
    }

    public void save(String path,
                     String fileName,
                     Optional<Map<String, String>> optionalMetadata,
                     InputStream inputStream){
        ObjectMetadata metadata = new ObjectMetadata();

        optionalMetadata.ifPresent(map ->{
            if (!map.isEmpty()) {
                map.forEach(metadata::addUserMetadata);
            }
        });

        try {
            s3.putObject(path, fileName, inputStream, metadata);
        }catch (AmazonServiceException e) {
            throw new IllegalStateException("Acesso ao S3 falhou", e);
        }
    }

    public byte[] download(String path, String imageLink) {
        try{
            S3Object object =  s3.getObject(path, imageLink);
            return IOUtils.toByteArray(object.getObjectContent());
        }catch (AmazonServiceException | IOException e) {
            throw new IllegalStateException("Falha ao fazer download do arquivo no s3", e);
        }
    }
}