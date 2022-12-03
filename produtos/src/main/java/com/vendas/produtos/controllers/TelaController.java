package com.vendas.produtos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vendas.produtos.main.Produto;
import com.vendas.produtos.services.ProdutoService;
import com.vendas.produtos.sql.ProdutoRepository;

import jakarta.validation.Valid;

@Controller
public class TelaController {

    @Autowired
    private ProdutoService service;

    @Autowired
    private ProdutoRepository repo;

    // Home
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "produto";
    }

    // Salvar
    @RequestMapping(value = "/salvar", method = RequestMethod.GET)
    public String telaSalvar(Produto produto) {
        return "/crud/salvar";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String salvarProduto(@Valid Produto produto, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("produto", produto);
            return telaSalvar(produto);
        }

        service.salvarProduto(produto);
        return "redirect:/salvar";
    }

    // Buscar
    @RequestMapping(value = "/buscar/{dados}", method = RequestMethod.GET)
    public ModelAndView buscarProduto(@PathVariable String dados) {

        Produto produto = service.buscarProduto(dados).orElse(null);
        ModelAndView setarProduto = new ModelAndView("/crud/buscar");

        if (produto != null) {
            setarProduto.addObject("Id", produto.getId());
            setarProduto.addObject("Codigo", produto.getCodigo());
            setarProduto.addObject("Data", produto.getData());
            setarProduto.addObject("Nome", produto.getNomeProduto());
            setarProduto.addObject("Quantidade", produto.getQuantidade());
            setarProduto.addObject("Valor", produto.getValor());
        }

        return setarProduto;
    }

    // BuscarTodos
    @RequestMapping(value = "/buscarTodos")
    public ModelAndView buscarTodos(Produto produto) {

        List<Produto> produtos = service.todosProdutos();

        ModelAndView setarTodos = new ModelAndView("/crud/todos");

        setarTodos.addObject("produto", produtos);

        return setarTodos;
    }

    //Atualizar Pela Aba Buscar Todos
    @RequestMapping(value = "/atualizar/{id}")
    public String atualizarProdutos(@PathVariable(name = "id") Integer id, Produto produto, BindingResult result,
            Model model) {


        service.salvarProduto(produto);
        return "redirect:/buscarTodos";
    }

    //Pagina de Atualizar, (GET)
    @RequestMapping(value = "/produto/atualizar/{dados}", method = RequestMethod.GET)
    public ModelAndView buscaAtualizar(@PathVariable(name = "dados") String dados) {

        Produto produto = service.buscarProduto(dados).orElse(null);
        ModelAndView mv = new ModelAndView("/crud/atualizar");

        if(produto != null) {
            mv.addObject("produto", produto);
        }

        return mv;
    }

    //Atualiza o produto pela pagina de Atualizar, (POST)
    @RequestMapping(value = "/atualizar/produto/{id}", method = RequestMethod.POST)
    public String atualizarProduto(@PathVariable(value = "id") Integer id, @ModelAttribute("produto") Produto produto) {
        service.salvarProduto(produto);
        return "redirect:/";
    }

    @RequestMapping(value = "/excluir/produto/{dados}")
    public ModelAndView telaDeletarProduto(@PathVariable(value = "dados") String dados) {
        

        Produto produto = service.buscarProduto(dados).orElse(null);
        ModelAndView setarProduto = new ModelAndView("/crud/deletar");

        if (produto != null) {
            setarProduto.addObject("Id", produto.getId());
            setarProduto.addObject("Codigo", produto.getCodigo());
            setarProduto.addObject("Data", produto.getData());
            setarProduto.addObject("Nome", produto.getNomeProduto());
            setarProduto.addObject("Quantidade", produto.getQuantidade());
            setarProduto.addObject("Valor", produto.getValor());
        }

        return setarProduto;
    }

    @RequestMapping(value = "/produto/{id}/excluir")
    public String excluir(@PathVariable(value = "id") Integer id) {
        repo.deleteById(id);
        return "redirect:/";
    }

    @GetMapping(value = "/excluir/{id}")
    public String excluirProduto(@PathVariable(value = "id") Integer id) {
        service.exluirProduto(id);
        return "redirect:/";
    }
}
