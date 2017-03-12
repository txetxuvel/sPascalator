program prueba26;


type
   tipoMatriz = ARRAY [1..5] OF INTEGER;
var 
   matriz:tipoMatriz;

begin

  matriz[1]:=5;
  matriz[2]:=4;
  matriz[3]:=3;
  matriz[4]:=2;
  matriz[5]:=1; 

  write(matriz[1]);
  write(matriz[4]);
  write(matriz[5]);

end.