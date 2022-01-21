package controller;

import com.gegidze.countrycodeserver.controller.CountryCodeController;
import com.gegidze.countrycodeserver.dto.CountryCodeResponse;
import com.gegidze.countrycodeserver.service.CountryCodeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class CountryCodeControllerTest {
    @Mock
    CountryCodeService countryCodeService;

    @InjectMocks
    CountryCodeController countryCodeController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(countryCodeController).build();
    }

    @Test
    void getCorrect() throws Exception {
        given(countryCodeService.get("374990326214")).willReturn("Armenia");

        CountryCodeResponse response = countryCodeController.get("00374990326214");

        mockMvc.perform(get("/00374990326214"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }
}
