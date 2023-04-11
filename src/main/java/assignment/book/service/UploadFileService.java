package assignment.book.service;

import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.InputStreamContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
@Service
public class UploadFileService {
    public String uploadFile(MultipartFile file)  {
        try {
        GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream("C:/Users/p/Downloads/credentials.json"))
                .createScoped(Arrays.asList(DriveScopes.DRIVE_FILE));
        HttpRequestInitializer requestInitializer = new HttpCredentialsAdapter(
                credentials);

        // Build a new authorized API client service.
        Drive service = new Drive.Builder(new NetHttpTransport(),
                GsonFactory.getDefaultInstance(),
                requestInitializer)
                .setApplicationName("Book")
                .build();

        String parentFolderId = "1VVCK3bWOiz-SJEktyehrtQHkEzi4JBE6";
        // Upload file from multipart request on drive.
        File fileMetadata = new File();
        fileMetadata.setName(file.getOriginalFilename());
        fileMetadata.setParents(Collections.singletonList(parentFolderId));

        // File's content.
        InputStreamContent mediaContent = new InputStreamContent(
                file.getContentType(),
                new BufferedInputStream(file.getInputStream()));
        // Specify media type and file-name for file.
        File uploadedFile = service.files().create(fileMetadata, mediaContent)
                .setFields("webViewLink") // chỉ lấy trường webViewLink
                .execute();
        return uploadedFile.getWebViewLink();
        } catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }
}
