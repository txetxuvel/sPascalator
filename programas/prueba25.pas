program prueba25;

CONST

   valorX='X vale: ';
   valorY='Y vale: ';
   valorZ='Z vale: ';
   valorM='M vale: ';
   salto='
';

var 
   x,y,z,m:real;

procedure suma(x,y:real);

var
   z:real;

begin
    z:=x+y;
    write(valorZ);write(z);write(salto);
    x:=z*2;
    write(valorZ);write(z);write(salto);
    z:=(z+4) MOD 5;
    write(valorZ);write(z);write(salto);
end;

begin
   x:=2.7;
   y:=3.2;
   suma(x,y);
   write(valorX);write(x);write(salto);
   y:=x*y DIV 2;
   write(valory);write(y);write(salto);
   write(valorX);write(x);write(salto);
   y:=x*y DIV 2;
   write(valory);write(y);write(salto);
   write(valorX);write(x);write(salto);
   y:=x*y DIV 2;
   write(valory);write(y);write(salto);
   write(valorX);write(x);write(salto);
   y:=x*y DIV 2;
   write(valory);write(y);write(salto);
   write(valorX);write(x);write(salto);
   y:=x*y DIV 2;
   write(valory);write(y);write(salto);
end.