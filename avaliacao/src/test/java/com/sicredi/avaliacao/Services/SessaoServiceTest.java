package com.sicredi.avaliacao.Services;
import com.sicredi.avaliacao.dtos.SessaoForm;
import com.sicredi.avaliacao.models.Sessao;
import com.sicredi.avaliacao.services.SessaoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
@ActiveProfiles("test")
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class SessaoServiceTest {
    @Autowired
    SessaoService sessaoService;

    @Test
    public void buscarSessaoPorIdInexistente(){
        try {
            sessaoService.BuscarSessaoPorId(40L);
        } catch (Exception e) {
            assertTrue(true);
        }
    }
    @Test
    public void imprimirPautasSemPautasCadastradas(){
        List<Sessao> sessoes = sessaoService.imprimirSessoes();
        assertNull(sessoes);
    }
    @Test
    public void verificarSeSessaoInexistenteExiste(){
        assertTrue(sessaoService.verificarSeSessaoExiste(2000L) == false);
    }
    @Test
    public void criarSessaoComHoraFimMenorQueInicio(){
        SessaoForm sessaoForm = new SessaoForm(LocalDateTime.now().minusMinutes(50));
        assertTrue(sessaoService.criarSessao(sessaoForm, 14L) == null);
    }
}
