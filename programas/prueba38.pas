program prueba38;

const
   salto='
';

type

   tabla = ARRAY [1..5] OF INTEGER;

var

   tabla1,tabla2:tabla;

procedure primero(var tabla1:tabla);

begin

   write(salto);

end;

begin

  tabla1[1]:=5;
  tabla1[2]:=4;
  tabla1[3]:=3;
  tabla1[4]:=2;
  tabla1[5]:=1;
   
  write(tabla1[1]);
  write(salto);
  write(tabla1[2]);
  write(salto);
  write(tabla1[3]);
  write(salto);
  write(tabla1[4]);
  write(salto);
  write(tabla1[5]);
  write(salto);

  tabla2:=tabla1;

  write(tabla2[1]);
  write(salto);
  write(tabla2[2]);
  write(salto);
  write(tabla2[3]);
  write(salto);
  write(tabla2[4]);
  write(salto);
  write(tabla2[5]);
  write(salto);

end.