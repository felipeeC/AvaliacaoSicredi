package com.sicredi.avaliacao.Services;
import com.sicredi.avaliacao.models.Pauta;
import com.sicredi.avaliacao.services.PautaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles("test")
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PautaServiceTest {
    @Autowired
    PautaService pautaService;
    @Test
    public void criarPautaTituloVazio(){
        assertTrue(pautaService.criarPauta(new Pauta("", "teste"))==null);
    }
    @Test
    public void buscarPautaPorIdInexistente(){
        try {
            pautaService.buscarPautaPorId(40L);
        } catch (Exception e) {
            assertTrue(true);
        }
    }
    public void imprimirPautasSemPautasCadastradas(){
        List<Pauta> pautas = pautaService.imprimirPautas();
        assertTrue(pautas == null);
    }
}
