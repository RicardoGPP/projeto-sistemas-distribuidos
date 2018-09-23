<?php
    require_once __DIR__ . "/../conexao/Conexao.php";
    require_once __DIR__ . "/../entidade/Pais.php";
    require_once __DIR__ . "/../../util/ComandoSQL.php";

    class PaisDAO
    {
        public function obterRegistro($codigo)
        {
            $pais = null;
            $conexao = Conexao::recuperar();
            $conexao -> beginTransaction();
            $sql = new ComandoSQL();
            $sql -> adicionar("SELECT");
            $sql -> adicionar("*");
            $sql -> adicionar("FROM");
            $sql -> adicionar("PAIS");
            $sql -> adicionar("WHERE");
            $sql -> adicionar("CODIGO = :CODIGO");
            $comando = $conexao -> prepare($sql -> comando);
            $comando -> bindValue(":CODIGO", $codigo, PDO::PARAM_INT);
            $comando -> execute();
            $conexao -> commit();
            if ($comando -> rowCount() == 1)
            {
                $resultado = $comando -> fetchAll()[0];       
                $pais = new Pais();
                $pais -> codigo = $resultado["CODIGO"];
                $pais -> nome = $resultado["NOME"];
            }
            return $pais;
        }
    }
?>