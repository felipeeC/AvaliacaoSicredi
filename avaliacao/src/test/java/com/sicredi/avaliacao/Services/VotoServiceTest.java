package com.sicredi.avaliacao.Services;
import com.sicredi.avaliacao.dtos.VotoForm;
import com.sicredi.avaliacao.services.VotoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertFalse;
@ActiveProfiles("test")
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class VotoServiceTest {
    @Autowired
    VotoService votoService;
    @Test
    public void votarComCpfErrado(){
        assertFalse(votoService.validarRequest(new VotoForm("1111","sim", 2L)));
    }
    @Test
    public void votarEmSessaoFechada(){
        assertFalse(votoService.validarRequest(new VotoForm("04432598018","sim", 2L)));
    }
    @Test
    public void votarSemResposta(){
        assertFalse(votoService.validarRequest(new VotoForm("04432598018","", 2L)));
    }
}
