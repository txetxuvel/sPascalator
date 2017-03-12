(* Conjunto de pruebas para la definicion de constantes *)
program prueba1;

const
(* Constante enteras *)
    x = 2 ;
    y = 2 + 3;
    z = - y + 4 -x + 8 ;
    suma = x + y ;
    producto = suma * y -24 MOD 5;
    producto2 = (suma * y -24 MOD 6) DIV 2;

(* Constante reales *)
    real1 = 2.5 ;
    real2 = 3.1 + 4 + 3;
    real3 = 0 - 2.7 + 45 -8 ;
    real4 = real3 DIV y  * 4 ;

(* Literales *)
    error1 = 'Ha habido un error' ;
    error2 = ': se ha producido el error ''24''' ;
    error3 = 'Ha habido un error' + ': se ha producido el error ''24''';
    error4 = 'Ha habido un error' + ': se ha producido el error ''24''' + '. Compruebe el log';
(*    error5 = error1 + error2; *)

(* Constantes Lógicas *)
    exito = suma > x ; (* true *)
    continua = 24 = 2 ; (* false *)
    logica1 = exito OR continua ; (* true *)
    logica2 = (NOT exito)  OR (z <= (y -x) * 1.5);


begin

end.