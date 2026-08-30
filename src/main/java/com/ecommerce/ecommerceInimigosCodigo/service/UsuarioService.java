package com.ecommerce.ecommerceInimigosCodigo.service;

import com.ecommerce.ecommerceInimigosCodigo.dto.ListaUsuarioDTO;
import com.ecommerce.ecommerceInimigosCodigo.dto.UsuarioForm;
import com.ecommerce.ecommerceInimigosCodigo.model.UserRole;
import com.ecommerce.ecommerceInimigosCodigo.model.Usuario;
import com.ecommerce.ecommerceInimigosCodigo.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void cadastrarUsuario(UsuarioForm form) {
        if (!form.getSenha().equals(form.getVerificarSenha())){
            throw new IllegalArgumentException("A senha e a confirmaçao de senha não coincidem");
        }

        if (usuarioRepository.existsByEmail(form.getEmail())){
            throw new IllegalArgumentException("ja existe um usuario cadastrado com esse e-mail");
        }

        Usuario usuario = new Usuario();
        usuario.setEmail(form.getEmail());
        usuario.setSenha(passwordEncoder.encode(form.getSenha()));
        usuario.setNome(form.getNome());
        usuario.setCpf(form.getCpf());
        usuario.setGrupo(UserRole.ESTOQUISTA); // sempre estoquista no cadastro público, ignora form.getGrupo()
        usuario.setStatus(form.getStatus() == null || form.getStatus().isBlank() ? "ativo" : form.getStatus());

        usuarioRepository.save(usuario);
    }

    public List<ListaUsuarioDTO> listaUsuarios() {
        return usuarioRepository.findAllByOrderByNomeAsc()
                .stream()
                .map(usuario -> new ListaUsuarioDTO(
                        usuario.getNome(),
                        usuario.getEmail(),
                        usuario.getGrupo(),
                        usuario.getStatus()
                ))
                .collect(Collectors.toList());
    }
}