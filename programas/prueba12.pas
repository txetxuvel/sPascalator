program prueba12;

const
   uno=1;
   dos=2;
   tres=3;
   cuatro=4;

var
  x:integer;
  exito:boolean;
  

{ procedure primero(x,y:integer;var z:integer;var exito:boolean);

var i:integer;

begin
     i:=x+y;
     exito:= z = i;

end;

 procedure segundo(x:integer);

var i:integer;

begin
     i:=x;
end;

 procedure tercero(var x:integer);

var i:integer;

begin
     i:=x;
end; }

begin

{   x:=3;
  segundo(7*3+1);
  tercero(x); 
  tercero(x+2);} 
  primero(uno,dos,x,exito);
 x:=6;
  primero(tres,cuatro,x,exito); }

end.

{ Fin del codigo }