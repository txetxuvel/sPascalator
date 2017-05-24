program prueba9;

const

   N=5;
   N2=N*N;
   FACTOR1=0.8;
   FACTOR2=FACTOR1+N2;

type
tipoMatriz=array[1..10] of integer;
tipoRegistro= record
   campo1:integer;
   campo2: real;
   campo3: boolean
end;

var
   primera, segunda, tercera: integer;
   cuarta, quinta, sexta: real;
   exito, ok: boolean;
   matriz, matriz2: tipoMatriz;
   registro, registro2: tipoRegistro;

begin

   primera:=3+4;
   segunda:=primera;
   segunda:=45*6+primera;
   tercera:=primera*segunda MOD 3;

   cuarta:=3.0+4.0;
   cuarta:=3.65-segunda+cuarta;
   quinta:=45 DIV cuarta;

   exito:=true;
   ok:=exito;

   registro.campo1:=primera-2;
   registro.campo2:=registro.campo1;
   matriz[1]:=4;
   matriz[registro.campo1]:=matriz[1] + primera + 4;

   registro:=registro2;
   matriz2:=matriz;

   
end.