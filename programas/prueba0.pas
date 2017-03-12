program prueba0;

const
  uno = 1;

var
   x:integer;
   y:real;

procedure primero(var x,y:integer);

var z:integer;

begin

   z:=x+y;

end;

begin

   x:=0;
   x:=(2+x*x) DIV x;
   primero(x,y);

end.