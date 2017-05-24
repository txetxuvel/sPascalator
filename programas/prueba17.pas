program prueba17;

const N=10;

type
   tipoTabla=ARRAY [1..N] OF INTEGER;
   tipoRegistro=RECORD 
     campo1:integer
   end;

var

   x,i:integer;
   tabla, tabla2:tipoTabla;
   registro:tipoRegistro;

procedure uno(var tabla:tipoTabla;tabla2:tipoTabla;var cuenta:integer;primera:integer);

var
   tablaAux:tipoTabla;

begin

   if (2>primera) then
      tablaAux[4]:=tabla2[6]+i*cuenta
   else
      tablaAux[3]:=cuenta;

   cuenta:=cuenta+1;

   if (cuenta<=3) then
      uno(tabla,tabla2,x,tabla2[3+1]); 
       

end;

begin

   x:=1;
  
   while (i<=N) do begin
      tabla[i]:=i;
      tabla2[i]:=i;
   end;

   uno(tabla,tabla2,x,tabla2[3+1]); 

end.