program prueba36;

const
   salto='
';

type

   registro = RECORD
		x,y:integer;
		valor:real
              END;
var

   registro1,registro2:registro;

procedure primero(registro1:registro);

begin

   write(registro1.x);
   write(salto);
   write(registro1.y);
   write(salto);
   write(registro1.valor);
   write(salto);
   write(salto);

   registro1.x:=6;
   registro1.y:=2;
   registro1.valor:=6.2;
   
   write(registro1.x);
   write(salto);
   write(registro1.y);
   write(salto);
   write(registro1.valor);
   write(salto);
   write(salto);

end;

begin

   registro1.x:=7;
   registro1.y:=5;
   registro1.valor:=7.5;
   write(registro1.x);
   write(salto);
   write(registro1.y);
   write(salto);
   write(registro1.valor);
   write(salto);
   write(salto);

   primero(registro1);

   write(registro1.x);
   write(salto);
   write(registro1.y);
   write(salto);
   write(registro1.valor);

   
end.