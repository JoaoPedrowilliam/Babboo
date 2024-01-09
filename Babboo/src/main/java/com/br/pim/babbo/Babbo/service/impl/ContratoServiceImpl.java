package com.br.pim.babbo.Babbo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.pim.babbo.Babbo.model.Contrato;
import com.br.pim.babbo.Babbo.model.Funcionario;
import com.br.pim.babbo.Babbo.repository.ContratoRepository;
import com.br.pim.babbo.Babbo.service.ContratoService;
import com.br.pim.babbo.Babbo.service.FuncionarioService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContratoServiceImpl implements ContratoService {

    @Autowired
    private  ContratoRepository contratoRepository;

    @Autowired
    private FuncionarioService funcionarioService;


    public Contrato findById(Long id){
        Optional<Contrato> contrato = this.contratoRepository.findById(id);
        
        return contrato.orElseThrow(()->  new RuntimeException(
         "Contrato nao encontrado! Id:"+ id+", Tipo"+ Contrato.class.getName()));
    }


    @Transactional
    @Override
    public Contrato criarContrato(Contrato contrato) {
        Funcionario funcionario = funcionarioService.findFuncionario(contrato.getFuncionario().getFuncionarioId())
        .orElseThrow(() -> new RuntimeException("Funcionário não encontrado para criar contrato."));

        contrato.setContratoId(null);
        contrato.setFuncionario(funcionario);
        return contratoRepository.save(contrato);
    }
    @Override
    public Contrato atualizarContrato(Contrato contrato) {
         Contrato existingContrato = contratoRepository.findById(contrato.getContratoId())
            .orElseThrow(() -> new RuntimeException("Contrato não encontrado: " + contrato.getContratoId()));

        // Atualize os campos relevantes do contrato existente com os valores do contrato recebido
        existingContrato.setDepartamento(contrato.getDepartamento());
        existingContrato.setTipo(contrato.getTipo());
        existingContrato.setCargo(contrato.getCargo());
        existingContrato.setSalarioBruto(contrato.getSalarioBruto());

        // Salve as alterações no banco de dados
        return contratoRepository.save(existingContrato);
    }

    @Override
    public Contrato demitir(Contrato contrato) {
        Contrato novocontrato = contratoRepository.findById(contrato.getContratoId()).orElseThrow(() -> new RuntimeException("Contrato não encontrado: " + contrato.getContratoId()));
        return contratoRepository.save(novocontrato);
    }


    @Override
    public List<Contrato> buscarContratos() {
        return contratoRepository.findAll();
    }

}
