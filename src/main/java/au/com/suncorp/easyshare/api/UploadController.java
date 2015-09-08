package au.com.suncorp.easyshare.api;

import java.util.List;
import java.util.Optional;

import au.com.suncorp.easyshare.api.dto.UploadDTO;
import ch.qos.logback.core.db.dialect.SybaseSqlAnywhereDialect;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import au.com.suncorp.easyshare.model.Upload;
import au.com.suncorp.easyshare.repository.UploadRepository;

import javax.servlet.http.HttpServletRequest;
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
    public ResponseEntity<?> createUpload(@RequestBody @Valid UploadDTO body) {
        System.out.println(body.getDescription());
        Upload upload = uploadRepository.save(new Upload(body.getDescription()));

        return new ResponseEntity<>(upload, HttpStatus.CREATED);
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
