program prueba16;

const N=10;

type
   tipoTabla=ARRAY [1..N] OF INTEGER;
   tipoRegistro=RECORD 
     campo1:integer
   end;

var

   x,i:integer;
   y:real;
   tabla, tabla2:tipoTabla;
   registro:tipoRegistro;


procedure uno;

var
   x:integer;
   y: real;

begin
end;

procedure dos(primera,segunda:integer;tercera:real;cuarta:boolean);

var
   x:integer;
   y: real;
   tabla:tipoTabla;

begin
end;

procedure tres(var tabla:tipoTabla;tabla2:tipoTabla;primera,segunda:integer);

var
   tablaAux:tipoTabla;

begin
end;

begin

   x:=1;
   y:=-1.53;
  
   while (i<=N) do begin
      tabla[i]:=i;
      tabla2[i]:=i;
   end;

   uno;
   dos(x,4,y,true);
   dos(x,4,6.54,true);
   tres(tabla,tabla2,45,x);
   tres(tabla,tabla2,registro.campo1,45);
   tres(tabla,tabla2,27,tabla2[3+1]); 

end.