program prueba7;

type
tipoMatriz=array[1..10] of integer;
tipoRegistro= record
  campo1:integer;
  campo2: real;
  campo3: boolean
end;

var 
  primera: integer;
  matriz: tipoMatriz;
  registro: tipoRegistro;

begin

  primera:=45;
  matriz[2]:=67;
  matriz[6]:=83;
  registro.campo3:=true;
  registro.campo2:=29.87;
  
end.