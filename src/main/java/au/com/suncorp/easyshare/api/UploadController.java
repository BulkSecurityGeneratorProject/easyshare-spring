package au.com.suncorp.easyshare.api;

import java.util.List;
import java.util.Optional;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import au.com.suncorp.easyshare.model.Upload;
import au.com.suncorp.easyshare.repository.UploadRepository;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/uploads")
@Api(basePath = "/api/uploads", value = "Upload", description = "Upload api", produces = "application/json")
public final class UploadController {

    @Autowired
    private UploadRepository uploadRepository;

    @RequestMapping(method = GET)
    @ApiOperation(value = "Get all uploads", notes = "Get all uploads")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "")})
    public List<Upload> getAllUploads() {
        return uploadRepository.findAll();
    }

    @RequestMapping(method = POST)
    public Upload createUpload(@RequestBody @Valid Upload upload) {
        return uploadRepository.save(upload);
    }

    @RequestMapping(method = GET, value = "/{key}")
    public Upload getUpload(@PathVariable String key) {
        return uploadRepository.findByKey(key);
    }

    @RequestMapping(method = DELETE, value = "/{key}")
    public void deleteUpload(@PathVariable String key) {
        uploadRepository.delete(key);
    }
}
