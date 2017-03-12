program prueba32;

CONST
   valorExito='EL valor de exito: ';
   valorX='EL valor de x: ';
   valorY='EL valor de y: ';
   valorJ='EL valor de j: ';
   salto='
';

var
   x,y:integer;
   j:real;
   exito:boolean;

procedure segundo(var x:integer;var exito:boolean);

begin

   write(valorExito);
   write(exito);write(salto);
   exito:=not exito;
   write(valorExito);
   write(exito);write(salto);

end;

procedure primero(var exito:boolean; x:integer;var j:real);

begin

   write(valorExito);
   write(exito);write(salto);
   segundo(x,exito);
   write(valorExito);
   write(exito);write(salto);

end;

begin

   exito:=(7>3) AND (3>7);
   x:=3;
   write(valorExito);
   write(exito);write(salto);
   primero(exito,x,j);
   write(valorExito);
   write(exito);write(salto);
   segundo(y,exito);
   write(valorExito);
   write(exito);write(salto);

end.