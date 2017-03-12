program prueba1;

CONST 
    n = 20;
    n2 = n * n > 24;

TYPE
    dias = ARRAY [1..7] OF integer;
    meses = ARRAY [1..12] OF INTEGER;
    registro = RECORD
(* Línea 10 *)
       campo1, campo2: integer;
       campo3: boolean
    END;

VAR
   primera, segunda: integer;
   tercera: boolean;
   cuarta: meses;
   
(* Línea 20 *)
procedure uno;

BEGIN

END;

procedure dos(var x,y: integer;  exito: boolean; j: integer);
CONST 
    K = 20;
(* Línea 30 *)
TYPE
    colores = ARRAY [1..7] OF integer;
    registro = RECORD
       campo1, campo2: integer;
       campo3: boolean
    END;

VAR
   primera, segunda: integer;
(* Línea 40 *)
BEGIN

    if (registro.campo1 + x > j) then
        BEGIN
            exito := false AND 4 > x * x;
            x := 3 *4  MOD j;
        END;
     else
           if exito then
                  uno;
          else
                  dos(x, y, not exito, j DIV 4); 
        uno;
      
END;

BEGIN
     registro . campo := 4;
END.