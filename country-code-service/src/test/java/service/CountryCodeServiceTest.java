package service;

import com.gegidze.countrycodeserver.data.CountryCodesRepository;
import com.gegidze.countrycodeserver.exception.NotFoundException;
import com.gegidze.countrycodeserver.service.CountryCodeService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CountryCodeServiceTest {

    @Mock
    CountryCodesRepository repository;

    @InjectMocks
    CountryCodeService countryCodeService;

    @Test
    void getCorrect() {
        ArrayList<Long> armenia = new ArrayList<>();
        armenia.add(3L);
        armenia.add(7L);
        armenia.add(4L);
        armenia.add(9L);
        armenia.add(9L);
        armenia.add(0L);
        armenia.add(8L);
        armenia.add(4L);
        armenia.add(0L);
        armenia.add(9L);
        armenia.add(9L);
        armenia.add(4L);
        given(repository.get(armenia)).willReturn("Armenia");
        String country = countryCodeService.get("374990840994");
        verify(repository).get(armenia);
        assertThat(country, is(equalTo("Armenia")));
    }

    @Test
    void getEmpty() {
        ArrayList<Long> tempNull = new ArrayList<>();
        tempNull.add(1L);
        tempNull.add(7L);
        tempNull.add(4L);
        tempNull.add(9L);
        tempNull.add(9L);
        tempNull.add(0L);
        tempNull.add(8L);
        tempNull.add(4L);
        tempNull.add(0L);
        tempNull.add(9L);
        tempNull.add(9L);
        tempNull.add(4L);
        given(repository.get(tempNull)).willReturn(null);
        NotFoundException thrown = assertThrows(NotFoundException.class, () -> {
            countryCodeService.get("174990840994");
        });

        verify(repository).get(tempNull);
        assertThat(thrown.getMessage(), is(equalTo("There is no country matches with your phone number")));
    }
}
