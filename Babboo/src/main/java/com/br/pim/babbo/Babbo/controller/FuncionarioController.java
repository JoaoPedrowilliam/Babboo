package com.br.pim.babbo.Babbo.controller;

import com.br.pim.babbo.Babbo.model.Contrato;
import com.br.pim.babbo.Babbo.model.Funcionario;
import com.br.pim.babbo.Babbo.model.Usuario;
import com.br.pim.babbo.Babbo.service.ContratoService;
import com.br.pim.babbo.Babbo.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private ContratoService contratoService;

    @GetMapping()
    public List<Funcionario> buscarFuncionarios() {
        return funcionarioService.findFuncionarios();
    }

    @GetMapping("/{funcionarioId}")
    public Optional<Funcionario> buscaFuncionario(@PathVariable("funcionarioId") Long funcionarioId) {
        return funcionarioService.findFuncionario(funcionarioId);
    }

    @PostMapping
    public Funcionario salvaFuncionario(@Validated @RequestBody Funcionario funcionario, Usuario usuarioId) {
        return funcionarioService.salvaFuncionario(funcionario);
    }

    @DeleteMapping("/{funcionarioId}")
    public void deletaFuncionario(@PathVariable("funcionarioId") Long funcionarioId) {
        funcionarioService.deletaFuncionario(funcionarioId);
    }

    @PutMapping("/{funcionarioId}")
    public ResponseEntity<Funcionario> atualizaFuncionario(@PathVariable("funcionarioId") Long funcionarioId, @RequestBody Funcionario funcionario) {
        return funcionarioService.atualizaFuncionario(funcionarioId, funcionario);
    }

    @GetMapping("/contrato")
    public List<Contrato> buscarContratos() {
        return contratoService.buscarContratos();
    }

    @PostMapping("/contrato")
    public Contrato criaContrato(@RequestBody Contrato contrato){
        return contratoService.criarContrato(contrato);
    }
}
