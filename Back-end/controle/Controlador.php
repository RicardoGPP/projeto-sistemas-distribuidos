<?php
    require_once __DIR__ . "/../modelo/dao/PessoaDAO.php";
    
    class Controlador
    {        
        private $pessoaDAO;
        
        public function __construct()
        {
            $this -> pessoaDAO = new PessoaDAO();
        }

        public function buscarPessoa($codigo)
        {
            return $this -> pessoaDAO -> obterRegistro($codigo);
        }
        
        public function listarPessoas()
        {
            return $this -> pessoaDAO -> obterLista();
        }
    }
?>