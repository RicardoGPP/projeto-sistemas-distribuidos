<?php
    require_once __DIR__ . "/../conexao/Conexao.php";
    require_once __DIR__ . "/../entidade/Pessoa.php";
    require_once __DIR__ . "/CidadeDAO.php";
    require_once __DIR__ . "/../../util/ComandoSQL.php";

    class PessoaDAO
    {
        private $cidadeDAO;

        public function __construct()
        {
            $this -> cidadeDAO = new CidadeDAO();
        }
        
        public function obterRegistro($codigo)
        {
            $pessoa = null;
            $conexao = Conexao::recuperar();
            $conexao -> beginTransaction();
            $sql = new ComandoSQL();
            $sql -> adicionar("SELECT");
            $sql -> adicionar("*");
            $sql -> adicionar("FROM");
            $sql -> adicionar("PESSOA");
            $sql -> adicionar("WHERE");
            $sql -> adicionar("CODIGO = :CODIGO");
            $comando = $conexao -> prepare($sql -> comando);
            $comando -> bindValue(":CODIGO", $codigo, PDO::PARAM_INT);
            $comando -> execute();
            $conexao -> commit();
            if ($comando -> rowCount() == 1)
            {
                $resultado = $comando -> fetchAll()[0];       
                $pessoa = new Pessoa();                
                $pessoa -> codigo = $resultado["CODIGO"];
                $pessoa -> cpf = $resultado["CPF"];
                $pessoa -> rg = $resultado["RG"];
                $pessoa -> nome = $resultado["NOME"];
                $pessoa -> dataNascimento = $resultado["DATA_NASCIMENTO"];
                $pessoa -> sexo = $resultado["SEXO"];
                $pessoa -> fuma = $resultado["FUMA"];
                $pessoa -> temFilhos = $resultado["TEM_FILHOS"];
                $pessoa -> endereco -> logradouro = $resultado["LOGRADOURO"];
                $pessoa -> endereco -> numero = $resultado["NUMERO"];
                $pessoa -> endereco -> bairro = $resultado["BAIRRO"];
                $pessoa -> endereco -> cidade = $this -> cidadeDAO -> obterRegistro($resultado["CIDADE"]);
                $pessoa -> endereco -> cep = $resultado["CEP"];
                $pessoa -> telefone = $resultado["TELEFONE"];
                $pessoa -> email = $resultado["EMAIL"];
                $pessoa -> foto = $resultado["FOTO"];
            }
            return $pessoa;
        }

        public function obterLista()
        {
            $pessoas = array();
            $conexao = Conexao::recuperar();
            $conexao -> beginTransaction();
            $sql = new ComandoSQL();
            $sql -> adicionar("SELECT");
            $sql -> adicionar("*");
            $sql -> adicionar("FROM");
            $sql -> adicionar("PESSOA");
            $sql -> adicionar("ORDER BY");
            $sql -> adicionar("CODIGO");
            $comando = $conexao -> prepare($sql -> comando);
            $comando -> execute();
            $conexao -> commit();
            if ($comando -> rowCount() > 0)
            {
                $resultados = $comando -> fetchAll();
                foreach($resultados as $resultado)
                {
                    $pessoa = new Pessoa();
                    $pessoa -> codigo = $resultado["CODIGO"];
                    $pessoa -> cpf = $resultado["CPF"];
                    $pessoa -> rg = $resultado["RG"];
                    $pessoa -> nome = $resultado["NOME"];
                    $pessoa -> dataNascimento = $resultado["DATA_NASCIMENTO"];
                    $pessoa -> sexo = $resultado["SEXO"];
                    $pessoa -> fuma = $resultado["FUMA"];
                    $pessoa -> temFilhos = $resultado["TEM_FILHOS"];
                    $pessoa -> endereco -> logradouro = $resultado["LOGRADOURO"];
                    $pessoa -> endereco -> numero = $resultado["NUMERO"];
                    $pessoa -> endereco -> bairro = $resultado["BAIRRO"];
                    $pessoa -> endereco -> cidade = $this -> cidadeDAO -> obterRegistro($resultado["CIDADE"]);
                    $pessoa -> endereco -> cep = $resultado["CEP"];
                    $pessoa -> telefone = $resultado["TELEFONE"];
                    $pessoa -> email = $resultado["EMAIL"];
                    $pessoa -> foto = $resultado["FOTO"];
                    array_push($pessoas, $pessoa);
                }            
            }
            return $pessoas;
        }
    }
?>