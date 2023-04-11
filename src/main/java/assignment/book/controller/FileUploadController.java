package assignment.book.controller;


import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.InputStreamContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.Permission;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/file")
public class FileUploadController {

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
//        GoogleCredentials credentials =  GoogleCredentials.getApplicationDefault()
//                .createScoped(Arrays.asList(DriveScopes.DRIVE_FILE));
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
        System.out.println("File URL: " + uploadedFile.getWebViewLink()); // hiển thị URL của file
        return uploadedFile.getWebViewLink();
    }
}
