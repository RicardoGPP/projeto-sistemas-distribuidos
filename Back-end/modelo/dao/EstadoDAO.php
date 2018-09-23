<?php
    require_once __DIR__ . "/../conexao/Conexao.php";
    require_once __DIR__ . "/../entidade/Estado.php";
    require_once __DIR__ . "/PaisDAO.php";
    require_once __DIR__ . "/../../util/ComandoSQL.php";

    class EstadoDAO
    {
        private $paisDAO;

        public function __construct()
        {
            $this -> paisDAO = new PaisDAO();
        }
        
        public function obterRegistro($codigo)
        {
            $estado = null;
            $conexao = Conexao::recuperar();
            $conexao -> beginTransaction();
            $sql = new ComandoSQL();
            $sql -> adicionar("SELECT");
            $sql -> adicionar("*");
            $sql -> adicionar("FROM");
            $sql -> adicionar("ESTADO");
            $sql -> adicionar("WHERE");
            $sql -> adicionar("CODIGO = :CODIGO");
            $comando = $conexao -> prepare($sql -> comando);
            $comando -> bindValue(":CODIGO", $codigo, PDO::PARAM_INT);
            $comando -> execute();
            $conexao -> commit();
            if ($comando -> rowCount() == 1)
            {
                $resultado = $comando -> fetchAll()[0];       
                $estado = new Estado();
                $estado -> codigo = $resultado["CODIGO"];
                $estado -> nome = $resultado["NOME"];
                $estado -> pais = $this -> paisDAO -> obterRegistro($resultado["PAIS"]);
            }
            return $estado;
        }
    }
?>