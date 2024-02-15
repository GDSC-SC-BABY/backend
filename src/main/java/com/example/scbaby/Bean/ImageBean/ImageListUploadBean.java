package com.example.scbaby.Bean.ImageBean;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ImageListUploadBean {
    @Value("${spring.cloud.gcp.storage.credentials.location}")
    private String keyFileName;

    @Value("${spring.cloud.gcp.storage.bucket}")
    private String bucketName;

    public List<String> exec(List<MultipartFile> multipartFiles) throws IOException {
        InputStream keyFile = ResourceUtils.getURL(keyFileName).openStream();

        Storage storage = StorageOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(keyFile))
                .build()
                .getService();

        return multipartFiles.stream()
                .map(multipartFile -> uploadImageToStorage(storage, multipartFile))
                .collect(Collectors.toList());
    }

    private String uploadImageToStorage(Storage storage, MultipartFile multipartFile) {
        if (multipartFile.isEmpty()) {
            return null;
        }

        try {
            String uuid = UUID.randomUUID().toString();
            String ext = multipartFile.getContentType();

            BlobInfo blobInfo = BlobInfo.newBuilder(bucketName, uuid)
                    .setContentType(ext).build();

            Blob blob = storage.create(blobInfo, multipartFile.getInputStream());

            return "https://storage.googleapis.com/" + bucketName + "/" + uuid;
        } catch (IOException e) {
            // Handle exception or log error
            e.printStackTrace();
            return null;
        }
    }
}
