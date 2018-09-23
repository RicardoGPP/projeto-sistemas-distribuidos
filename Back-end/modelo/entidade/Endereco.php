<?php
    require_once __DIR__ . "/../../util/AtributoNaoEncontradoException.php";
    require_once __DIR__ . "/Cidade.php";

    class Endereco implements JsonSerializable
    {
        private $logradouro;
        private $numero;
        private $bairro;
        private $cidade;
        private $cep;

        public function __get($atributo)
        {
            switch ($atributo)
            {
                case "logradouro": return $this -> logradouro;
                case "numero": return $this -> numero;
                case "bairro": return $this -> bairro;
                case "cidade": return $this -> cidade;
                case "cep": return $this -> cep;
                default: throw new AtributoNaoEncontradoException($atributo);
            }
        }

        public function __set($atributo, $valor)
        {
            switch ($atributo)
            {
                case "logradouro": $this -> logradouro = $valor; break;
                case "numero": $this -> numero = $valor; break;
                case "bairro": $this -> bairro = $valor; break;
                case "cidade": $this -> cidade = $valor; break;
                case "cep": $this -> cep = $valor; break;
                default: throw new AtributoNaoEncontradoException($atributo);
            }
        }

        public function __construct()
        {
            $this -> logradouro = "";
            $this -> numero = "";
            $this -> bairro = "";
            $this -> cidade = null;
            $this -> cep = "";
        }

        public function jsonSerialize()
        {
            return array
            (
                "logradouro" => $this -> logradouro,
                "numero" => $this -> numero,
                "bairro" => $this -> bairro,
                "cidade" => $this -> cidade,
                "cep" => $this -> cep
            );
        }
    }
?>