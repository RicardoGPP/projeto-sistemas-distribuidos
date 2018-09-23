<?php
    require_once __DIR__ . "/../../util/AtributoNaoEncontradoException.php";
    require_once __DIR__ . "/Entidade.php";
    require_once __DIR__ . "/Estado.php";

    class Cidade extends Entidade
    {
        private $nome;
        private $estado;

        public function __get($atributo)
        {
            switch ($atributo)
            {
                case "codigo": return $this -> codigo;
                case "nome": return $this -> nome;
                case "estado": return $this -> estado;
                default: throw new AtributoNaoEncontradoException($atributo);
            }
        }

        public function __set($atributo, $valor)
        {
            switch ($atributo)
            {
                case "codigo": $this -> codigo = $valor; break;
                case "nome": $this -> nome = $valor; break;
                case "estado": $this -> estado = $valor; break;
                default: throw new AtributoNaoEncontradoException($atributo);
            }
        }

        public function __construct()
        {
            parent::__construct();
            $this -> nome = "";
            $this -> estado = null;
        }

        public function jsonSerialize()
        {
            return array
            (
                "codigo" => $this -> codigo,
                "nome" => $this -> nome,
                "estado" => $this -> estado
            );
        }
    }
?>