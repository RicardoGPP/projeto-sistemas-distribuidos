<?php
    require_once __DIR__ . "/../../util/AtributoNaoEncontradoException.php";
    require_once __DIR__ . "/Entidade.php";
    require_once __DIR__ . "/Pais.php";

    class Estado extends Entidade
    {
        private $nome;
        private $pais;

        public function __get($atributo)
        {
            switch ($atributo)
            {
                case "codigo": return $this -> codigo;
                case "nome": return $this -> nome;
                case "pais": return $this -> pais;
                default: throw new AtributoNaoEncontradoException($atributo);
            }
        }

        public function __set($atributo, $valor)
        {
            switch ($atributo)
            {
                case "codigo": $this -> codigo = $valor; break;
                case "nome": $this -> nome = $valor; break;
                case "pais": $this -> pais = $valor; break;
                default: throw new AtributoNaoEncontradoException($atributo);
            }
        }

        public function __construct()
        {
            parent::__construct();
            $this -> nome = "";
            $this -> pais = null;
        }

        public function jsonSerialize()
        {
            return array
            (
                "codigo" => $this -> codigo,
                "nome" => $this -> nome,
                "pais" => $this -> pais
            );
        }
    }
?>