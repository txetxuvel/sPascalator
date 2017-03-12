program prueba10;

const
   uno=1;
   dos=2;
   tres=3;
   cuatro=4;

var
  x,y:integer;
  exito:boolean;

begin

x:=1;
y:=0;
WHILE x < cuatro DO
   x:=x+1;

REPEAT
  y:=x+1
UNTIL y>=cuatro;

x:=1;
y:=0;
WHILE x < cuatro DO BEGIN
   x:=x+1;
   REPEAT
      y:=x+1
   UNTIL y>=cuatro;
END;


exito:= x = cuatro;

end.