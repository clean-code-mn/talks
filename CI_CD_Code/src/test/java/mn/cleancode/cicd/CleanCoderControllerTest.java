package mn.chinoyunsoft.cc.clean;

import mn.chinoyunsoft.cc.clean.controller.CleanCoderController;
import mn.chinoyunsoft.cc.clean.model.CleanCoder;
import mn.chinoyunsoft.cc.clean.model.CleanCoders;
import mn.chinoyunsoft.cc.clean.repository.CleanCoderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestPropertySource(properties = {
        "spring.jpa.hibernate.ddl-auto=validate"
})
public class CleanCoderControllerTest {
    @InjectMocks CleanCoderController cleanCoderController;

    @Mock CleanCoderRepository cleanCoderRepository;

    @Test public void testAddCleanCoder() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        CleanCoder cleanCoder = new CleanCoder("Khangaikhuu", true);
        cleanCoder.setId(1);
        when(cleanCoderRepository.save(any(CleanCoder.class))).thenReturn(cleanCoder);

        CleanCoder cleanCodeAdd = new CleanCoder("Lokesh", true);
        ResponseEntity<Object> responseEntity = cleanCoderController.addCleanCoder(cleanCodeAdd);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
    }

    @Test public void testFindAll() {
        // given
        CleanCoder cleanCoder1 = new CleanCoder("Lokesh", true);
        CleanCoder cleanCoder2 = new CleanCoder("Khangaikhuu", true);
        List<CleanCoder> list = new ArrayList<CleanCoder>();
        list.addAll(Arrays.asList(cleanCoder1, cleanCoder2));

        when(cleanCoderRepository.findAll()).thenReturn(list);

        // when
        CleanCoders result = cleanCoderController.getCleanCoders();

        // then
        assertThat(result.getCleanCoderList().size()).isEqualTo(2);

        assertThat(result.getCleanCoderList().get(0).getCoderName()).isEqualTo(cleanCoder1.getCoderName());

        assertThat(result.getCleanCoderList().get(1).getCoderName()).isEqualTo(cleanCoder2.getCoderName());
    }

}