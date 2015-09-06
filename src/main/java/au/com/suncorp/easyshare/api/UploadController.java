////////////////////////////////////////////////////////////////////////////////
//
// Copyright (c) 2015, Suncorp Metway Limited. All rights reserved.
//
// This is unpublished proprietary source code of Suncorp Metway Limited.
// The copyright notice above does not evidence any actual or intended
// publication of such source code.
//
////////////////////////////////////////////////////////////////////////////////

package au.com.suncorp.easyshare.api;

import java.util.List;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import au.com.suncorp.easyshare.services.util.RandomUtil;

import au.com.suncorp.easyshare.model.Upload;
import au.com.suncorp.easyshare.repository.UploadRepository;

@RestController
@RequestMapping("/api/upload")
@Api(basePath = "/api/upload", value = "Upload", description = "Upload api", produces = "application/json")
public final class UploadController {

    @Autowired
    private UploadRepository repository;

    @RequestMapping(method = GET)
    @ApiOperation(value = "Get all uploads", notes = "Get all uploads")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "")})
    public List<Upload> getAllUploads() {
        return repository.findAll();
    }

    @RequestMapping(method = POST)
    public Upload createUpload() {
        String key = RandomUtil.generateString(24);
        String id = RandomUtil.generateInt(12);
        String description = "reece";

        return repository.save(new Upload(id, description, key));
    }

    @RequestMapping(method = GET, value = "/{key}")
    public Upload getUpload(@PathVariable String key) {
        return repository.findByKey(key);
    }

    @RequestMapping(method = DELETE, value = "/{key}")
    public void deleteUpload(@PathVariable String key) {
        repository.delete(key);
    }
}
