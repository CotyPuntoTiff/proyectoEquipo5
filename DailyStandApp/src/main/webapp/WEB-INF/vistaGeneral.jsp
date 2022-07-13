<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vista General</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>



<body>
    <div id="vista general" class=".bg-light.bg-gradient container-fluid p-3 text-center">
        <div id="CentroArriba">
            <div id="titulo"> 
                <h1>Reunión del Día</h1>
            </div>
            <div id="reloj">
                <!--Hora-->
            <div class="mx-auto p-1"
            style="width: 200px; text-align: center; border-radius: 5px; background-color: rgba(0, 0, 0, 0.10);">
            <script type="text/javascript">
                function startTime() {
                    today = new Date();
                    h = today.getHours();
                    m = today.getMinutes();
                    m = checkTime(m);
                    document.getElementById('reloj').innerHTML = h + ":" + m;
                    t = setTimeout('startTime()', 500);
                }
                function checkTime(i) { if (i < 10) { i = "0" + i; } return i; }
                window.onload = function () { startTime(); }
            </script>
            <div id="reloj" style="font-size:20px;"></div>
        </div>
        <!--Fin código hora-->
            </div>
        </div>
        <div id="EsquinaSupIzquierda">
            <div id="nombre usuario"> 
                <h1>Maria Ponce</h1>
            </div>
        </div>
            <div id="logo"></div>
        <div id="EsquinaSupDerecha">
            <div id="calendario">Calendario</div>
            <div id="filtroPreguntas">Filtro Preguntas</div>
        </div>
        <div id="contenedorReportes">
            <div>REPORTE 1 </div>
            <div>REPORTE 2 </div>
            <div>REPORTE 3 </div>
            <div>REPORTE 4 </div>
            <div>REPORTE 5 </div>
        </div>

    </div>
    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>