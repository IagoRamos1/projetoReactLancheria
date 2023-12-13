package com.lancheria.lancheria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lancheria.lancheria.entities.Pedido;
import com.lancheria.lancheria.services.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @PostMapping("/cadastroPedido")
    public List<Pedido> cadastroPedido(Pedido pedido) {
        return pedidoService.cadastroPedido(pedido);
    }

    @GetMapping("/listarPedido")
    public List<Pedido> listarPedido() {
        return pedidoService.listarPedido();
    }

    @GetMapping("/buscaPedido")
    public Pedido buscarPedido(@RequestParam(value = "id") int id) {
        return pedidoService.buscaPedido(id);
    }

    // @PostMapping("/excluirPedido")
    // public List<Pedido> excluirPedido(@RequestParam(value = "id") int id) {
    // pedidoRepository.deleteById(id);
    // List<Pedido> pedidos = new ArrayList<>();
    // pedidos = pedidoRepository.findAll();
    // return pedidos;
    // }

    @DeleteMapping("/deletaPedido")
    public List<Pedido> deletaPedido(@RequestParam(value = "id") int id) {
        return pedidoService.deletaPedidos(id);
    }
}
