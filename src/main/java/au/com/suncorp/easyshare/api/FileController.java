package au.com.suncorp.easyshare.api;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import au.com.suncorp.easyshare.model.Upload;
import au.com.suncorp.easyshare.model.FileMetadata;

import au.com.suncorp.easyshare.repository.FileMetadataRepository;
import au.com.suncorp.easyshare.repository.UploadRepository;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/api/uploads/{key}/file")
@Api(basePath = "/api/uploads/file", value = "File", description = "FileMetadata API", produces = "application/json")
public class FileController {

    @Autowired
    private UploadRepository uploadRepository;

    @Autowired
    private FileMetadataRepository fileMetadataRepository;

    @RequestMapping(method = POST)
    @ApiOperation(value = "Multipart file upload", notes = "Upload a file to an ID")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "") })
    public @ResponseBody String uploadFile(@RequestParam("file") MultipartFile file, @PathVariable String key) {

        // Check that upload exists
        // Store File
        // Add File metadata to upload
        // Respond

        Upload upload = uploadRepository.findByKey(key);

        if (upload == null) {
            return "No matching upload found";
        }

        if (file == null || file.isEmpty()) {
            System.out.println("##### \n Null file \n #####");
            return "false";
        }

        // Record file metadata
        UUID fileID = UUID.randomUUID();
        String filename = file.getName();
        String contentType = file.getContentType();
        long contentLength = file.getSize();

        try {
            byte[] bytes = file.getBytes();
            BufferedOutputStream stream =
                    new BufferedOutputStream(new FileOutputStream(new File(fileID.toString())));
            stream.write(bytes);
            stream.close();
        } catch (Exception e) {
            return "You failed to upload " + upload.getKey() + " => " + e.getMessage();
        }

        FileMetadata metadata = new FileMetadata(fileID, filename, contentType, contentLength);

        fileMetadataRepository.save(metadata);

        return "AEGeag";
    }

    @RequestMapping(method = GET, value = "/{ID}")
    @ApiOperation(value = "Get all uploads", notes = "Get all uploads")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "")})
    public List<Upload> downloadFile(@PathVariable String ID) {
        return uploadRepository.findAll();
    }

    @RequestMapping(method = DELETE)
    @ApiOperation(value = "Delete file", notes = "Delete file from upload")
    @ApiResponses(value = {@ApiResponse(code = 204, message = "OK")})
    public List<Upload> deleteFile() {
        return uploadRepository.findAll();
    }
}
