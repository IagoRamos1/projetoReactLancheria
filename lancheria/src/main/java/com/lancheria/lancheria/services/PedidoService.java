package com.lancheria.lancheria.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lancheria.lancheria.entities.Pedido;
import com.lancheria.lancheria.repository.PedidoRepository;

@Service
public class PedidoService {
    @Autowired
    PedidoRepository pedidoRepository;

    public List<Pedido> cadastroPedido(Pedido pedido) {
        List<Pedido> listaPedido = pedidoRepository.findAll();
        pedidoRepository.save(pedido);
        return listaPedido;
    }

    public List<Pedido> listarPedido() {
        List<Pedido> listaPedido = pedidoRepository.findAll();
        return listaPedido;
    }

    public Pedido buscaPedido(Integer id) {
        Pedido pedido = pedidoRepository.findById(id).get();
        return pedido;
    }

    public List<Pedido> deletaPedidos(Integer id) {
        pedidoRepository.deleteById(id);
        List<Pedido> pedidos = new ArrayList<>();
        pedidos = pedidoRepository.findAll();
        return pedidos;
    }
}
