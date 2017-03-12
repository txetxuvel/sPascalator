program prueba22;

CONST

   valorX='X vale: ';
   valorY='Y vale: ';
   valorZ='Z vale: ';
   valorM='M vale: ';
   salto='
';


var 
   x,y,z,m:integer;

procedure suma(var x,y:integer);

var
   z:integer;

begin
    z:=x+y;
    x:=z*2;
    write(valorZ);write(z);write(salto);
    z:=(z+4) MOD 5;
    write(valorZ);write(z);write(salto);
end;

begin
   x:=2;
   y:=3;
   suma(x,y);
   write(valorX);write(X);write(salto);
   y:=x*y DIV 2;
   write(valorY);write(Y);write(salto);
end.