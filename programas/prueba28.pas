program prueba28;

type
   tipoRegistro = RECORD 
      id:integer;
      peso:real
   end;

var
   registro: tipoRegistro;
   x:integer;
   y:real;

begin

   registro.id:=3;
   registro.peso:=34.65;

   x:=registro.id;
   y:=registro.peso; 

   write(registro.id);
   write(registro.peso);

   write(x);
   write(y) 

end.