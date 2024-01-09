package com.br.pim.babbo.Babbo.service;


import java.util.List;

import com.br.pim.babbo.Babbo.model.Contrato;

public interface ContratoService {

    List<Contrato> buscarContratos();
    
    Contrato criarContrato(Contrato contrato);
    
    Contrato atualizarContrato(Contrato contrato);

    Contrato demitir(Contrato contrato);
}
