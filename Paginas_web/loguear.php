<!DOCTYPE html>
<html>
    <head>
        <title>Inicio De Sesion</title>
    </head>
    <body>
        <?php
            try
            {
                # Las conexiones se establecen creando instancias de la clase base PDO. El constructor acepta parametros para especificar el origen de la base de datos (conocido como DNS) y, opcionalmente, el nombre del usuario y la contraseña (si la hubiera).
                $conMySQL = new PDO("mysql:host=localhost; port=3307; dbname=la_jirafa","root","");
                # PDO::setAttribute - Establece un atributo.
                $conMySQL->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
                $conMySQL->exec("SET CHARACTER SET UTF8");
                $sentenciaSQL = "SELECT * FROM USUARIO WHERE USUARIO = :usuario AND passw = :passw";
                # PDO::prepara - prepara una sentencia para su ejecucion y devuelve un objeto sentencia.
                $sentenciaPrep = $conMySQL->prepare($sentenciaSQL);
                # htmlspecialchars - convierte caracteres especiales en entidades HTML.
                # addslashes - Escapa un string con barras invertidas.
                $log=htmlspecialchars(addslashes($_POST["usuario"])); $pas=htmlspecialchars(addslashes($_POST["passw"]));
                # PDOStatement::execute - Ejecuta una sentencia preparada.
                $sentenciaPrep->execute(array(":usuario"=>$log, ":passw"=>$pas));
                #PDOStatement::rowCount - Devuelve el numero de filas afectadas por la ultima sentencia SQL.
                $numRegistros = $sentenciaPrep->rowCount();
                if ($numRegistros !=0)
                {
                    printf("Bienvenido - ZONA VIP");
                }
                else
                {
                    #header - Envia encabezado sin formato HTTP.
                    header("localhost/loguer.html");
                }
            }
            catch(Exception $e)
            {
                #die o exit - Imprime un mensaje y termina el script actual.
                die("Error: " . $e->getMessage());
            }
            finally
            {
                $contMySQL = null;
            }
        ?>
    </body>
</html>