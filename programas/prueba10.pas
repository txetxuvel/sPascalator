program prueba10;

const 

{   X=45 (* Error sintactico por no tener ; *) }
   N=5;
{   N=4; (* Error sem�ntico por identificador repetido *) }
   N2=N*N;
{   N3=N*Y; (* Error sem�ntico por identificador no declarado *) }
   FACTOR1=0.8;
   FACTOR2=FACTOR1+N2;

type
tipoMatriz=array[1..10] of integer;
{tipoMatriz2=array[1.10] of integer; (* Error sintactico porque falta un . *) }
{tipoMatriz3=array[1..10] of nada; (* Error sem�ntico por no ser un tipo no definido *) }
{tipoMatriz4=array[1..10] of tipoMatriz; (* Error sem�ntico por no ser un tipo predefinido *) }

{ N= record
   campo1:integer
end; (* Error por identificador duplicado *) }

tipoRegistro= record
   campo1:integer;
   campo2: real;
   campo3: boolean
end;

tipoRegistro2= record
   campo1: integer;
{   campo2 real; (* Error sint�ctico porque faltan el caracter : *) }
{   campo1: real; (* Error por identificador de campo duplicado *) }
   campo3: boolean
end;

{ tipoRegistro3= record
   campo: boolean;
end; (* Error sint�ctico porque hay ; antes del end *) }

{tipoRegistro =record 
   campo1: integer
end; (* Error por identificador de tipo duplicado *) }

var (* si esta l�nea no se descomenta se provocan errores sint�cticos porque sigue en el �mbito de la declaraci�n de tipos *)
   primera, segunda, tercera: integer;
{   primera2, segunda2 tercera2: integer; (* Error sint�ctico porque falta una , entre las variables *) }
{   primera: real; (* Error por identificador duplicado *) }
{   tipoMatriz: integer; (* Error por identificador duplicado *) }
{   N: integer; (* Error por identificador duplicado *) }
{   otra: noexiste; (* Error porque no existe el tipo *) }
   cuarta, quinta, sexta: real;
   exito, ok: boolean;
   matriz, matriz2: tipoMatriz;
   registro,registro2: tipoRegistro;

begin

{   variable:=valor; (* Error sem�ntico porque variable no est� declarado *) }

   primera:=3+4;
{   primera:=3 + * 4; (* Error sint�ctico *) }
{   primera:= 4.65; (* Error sem�ntico por que no coinciden los tipos *) }
   segunda:=primera;
   segunda:=45*6+primera;
   tercera:=primera*segunda MOD 3;
{   tercera=primera*segunda MOD 3; (* Error sint�ctico por camiar = por := *) }

   cuarta:=3.0+4.0;
{   cuarta:=true; (* Error sem�ntico por que no coinciden los tipos *) }
   cuarta:=primera;
{   primera:=cuarta; (* Error sem�ntico por que no coinciden los tipos *) }
   cuarta:=3.65-segunda+cuarta;
   quinta:=45 DIV cuarta;

   exito:=true;
{   exito:=1; (* Error sem�ntico por que no coinciden los tipos *) }
   ok:=exito;

{   N:=6; (* Error sem�ntico porque N no es una variable *) }

   registro.campo1:=primera-2;
   registro.campo2:=registro.campo1;
   matriz[1]:=4;
   matriz[registro.campo1]:=matriz[1] + primera + 4;
{   matriz[registro.campo2]:=matriz[1] + primera + 4; (* Error semantico por que el �ndice no es un valor entero *) }

   registro2:=registro;
{   registro2:=primera; (* Error por que no coinciden los tipos *) }
   matriz2:=matriz;
{   matriz:=registro; (* Error por que no coinciden los tipos *) }

end.