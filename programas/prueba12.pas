program prueba12;

var
   primera:integer;
   exito, ok: boolean;

begin

   if true then
      primera:=4;
   exito:=true;

   if exito then
      primera:=4;

   if exito then
      primera:=3
   else
      primera:=7;

   if primera>8 then
      primera:=8
   else
      primera:=19;

   if (exito AND (5<>6))
   THEN BEGIN
      primera:=6;
      exito:=false;
   END
   ELSE
      IF exito then begin
         primera:=primera DIV 2;
         ok:=false;
      end

end.