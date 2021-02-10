package br.com.plannic;

import br.com.plannic.controller.UsuarioController;
import br.com.plannic.model.Usuario;
import br.com.plannic.repository.UsuarioRepository;
import br.com.plannic.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import java.util.Arrays;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

    @InjectMocks
    UsuarioController usuarioController;

    @Mock
    UsuarioService usuarioService;

    @Test
    public void adicionarUsuario(){

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Usuario usuario = new Usuario(1, "usuarioteste@gmail.com", "senha123", "Usuario Teste", LocalDateTime.now());
        ResponseEntity<Usuario> responseEntity = usuarioController.save(usuario);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
    }

    @Test
    public void encontrarUsuarios(){

        Usuario usuario = new Usuario(1, "usuarioteste@gmail.com", "senha123", "Usuario Teste", LocalDateTime.now());
        Usuario usuario2 = new Usuario(2, "usuarioteste2@gmail.com", "senha345", "Usuario Teste2", LocalDateTime.now());
        Usuario usuario3 = new Usuario(3, "usuariotest3@gmail.com", "senha567", "Usuario Teste3", LocalDateTime.now());

        ResponseEntity<Usuario> responseEntity = usuarioController.save(usuario);
        ResponseEntity<Usuario> responseEntity1 = usuarioController.save(usuario2);
        ResponseEntity<Usuario> responseEntity2 = usuarioController.save(usuario3);

        usuarioController.getAll();

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
        assertThat(responseEntity1.getStatusCodeValue()).isEqualTo(201);
        assertThat(responseEntity2.getStatusCodeValue()).isEqualTo(201);
    }

}
