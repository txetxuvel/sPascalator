program prueba34;

const

   salto='
';


type

   tabla = ARRAY [1..5]  OF INTEGER;

var
   tabla1, tabla2: tabla;

procedure uno (var tabla1:tabla);

begin

   write(tabla1[2]);
   write(salto);
   tabla1[2]:=4;
   write(tabla1[2]);
   write(salto);

end;


begin

   tabla1[1]:=1;
   tabla1[2]:=2;
   tabla1[3]:=3;
   tabla1[4]:=4;
   tabla1[5]:=5;
   write(tabla1[2]);
   write(salto);

   uno(tabla1);

   write(tabla1[2]);
   write(salto);

end.