program prueba38;

const
   salto='
';

type

   tabla = ARRAY [1..5] OF INTEGER;
   registro = RECORD
	campo1:integer;
	tabla1:tabla
	END;

var

   registro1,registro2:registro;

begin

  registro1.tabla1[1]:=5;
  registro1.tabla1[2]:=4;
  registro1.tabla1[3]:=3;
  registro1.tabla1[4]:=2;
  registro1.tabla1[5]:=1;

  registro1.campo1:=3;
   
  write(registro1.tabla1[1]);
  write(salto);
  write(registro1.tabla1[2]);
  write(salto);
  write(registro1.tabla1[3]);
  write(salto);
  write(registro1.tabla1[4]);
  write(salto);
  write(registro1.tabla1[5]);
  write(salto);

  write(registro1.campo1);
  write(salto);

  registro2:=registro1;

  write(registro2.tabla2[1]);
  write(salto);
  write(registro2.tabla2[2]);
  write(salto);
  write(registro2.tabla2[3]);
  write(salto);
  write(registro2.tabla2[4]);
  write(salto);
  write(registro2.tabla2[5]);
  write(salto);

  write(registro2.campo1);
  write(salto);

 
  
end.