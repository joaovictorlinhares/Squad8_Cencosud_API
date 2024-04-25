package br.com.promocoes_api.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.promocoes_api.api.services.ProdutoService;
import br.com.promocoes_api.api.services.SecaoService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/API/Produto")
@AllArgsConstructor
public class ProdutoController {

    private final SecaoService secaoService;
    private final ProdutoService produtoService;

}
