<?php
    require_once __DIR__ . "/../../util/AtributoNaoEncontradoException.php";
    require_once __DIR__ . "/Entidade.php";
    require_once __DIR__ . "/Endereco.php";

    class Pessoa extends Entidade
    {
        private $cpf;
        private $rg;
        private $nome;
        private $dataNascimento;
        private $sexo;
        private $fuma;
        private $temFilhos;
        private $endereco;
        private $telefone;
        private $email;
        private $foto;

        public function __get($atributo)
        {
            switch ($atributo)
            {
                case "codigo": return $this -> codigo;
                case "cpf": return $this -> cpf;
                case "rg": return $this -> rg;
                case "nome": return $this -> nome;
                case "dataNascimento": return $this -> dataNascimento;
                case "sexo": return $this -> sexo;
                case "fuma": return $this -> fuma;
                case "temFilhos": return $this -> temFilhos;
                case "endereco": return $this -> endereco;
                case "telefone": return $this -> telefone;
                case "email": return $this -> email;
                case "foto": return $this -> foto;                
                default: throw new AtributoNaoEncontradoException($atributo);
            }
        }

        public function __set($atributo, $valor)
        {
            switch ($atributo)
            {
                case "codigo": $this -> codigo = $valor; break;
                case "cpf": $this -> cpf = $valor; break;
                case "rg": $this -> rg = $valor; break;
                case "nome": $this -> nome = $valor; break;
                case "dataNascimento": $this -> dataNascimento = $valor; break;
                case "sexo": $this -> sexo = $valor; break;
                case "fuma": $this -> fuma = $valor; break;
                case "temFilhos": $this -> temFilhos = $valor; break;
                case "telefone": $this -> telefone = $valor; break;
                case "email": $this -> email = $valor; break;
                case "foto": $this -> foto = $valor; break;
                default: throw new AtributoNaoEncontradoException($atributo);
            }
        }

        public function __construct()
        {
            parent::__construct();
            $this -> cpf = "";
            $this -> rg = "";
            $this -> nome = "";
            $this -> dataNascimento = "";
            $this -> sexo = "";
            $this -> fuma = false;
            $this -> temFilhos = false;
            $this -> endereco = new Endereco();
            $this -> telefone = "";
            $this -> email = "";
            $this -> foto = "";
        }

        public function jsonSerialize()
        {
            return array
            (
                "codigo" => $this -> codigo,
                "cpf" => $this -> cpf,
                "rg" => $this -> rg,
                "nome" => $this -> nome,
                "dataNascimento" => $this -> dataNascimento,
                "sexo" => $this -> sexo,
                "fuma" => $this -> fuma,
                "temFilhos" => $this -> temFilhos,
                "endereco" => $this -> endereco,
                "telefone" => $this -> telefone,
                "email" => $this -> email,
                "foto" => $this -> foto
            );
        }
    }
?>