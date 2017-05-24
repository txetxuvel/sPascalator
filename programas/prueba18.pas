program prueba18;

var
   x,y:integer;
procedure uno(i:integer);

var 
   x:integer;

   procedure dos(j: integer);

      procedure tres(k:integer);
      var
         variable:integer;
      begin

         variable:=k+j+x+y+i;

      end;

   begin

      tres(j)

   end;

begin

   dos(i);

end;

begin
   x:=0;
   y:=0;
   uno(0);
end.