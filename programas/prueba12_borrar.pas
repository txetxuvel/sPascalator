program prueba12;
const
   uno=1;
   dos=2;
   tres=3;
   cuatro=4;
var
  x:integer;
  exito:boolean;
  y:real;
procedure primero(x,y:integer;var z:integer);
begin
end;
procedure segundo(x:integer);
begin
end;
procedure tercero(var x:integer);
begin
end;
procedure cuarto(exito:boolean;x,y:integer;var z:integer);
begin
end;
begin

 x:=3;
 segundo(7*3+1);
 y:=x;
{ x:=y;}
 tercero(x);
{ tercero(x+2); }
 primero(uno,dos,x);
 x:=6;
{ cuarto(exito,tres,cuatro,x); }

end.