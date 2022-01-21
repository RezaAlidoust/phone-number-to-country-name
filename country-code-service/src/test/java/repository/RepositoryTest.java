package repository;

import com.gegidze.countrycodeserver.data.CountryCodesRepository;
import com.gegidze.countrycodeserver.data.CountryCodesRepositoryImpl;
import com.gegidze.countrycodeserver.entity.CountryCode;
import com.gegidze.countrycodeserver.entity.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static com.gegidze.countrycodeserver.helper.Helper.convertIntToDigitArray;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
public class RepositoryTest {
    @Mock
    Node root;

    @InjectMocks
    CountryCodesRepositoryImpl repository;

    @BeforeEach
    void setUp() {
        this.root = new Node();
    }

    @Test
    void insertWithPathTest() {
        ArrayList<CountryCode> countryCodes = new ArrayList<>();
        CountryCode c = new CountryCode();
        c.setCode(1);
        c.setCountry("USA");
        countryCodes.add(c);

        c = new CountryCode();
        c.setCode(22);
        c.setCountry("Iraq");
        countryCodes.add(c);

        for (CountryCode countryCode : countryCodes) {
            repository.insertWithPath(this.root, convertIntToDigitArray(countryCode.getCode()), countryCode.getCountry());
        }

        assertThat(this.root.getChildren().size(), is(equalTo(2)));
    }
}
