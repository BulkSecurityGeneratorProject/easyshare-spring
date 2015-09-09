package au.com.suncorp.easyshare.rest;

import au.com.suncorp.easyshare.EasyshareApplication;
import au.com.suncorp.easyshare.TestUtil;
import au.com.suncorp.easyshare.api.UploadController;
import au.com.suncorp.easyshare.api.dto.UploadDTO;
import au.com.suncorp.easyshare.model.Upload;
import au.com.suncorp.easyshare.repository.UploadRepository;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.transaction.Transactional;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the UserResource REST controller.
 *
 * @see au.com.suncorp.easyshare.api.UploadController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EasyshareApplication.class)
@WebAppConfiguration
@IntegrationTest
public class FileUploadControllerTest {

    @Autowired
    private UploadRepository uploadRepository;

    @Autowired
    private MockMvc restFileMockMvc;

    @Test
    private void testFileUpload() {
        Upload upload = uploadRepository.save(new Upload("Decsription"));


    }
}
