package com.example.scbaby.Bean.ImageBean;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
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
import java.nio.ByteBuffer;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ImageListUpdateBean {
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
                .map(multipartFile -> updateImageInStorage(storage, multipartFile))
                .collect(Collectors.toList());
    }

    private String updateImageInStorage(Storage storage, MultipartFile multipartFile) {
        if (multipartFile.isEmpty()) {
            return null;
        }

        try {
            String uuid = UUID.randomUUID().toString();
            String ext = multipartFile.getContentType();

            BlobId blobId = BlobId.of(bucketName, uuid);
            Blob existingBlob = storage.get(blobId);

            if (existingBlob != null) {
                existingBlob.writer().write(ByteBuffer.wrap(multipartFile.getBytes()));
            } else {
                BlobInfo blobInfo = BlobInfo.newBuilder(bucketName, uuid)
                        .setContentType(ext).build();

                Blob blob = storage.create(blobInfo, multipartFile.getBytes());
            }

            return "https://storage.googleapis.com/" + bucketName + "/" + uuid;
        } catch (IOException e) {
            // Handle exception or log error
            e.printStackTrace();
            return null;
        }
    }
}
