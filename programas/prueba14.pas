program prueba14;

const
   N=4;

type
   tipoTabla=ARRAY [1..N] OF real;

var
   i:integer;
   continuar:boolean;
   tabla: tipoTabla;

begin

   i:=1;
   
   while i<=N do begin
      tabla[i]:=i+ 0.5;
      i:=i+1;
   end;
{   while do begin (* Error sintactico ya que falta la condici�n *)
      i:=i+1;
   end; }
{   while 1<=N begin (* Error sintactico ya que falta la palabra reservada do *)
      i:=i+1;
   end; }
{   while (i<=N)+2 do begin (* Error sem�ntico ya que no coinciden los tipos en la expresi�n *)
      i:=i+1;
   end;}

{   while 2 do begin (* Error sem�ntico ya que la condici�n no es de tipo l�gico *)
      i:=i+1;
   end;}

{   repeat
       tabla[2]:=tabla[2]-0.1 DIV 2;
   until tabla[2]; (* Error sintactico porque falta el ; *) }

{   repeat
   until tabla[2]<2 (* Error sintactico porque falta el ; *) }

   if tabla[2]>1 then
      tabla[4]:=45
   else
      tabla[4]:=36;
{   else (* Error sint�ctico *) }
      tabla[4]:=24;

   if tabla[2]>(1+1) then
{      repeat
         tabla[2]:=tabla[2]-0.1 DIV 2;
      until tabla[2]<2; (* Error sint�ctico porque sobra el ; *)}
   else
{      if  false+4 then (* Error sem�ntico porque on coinciden los tipos *) }
         tabla[3+6]:=45;

end.