program prueba21;

var 
   x,y:integer;

procedure suma(x,y:integer);

var
   z:integer;

begin
    z:=x+y;
    write(z)
end;

begin
   x:=2;
   y:=3;
   suma(x,y)
end.