program prueba24;

var 
   x,y,z,m:integer;

procedure suma(x,y:integer);

var
   z:integer;

begin
    z:=x+y;
    x:=z*2;
    write(z);
    z:=(z+4) MOD 5;
    write(z);
end;

begin
   x:=2;
   y:=3;
   suma(x,y);
   write(x);
   y:=x*y DIV 2;
   write(y)
end.