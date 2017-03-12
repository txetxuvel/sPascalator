program prueba35;

CONST
   salto='
';

var

   x:integer;
   y:integer;

procedure primero(var x:integer;y:integer);


begin

   write(x);
   write(salto);
   write(y);
   write(salto);
   x:=7;
   y:=7;
   write(x);
   write(salto);
   write(y);
   write(salto);

end;

begin

   x:=5;
   y:=5;
   write(x);
   write(salto);
   write(y);
   write(salto);
   primero(x,y);
   write(x);
   write(salto);
   write(y);
   write(salto);

end.