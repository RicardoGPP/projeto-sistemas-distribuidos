<?php    
    header('Access-Control-Allow-Origin: *'); 
    header("Access-Control-Allow-Credentials: true");
    header('Access-Control-Allow-Methods: GET');
    header('Access-Control-Max-Age: 1000');
    header('Access-Control-Allow-Headers: Origin, Content-Type, X-Auth-Token , Authorization');
	
    require_once __DIR__ . "/controle/Controlador.php";    

    $controlador = new Controlador();
    $metodo = $_GET["metodo"];
    $retorno = null;

    switch ($metodo)
    {
        case "buscarPessoa": $retorno = $controlador -> $metodo($_GET["codigo"]); break;
        case "listarPessoas": $retorno = $controlador -> $metodo(); break;
    }

    echo htmlspecialchars(json_encode($retorno), ENT_QUOTES, 'UTF-8');
?>