<?php
    require_once __DIR__ . "/../conexao/Conexao.php";
    require_once __DIR__ . "/../entidade/Cidade.php";
    require_once __DIR__ . "/EstadoDAO.php";
    require_once __DIR__ . "/../../util/ComandoSQL.php";

    class CidadeDAO
    {
        private $estadoDAO;

        public function __construct()
        {
            $this -> estadoDAO = new EstadoDAO();
        }
        
        public function obterRegistro($codigo)
        {
            $cidade = null;
            $conexao = Conexao::recuperar();
            $conexao -> beginTransaction();
            $sql = new ComandoSQL();
            $sql -> adicionar("SELECT");
            $sql -> adicionar("*");
            $sql -> adicionar("FROM");
            $sql -> adicionar("CIDADE");
            $sql -> adicionar("WHERE");
            $sql -> adicionar("CODIGO = :CODIGO");
            $comando = $conexao -> prepare($sql -> comando);
            $comando -> bindValue(":CODIGO", $codigo, PDO::PARAM_INT);
            $comando -> execute();
            $conexao -> commit();
            if ($comando -> rowCount() == 1)
            {
                $resultado = $comando -> fetchAll()[0];       
                $cidade = new Cidade();
                $cidade -> codigo = $resultado["CODIGO"];
                $cidade -> nome = $resultado["NOME"];
                $cidade -> estado = $this -> estadoDAO -> obterRegistro($resultado["ESTADO"]);
            }
            return $cidade;
        }
    }
?>