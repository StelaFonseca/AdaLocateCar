package org.adalocatecar.servicos;

import org.adalocatecar.modelos.Cliente;

public interface RepositorioCliente {
    void cadastrarCliente();

    boolean verificarDuplicidade(long documento);

    Cliente buscarClientePorDocumento();

    void alterarCliente();
}