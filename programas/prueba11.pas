  { Comienzo del codigo }
program prueba11;

const
   uno=1;
   dos=2;
   tres=3;
   cuatro=4;

var
  x:integer;
  exito:boolean;
  

 procedure primero(x,y:integer;var z:integer;var exito:boolean);

var i:integer;

begin
     i:=x+y;
     exito:= z = i;

end;


begin

   x:=3;
  primero(uno,dos,x,exito);
{ x:=6;
  primero(tres,cuatro,x,exito); }

end.

{ Fin del codigo }