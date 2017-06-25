program demo04;

const
   cadena='El valor de PI es ';
   PI=3.14159;

   procedure uno(x:real);

      procedure dos(x:real);

         procedure tres(x:real);

         begin
            WRITE(cadena);
            WRITE(x)
         end;

      begin
	tres(x);
      end;

   begin
      dos(x);
   end;

begin
   uno(PI)
end.