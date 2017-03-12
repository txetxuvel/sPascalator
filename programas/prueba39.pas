program prueba38;

const
   salto='
';

type

   tabla = ARRAY [1..5] OF INTEGER;
   registro = RECORD
	campo1:integer;
	campo2:real
	END;

var

   tabla1,tabla2:tabla;
   registro1,registro2:registro;

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


  registro1.campo1:=3;
  registro1.campo2:=4.76754;
  write(registro1.campo1);
  write(salto);
  write(registro1.campo2);
  write(salto);

  registro2:=registro1;

  write(registro2.campo1);
  write(salto);
  write(registro2.campo2);
  write(salto);

  
  
end.