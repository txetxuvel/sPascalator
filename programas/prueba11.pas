program prueba11;

type
tipoMatriz=array[1..10] of integer;
tipoRegistro= record
   campo1:integer;
   campo2: real;
   campo3: boolean
end;

var
   primera: integer;
   segunda: real;
   exito: boolean;
   matriz:tipoMatriz;
   registro:tipoRegistro;

begin

   primera:=4;
   segunda:=3.99;
   exito:=4<5;
   exito:=(4<primera) AND (5>4);
   exito:=(4=6) OR (true AND FALSE) OR (6<>8);
   registro.campo3:=exito OR (primera>segunda);

end.